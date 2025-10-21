package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public void checkIn() {
        if (!occupied && !dirty) {
            occupied = true;
            dirty = true;
            System.out.println("Check-in completed.");
        }
        else if (!occupied && dirty) {
            System.out.println("Check-in failed. Room needs to be cleaned");
        }
        else  {
            System.out.println("Check-in failed. Room is occupied.");
        }


    }

    public  void checkOut() {
        if (occupied) {
            occupied = false;
            dirty = true;
            System.out.println("Check-out completed.");
        } else {
            System.out.println("Check-out failed. Room is not occupied.");
        }
    }

    public void cleanRoom() {
        if (dirty && !occupied) {
            dirty = false;
            System.out.println("Room is cleaned and ready for check-in.");
        }
        else if (occupied) {
            System.out.println("Room is occupied and not available for cleaning.");
            }
        else {
            System.out.println("Room is already clean and ready for check-in");
        }

    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    @Override
    public String toString() {
        return "Room with " + numberOfBeds + " beds, $" + price + ", " +
                (occupied ? "Occupied" : "Available") + ", " +
                (dirty ? "Dirty" : "Clean");
    }
}