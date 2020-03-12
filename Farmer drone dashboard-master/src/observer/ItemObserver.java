package observer;

import abstr.Node;
import ttaiit.blogspot.com.World;

import java.util.Map;

public class ItemObserver implements Observer {

    private int itemNumber;
    private Map<String, Object> nodemap;

    public ItemObserver(World world){
        itemNumber = 0;
        nodemap = world.getNodemap();
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public void update() {
        itemNumber = 0;
        for( Object v: nodemap.values()){
            if(((Node)v).getType().equals("Item")){
                itemNumber++;
            }
        }
        setItemNumber(itemNumber);
    }

}
