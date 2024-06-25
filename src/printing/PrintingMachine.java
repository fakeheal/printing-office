package printing;

import exception.PrintingException;

import java.util.ArrayList;

public class PrintingMachine {
    private final int maxBlankPages;
    private final boolean isColor;
    private final ArrayList<PrintJob> printedJobs = new ArrayList<>();
    private int blankPages;

    public PrintingMachine(int maxPages, boolean isColor) {
        this.maxBlankPages = maxPages;
        this.isColor = isColor;
    }

    public void loadPaper(int pages) throws PrintingException {
        if (pages < 0) {
            throw new PrintingException("Cannot load negative number of pages");
        }

        if (blankPages + pages > maxBlankPages) {
            throw new PrintingException("Too many pages");
        }

        blankPages += pages;
    }

    public void print(PrintJob job) throws PrintingException {
        if (job.isColor() && !isColor) {
            throw new PrintingException("Color type mismatch");
        }

        int pagesToPrint = job.getCopies() * job.getPublication().pages();
        if (pagesToPrint > blankPages) {
            throw new PrintingException("Not enough blank pages");
        }

        blankPages -= pagesToPrint;

        printedJobs.add(job);
    }

    public ArrayList<PrintJob> getPrintedJobs() {
        return printedJobs;
    }

    public int getPrintedPagesCount() {
        int pages = 0;
        for (PrintJob job : printedJobs) {
            pages += job.getCopies() * job.getPublication().pages();
        }
        return pages;
    }

    public int getBlankPages() {
        return blankPages;
    }

    public int getMaxBlankPages() {
        return maxBlankPages;
    }
}
