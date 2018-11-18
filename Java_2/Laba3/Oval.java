package com.lablll.labwork3;

public class Oval extends FigureDecorator {
    public Oval(Figure figure) {
        super(figure);
    }

    public String showOval() {
        return " с овалом";
    }

    @Override
    public String show() {
        return super.show() + showOval();
    }

    @Override
    public Figure undecorate() {
        return super.undecorate();
    }
}
