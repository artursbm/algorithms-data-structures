package wise;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class CircuitBreaker {

    public enum State { CLOSED, OPEN, HALF_OPEN }

    @Getter
    private final String name;
    private final int failureThreshold;       // failures before opening
    private final int successThreshold;       // successes in HALF_OPEN to close
    private final long timeoutMs;             // how long to stay OPEN before trying again

    @Getter
    private final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);
    private final AtomicInteger failureCount  = new AtomicInteger(0);
    private final AtomicInteger successCount  = new AtomicInteger(0);
    private final AtomicLong   lastFailureTime = new AtomicLong(0);

    public CircuitBreaker(String name, int failureThreshold, int successThreshold, long timeoutMs) {
        this.name             = name;
        this.failureThreshold = failureThreshold;
        this.successThreshold = successThreshold;
        this.timeoutMs        = timeoutMs;
    }

    // ── Core execution entry point ────────────────────────────────────────────

    public <T> T execute(Supplier<T> action) throws Exception {
        State current = evaluateState();

        if (current == State.OPEN) {
            throw new CircuitBreakerOpenException(
                    String.format("Circuit '%s' is OPEN. Retry after %d ms.", name, timeoutMs));
        }

        try {
            T result = action.get();
            onSuccess();
            return result;
        } catch (Exception e) {
            onFailure();
            throw e;
        }
    }

    // ── State transitions ─────────────────────────────────────────────────────

    private State evaluateState() {
        if (state.get() == State.OPEN) {
            long elapsed = System.currentTimeMillis() - lastFailureTime.get();
            if (elapsed >= timeoutMs && state.compareAndSet(State.OPEN, State.HALF_OPEN)) {
                System.out.printf("[%s] OPEN → HALF_OPEN (probing...)%n", name);
                successCount.set(0);
            }
        }
        return state.get();
    }

    private void onSuccess() {
        if (state.get() == State.HALF_OPEN) {
            if (successCount.incrementAndGet() >= successThreshold) {
                transitionTo(State.CLOSED);
                failureCount.set(0);
                System.out.printf("[%s] HALF_OPEN → CLOSED (recovered)%n", name);
            }
        } else {
            failureCount.set(0); // reset on any success in CLOSED state
        }
    }

    private void onFailure() {
        lastFailureTime.set(System.currentTimeMillis());

        if (state.get() == State.HALF_OPEN) {
            transitionTo(State.OPEN);
            System.out.printf("[%s] HALF_OPEN → OPEN (probe failed)%n", name);
            return;
        }

        if (failureCount.incrementAndGet() >= failureThreshold) {
            transitionTo(State.OPEN);
            System.out.printf("[%s] CLOSED → OPEN (threshold reached: %d failures)%n",
                    name, failureCount.get());
        }
    }

    private void transitionTo(State next) {
        state.set(next);
    }

    @Override
    public String toString() {
        return String.format("CircuitBreaker[%s | state=%s | failures=%d]",
                name, state.get(), failureCount.get());
    }

    // ── Custom exception ──────────────────────────────────────────────────────

    public static class CircuitBreakerOpenException extends RuntimeException {
        public CircuitBreakerOpenException(String message) { super(message); }
    }
}
