package assignment_three;

import java.util.Comparator;

public class CompareEmployeesNetSalary implements Comparator<Employee> {

    /*Comparing the employees net salaries by using an if and
         put them in size order. If the size is the same they will be printed in alphabetical order.*/
    @Override
    public int compare(Employee o1, Employee o2) {

        if(o1.getNetSalary()== o2.getNetSalary())
            return o1.getName().compareToIgnoreCase(o2.getName());
        if((o1.getNetSalary()-o2.getNetSalary())>0)
            return 1;
        if((o1.getNetSalary()-o2.getNetSalary())<0)
            return -1;
        return 0;
    }
}
