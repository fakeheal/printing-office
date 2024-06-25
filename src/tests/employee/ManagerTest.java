package employee;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {

    @Test
    void getName() {
        Manager manager = new Manager("John", BigDecimal.valueOf(1000));
        assertEquals("John", manager.getName());
    }

    @Test
    void getSalary() {
        Manager manager = new Manager("John", BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000), manager.getSalary());
    }
}