package printing;

import exception.PrintingException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PrintingMachineTest {

    @Test
    void loadPaperFailsWithNegativeNumber() {
        PrintingMachine machine = new PrintingMachine(100, true);
        assertThrows(PrintingException.class, () -> machine.loadPaper(-1));
    }

    @Test
    void loadPaperFailsIfLimitExceeded() {
        PrintingMachine machine = new PrintingMachine(100, true);
        assertThrows(PrintingException.class, () -> machine.loadPaper(101));
    }

    @Test
    void loadPaper() {
        PrintingMachine machine = new PrintingMachine(100, true);
        try {
            machine.loadPaper(50);
        } catch (PrintingException e) {
            fail();
        }
        assertEquals(50, machine.getBlankPages());
    }

    @Test
    void print() {
        PrintingMachine machine = new PrintingMachine(100, true);
        try {
            machine.loadPaper(50);
            machine.print(
                    new PrintJob(
                            new Publication("Poster", "AC/DC", 1, new Paper(PaperSize.A5, PaperType.glossy)),
                            1,
                            true,
                            BigDecimal.valueOf(20.0)
                    ));
        } catch (PrintingException e) {
            fail();
        }
    }

    @Test
    void printFailsIfNotEnoughPaper() {
        PrintingMachine machine = new PrintingMachine(100, true);
        assertThrows(
                PrintingException.class,
                () -> machine.print(
                        new PrintJob(
                                new Publication("Poster", "AC/DC", 1, new Paper(PaperSize.A5, PaperType.glossy)),
                                1,
                                true,
                                BigDecimal.valueOf(20.0)
                        )
                )
        );
    }

    @Test
    void printFailsIfPrintJobIsColorAndMachineIsNot() {
        PrintingMachine machine = new PrintingMachine(100, true);
        assertThrows(
                PrintingException.class,
                () -> machine.print(
                        new PrintJob(
                                new Publication("Poster", "AC/DC", 1, new Paper(PaperSize.A5, PaperType.glossy)),
                                1,
                                false,
                                BigDecimal.valueOf(20.0)
                        )
                )
        );
    }

    @Test
    void printSucceedsIfPrintJobIsNotColorAndMachineIsColor() {
        PrintingMachine machine = new PrintingMachine(100, false);
        try {
            machine.loadPaper(50);
            machine.print(
                    new PrintJob(
                            new Publication("Poster", "AC/DC", 1, new Paper(PaperSize.A5, PaperType.glossy)),
                            1,
                            false,
                            BigDecimal.valueOf(20.0)
                    )
            );
        } catch (PrintingException e) {
            fail();
        }
    }

    @Test
    void getPrintedJobs() {
        PrintingMachine machine = new PrintingMachine(100, true);

        try {
            machine.loadPaper(50);
            machine.print(
                    new PrintJob(
                            new Publication("Poster", "AC/DC", 1, new Paper(PaperSize.A5, PaperType.glossy)),
                            1,
                            true,
                            BigDecimal.valueOf(20.0)
                    )
            );

            assertEquals(1, machine.getPrintedJobs().size());

            assertEquals("Poster", machine.getPrintedJobs().get(0).getPublication().title());
            assertEquals("AC/DC", machine.getPrintedJobs().get(0).getPublication().issue());
            assertEquals(1, machine.getPrintedJobs().get(0).getPublication().pages());
        } catch (PrintingException e) {
            fail();
        }
    }

    @Test
    void getPrintedPagesCount() {

        PrintingMachine machine = new PrintingMachine(100, true);

        try {
            machine.loadPaper(100);
            machine.print(
                    new PrintJob(
                            new Publication("Poster", "AC/DC", 25, new Paper(PaperSize.A5, PaperType.glossy)),
                            4,
                            true,
                            BigDecimal.valueOf(20.0)
                    )
            );

            assertEquals(100, machine.getPrintedPagesCount());
        } catch (PrintingException e) {
            fail();
        }


    }
}