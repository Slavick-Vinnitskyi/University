package com.lablll.labwork6;

import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.*;

/**
 * Класс задаёт формулу
 */
public class Calculate {

    private static double formula(double x) {
        return 2 * pow(x - 8, 2);
    }

    /**
     * @return карту пар значений х : у
     */
    static Map<Double, Double> calculating(int min, int max) {
        // calculating y
        Map<Double, Double> tableOfPoints = new TreeMap<>();
        for(double x = min; x <= max; x += 0.3) {

            double y = formula(x);

            tableOfPoints.put(x, y);
        }
        return tableOfPoints;
    }
}