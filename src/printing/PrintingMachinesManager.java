package printing;

import java.util.ArrayList;

public class PrintingMachinesManager {

    private final ArrayList<PrintingMachine> printingMachines;

    public PrintingMachinesManager() {
        printingMachines = new ArrayList<>();
    }

    public void addPrintingMachine(int maxPages, boolean isColor) {
        printingMachines.add(new PrintingMachine(maxPages, isColor));
    }

    public ArrayList<PrintingMachine> getPrintingMachines() {
        return printingMachines;
    }
}
