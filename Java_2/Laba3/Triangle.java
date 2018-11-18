package com.lablll.labwork3;

public class Triangle implements Figure {

    private String basicString;

    public Triangle(String basicString) {
        this.basicString = basicString;
    }

    public Triangle() {
        this.basicString = "Треугольник";
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
