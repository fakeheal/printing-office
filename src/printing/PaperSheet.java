package printing;

import interfaces.Paperable;

public record PaperSheet(PaperSize size, PaperType type) implements Paperable {
}
