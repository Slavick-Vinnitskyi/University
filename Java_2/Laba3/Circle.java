package com.lablll.labwork3;

public class Circle implements Figure {

    private String basicString;

    public Circle(String basicString) {
        this.basicString = basicString;
    }

    public Circle() {
        this.basicString = "Круг";
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
