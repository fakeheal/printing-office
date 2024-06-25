package printing;

import exception.ManagerException;
import utils.Pair;

import java.math.BigDecimal;
import java.util.HashMap;

public class PaperSizeInventory extends HashMap<PaperSize, Integer> {
    private final HashMap<PaperSize, Pair<BigDecimal, Integer>> sizes = new HashMap<>();

    public PaperSizeInventory() {
        for (PaperSize paperSize : PaperSize.values()) {
            this.sizes.put(paperSize, new Pair<>(BigDecimal.ZERO, 0));
        }
    }

    public void addPaper(PaperSize paperSize, BigDecimal priceOrIncrement, int quantity) {
        Pair<BigDecimal, Integer> pair = sizes.get(paperSize);
        BigDecimal price = pair.key();
        int currentQuantity = pair.value();

        if (priceOrIncrement != null) {
            price = price.add(priceOrIncrement);
        }

        currentQuantity += quantity;

        sizes.put(paperSize, new Pair<>(price, currentQuantity));
    }

    public void removePaper(PaperSize paperSize, int quantity) throws ManagerException {
        Pair<BigDecimal, Integer> pair = sizes.get(paperSize);
        int currentQuantity = pair.value();

        if (currentQuantity < quantity) {
            throw new ManagerException("Not enough paper in inventory");
        }

        currentQuantity -= quantity;

        sizes.put(paperSize, new Pair<>(pair.key(), currentQuantity));
    }
}