package assignment_three;

import java.util.*;

/* Downsides of promoting an object is that
  we have to access the original salary, which reduces the encapsulation of the original salary */
public class ReusaxCorp {

    /*once a new employee is created it will end up in this map. to get
    access to the items in your map you use a key which in this case is the ID*/
    private HashMap<String, Employee> employees = new HashMap<>();

    //Register new employees.
    public void register(Employee newEmployee) {
        if (!checkId(newEmployee.getId()))
            employees.put(newEmployee.getId(), newEmployee);
    }

    //Removing employees.
    public void remove(String id) {
        Employee toBeRemoved = retrieveEmployee(id);
        if (toBeRemoved != null)
            employees.remove(id);

    }

    //This method returns the Employee using the given id as a key to access it (if it exists) in the map.
    public Employee retrieveEmployee(String id) {

        if (employees.get(id) != null)
            return employees.get(id);

        return null;
    }

    //following methods updates/change the attributes
    public void updateName(String id, String newName) {

        retrieveEmployee(id).setName(newName);
    }

    public void updateSalary(String id, double newSalary) {

        retrieveEmployee(id).setGrossSalary(newSalary);
    }

    public void updateDegree(String id, char degree) {

        if (checkIfManager(id))
            ((Manager) retrieveEmployee(id)).setDegree(degree);
    }

    public void updateDepartment(String id, String department) {

        if (checkIfDirector(id))
            ((Director) retrieveEmployee(id)).setDepartments(department);
    }

    public void updateGpa(String id, int gpa) {

        if (checkIfIntern(id))
            ((Intern) retrieveEmployee(id)).setGpa(gpa);
    }

    public void setDirectorsBenefit(double directorsBenefit) {

        Director.setDirectorsBenefit(directorsBenefit);

    }

    //Calculating the total amount of gross salaries
    public double payGrossSalaries() {
        double totalGrossSalary = 0.0;

        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            String key = entry.getKey();
            Employee value = entry.getValue();
            totalGrossSalary += value.getGrossSalary();

        }
        return totalGrossSalary;
    }

    //Calculating the total amount of net salaries
    public double payNetSalaries() {
        double totalNetSalary = 0.0;

        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            String key = entry.getKey();
            Employee value = entry.getValue();
            totalNetSalary += value.getGrossSalary();

        }
        return totalNetSalary;
    }

    //returns the amount of employees
    public int numberOfEmployees() {
        return employees.size();

    }

    //Creating new employee
    public Employee createEmployee(String id, String name, double salary) {

        return new Employee(id, name, salary);
    }

    //Creating new intern
    public Intern createIntern(String id, String name, double salary, int gpa) {

        return new Intern(id, name, salary, gpa);
    }

    //Creating new Manager
    public Manager createManager(String id, String name, double salary, char degree) {

        return new Manager(id, name, salary, degree);
    }

    //Creating new Director
    public Director createDirector(String id, String name, double salary, char degree, String department) {

        return new Director(id, name, salary, degree, department);

    }

    /*Task 5
    Changing the employee's role to another.
    By using the hashmap and the key ID to access the employee it will automatically
    remove the old employee when the new promoted one is created.

    We didn't downcast to avoid taking risks, but we don't save the degree of a manager getting promoted to a Director as a result.
    If we had more complex code, we would either have  a lot more unsaved data, or we would have to downcast which is very risky.
    The salary that is used is the base salary that exist in Employee which also makes this solution better.
    If we used the salary that is used in each role that extends from the employee, it would make
    it more difficult to go from a higher level employee to a lower level.*/

    public void promoteToManager(String id, char degree) {

        Employee oldEmployee = retrieveEmployee(id);
        Manager promotedEmployee = createManager(oldEmployee.getId(), oldEmployee.getName(), oldEmployee.getOriginalSalary(), degree);
        employees.put(id, promotedEmployee);

    }

    public void promoteToEmployee(String id) {

        Employee oldEmployee = retrieveEmployee(id);
        Employee promotedEmployee = createEmployee(oldEmployee.getId(), oldEmployee.getName(), oldEmployee.getOriginalSalary());
        employees.put(id, promotedEmployee);

    }

    public void promoteToIntern(String id, int gpa) {

        Employee oldEmployee = retrieveEmployee(id);
        Intern promotedEmployee = createIntern(oldEmployee.getId(), oldEmployee.getName(), oldEmployee.getOriginalSalary(), gpa);
        employees.put(id, promotedEmployee);

    }

    public void promoteToDirector(String id, char degree, String department) {

        Employee oldEmployee = retrieveEmployee(id);
        Director promotedEmployee = createDirector(oldEmployee.getId(), oldEmployee.getName(), oldEmployee.getOriginalSalary(), degree, department);
        employees.put(id, promotedEmployee);

    }

    /* if the boolean is true the order of the attributes will be ascending.
    if it turns out to be false the order of the attributes will be descending.*/
    public List sortBy(String sortingType, boolean sortingDirection) {

        ArrayList<Employee> employeesList = new ArrayList<>(employees.values());

        if (sortingType.equalsIgnoreCase("name")) {
            if (sortingDirection)
                Collections.sort(employeesList, new CompareEmployeesName());
            else {
                Collections.sort(employeesList, new CompareEmployeesNameDescending());
            }

        } else if (sortingType.equalsIgnoreCase("netSalary")) {
            if (sortingDirection)
                Collections.sort(employeesList, new CompareEmployeesNetSalary());
            else {
                Collections.sort(employeesList, new CompareEmployeesNetSalaryDescending());

            }

        }
        return employeesList;
    }

    // We use the method checkId every time the user searches anf creates a new ID/employee.
    public boolean checkId(String id) {

        boolean idExists = false;
        if (employees.containsKey(id))
            idExists = true;
        return idExists;
    }

    // We check if the given id is of the specific type we send.
    // You need to create a dummy object/reference of the given type you want check for to use this method.
    public boolean checkIfManager(String id) {

        boolean isAManager = false;
        if (retrieveEmployee(id) instanceof Manager)
            isAManager = true;
        return isAManager;
    }

    public boolean checkIfIntern(String id) {

        boolean isAIntern = false;
        if (retrieveEmployee(id) instanceof Intern)
            isAIntern = true;
        return isAIntern;
    }

    public boolean checkIfDirector(String id) {

        boolean isADirector = false;
        if (retrieveEmployee(id) instanceof Director)
            isADirector = true;
        return isADirector;
    }
}
