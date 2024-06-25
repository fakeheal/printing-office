package printing;

public class Publication {

    private final String title;
    private final String issue;
    private final int pages;

    private final Paper paper;

    public Publication(String title, String issue, int pages, Paper paper) {
        this.title = title;
        this.issue = issue;
        this.pages = pages;
        this.paper = paper;
    }

    public String getTitle() {
        return title;
    }

    public String getIssue() {
        return issue;
    }

    public int getPages() {
        return pages;
    }

    public Paper getPaper() {
        return paper;
    }
}
