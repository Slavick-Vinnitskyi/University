package com.lablll.labwork3;

public class Rectangle implements Figure {

    private String basicString;

    public Rectangle(String basicString) {
        this.basicString = basicString;
    }

    public Rectangle() {
        this.basicString = "Прямоугольник";
    }

    @Override
    public String show() {
        return basicString;
    }

    @Override
    public Figure undecorate() {
        return this;
    }

    @Override
    public Figure removeDecoration(String className) {
        return this;
    }

    @Override
    public String nonDecoratedString() {
        return basicString;
    }
}
