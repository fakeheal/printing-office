package interfaces;

import printing.PaperSize;
import printing.PaperType;

public interface Paperable {
    PaperSize size();
    PaperType type();
}
