package com.lablll.labwork4;

import java.util.HashMap;
import java.util.Map;

public class CharFactory {

    public static Map<Character, EnglishCharacter> getShapes() {
        return shapes;
    }

    //    final для того, чтобы мы никак не смогли использовать другой Map
//    элементы добавлять можна так как это именяет состояние обьекта, а не заменяет сам обьект
    private static final Map<Character, EnglishCharacter> shapes = new HashMap<>();

    EnglishCharacter getChar(char shapeName) {

        EnglishCharacter shape = shapes.get(shapeName);
        if (shape == null) {
            shape = new EnglishCharacter(shapeName);
            shapes.put(shapeName, shape);
            return shape;
        } else return shape;
    }
}
