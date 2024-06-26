package employee;

import utils.EmployeeType;

import java.math.BigDecimal;
import java.util.ArrayList;

public class EmployeeManager {
    private final ArrayList<Employee> employees = new ArrayList<>();

    private final BigDecimal baseSalary;

    public EmployeeManager(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void addEmployee(String name, EmployeeType employeeType) {
        if (employeeType == EmployeeType.manager) {
            employees.add(new Manager(name, baseSalary));
        } else {
            employees.add(new Operator(name, baseSalary));
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public BigDecimal calculateEmployeeSalaries(BigDecimal bonus) {
        BigDecimal totalSalaries = new BigDecimal(0);
        for (Employee employee : employees) {
            BigDecimal salary = employee.getSalary();
            if (employee instanceof Manager) {
                salary = salary.add(bonus);
            }
            totalSalaries = totalSalaries.add(salary);
        }
        return totalSalaries;
    }
}
