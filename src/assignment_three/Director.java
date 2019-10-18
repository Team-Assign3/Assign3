package assignment_three;

public class Director extends Manager {

    //Attributes
    private String departments;
    private static double directorsBenefit = 0;


    //Constructor with the including info from the superclass employee.
    public Director(String id, String name, double grossSalary, char degree,
                    String departments) {
        super(id, name, grossSalary, degree);
        this.departments = departments;

    }

    @Override
    public double getGrossSalary() {
        return super.getGrossSalary() + directorsBenefit;

    }

    //Getters and setters

    public String getDepartment() {
        return this.departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public double getDirectorsBenefit() {
        return this.directorsBenefit;
    }

    public static void setDirectorsBenefit(double directorsBonus) {
        directorsBenefit = directorsBonus;
    }


    @Override
    public double getNetSalary() {

        //Calculate the directors taxes with a if statement
        /*if the salary is less than 30k the tax is 10%
         * if it's between 30k and 50k it's 40% taxes
         * if it's more than 50 its first 20% tax on the first 30k of your salary then 40% tax on that above*/

        double grossSalary = this.getGrossSalary();
        double netSalary = 0;

        if (grossSalary < 30000) {
            netSalary = grossSalary * 0.90;
        } else if ((grossSalary >= 30000) && (grossSalary <= 50000)) {
            netSalary = grossSalary * 0.80;
        } else if (grossSalary > 50000) {
            netSalary = grossSalary - (30000 * 0.20) - ((grossSalary - 30000) * 0.40);
        }

        return netSalary;

    }

}

