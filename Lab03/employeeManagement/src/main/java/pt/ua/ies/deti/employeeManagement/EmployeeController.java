package pt.ua.ies.deti.employeeManagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import pt.ua.ies.deti.employeeManagement.EmployeeService;
import pt.ua.ies.deti.employeeManagement.Employee;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;



import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService EmployeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = EmployeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
        Employee employee = EmployeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(name = "email", required = false) String email) {
        List<Employee> employees;
        if (email != null) {
            employees = EmployeeService.getEmployeeByEmail(email);
        } else {
            employees = EmployeeService.getAllEmployees();
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
                                                   @RequestBody Employee employee) {
        employee.setId(employeeId);
        Employee updatedEmployee = EmployeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        EmployeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }
}
