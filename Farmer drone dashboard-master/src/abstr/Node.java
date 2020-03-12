package abstr;

public abstract class Node implements VObject, Cloneable {
    private String name;
    private String type;
    private double price;
    private int coordinate_x;
    private int coordinate_y;
    private int width;
    private int length;

    public abstract void initialize(String name, double price, int coordinate_x, int coordinate_y, int width, int length);
    public abstract void changeName(String name);
    public abstract void changePrice(double price);
    public abstract void changeXcoordinate(int x);
    public abstract void changeYcoordinate(int y);
    public abstract void changeWidth(int width);
    public abstract void changeLength(int length);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCoordinate_x() {
        return coordinate_x;
    }

    public void setCoordinate_x(int coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    public int getCoordinate_y() {
        return coordinate_y;
    }

    public void setCoordinate_y(int coordinate_y) {
        this.coordinate_y = coordinate_y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object clone(){
        Node node = null;

        try {
            node = (Node) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return node;
    }

}
