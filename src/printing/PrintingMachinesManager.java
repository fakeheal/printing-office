package printing;

import interfaces.Paperable;
import interfaces.PrintableMachine;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PrintingMachinesManager {
    private final PaperManager paperManager;
    private final ArrayList<PrintableMachine> printingMachines;

    public PrintingMachinesManager(PaperManager paperManager) {
        this.paperManager = paperManager;
        printingMachines = new ArrayList<>();
    }

    public void addPrintingMachine(int maxPages, boolean isColor) {
        printingMachines.add(new PrintingMachine(maxPages, isColor));
    }

    public ArrayList<PrintableMachine> getPrintingMachines() {
        return printingMachines;
    }

    public BigDecimal calculateTotalPrintCost() {
        BigDecimal totalCost = new BigDecimal(0);
        for (PrintableMachine machine : printingMachines) {
            ArrayList<PrintJob> printedJobs = machine.getPrintedJobs();
            for (PrintJob printJob : printedJobs) {
                int copies = printJob.getCopies();
                Paperable paper = printJob.getPublication().paper();
                totalCost = totalCost.add(
                        paperManager.getCostPerSheet(paper.type(), paper.size())
                                .multiply(new BigDecimal(copies))
                );
            }
        }
        return totalCost;
    }

    public BigDecimal calculateTotalPrintRevenue() {
        BigDecimal totalRevenue = new BigDecimal(0);
        for (PrintableMachine machine : printingMachines) {
            ArrayList<PrintJob> printedJobs = machine.getPrintedJobs();
            for (PrintJob printJob : printedJobs) {
                totalRevenue = totalRevenue.add(
                        printJob.getPricePerCopy().multiply(new BigDecimal(printJob.getCopies()))
                );
            }
        }
        return totalRevenue;
    }

    public BigDecimal calculateTotalPrintProfit() {
        return calculateTotalPrintRevenue().subtract(calculateTotalPrintCost());
    }
}
