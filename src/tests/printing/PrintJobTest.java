package printing;

import exception.PrintingException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class PrintJobTest {

    @Test
    void throwsExceptionIfPricePerCopyIsInvalid() {
        assertThrows(
                PrintingException.class,
                () -> new PrintJob(
                        new Publication("Title", "Issue", 10, new PaperSheet(PaperSize.A3, PaperType.glossy)),
                        1,
                        false,
                        BigDecimal.valueOf(-1)
                )
        );
    }

    @Test
    void throwsExceptionIfCopiesIsNegative() {
        assertThrows(
                PrintingException.class,
                () -> new PrintJob(
                        new Publication("Title", "Issue", 10, new PaperSheet(PaperSize.A3, PaperType.glossy)),
                        -1,
                        false,
                        BigDecimal.valueOf(1)
                )
        );
    }

    @Test
    void doesNotThrowExceptionIfDataIsValid() {
        try {
            new PrintJob(
                    new Publication("Title", "Issue", 10, new PaperSheet(PaperSize.A3, PaperType.glossy)),
                    1,
                    false,
                    BigDecimal.valueOf(1)
            );
        } catch (PrintingException e) {
            fail();
        }
    }
}