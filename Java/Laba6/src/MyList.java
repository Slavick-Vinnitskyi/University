import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MyList implements IMyList {

    /**
     * Стандартный размер
     */
    final static int DEFAULT_CAPACITY = 10;
    /**
     * Массив обьектов "Банк"
     */
    private MainBank[] banks;

    /**
     * Чтобы знать актуальный размер списка
     */
    private int pointer = 0;
    /**
     * Размер
     */
    private int size = 10;

    /**
     * Создание списка с дефолтной длины
     */
    public  MyList(){
        banks = new MainBank[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор с добавлением первого банка
     * @param value первый банк
     */
    public  MyList(MainBank value){

        banks = new MainBank[DEFAULT_CAPACITY];
        AddList(value);
    }

    /**
     * Конструктор с добавлением банков
     * @param list список
     */
    public  MyList(ArrayList<MainBank> list){
        try {
            banks = new MainBank[list.size()];
        }
        catch (NegativeArraySizeException e) {
            e.getMessage();
        }

        for (int i = 0, n = list.size(); i < n; i++){
            banks[i] = list.get(i);
        }
    }

    /**
     * @return Возвращает размер списка(заполненные)
     */
    @Override
    public int size() {
        int count = 0;
        while(banks[count]!= null) {

            count++;
        }
        return count;
    }


    /**
     * @return Возвращает полный размер списка (ячейки с выделенной памятью)
     */
    @Override
    public int allSize() {
        return banks.length;
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает Банк
     */
    @Override
    public MainBank get(int index) {
        return banks[index];
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает процент по обычному кредиту
     */
    @Override
    public float getpercentUsualCredit(int index) {
        return banks[index].getPercentUsualCredit();
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает процент по ипотеке
     */
    @Override
    public float getpercentHomeCredit(int index) {
        return banks[index].getPercentHomeCredit();
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает процент по кредиту на авто
     */
    @Override
    public float getpercentCarCredit(int index) {
        return banks[index].getPercentCarCredit();
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает максимальное кол-во месяцев по ипотеке
     */
    @Override
    public int getmaxMonthsUsual(int index) {
        return banks[index].getMaxMonthsUsual();
    }

    /**
     * @param index индекс банка в списке
     * @return Возвращает максимальное кол-во месяцев по кредиту
     */
    @Override
    public int maxMonthsCarAndHome(int index) {
        return banks[index].getMaxMonthsUsual();
    }

    /**
     * @return Итератор
     */
    @Override
    public Iterator<MainBank> iterator() {
        return new MyIterable<>(banks);
    }

    /**
     *  Добавляет новый элемент в список. При достижении размера внутреннего
     массива происходит его увеличение в два раза.
     * @param item Банк который нужно добавить
     * @return  Список с добавленным елементом Банк
     */
    @Override
    public boolean AddList(MainBank item) {
        try {
            if(pointer >= size/2){// если размер списка уже больше чем половина заданного размера, то размер = размер*1.5
                size = size + size >> 1;
                MainBank[] temp = banks;
                banks = new MainBank[size];
                System.arraycopy(temp, 0, banks, 0, temp.length);//перемещаем массив
            }
            banks[pointer] = item;
            pointer++;
            return true;

        }catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}