package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(2, 150.0, false, false);
        System.out.println("Room Test:\n" + room);

        Reservation res = new Reservation("king", 3, true);
        System.out.println("\nReservation Test:\n" + res);

        Employee emp = new Employee(101, "Alice Smith", "Front Desk", 20.0, 45);
        System.out.println("\nEmployee Test:\n" + emp);
    }
}