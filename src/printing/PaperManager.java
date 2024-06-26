package printing;

import exception.ManagerException;
import exception.PrintingException;

import java.math.BigDecimal;
import java.util.HashMap;

public class PaperManager {
    private final HashMap<PaperType, PaperSizeInventory> paperInventory;

    public PaperManager() {
        this.paperInventory = new HashMap<>();
        for (PaperType paperType : PaperType.values()) {
            paperInventory.put(paperType, new PaperSizeInventory());
        }
    }

    public boolean hasEnoughSheets(PaperType paperType, PaperSize paperSize, int quantity) {
        return paperInventory.get(paperType).get(paperSize).value() >= quantity;
    }

    public void addPaper(PaperType paperType, PaperSize paperSize, BigDecimal priceOrIncrement, int quantity) {
        paperInventory.get(paperType).addPaper(paperSize, priceOrIncrement, quantity);
    }

    public void removePaper(PaperType paperType, PaperSize paperSize, int quantity) throws ManagerException {
        paperInventory.get(paperType).removePaper(paperSize, quantity);
    }

    public BigDecimal getCostPerSheet(PaperType paperType, PaperSize paperSize) {
        if (paperSize == PaperSize.A5) {
            return paperInventory.get(paperType).get(paperSize).key();
        }

        return paperInventory.get(paperType).get(PaperSize.A5).key().add(
                paperInventory.get(paperType).get(paperSize).key().multiply(
                        paperInventory.get(paperType).get(PaperSize.A5).key()
                                .divide(BigDecimal.valueOf(100))
                )
        );
    }
}
