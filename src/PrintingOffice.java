import employee.EmployeeManager;
import printing.PaperManager;
import printing.PrintingMachinesManager;

import java.math.BigDecimal;

public class PrintingOffice {
    private final EmployeeManager employeeManager;
    private final PrintingMachinesManager printingMachinesManager = new PrintingMachinesManager();
    private final PaperManager paperManager = new PaperManager();

    public PrintingOffice(BigDecimal baseSalary) {
        this.employeeManager = new EmployeeManager(baseSalary);
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
