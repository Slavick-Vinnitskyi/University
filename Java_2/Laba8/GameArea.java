package com.lablll.labwork8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Композитная структура игрового поля
 */
public class GameArea implements Texture, Copyable {

    private List<Texture> components = new ArrayList<>();

    void addComponent(Texture... component) {
        components.addAll(List.of(component));
    }

    void removeComponent(Texture component) {
        components.remove(component);
    }

    @Override
    public String draw() {
        return this.toString();
    }

    @Override
    public GameArea copy() {
        try {
            return (GameArea) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GameArea deepCopy() {

        GameArea copyGameArea = new GameArea();
        for (Texture texture : components) {
            try {
                copyGameArea.addComponent((Texture) ((Copyable)texture).deepCopy());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return copyGameArea;
    }

    @Override
    public boolean equals(Object obj) {
        return
                obj instanceof GameArea &&
                        ((GameArea) obj).components.equals(this.components);
    }

    @Override
    public String toString() {
        String[] split = Arrays.toString(components.toArray()).split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append(split[i]).append("\n");
        }
        return "Игровое поле : " +
                "components = " +
                stringBuilder.toString();
    }
}
