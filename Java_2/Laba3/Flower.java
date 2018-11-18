package com.lablll.labwork3;

public class Flower extends  FigureDecorator {

    public Flower(Figure figure) {
        super(figure);
    }

    public String showFlower(){
        return " с цветком";
    }

    @Override
    public String show() {
        return super.show() + showFlower();
    }

    @Override
    public Figure undecorate() {
        return super.undecorate();
    }
}
