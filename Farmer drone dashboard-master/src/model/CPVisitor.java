package model;

import abstr.AbstractVisitor;
import abstr.Node;

import java.util.List;

public class CPVisitor extends AbstractVisitor {

    @Override
    public double visit(Item obj) {
        return obj.getPrice();
    }

    @Override
    public double visit(ItemContainer obj) {
        List<Node> itemlist = obj.getItemList();
        double sum = obj.getPrice();
        for (Node node : itemlist){
            if (node.getType().equals("Item"))
                sum += node.getPrice();
            else
                sum += visit((ItemContainer) node);
        }

        return sum;
    }
}
