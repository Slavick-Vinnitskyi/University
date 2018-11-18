package model.list;

import model.entities.MainBank;

import java.io.Serializable;
import java.util.*;

public class MyList implements List, Serializable {
    static final long serialVersionUID = 47L;
    /**
     * Стандартный размер
     */
    private final static int DEFAULT_CAPACITY = 10;
    /**
     * Массив обьектов "Банк"
     */
    private MainBank[] banks;

    /**
     * Чтобы знать актуальный размер списка
     */
    private int size = 0;


//    public model.entities.MainBank[] getBanks() {
//        return banks;
//    }

    /**
     * Создание списка с дефолтной длины
     */
    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    public MyList(int capacity) {
        this.banks = new MainBank[capacity];
    }

    /**
     * Конструктор с добавлением первого банка
     *
     * @param value первый банк
     */
    public MyList(MainBank value) {

        this.banks = new MainBank[DEFAULT_CAPACITY];
        add(value);
    }

    /**
     * Конструктор с добавлением банков
     *
     * @param list список
     */
    public MyList(Collection<MainBank> list) {
        try {
            banks = new MainBank[list.size()];
        } catch (NegativeArraySizeException e) {
            e.getMessage();
        }
        int i = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            banks[i] = (MainBank) iterator.next();
            i++;
            size++;
        }
    }

    /**
     * @return Возвращает размер списка(заполненные)
     */
    @Override
    public int size() {
        return  size;
    }

    @Override
    public boolean isEmpty() {
        return  size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (MainBank bank : banks) {
            if (o.equals(bank)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public Iterator iterator() {
        return new MyIterator<>(banks);
    }

    /**
     * Добавляет новый элемент в список. При достижении размера половины внутреннего
     * массива происходит его увеличение в полтора раза.
     *
     * @param item Банк который нужно добавить
     * @return Список с добавленным елементом Банк
     */
    @Override
    public boolean add(Object item) {
        try {
            if(size >= allSize() / 2) {
                int newSize = banks.length + banks.length / 2;
                MainBank[] temp = banks;
                banks = new MainBank[newSize];
                System.arraycopy(temp, 0, banks, 0, temp.length);//перемещаем массив
            }
            banks [size] = (MainBank) item;
            size++;
            return true;

        }catch (ClassCastException ex){
            ex.printStackTrace();
        }
        return false;

    }

    /** Три варианта :
     *      -Добавление  в пустой список
     *      -Добавление индекса больше размера списка
     *      -Добавление null елемента
     * @param index индекс добавления
     * @param element обьект добавления
     */
    @Override
    public void add(int index, Object element) {

        if(element == null) {
            return;
        }
        if (index == size) {
            banks[index] = (MainBank) element;
//            add(element);
            size++;
        }
        else if(index >= allSize() / 2) {
            int newSize = banks.length + banks.length / 2;
            banks = new MainBank[newSize];
            banks[index] = (MainBank) element;
            size++;
        }
        else {
            banks[index] = (MainBank) element;
            size++;
        }

    }

    @Override
    public boolean remove(Object o) {
        if(size == 0)
            throw new RuntimeException("List is empty. Cannot delete. ");

        int i = 0;
        MainBank[] temp = banks;
        for(MainBank bank : banks) {
            if(bank != null && !bank.equals(o)) {
                banks[i] = temp[i];
                i++;
            }
            else banks[i] = null;
        }
        size--;
        return true;
    }


    @Override
    public boolean addAll(Collection c) {
        if (c == null || c.isEmpty()) {
            return false;
        }
        for(Object item : c) {
            banks[size] = (MainBank) item;
            size++;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (c == null || c.isEmpty()) {
            return false;
        }
        for(Object item : c) {
            banks[index] = (MainBank) item;
            size++;
        }
        return true;
    }


    @Override
    public void clear() {
        int  i = 0;
        for (MainBank bank : banks) {
            banks[i] = null;
            size--;
            i++;
        }
        size = 0;
    }

    /**
     * @param c коллекция для сравнивания
     * @return false если коллекция пустая или заполненая null елементами
     */
    @Override
    public boolean retainAll(Collection c) {
        if(c == null || c.isEmpty()) {
            return false;
        }
        boolean changed = false;

        for (int n = size() - 1, i = n; i >= 0; i--) {
            Object obj = get(i);
            if (!c.contains(obj)) {
                remove(i);
                changed = true;
                size--;
            }
        }
        return changed;
    }



    @Override
    public boolean removeAll(Collection c) {
        int i = 0;
        MainBank[] temp = banks;
        for (Object item : c) {
            for (MainBank bank : banks) {
                if (item.equals(bank)) {
                    banks[i] = temp[i];
                    i++;
                }
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    /**
     * @return a copy of that array.
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(banks, size());
    }

    /**  Returns an array containing all of the elements in this list in
     * proper sequence
     * @param a the array into which the elements of this list are to
     *      *          be stored, if it is big enough; otherwise, a new array of the
     *      *          same runtime type is allocated for this purpose.
     * @return a copy of that array.
     */
    @Override
    public Object[] toArray(Object[] a) {
        if (a == null) {
            throw new NullPointerException("Array doesn`t contain any element");
        }
        if (a.length < size()) {
            return Arrays.copyOf(banks, size(), a.getClass());
        }

        System.arraycopy(banks, 0, a, 0, size());

        if (a.length > size()) {
            a[size()] = null;
        }

        return a;
    }


    /**
     * @return Возвращает полный размер списка (ячейки с выделенной памятью)
     */

    public int allSize() {
        return banks.length;
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает Банк
     */

    public MainBank get(int index) {
        return banks[index];
    }

    @Override
    public Object set(int index, Object element) {
        if (banks[index] != null && index < size) {
            banks[index] = (MainBank) element;
            return banks;
        }
        return null;
    }

    @Override
    public Object remove(int index) {
        if(banks[index] != null && index < size) {
            banks[index] = null;
            size--;
            return banks;
        }
        return null;
    }

    /**
     * @param o Обьект поиска в коллекции
     * @return -1 если не найдено, или номер вхождения в коллекции
     */
    @Override
    public int indexOf(Object o) {
        int i = 0;
        for(MainBank bank : banks) {
            if(bank != null && bank.equals(o)){
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        List<Object> list = Arrays.asList(banks);
        ListIterator<Object> iterator = list.listIterator(list.size()-1);
        int i = list.size();
        System.out.println(i);
        while (iterator.hasPrevious()) {
            if(iterator.previous().equals(o)) {
                return i;
            }
            i--;
        }
        return  -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает процент по обычному кредиту
     */

    public float getpercentUsualCredit(int index) {
        return banks[index].getPercentUsualCredit();
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает процент по ипотеке
     */

    public float getpercentHomeCredit(int index) {
        return banks[index].getPercentHomeCredit();
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает процент по кредиту на авто
     */

    public float getpercentCarCredit(int index) {
        return banks[index].getPercentCarCredit();
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает максимальное кол-во месяцев по ипотеке
     */

    public int getmaxMonthsUsual(int index) {
        return banks[index].getMaxMonthsUsual();
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает максимальное кол-во месяцев по кредиту
     */

    public int maxMonthsCarAndHome(int index) {
        return banks[index].maxMonthsCarAndHome;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyList)) {
            return false;
        }

        MyList train = (MyList) o;

        if(train.banks == ((MyList) o).banks){
            return true;
        }

        return false;

    }
}