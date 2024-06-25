import exception.ManagerException;
import exception.PrintingException;
import printing.*;
import utils.EmployeeType;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        PrintingOffice printingOffice = new PrintingOffice(BigDecimal.valueOf(1000));

        printingOffice.getEmployeeManager().addEmployee("John", EmployeeType.manager);
        printingOffice.getEmployeeManager().addEmployee("Jane", EmployeeType.operator);
        printingOffice.getEmployeeManager().addEmployee("Jack", EmployeeType.operator);

        printingOffice.getPrintingMachinesManager().addPrintingMachine(100, true);
        printingOffice.getPrintingMachinesManager().addPrintingMachine(200, false);

        printingOffice.getPaperManager().addPaper(PaperType.glossy, PaperSize.A5, BigDecimal.valueOf(0.1), 100);
        printingOffice.getPaperManager().addPaper(PaperType.glossy, PaperSize.A3, BigDecimal.valueOf(50), 100);

        PrintingMachine printingMachine = printingOffice.getPrintingMachinesManager().getPrintingMachines().get(0);


        try {
            Paper paper = new Paper(PaperSize.A5, PaperType.glossy);
            Publication publication = new Publication("Poster", "AC/DC", 1, paper);
            int copies = 1;

            printingMachine.loadPaper(100);
            printingMachine.print(new PrintJob(
                    publication,
                    copies,
                    true,
                    BigDecimal.valueOf(20.0)
            ));

            printingOffice.getPaperManager().removePaper(paper.paperType(), paper.size(), copies * publication.pages());

            System.out.println(printingMachine.getPrintedJobs());
            System.out.println("Number of pages printed by the machine: " + printingMachine.getPrintedPagesCount());
        } catch (PrintingException | ManagerException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Employee salary: " + printingOffice.getEmployeeManager().calculateEmployeeSalaries());
    }


    public static void something() {

//        try {
//            String content = Files.readString(Path.of("db.txt"));
//            String[] lines = content.split("\n");
//
//            ProcessingLine currentLine = ProcessingLine.employees;
//            String[] headers = {"Employees:", "Printing Machines:", "Paper:"};
//            for (String line : lines) {
//                if (Arrays.asList(headers).contains(line)) {
//                    continue;
//                }
//
//                if (currentLine == ProcessingLine.employees) {
//                    String[] employeeData = line.split(",");
//                    for (int i = 0; i < employeeData.length; i += 3) {
//                        String name = employeeData[i];
//                        EmployeeType employeeType = EmployeeType.valueOf(employeeData[i + 1]);
//                        BigDecimal salary = new BigDecimal(employeeData[i + 2]);
//                        printingOffice.getEmployeeManager().addEmployee(name, employeeType, salary);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}