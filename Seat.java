
/**
 * Write a description of class Seat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Seat {
    private int seatNumber;
    private boolean isReserved;

    public Seat(boolean isReserved, int seatNumber) {
        this.isReserved = isReserved;
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public boolean getReservationStatus() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void unreserve() {
        isReserved = false;
    }
}

