package pro.sky._K.HW6;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 100; // Максимальное количество сотрудников
    private List<Employee> employees; // Коллекция для хранения сотрудников

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    // Методы для управления сотрудниками

    // Шаг 2: Добавление сотрудника по имени и фамилии
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

    // Шаг 3: Удаление сотрудника по имени и фамилии
    public void removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employeeToRemove = findEmployee(firstName, lastName);
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    // Шаг 4: Поиск сотрудника по имени и фамилии
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        return null; // Если сотрудник не найден
    }
}

