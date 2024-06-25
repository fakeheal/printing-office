package printing;

import exception.ManagerException;

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

    public void addPaper(PaperType paperType, PaperSize paperSize, BigDecimal priceOrIncrement, int quantity) {
        PaperSizeInventory inventory = paperInventory.get(paperType);
        inventory.addPaper(paperSize, priceOrIncrement, quantity);
    }

    public void removePaper(PaperType paperType, PaperSize paperSize, int quantity) throws ManagerException {
        PaperSizeInventory inventory = paperInventory.get(paperType);
        inventory.removePaper(paperSize, quantity);
    }
}
