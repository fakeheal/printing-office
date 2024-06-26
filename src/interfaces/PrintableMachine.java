package interfaces;

import exception.PrintingException;
import printing.PrintJob;

import java.util.ArrayList;

public interface PrintableMachine {
    void loadPaper(int amount) throws PrintingException;

    void print(PrintJob job) throws PrintingException;

    int getPrintedPagesCount();

    int getMaxBlankPages();

    ArrayList<PrintJob> getPrintedJobs();
}
