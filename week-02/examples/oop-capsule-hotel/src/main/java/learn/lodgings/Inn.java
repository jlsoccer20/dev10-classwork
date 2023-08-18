package learn.lodgings;

import learn.guests.Guest;
import learn.guests.Reservation;

import java.util.ArrayList;

public class Inn implements Lodging {


    // ArrayLists --> Dynamic length

    // Initializing a new array list
    //This array list only holds this data type called "Reservation"
    private final ArrayList<Reservation> reservations = new ArrayList<>();


    @Override
    public boolean checkIn(Guest guest, int roomNumber) {
        // Create a new reservation from the Guest and room Number
        // Add it to the reservations list
        Reservation newReservation = new Reservation(guest, roomNumber);
        // .add() -> with one argument
        reservations.add(newReservation);
        // .add(idx, item) -> insert an element at a specified index
        // .addAll()
        // Can create a new ArrayList from an existing array
        // new ArrayList<>(Arrays.asList(array))

        return true;
    }

    @Override
    public boolean checkOut(int roomNumber) {
        return false;
    }

    @Override
    public String getGuestList(int roomNumber) {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
