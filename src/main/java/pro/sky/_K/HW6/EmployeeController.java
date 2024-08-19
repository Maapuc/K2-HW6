package pro.sky._K.HW6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService service;


    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEpmloyee(@RequestParam String lastName,@RequestParam String firsName) {
        return service.addEmployee(lastName, firsName);
    }

    @GetMapping("/remove")
    public Employee removeEpmloyee(@RequestParam String lastName,@RequestParam String firsName) {
        return service.removeEmployee(lastName, firsName);
    }

    @GetMapping("/finde")
    public Employee findEpmloyee(@RequestParam String lastName,@RequestParam String firsName) {
        return service.findEmployee(lastName, firsName);
    }

    @GetMapping
    public Collection<Employee> getAll() {
        return service.getAll();
    }
}