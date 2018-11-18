package com.lablll.labwork8;

import java.util.ArrayList;
import java.util.List;

/**
 * Композитный компонент 1-го уровня
 */
public class SmallComposite implements Texture,Copyable {

    private String subject;
    private List<Texture> components = new ArrayList<>();

    SmallComposite(String subject) {
        this.subject = subject;
    }

    void addComponent(Texture component) {
        components.add(component);
    }

    void removeComponent(Texture component) {
        components.remove(component);
    }


    @Override
    public String draw() {
        return this.toString();
    }

    @Override
    public SmallComposite copy() throws CloneNotSupportedException {
        return (SmallComposite) super.clone();
    }

    @Override
    public SmallComposite deepCopy() {

        SmallComposite copySmallComposite = new SmallComposite(this.subject);
        for (Texture texture : components) {
            try {
                copySmallComposite.addComponent((Texture) ((Copyable)texture).copy());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return copySmallComposite;
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
                obj instanceof SmallComposite &&
                        ((SmallComposite) obj).subject.equals(this.subject) &&
                        ((SmallComposite) obj).components.equals(this.components);

    }
}
