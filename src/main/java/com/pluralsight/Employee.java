package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
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