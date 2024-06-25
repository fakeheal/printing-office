package printing;

import exception.PrintingException;

import java.math.BigDecimal;

public class PrintJob {

    private final Publication publication;
    private final int copies;
    private final boolean isColor;

    private final BigDecimal pricePerCopy;

    public PrintJob(Publication publication, int copies, boolean isColor, BigDecimal pricePerCopy) throws PrintingException {
        this.publication = publication;
        this.isColor = isColor;

        if (pricePerCopy.compareTo(BigDecimal.ZERO) < 0) {
            throw new PrintingException("Price per copy cannot be negative");
        }

        this.pricePerCopy = pricePerCopy;

        if (copies < 0) {
            throw new PrintingException("Cannot print negative number of copies");
        }

        this.copies = copies;
    }

    public Publication getPublication() {
        return publication;
    }

    public int getCopies() {
        return copies;
    }

    public boolean isColor() {
        return isColor;
    }

    public BigDecimal getPricePerCopy() {
        return pricePerCopy;
    }

    @Override
    public String toString() {
        return "PrintJob{" +
                "publication=" + publication +
                ", copies=" + copies +
                ", isColor=" + isColor +
                ", pricePerCopy=" + pricePerCopy +
                '}';
    }
}
