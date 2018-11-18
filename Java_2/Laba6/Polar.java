package com.lablll.labwork6;
import static java.lang.Math.*;

public class Polar implements Coordinates {
//    r = sqrt(x^2 + y^2)
//    fi = arctag(y/x) (in radians)
    @Override
    public void draw(double x, double y) {
        double r =  sqrt(pow(x, 2) + pow(y, 2));

        double fi = toDegrees(atan(y/x));
        System.out.printf("r : %.3f fi : %.3f\n", r, fi);

    }
}
