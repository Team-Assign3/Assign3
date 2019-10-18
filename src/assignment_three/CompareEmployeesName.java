package assignment_three;

import java.util.Comparator;

public class CompareEmployeesName implements Comparator<Employee> {

    /*Compare the employees' names and put them in alphabetical order by using an if statement.
        If the name is the same the first one will be the one with  the lowest salary.*/
    @Override
    public int compare(Employee o1, Employee o2) {
    if(o1.getName().equalsIgnoreCase(o2.getName())==false)
        return o1.getName().compareToIgnoreCase(o2.getName());
    if(o1.getOriginalSalary()-o2.getOriginalSalary()>0)
        return 1;
    if(o1.getOriginalSalary()-o2.getOriginalSalary()<0)
            return -1;
  return 0;
    }

}
