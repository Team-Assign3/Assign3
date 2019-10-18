package assignment_three;

public class Manager extends Employee {

    //Attributes
    //b = BSc. m = MSc. p = PHD
    private char degree;

    public Manager(String id, String name, double grossSalary, char degree) {
        super(id, name, grossSalary);
        this.degree = degree;

    }

    public char getDegree(){

        return this.degree;
    }

    public void setDegree(char degree) {
        this.degree = degree;
    }

    //Calculating the net salary for the manager, including the bonus they get depending on their degree.
    @Override
    public double getGrossSalary() {
        if (degree == 'b')
            return (super.getGrossSalary() * 1.1);
        else if (degree == 'm')
            return (super.getGrossSalary() * 1.2);
        else if (degree == 'p')
            return (super.getGrossSalary() * 1.35);

        return super.getGrossSalary();
    }

}

