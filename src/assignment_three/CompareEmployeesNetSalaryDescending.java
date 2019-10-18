package assignment_three;

public class CompareEmployeesNetSalaryDescending extends CompareEmployeesNetSalary {

    @Override
    public int compare(Employee o1, Employee o2){

        return -super.compare(o1, o2);
    }
}
