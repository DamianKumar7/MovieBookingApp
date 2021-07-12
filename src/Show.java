import java.util.HashMap;
import java.util.List;

public class Show {
    List<String> seats;
    HashMap<String, Boolean> mapForSeats;

    Show(List<String> seats) throws SeatIsAlreadyPresentException {
        this.seats = seats;
        mapForSeats = new HashMap<>();
        for (String seat : seats) {
            if (mapForSeats.containsKey(seat)) {
                throw new SeatIsAlreadyPresentException("The Seat Is Already Present In The Theatre");
            }
            mapForSeats.put(seat, true);
        }

    }



}
