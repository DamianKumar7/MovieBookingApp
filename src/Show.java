import java.util.HashMap;
import java.util.List;

public class Show {
    List<String> seats;
    HashMap<String, Boolean> mapForSeats;

    Show(List<String> seats) throws SeatIsAlreadyPresentException {
        this.seats = seats;
        mapForSeats = new HashMap<>();
        for (int seatNumber = 0; seatNumber < seats.size(); seatNumber++) {
            if (mapForSeats.containsKey(seats.get(seatNumber)) == true) {
                throw new SeatIsAlreadyPresentException("The Seat Is Already Present In The Theatre");
            }
            mapForSeats.put(seats.get(seatNumber), true);
        }

    }



}
