package employee;

import java.math.BigDecimal;

public class Manager extends Employee {
    public Manager(String name, BigDecimal salary) {
        super(name, salary);
    }

    @Override
    public BigDecimal getSalary() {
        return salary;
    }
}
