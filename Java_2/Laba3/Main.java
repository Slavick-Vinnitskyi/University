package com.lablll.labwork3;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Managing class
 *
 */
public class Main {
    private static ArrayList<FigureDecorator> list = new ArrayList<>();

    public static void main(String[] args) {

        //Три основных(декорируемых) обьекта
        Figure[] figures = new Figure[3], decorators = new Figure[3], decoratedFigures = new Figure[3];
        figures[0] = new Triangle();
        figures[1] = new Circle();
        figures[2] = new Rectangle();
        System.out.println("\tBasic figures is: ");
        output(figures);

        // Три декоратора
        decorators[0] = new Flower(figures[0]);
        decorators[1] = new Star(figures[1]);
        decorators[2] = new Oval(figures[2]);
        System.out.println("\tDecorated figures is: ");
        output(decorators);

        //Декорация
        decoratedFigures[0] = new Star(new Flower(new Oval(figures[0])));
        decoratedFigures[1] = new Flower(new Star(new Oval(figures[1])));
        decoratedFigures[2] = new Oval(new Star(new Flower(figures[2])));


        System.out.println("\tFully decorated figures is: ");
        output(decoratedFigures);


        while (decoratedFigures[0].undecorate() != decoratedFigures[0] &&
                decoratedFigures[1].undecorate() != decoratedFigures[1] &&
                decoratedFigures[2].undecorate() != decoratedFigures[2]) {
            decoratedFigures[0] = decoratedFigures[0].undecorate();
            decoratedFigures[1] = decoratedFigures[1].undecorate();
            decoratedFigures[2] = decoratedFigures[2].undecorate();
            System.out.println("\tRolling back decorations: ");
            output(decoratedFigures);
        }

        Figure undecorate = new Star(new Star(new Circle()));
        System.out.println("Decoration chain before removal is: " + undecorate.show());
        undecorate = undecorate.removeDecoration(Star.class.getName());
        System.out.println("Decoration chain after removal is: " + undecorate.show());
    }

    private static Figure createDecoration(Figure toDecorate, String... classToDecorate) {

        ArrayList<String> classStack = new ArrayList<>(Arrays.asList(classToDecorate));

        Figure decorated = null;

        for (String className : classStack) {

            try {
                Class<?> clazz = Class.forName(className);
                Constructor<?> constructor = clazz.getConstructor(Figure.class);
                Object object = constructor.newInstance(toDecorate);
                decorated = (Figure) object;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return decorated;
    }

    private static void addComponent(FigureDecorator... figureDecorators) {
        list.addAll(Arrays.asList(figureDecorators));
    }

    private static void removeComponent(FigureDecorator... figureDecorators) {
        list.removeAll(Arrays.asList(figureDecorators));
    }

    private static Figure getFigure(Figure figure) {
        Class e;
        for (FigureDecorator figureDecorator : list) {
            e = figureDecorator.getClass();

            try {
                figure = (Figure) e.getConstructor(new Class[]{Figure.class}).newInstance(figure);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return figure;
    }

    private static void output(Figure[] arr) {

        Arrays.asList(arr).forEach((f) -> System.out.println(f.show()));
    }
}
