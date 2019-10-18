package assignment_three;

public class CompareEmployeesNameDescending extends CompareEmployeesName {


    @Override
    public int compare(Employee o1, Employee o2){

        return -super.compare(o1, o2);
    }


}
