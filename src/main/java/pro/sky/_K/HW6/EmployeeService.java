package pro.sky._K.HW6;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeService implements EmpoyeeService1 {
    private static final int MAX_EMPLOYEES = 100;
    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName)  {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new MaxEmployeesReachedException("Максимальное количество сотрудников уже достигнуто");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employeeToRemove = findEmployee(firstName, lastName);
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employeeToRemove;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Collection<Employee> getAll() {
        return List.of();
    }

}

