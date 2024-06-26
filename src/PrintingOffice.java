import employee.EmployeeManager;
import printing.PaperManager;
import printing.PrintingMachinesManager;

import java.math.BigDecimal;

public class PrintingOffice {
    private final EmployeeManager employeeManager;
    private final PaperManager paperManager = new PaperManager();
    private final PrintingMachinesManager printingMachinesManager;

    public PrintingOffice(BigDecimal baseSalary) {
        this.employeeManager = new EmployeeManager(baseSalary);
        this.printingMachinesManager = new PrintingMachinesManager(paperManager);
    }

    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public PrintingMachinesManager getPrintingMachinesManager() {
        return printingMachinesManager;
    }

    public PaperManager getPaperManager() {
        return paperManager;
    }
}
