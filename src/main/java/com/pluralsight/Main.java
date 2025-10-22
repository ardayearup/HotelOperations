package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(2, 150.0, false, false);
        System.out.println("Room Test:\n" + room);

        Reservation res = new Reservation("king", 3, true);
        System.out.println("\nReservation Test:\n" + res);

        Employee emp = new Employee(101, "Alice Smith", "Front Desk", 20.0, 45);
        System.out.println("\nEmployee Test:\n" + emp);
        emp.punchIn();
        emp.punchOut();

        Hotel hotel = new Hotel("Sunrise Inn", 5, 10);
        System.out.println("\nHotel Test:\n" + hotel);
        boolean booked1 = hotel.bookRoom(2, true);
        boolean booked2 = hotel.bookRoom(3, false);
        System.out.println("Booking suites: " + booked1);
        System.out.println("Booking basic rooms: " + booked2);
        System.out.println("After booking:\n" + hotel);
    }
}