import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ShowTest {

    @Test
    void checkSeatIsAlreadyPresentExceptionForSameSeatEnteredTwice() {
        boolean seatAlreadyPresentExceptionThrown = false;
        try {
            Show newShowInstance = new Show(Arrays.asList("A1", "A2", "A3", "A1"));

        } catch (SeatIsAlreadyPresentException e) {
            seatAlreadyPresentExceptionThrown = true;
        }
        assertTrue(seatAlreadyPresentExceptionThrown);
    }




}