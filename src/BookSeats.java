import java.util.List;

public class BookSeats {
    List<String>seatsToBeBooked;
    Show newShow;
    BookSeats(List<String> seatsToBeBooked,Show newShow) throws SeatIsAlreadyPresentException {
        this.seatsToBeBooked = seatsToBeBooked;
        this.newShow = newShow;
    }
    public boolean checkSeatsAreEmptyForBooking()throws OrderedMoreSeatsThanAllotedInTheatre
    {
        if(seatsToBeBooked.size()>newShow.seats.size())
            throw new OrderedMoreSeatsThanAllotedInTheatre("Entered more seats than what are present in the theatre");
        for(int seatNumber = 0;seatNumber<seatsToBeBooked.size();seatNumber++){
            if(!newShow.mapForSeats.get(seatsToBeBooked.get(seatNumber))){
                return false;
            }
        }
        markBookedSeatsAsOccupied();
        return true;
    }
    public void markBookedSeatsAsOccupied(){
        for(int seat = 0;seat<seatsToBeBooked.size();seat++){
            newShow.mapForSeats.put(seatsToBeBooked.get(seat),false);
        }
    }


}
