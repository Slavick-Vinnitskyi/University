package com.lablll.labwork8;

public interface Copyable extends Cloneable {
    Object copy() throws CloneNotSupportedException;

    Object deepCopy();
}
