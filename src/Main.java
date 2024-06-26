import exception.ManagerException;
import exception.PrintingException;
import interfaces.PrintableMachine;
import printing.*;
import utils.EmployeeType;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        PrintingOffice printingOffice = new PrintingOffice(BigDecimal.valueOf(1000));

        printingOffice.getEmployeeManager().addEmployee("John", EmployeeType.manager);
        printingOffice.getEmployeeManager().addEmployee("Jane", EmployeeType.operator);
        printingOffice.getEmployeeManager().addEmployee("Jack", EmployeeType.operator);

//        printingOffice.getPrintingMachinesManager().addPrintingMachine(new NewspaperPrintingMachine(100, true));
        printingOffice.getPrintingMachinesManager().addPrintingMachine(new PrintingMachine(100, true));
        printingOffice.getPrintingMachinesManager().addPrintingMachine(new PrintingMachine(50, false));

        printingOffice.getPaperManager().addPaper(PaperType.glossy, PaperSize.A5, BigDecimal.valueOf(10), 100);
        printingOffice.getPaperManager().addPaper(PaperType.glossy, PaperSize.A3, BigDecimal.valueOf(50), 100);

        PrintableMachine printingMachine = printingOffice.getPrintingMachinesManager().getPrintingMachines().get(0);

        try {
            PaperSheet paperSheet = new PaperSheet(PaperSize.A3, PaperType.glossy);
            Publication publication = new Publication("Poster", "AC/DC", 1, paperSheet);
            PrintJob printJob = new PrintJob(publication, 10, true, BigDecimal.valueOf(20.0));

            printingOffice.getPrintingMachinesManager()
                    .loadPaperIntoMachine(
                            printingMachine,
                            paperSheet.type(),
                            paperSheet.size(),
                            printJob.getCopies() * publication.pages()
                    );

            printingMachine.print(printJob);

            printingOffice.getPaperManager().removePaper(
                    paperSheet.type(),
                    paperSheet.size(),
                    printJob.getCopies() * publication.pages()
            );

            System.out.println(printingMachine.getPrintedJobs());
            System.out.println("Number of pages printed by the machine: " + printingMachine.getPrintedPagesCount());
        } catch (PrintingException | ManagerException e) {
            System.out.println(e.getMessage());
        }


        BigDecimal profit = printingOffice.getPrintingMachinesManager().calculateTotalPrintProfit();
        BigDecimal bonus = BigDecimal.ZERO;
        if (profit.compareTo(BigDecimal.valueOf(10)) > 0) {
            bonus = BigDecimal.valueOf(100);
        }
        System.out.println("Employee salary: " + printingOffice.getEmployeeManager().calculateEmployeeSalaries(bonus));
        System.out.println("Total print cost: " + printingOffice.getPrintingMachinesManager().calculateTotalPrintCost());
        System.out.println("Total print revenue: " + printingOffice.getPrintingMachinesManager().calculateTotalPrintRevenue());
        System.out.println("Total print profit: " + profit);
    }
}