import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookSeatsTest {

    @Test
    void checkSeatsAreEmptyForBookingThrowsMoreSeatsOrderedThanPresentException() {
        boolean exceptionForMoreSeatsOrderedThrown = false;
        try {
            Show newShow = new Show(Arrays.asList("A1","A2","A3","A4","A5","A5","A6","A7"));
            BookSeats bookSeatsForShow = new BookSeats(Arrays.asList("A1","A2","A3","A4","A5","A5","A6","A7,A8"),newShow);

        } catch (SeatIsAlreadyPresentException e) {
            exceptionForMoreSeatsOrderedThrown = true;
        }
        assertTrue(exceptionForMoreSeatsOrderedThrown);

    }
    @Test
    void checkSeatsAreEmptyForBooking() throws SeatIsAlreadyPresentException, OrderedMoreSeatsThanAllotedInTheatre {
        Show newShow = new Show(Arrays.asList("A1","A2","A3","A4","A5","A5","A6","A7"));
        BookSeats bookSeatsForShow = new BookSeats(Arrays.asList("A1","A2"),newShow);

        boolean seatsSucessfullyBooked = bookSeatsForShow.checkSeatsAreEmptyForBooking();
        assertTrue(seatsSucessfullyBooked);
    }
}