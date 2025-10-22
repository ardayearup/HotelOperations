package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;
    private boolean punchedIn;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.punchedIn = false;
    }

    public void punchIn(double time) {
        if (punchedIn) {
            System.out.println(name + " has already punched in!");
        } else {
            startTime = time;
            punchedIn = true;
            System.out.println(name + " punched in at " + time);
        }
    }

    public void punchIn() {
        if (punchedIn) {
            System.out.println(name + " has already punched in!");
        } else {
            LocalDateTime now = LocalDateTime.now();
            startTime = now.getHour() + now.getMinute() / 60.0;
            punchedIn = true;
            System.out.println(name + " punched in at " + now.getHour() + ":" + now.getMinute());
        }
    }

    public void punchOut(double time) {
        if (!punchedIn) {
            System.out.println(name + " has not punched in yet!");
        } else if (time < startTime) {
            System.out.println("Invalid punch-out time. Time cannot be earlier than punch-in time.");
        } else {
            double hours = time - startTime;
            hoursWorked += hours;
            punchedIn = false;
            System.out.println(name + " punched out at " + time + " (worked " + hours + " hours)");
        }
    }

    public void punchOut() {
        if (!punchedIn) {
            System.out.println(name + " has not punched in yet!");
        } else {
            LocalDateTime now = LocalDateTime.now();
            double currentTime = now.getHour() + now.getMinute() / 60.0;
            double hours = currentTime - startTime;
            if (hours < 0) {
                System.out.println("Invalid punch-out time.");
            } else {
                hoursWorked += hours;
                punchedIn = false;
                System.out.println(name + " punched out at " + now.getHour() + ":" + now.getMinute() + " (worked " + hours + " hours)");
            }
        }
    }

    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay() {
        return getRegularHours() * payRate + getOvertimeHours() * payRate * 1.5;
    }

    @Override
    public String toString() {
        return "Employee " + name + " (ID: " + employeeId + ") in " + department +
                " worked " + hoursWorked + " hrs, Pay: $" + getTotalPay();
    }
}