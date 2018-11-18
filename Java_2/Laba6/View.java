package com.lablll.labwork6;

//StrategyClient
public class View {

    private Coordinates coordinates;

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void executeStrategy(double x, double y) {
        coordinates.draw(x, y);
    }
}
