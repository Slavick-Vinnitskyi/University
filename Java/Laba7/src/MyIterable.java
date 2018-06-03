import java.util.Iterator;

public class MyIterable<T> implements Iterator<T> {

    /**
     * индекс в списке
     */
    private int index = 0;
    /**
     * Значение
     */
    private T[] values;

    MyIterable(T[] values){
        this.values = values;
    }

    /**
     * @return Если hasNext() вызывается впервые - вернет true
     */
    @Override
    public boolean hasNext() {
        return false;
    }

    /**
     * @return  Возвращает текущий ел-т и ссылку на следующий
     */
    @Override
    public T next() {
        return null;
    }
}
