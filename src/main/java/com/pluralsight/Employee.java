package com.pluralsight;

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