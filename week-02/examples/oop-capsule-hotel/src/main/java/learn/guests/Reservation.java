package learn.guests;

public class Reservation {
    private Guest guest;
    int roomNumber;

    public Reservation(Guest guest, int roomNumber) {
        this.guest = guest;
        this.roomNumber = roomNumber;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
