package model.list;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    static final long serialVersionUID = 46L;
    private int i = 0;
    private T[] banks;

    MyIterator(T[] banks) {
        this.banks = banks;
    }

    @Override
    public boolean hasNext() {
        return i < banks.length && banks[i] != null;
    }

    @Override
    public T next() {
        if(hasNext()) {
            return banks[i++];
        }
        return null;
    }
}
