package printing;

public class Paper {
    private final PaperSize size;
    private final PaperType paperType;

    public Paper(PaperSize size, PaperType paperType) {
        this.size = size;
        this.paperType = paperType;
    }

    public PaperSize getSize() {
        return size;
    }

    public PaperType getPaperType() {
        return paperType;
    }
}
