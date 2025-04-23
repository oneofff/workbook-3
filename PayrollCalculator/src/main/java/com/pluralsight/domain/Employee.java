package com.pluralsight.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(String csvLine) {
        String[] parts = csvLine.split("\\|");
        this.employeeId = Integer.parseInt(parts[0]);
        this.name = parts[1];
        this.hoursWorked = Double.parseDouble(parts[2]);
        this.payRate = Double.parseDouble(parts[3]);
    }

    public double getGrossPay() {
        return hoursWorked * payRate;
    }

    public String getCsvLine() {
        return this.employeeId + "|" +
                this.name + "|"
                + getGrossPay() + "\n";
    }

    @Override
    public String toString() {
        return String.format("Employee ID: %d, Name: %s, Hours Worked: %.2f, Pay Rate: %.2f, Gross Pay: %.2f",
                employeeId, name, hoursWorked, payRate, getGrossPay());
    }

    public String toJsonLine() {
        return String.format("{\"employeeId\": %d, \"name\": \"%s\", \"hoursWorked\": %.2f, \"payRate\": %.2f, \"grossPay\": %.2f}",
                employeeId, name, hoursWorked, payRate, getGrossPay());
    }
}
