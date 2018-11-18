package com.lablll.labwork8;

/**
 * Компонент
 */
public class Component implements Texture, Copyable {

    private String subject;

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    Component(String subject, String color) {
        this.subject = subject;
        this.color = color;
    }


    @Override
    public String draw() {
        return this.toString();
    }


    @Override
    public Component copy() {
        return new Component(this.subject,this.color);
    }

    @Override
    public Component deepCopy() {

        return new Component(this.subject, this.color);
    }
    @Override
    public String toString() {
        return String.format("%s : (%s)", subject, color);
    }

    @Override
    public boolean equals(Object obj) {
        return
                obj instanceof Component &&
                        ((Component) obj).color.equals(this.color) &&
                        ((Component) obj).subject.equals(this.subject);
    }
}
