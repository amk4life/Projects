package factory;

import abstr.Node;
import model.Item;
import model.ItemContainer;

public class TreeNodeFactory {
    private String type;


    public TreeNodeFactory(){}

    public TreeNodeFactory(String type){
        this.type = type;
    }

    public Node getInstance(String type){
        if (type.equals("Item"))
            return new Item();
        else if (type.equals("ItemContainer"))
            return new ItemContainer();

        throw new IllegalArgumentException();
    }
}
