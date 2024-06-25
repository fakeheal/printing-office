package employee;

import java.math.BigDecimal;

abstract public class Employee {

    protected final BigDecimal salary;
    private final String name;

    public Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
