package learn.lodgings;

import learn.guests.Guest;

public class CapsuleHotel implements Lodging {

    private final Guest[] rooms;

    public CapsuleHotel(int roomCount) {
        this.rooms = new Guest[roomCount];
    }

    @Override
    public boolean checkIn(Guest guest, int roomNumber) {
        int roomIndex = roomNumber - 1;
        // If room is empty
        if (rooms[roomIndex] == null) {
            rooms[roomIndex] = guest;
            return true;
        }

        // Unsuccessful (room not empty)
        return false;
    }

    @Override
    public boolean checkOut(int roomNumber) {
        int roomIndex = roomNumber - 1;
        // If room occupied
        if (rooms[roomIndex] != null) {
            rooms[roomIndex] = null;
            return true;
        }

        // Unsuccessful (room not occupied)
        return false;
    }

    @Override
    public String getGuestList(int roomNumber) {
        StringBuilder result = new StringBuilder();
        int roomIndex = roomNumber - 1;
        int startIndex = roomIndex - 5;
        int endIndex = roomIndex + 5; // inclusive
        int numberOfRooms = rooms.length;

        // If number of rooms is less than 11
        if (numberOfRooms <= 11) {
            startIndex = 0;
            endIndex = numberOfRooms - 1;
        } else {
            // Else:
            // If our startIndex is less than zero
            if (startIndex < 0) {
                // set it to 0
                startIndex = 0;
                endIndex = 10;
            } else if (endIndex >= numberOfRooms) {
                // If endIndex is past # of rooms, set it to number of rooms -1
                endIndex = numberOfRooms - 1;
                startIndex = numberOfRooms - 11;
            }
        }

        for (int i = startIndex; i <= endIndex; i++) {
            result.append(String.format("Capsule %s: %s%n", i + 1, rooms[i] == null ? "[unoccupied]" : rooms[i].getName()));
        }

        return result.toString();
    }

    @Override
    public boolean isFull() {
        for (Guest g : rooms) {
            if (g == null) {
                return false;
            }
        }

        return true;
    }
}

