package com.lablll.labwork4;

public class Coordinate {
    /**
     * номер строки
     */
    public int x;
    /**
     * номер столбца
     */
    public int y;

    private Payload payload = new Payload();

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;

    }

    StringBuilder drawChar(EnglishCharacter character) {
        return payload.draw(character.c, x, y);
    }
}
