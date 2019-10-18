package assignment_three;

public class Intern extends Employee {

    //Attributes
    private int gpa;

    //Constructor
    public Intern(String id, String name, double grossSalary, int gpa) {

        super(id, name, grossSalary);
        this.gpa = gpa;
    }

    public int getGpa() {
        return this.gpa;
    }


    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    //Method to calculate the gross salary of an intern.
    @Override
    public double getGrossSalary() {

        if (this.gpa < 5) {
            return 0;
        } else if (gpa >= 8) {
            return super.getGrossSalary() + 1000;
        }
        return super.getGrossSalary();
    }

    //The net salary of the intern is the same as his gross salary.
    @Override
    public double getNetSalary() {
        return this.getGrossSalary();
    }


}
