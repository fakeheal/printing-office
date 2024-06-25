package printing;

import exception.ManagerException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PaperSizeInventoryTest {

    @Test
    void addPaper() {
        PaperSizeInventory paperSizeInventory = new PaperSizeInventory();
        paperSizeInventory.addPaper(PaperSize.A4, BigDecimal.valueOf(5), 10);
        assertEquals(BigDecimal.valueOf(5), paperSizeInventory.get(PaperSize.A4).key());
        assertEquals(10, paperSizeInventory.get(PaperSize.A4).value());
    }

    @Test
    void removePaper() {
        PaperSizeInventory paperSizeInventory = new PaperSizeInventory();
        paperSizeInventory.addPaper(PaperSize.A4, BigDecimal.valueOf(5), 10);
        try {
            paperSizeInventory.removePaper(PaperSize.A4, 5);
            assertEquals(BigDecimal.valueOf(5), paperSizeInventory.get(PaperSize.A4).key());
            assertEquals(5, paperSizeInventory.get(PaperSize.A4).value());
        } catch (ManagerException e) {
            fail();
        }
    }
}