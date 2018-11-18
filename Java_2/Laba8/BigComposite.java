package com.lablll.labwork8;

import java.util.ArrayList;
import java.util.List;

/**
 * Композитный элемент 2-го уровня
 */
public class BigComposite implements Texture,Copyable {

    private String subject;
    private List<Texture> components = new ArrayList<>();

    BigComposite(String subject) {
        this.subject = subject;
    }

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
    public GameArea copy() throws CloneNotSupportedException {
        return (GameArea) super.clone();
    }

    @Override
    public BigComposite deepCopy() {

        BigComposite copyGameArea = new BigComposite(this.subject);
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
    public String toString() {
        return subject +
                " : { components=" +
                components +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        return
                obj instanceof BigComposite &&
                        ((BigComposite) obj).subject.equals(this.subject) &&
                        ((BigComposite) obj).components.equals(this.components);

    }
}
