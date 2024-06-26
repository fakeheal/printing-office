package printing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintingMachinesManagerTest {
    @Test
    void addPrintingMachine() {
        PaperManager paperManager = new PaperManager();
        PrintingMachinesManager printingMachinesManager = new PrintingMachinesManager(paperManager);
        printingMachinesManager.addPrintingMachine(new PrintingMachine(100, false));
        assertEquals(1, printingMachinesManager.getPrintingMachines().size());
        assertEquals(100, printingMachinesManager.getPrintingMachines().get(0).getMaxBlankPages());
    }
}