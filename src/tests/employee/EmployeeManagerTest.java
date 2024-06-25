package employee;

import org.junit.jupiter.api.Test;
import utils.EmployeeType;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    @Test
    void addEmployee() {
        EmployeeManager employeeManager = new EmployeeManager(BigDecimal.valueOf(1000));
        employeeManager.addEmployee("John", EmployeeType.manager);
        assertEquals(1, employeeManager.getEmployees().size());
        assertEquals(BigDecimal.valueOf(1000), employeeManager.calculateEmployeeSalaries());

    }

    @Test
    void getEmployees() {
        EmployeeManager employeeManager = new EmployeeManager(BigDecimal.valueOf(1000));
        employeeManager.addEmployee("John", EmployeeType.manager);
        assertEquals(1, employeeManager.getEmployees().size());
        assertEquals("John", employeeManager.getEmployees().get(0).getName());
        assertEquals(BigDecimal.valueOf(1000), employeeManager.getEmployees().get(0).getSalary());
    }

    @Test
    void calculateEmployeeSalaries() {
        EmployeeManager employeeManager = new EmployeeManager(BigDecimal.valueOf(1000));
        employeeManager.addEmployee("John", EmployeeType.manager);
        assertEquals(BigDecimal.valueOf(1000), employeeManager.calculateEmployeeSalaries());

        employeeManager.addEmployee("Jane", EmployeeType.operator);
        assertEquals(BigDecimal.valueOf(2000), employeeManager.calculateEmployeeSalaries());
    }
}