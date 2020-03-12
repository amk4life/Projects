package model;

import abstr.AbstractVisitor;
import abstr.Node;

public class Item extends Node {

    public void initialize(String name, double price, int coordinate_x, int coordinate_y, int width, int length){
        super.setName(name);
        super.setPrice(price);
        super.setType("Item");
        super.setCoordinate_x(coordinate_x);
        super.setCoordinate_y(coordinate_y);
        super.setWidth(width);
        super.setLength(length);
    }

    @Override
    public void changeName(String name) {
        this.setName(name);
    }

    @Override
    public void changePrice(double price) {
        this.setPrice(price);
    }

    @Override
    public void changeXcoordinate(int x) {
        this.setCoordinate_x(x);
    }

    @Override
    public void changeYcoordinate(int y) {
        this.setCoordinate_y(y);
    }

    @Override
    public void changeWidth(int width) {
        this.setWidth(width);
    }

    @Override
    public void changeLength(int length) {
        this.setLength(length);
    }

    @Override
    public double accept(AbstractVisitor handler){
        return handler.visit(this);
    }

}
