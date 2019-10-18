package assignment_three;

import java.util.Objects;

public class Employee {

    //Attributes
    private String id;
    private String name;
    private double grossSalary;

    //Constructor
    public Employee(String id, String name, double grossSalary) {
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
    }

    //Getters and setters
    public String getId() {
        return this.id;
    }

    public double getOriginalSalary() {

        return this.grossSalary;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }


    //Calculating the net salary
    public double getNetSalary() {
        return (getGrossSalary() * 0.90);
    }

    //toString to print the employee
    public String toString() {
        return (this.name + "’s gross salary is of " + getGrossSalary() + " SEK per month.");
    }

    /*equal and hashcode for the ID only. Use to compare two objects of type Employee, when you have the same ID you're equal.*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


