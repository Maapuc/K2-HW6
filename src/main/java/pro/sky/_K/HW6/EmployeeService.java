package pro.sky._K.HW6;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 100;
    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }


    public void addEmployee(String firstName, String lastName) throws MaxEmployeesReachedException {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new MaxEmployeesReachedException("Максимальное количество сотрудников уже достигнуто");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        Employee newEmployee = new Employee(firstName, lastName);
        employees.add(employee);
    }


    public void removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employeeToRemove = findEmployee(firstName, lastName);
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }


    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        return null;
    }

    public Collection<Employee> getAll() {
        return employees;
    }
}

