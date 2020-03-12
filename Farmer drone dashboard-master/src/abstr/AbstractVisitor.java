package abstr;

import model.Item;
import model.ItemContainer;

public abstract class AbstractVisitor {
    public abstract double visit(Item obj);
    public abstract double visit(ItemContainer obj);
}
