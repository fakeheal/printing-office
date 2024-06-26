package printing;

import exception.PrintingException;
import interfaces.PrintableMachine;

public class NewspaperPrintingMachine extends PrintingMachine implements PrintableMachine {

    public NewspaperPrintingMachine(int maxPages, boolean isColor) {
        super(maxPages, isColor);
    }

    @Override
    public void print(PrintJob job) throws PrintingException {
        if (job.getPublication().paper().type() != PaperType.newspaper) {
            throw new PrintingException("This machine prints only newspapers.");
        }
        super.print(job);
    }
}
