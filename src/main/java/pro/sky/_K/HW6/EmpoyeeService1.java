package pro.sky._K.HW6;

import java.util.Collection;

public interface EmpoyeeService1 {
    Employee addEmployee(String firstName, String lastName) throws MaxEmployeesReachedException;

    Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAll();
}
