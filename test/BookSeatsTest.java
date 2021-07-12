import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookSeatsTest {

    @Test
    void testSeatsAreEmptyForBookingThrowsMoreSeatsOrderedThanPresentException() {
        boolean exceptionForMoreSeatsOrderedThrown = false;
        try {
            Show newShow = new Show(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A5", "A6", "A7"));
            BookSeats bookSeatsForShow = new BookSeats(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A5", "A6", "A7,A8"), newShow);
            bookSeatsForShow.checkSeatsAreEmptyForBooking();
        } catch (OrderedMoreSeatsThanAllotedInTheatre | SeatIsAlreadyPresentException e) {
            exceptionForMoreSeatsOrderedThrown = true;
        }
        assertTrue(exceptionForMoreSeatsOrderedThrown);

    }

    @Test
    void testSeatsAreEmptyForBooking() throws SeatIsAlreadyPresentException, OrderedMoreSeatsThanAllotedInTheatre {

        try {
            Show newShow = new Show(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7"));
            BookSeats bookSeatsForShow = new BookSeats(Arrays.asList("A1", "A2"), newShow);

            boolean seatsSucessfullyBooked = bookSeatsForShow.checkSeatsAreEmptyForBooking();
            assertTrue(seatsSucessfullyBooked);
        } catch (OrderedMoreSeatsThanAllotedInTheatre e) {
        }

    }

    @Test
    void testForAttemptToBookOccupiedSeat() throws SeatIsAlreadyPresentException, OrderedMoreSeatsThanAllotedInTheatre {
        Show newShow = new Show(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7"));
        BookSeats bookSeatsForGroup1 = new BookSeats(Arrays.asList("A1", "A2"), newShow);
        BookSeats bookSeatsForGroup2 = new BookSeats(Arrays.asList("A1", "A2"), newShow);
        boolean seatsSuccesfullyBookedForGroup1 = bookSeatsForGroup1.checkSeatsAreEmptyForBooking();
        boolean seatsSuccesfullyBookedForGroup2 = bookSeatsForGroup2.checkSeatsAreEmptyForBooking();

        assertFalse(seatsSuccesfullyBookedForGroup2);

    }

    @Test
    void testForBookingSeatsInTwoDifferentShows() throws SeatIsAlreadyPresentException, OrderedMoreSeatsThanAllotedInTheatre {
        Show show1 = new Show(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A9"));
        Show show2 = new Show(Arrays.asList("A1", "A2", "A3", "A4", "A5"));

        BookSeats bookSeatsForGroup1 = new BookSeats(Arrays.asList("A1", "A2"), show1);
        BookSeats bookSeatsForGroup2 = new BookSeats(Arrays.asList("A1", "A2"), show2);

        assertTrue(bookSeatsForGroup1.checkSeatsAreEmptyForBooking());
        assertTrue(bookSeatsForGroup2.checkSeatsAreEmptyForBooking());

    }
}