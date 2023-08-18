package learn;

import learn.ui.LodgingController;

public class App {
    public static void main(String[] args) {
        LodgingController lodgingController = new LodgingController();
        lodgingController.run();
    }

    // Digging into the code:
    // 1. What is the entry point to this application?
    // Our App

    // 2. What classes does Lodging Controller use?
    // 3. How is a Lodging related to a CapsuleHotel?
    // 4. How are Guests and Reservations related?
}

// From Office Hours Notes: OOP Capsule Hotel Planning
// Menus could be a class => Hotel/Lodging Manager
// What are the "Real World Things" in the app? Guest, Hotel
// Lodging Interface => Every Lodging can checkIn, checkOut, viewGuests
// CapsuleHotel implements the Lodging Interface
// One day our app could support Inns, Motels, Resorts
// Guest class
// Stretch feature: Room class

// A concrete class can implement an Interface
// An object is an "instance" of a class