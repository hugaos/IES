package pt.ua.ies.deti.employeeManagement;
import java.util.List;
import pt.ua.ies.deti.employeeManagement.Employee;
public interface EmployeeServiceInt {
    Employee createEmployee(Employee Employee);

    Employee getEmployeeById(Long EmployeeId);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee Employee);

    void deleteEmployee(Long EmployeeId);

    List<Employee> getEmployeeByEmail(String EmployeeEmail);
}
