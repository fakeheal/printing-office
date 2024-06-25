package employee;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void getName() {
        Operator operator = new Operator("Operator", BigDecimal.valueOf(1000));
        assertEquals("Operator", operator.getName());

    }

    @Test
    void getSalary() {
        Operator operator = new Operator("Operator", BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000), operator.getSalary());
    }
}