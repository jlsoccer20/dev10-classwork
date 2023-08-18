package learn.lodgings;

import learn.guests.Guest;

public interface Lodging {
    boolean checkIn(Guest guest, int roomNumber);

    boolean checkOut(int roomNumber);

    String getGuestList(int roomNumber);

    boolean isFull();
}

