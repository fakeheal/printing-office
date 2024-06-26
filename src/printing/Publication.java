package printing;

import interfaces.Paperable;
import interfaces.Printable;

public record Publication(String title, String issue, int pages, Paperable paper) implements Printable {

}
