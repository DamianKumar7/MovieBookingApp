import java.util.List;

public class BookSeats {
    List<String> seatsToBeBooked;
    Show newShow;

    BookSeats(List<String> seatsToBeBooked, Show newShow) throws SeatIsAlreadyPresentException {
        this.newShow = newShow;
        this.seatsToBeBooked = seatsToBeBooked;

    }

    public boolean checkSeatsAreEmptyForBooking() throws OrderedMoreSeatsThanAllotedInTheatre {
        if (seatsToBeBooked.size() > newShow.seats.size()) {
            throw new OrderedMoreSeatsThanAllotedInTheatre("Entered more seats than what are present in the theatre");
        }
        for (String s : seatsToBeBooked) {
            if (!newShow.mapForSeats.get(s)) {
                return false;
            }
        }
        markBookedSeatsAsOccupied();
        return true;
    }

    public void markBookedSeatsAsOccupied() {
        for (String s : seatsToBeBooked) {
            newShow.mapForSeats.put(s, false);
        }
    }


}
