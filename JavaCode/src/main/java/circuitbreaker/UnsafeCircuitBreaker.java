package circuitbreaker;

import lombok.Getter;

import java.time.Instant;
import java.util.List;

/**
 * A circuit breaker needs a few aspects to work:
 * <ul>
 *   <li>state: open, closed, half-open </li>
 *   <li>threshold: a metric regarding failing requests that triggers change of state closed -> open</li>
 *   <li>open state timeout: an amount of time on which the state will be OPEN</li>
 *   <li>state management logic: to manage the state changes over time</li>
 *   <li>half-open requests: a number of requests that will be allowed to be tried to see if the system is recovered</li>
 *   <li>half-open success measure: the rate of success over half-open requests to trigger state changes</li>
 *       <ul>
 *         <li>either change to close state (system is working, high success rate)</li>
 *         <li>or to open state (system is still unhealthy, low success rate)</li>
 *       </ul>
 *   <li>fallback strategy: a strategy to handle open state - how will the system respond when the CB is in open state</li>
 *   <li>reset strategy: a strategy to manually reset the state of the system - for maintenance purposes, for example</li>
 * </ul>
 * <p>
 * A Circuit Breaker needs to "monitor" the function it is calling. Therefore, it needs to "decorate" it, which means
 * it should run before the function execution to check the current state and act accordingly, and if the function
 * can execute, run after the function execution to gather information for the next function call
 **/
public class UnsafeCircuitBreaker {

    // current state of the CB instance
    @Getter
    private StateEnum state;

    // The CB will open if failed requests > 3
    private static final int THRESHOLD = 3;

    // the CB will transition to half-open when time >= 10s
    private long TIMEOUT;

    // number of requests that can be tried to check if service is healthy
    private static final int TRY_REQUESTS = 3;

    // rate at which the system needs to respond success to be considered healthy
    // and trigger state change to CLOSED
    private static final double SUCCESS_RATE = 1.0;

    // I can add a timestamp to when the CB Opened, so I can compare this with the timeout
    private long openInstant;


    // These will be aux state controlling variables

    // Also CB can control the number of tried requests that were successful
    private int successfulTriedRequests;

    // and this one so that successfulTriedRequests / totalTriedRequests gives me the success rate
    private int totalTriedRequests;

    private int failedRequestsCount;


    // create the CB with state CLOSED - assume service working
    public UnsafeCircuitBreaker(int timeout) {
        this.state = StateEnum.CLOSED;
        this.failedRequestsCount = 0;
        this.TIMEOUT = timeout;
    }

    private void resetAuxState() {
        this.successfulTriedRequests = 0;
        this.totalTriedRequests = 0;
        this.failedRequestsCount = 0;
    }

    private void triggerOpenCircuit() {
        this.state = StateEnum.OPEN;
        // there can be a problem with timezones, but let's keep it simple for now
        this.openInstant = Instant.now().getEpochSecond();
        // after setting this state, reset the other auxiliary variables
        resetAuxState();
    }

    private void triggerHalfOpenCircuit() {
        this.state = StateEnum.HALF_OPEN;
    }

    private void triggerClosedCircuit() {
        this.state = StateEnum.CLOSED;
        resetAuxState();
    }

    private void increaseFailedRequestCount() {
        this.failedRequestsCount++;
    }

    private void increaseSuccessfulTriedRequests() {
        this.successfulTriedRequests++;
    }

    private void increaseTotalTriedRequests() {
        this.totalTriedRequests++;
    }

    private void manageStateChanges() {
        switch (this.state) {
            case CLOSED -> {
                if (this.failedRequestsCount >= THRESHOLD)
                    triggerOpenCircuit();
            }

            case OPEN -> {
                var waitedTime = Instant.now().getEpochSecond() - this.openInstant;
                if (waitedTime >= TIMEOUT) {
                    triggerHalfOpenCircuit();
                }
            }

            case HALF_OPEN -> {
                if (this.failedRequestsCount > 0) triggerOpenCircuit();
                else if (totalTriedRequests >= TRY_REQUESTS) {
                    if ((double) this.successfulTriedRequests / totalTriedRequests >= SUCCESS_RATE) {
                        triggerClosedCircuit();
                    } else {
                        triggerOpenCircuit();
                    }
                }
            }
        }
    }

    public void handlePreRequest() {
        if (this.state.equals(StateEnum.OPEN)) {
            var waitedTime = Instant.now().getEpochSecond() - this.openInstant;
            throw new IllegalStateException(String.format(
                    "System is unavailable. Try again in %d seconds",
                    (TIMEOUT - waitedTime)));
        }
    }

    public void handleStateAfterServiceResponse(int responseStatus) {
        switch (this.state) {
            case CLOSED -> {
                if (!List.of(200, 201, 202, 204).contains(responseStatus)) {
                    increaseFailedRequestCount();
                }
            }

            case OPEN -> {
                var waitedTime = Instant.now().getEpochSecond() - this.openInstant;
                if (waitedTime < TIMEOUT) {
                    // a kind of premature fallback strategy
                    throw new IllegalStateException(String.format(
                            "System is unavailable. Try again in %d seconds",
                            (TIMEOUT - waitedTime)));
                } else {
                    if (List.of(200, 201, 202, 204).contains(responseStatus)) {
                        increaseSuccessfulTriedRequests();
                    }
                }
            }
            case HALF_OPEN -> {
                if (List.of(200, 201, 202, 204).contains(responseStatus)) {
                    increaseSuccessfulTriedRequests();
                } else {
                    increaseFailedRequestCount();
                }
                increaseTotalTriedRequests();
            }
        }
        manageStateChanges();
    }


}
