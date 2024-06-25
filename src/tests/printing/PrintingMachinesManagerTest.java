package printing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintingMachinesManagerTest {
    @Test
    void addPrintingMachine() {
        PrintingMachinesManager printingMachinesManager = new PrintingMachinesManager();
        printingMachinesManager.addPrintingMachine(100, true);
        assertEquals(1, printingMachinesManager.getPrintingMachines().size());
        assertEquals(100, printingMachinesManager.getPrintingMachines().get(0).getMaxBlankPages());
    }
}