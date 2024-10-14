package pro.sky._K.HW6;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmpoyeeService1 {
    private static final int MAX_EMPLOYEES = 100;
    private final Map<String, Employee> employees;
    private java.util.Collection<Employee> Collection;

    public EmployeeService() {
        this.employees = new HashMap<>(MAX_EMPLOYEES);
    }


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new MaxEmployeesReachedException("Максимальное количество сотрудников уже достигнуто");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        var key = makekey(firstName, lastName);
        employees.put(key, employee);
        return employee;
    }

    private static String makekey(String firstName, String lastName) {
        return (firstName + "_" + lastName).toLowerCase();
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        var key = makekey(firstName, lastName);
        var removed = employees.remove(key);
        if (removed == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return removed;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        var key = makekey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    @Override
    public Collection<Employee> getAll() {
        return Collection;
    }
}


