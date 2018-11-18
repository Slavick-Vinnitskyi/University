package com.lablll.labwork6;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Double, Double> tableOfPoints;

        tableOfPoints = Calculate.calculating(-5, 5);

        View onConsole = new View();
        onConsole.setCoordinates(new Polar());

        tableOfPoints.forEach(onConsole::executeStrategy);
    }
}
