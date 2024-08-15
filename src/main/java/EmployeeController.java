import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky._K.HW6.Employee;
import pro.sky._K.HW6.EmployeeService;
import pro.sky._K.HW6.MaxEmployeesReachedException;

import java.util.Collection;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    private final EmployeeService service;

    @RequestMapping("/add")

    public void addEmployee(@RequestParam String firstName, @RequestParam String lastName) throws MaxEmployeesReachedException {
    service.addEmployee(firstName, lastName);

    }

    @RequestMapping("/remove")
    public void removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        service.removeEmployee(firstName, lastName);

    }

    @RequestMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }
    @RequestMapping("all")
    public Collection<Employee> getAll() {
        return service.getAll();
    }

}


