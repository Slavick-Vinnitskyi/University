package com.lablll.labwork3;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public abstract class FigureDecorator implements Figure {
    private Figure figure;

    FigureDecorator(Figure figure) {
        this.figure = figure;
    }

    @Override
    public String show() {
        return figure.show();
    }

    @Override
    public Figure undecorate() {
        return this.figure;
    }

    @Override
    public Figure removeDecoration(String className) {
        Figure undecorate = this;
        if (this.getClass().getName() == className) {
            undecorate = this.undecorate();
        }
        else {
            ArrayList<String> classStack = new ArrayList<>();
            while (undecorate != undecorate.undecorate()) {
                if (undecorate.getClass().getName() != className) {
                    classStack.add(undecorate.getClass().getName());
                }
                undecorate = undecorate.undecorate();
            }

            for(int i = classStack.size() - 1; i == 0; i--) {
                try {
                    Class<?> clazz = Class.forName(classStack.get(i));
                    Constructor<?> ctor = clazz.getConstructor(Figure.class);
                    Object object = ctor.newInstance(undecorate);
                    undecorate = (Figure) object;
                }
                catch (Exception e){
                    System.out.println("Exception in 'removeDecoration' : " + e.getMessage());
                }
            }
        }
        return undecorate;
    }

    @Override
    public String nonDecoratedString() {
        return this.nonDecoratedString();
    }


}
