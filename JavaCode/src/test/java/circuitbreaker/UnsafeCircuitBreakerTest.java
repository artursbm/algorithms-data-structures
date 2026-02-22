package circuitbreaker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnsafeCircuitBreakerTest {

    @Test
    void handleStateAfterServiceResponse() throws InterruptedException {
        int timeout = 1;
        var cb = new UnsafeCircuitBreaker(timeout);
        // how can I test this? First, I need to have a request simulator
        // it can be a simple array of status
        int[] responses = {200, 200, 500, 500, 500, 500, 500, 200, 200, 200, 200};
        //                  0    1    2    3    4    5    6    7    8    9   10
        // this responses tells me that the system is working fine, then it starts to fail...
        // after 3 500s, I need to open the circuit, and I can wait for 10s to call it again
        // the state will be HALF_OPEN; I'll get a new 500, which will change the state to OPEN
        // after another 10s, HALF_OPEN again. I'll request again for 3 times, get 3 200s and the system healthy (CLOSED)
        assertEquals(StateEnum.CLOSED, cb.getState());

        cb.handleStateAfterServiceResponse(responses[0]);
        assertEquals(StateEnum.CLOSED, cb.getState());

        cb.handleStateAfterServiceResponse(responses[1]);
        assertEquals(StateEnum.CLOSED, cb.getState());

        cb.handleStateAfterServiceResponse(responses[2]);
        assertEquals(StateEnum.CLOSED, cb.getState());

        cb.handleStateAfterServiceResponse(responses[3]);
        assertEquals(StateEnum.CLOSED, cb.getState());

        cb.handleStateAfterServiceResponse(responses[4]);
        assertEquals(StateEnum.OPEN, cb.getState());

        Thread.sleep(timeout * 1000);
        cb.handleStateAfterServiceResponse(responses[5]);
        assertEquals(StateEnum.HALF_OPEN, cb.getState());

        cb.handleStateAfterServiceResponse(responses[6]);
        assertEquals(StateEnum.OPEN, cb.getState());

        assertThrows(IllegalStateException.class, () -> cb.handleStateAfterServiceResponse(responses[6]));
        assertEquals(StateEnum.OPEN, cb.getState());

        Thread.sleep(timeout * 1000);
        cb.handleStateAfterServiceResponse(responses[7]);
        assertEquals(StateEnum.HALF_OPEN, cb.getState());

        cb.handleStateAfterServiceResponse(responses[8]);
        assertEquals(StateEnum.HALF_OPEN, cb.getState());

        cb.handleStateAfterServiceResponse(responses[9]);
        assertEquals(StateEnum.HALF_OPEN, cb.getState());

        cb.handleStateAfterServiceResponse(responses[10]);
        assertEquals(StateEnum.CLOSED, cb.getState());


    }
}
