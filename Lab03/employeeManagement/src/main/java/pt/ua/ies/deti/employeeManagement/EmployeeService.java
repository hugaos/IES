package pt.ua.ies.deti.employeeManagement;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import pt.ua.ies.deti.employeeManagement.Employee;
import pt.ua.ies.deti.employeeManagement.EmployeeRepository;
@Service
@AllArgsConstructor
public class EmployeeService implements EmployeeServiceInt {
    private EmployeeRepository EmployeeRepository;

    @Override
    public Employee createEmployee(Employee Employee) {
        return EmployeeRepository.save(Employee);
    }

    @Override
    public Employee getEmployeeById(Long EmployeeId) {
        Optional<Employee> optionalEmployee = EmployeeRepository.findById(EmployeeId);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return EmployeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee Employee) {
        Employee existingEmployee = EmployeeRepository.findById(Employee.getId()).get();
        existingEmployee.setFirstName(Employee.getFirstName());
        existingEmployee.setLastName(Employee.getLastName());
        existingEmployee.setEmail(Employee.getEmail());
        Employee updatedEmployee = EmployeeRepository.save(existingEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long EmployeeId) {
        EmployeeRepository.deleteById(EmployeeId);
    }

    @Override
    public List<Employee> getEmployeeByEmail(String email) {
        return EmployeeRepository.findByEmail(email);
    }
}
