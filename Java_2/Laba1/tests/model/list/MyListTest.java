package model.list;

import model.entities.Bank1;
import model.entities.Bank2;
import model.entities.Bank3;
import model.entities.MainBank;
import model.list.MyList;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyListTest {
    private MyList myList = new MyList();

    private Bank1 bank1 = new Bank1(30f, 43f, 12f, 10, 123);
    private Bank2 bank2 = new Bank2(30f, 43f, 12f, 90, 123);
    private Bank3 bank3 = new Bank3(30f, 43f, 12f, 90, 123);
    private Bank1 bank4 = new Bank1(30f, 44f, 12f, 60, 153);
    private Bank2 bank5 = new Bank2(30f, 43f, 12f, 80, 123);
    private Bank3 bank6 = new Bank3(30f, 43f, 12f, 90, 123);
    private Bank1 bank7 = new Bank1(30f, 43f, 12f, 90, 123);
    private Bank2 bank8 = new Bank2(30f, 43f, 12f, 90, 123);
    private Bank3 bank9 = new Bank3(30f, 43f, 12f, 90, 123);
    private Bank1 bank10 = new Bank1(30f, 43f, 12f, 90, 123);

    private MainBank[] banks5 = {bank1, bank2, bank3, bank4, bank5};
    private MainBank[] banks10 = {bank1, bank2, bank3, bank4, bank5, bank6, bank7, bank8, bank9, bank10};

    private void addOne() {
        myList.add(bank1);
    }

    private void addFive() {
        myList.addAll(Arrays.asList(banks5));
    }

    private void addTen() {
        myList.addAll(Arrays.asList(banks5));
    }

    @Test
    public void testConstructorCollection() {

        MainBank mb = new Bank1(30f, 33f, 23f, 90, 55);
        Collection<MainBank> col = new HashSet();
        col.add(mb);
        MyList ml = new MyList(col);
        assertTrue(ml.contains(mb));
        assertEquals(col.size(), ml.size());
    }

    @Test
    public void testCapacityBeforeAdding() {
        assertEquals(myList.allSize(), 10);
    }

    @Test
    public void testSizeAfterAdding() {
        addOne();
        assertEquals(myList.size(), 1);
    }

    @Test
    public void testContainsRightElAfterAdding() throws NullPointerException {
        addOne();
        assertTrue(myList.contains(bank1));
    }

    @Test
    public void testCapacityAfterAdding() {
        addOne();
        assertEquals(myList.allSize(), 10);
    }

    @Test
    public void testSizeAfterFewAdding() {
        addFive();
        assertEquals(myList.size(), 5);
    }

    @Test
    public void testCapacityAfterFewAdding() {
        addFive();
        assertEquals(myList.allSize(), 10);
    }

    @Test
    public void testSizeAfterLotsAdding() {
        addOne();
        addFive();
        assertEquals(myList.size(), 6);
    }

    @Test
    public void testCapacityAfterLotsAdding() {
        addOne();
        addFive();
        addOne();
        assertEquals(myList.allSize(), 15);
    }

    @Test
    public void testContainsRightElAfterLotsAdding() {
        addFive();
        assertTrue(myList.contains(bank1));
        assertTrue(myList.contains(bank2));
        assertTrue(myList.contains(bank3));
        assertTrue(myList.contains(bank4));
        assertTrue(myList.contains(bank5));
        assertEquals(5, myList.size());
    }

    @Test
    public void testToArray() {
        addFive();
        assertArrayEquals(banks5, myList.toArray());
        assertEquals(5, myList.size());
    }

    @Test
    public void testToArrayWithParam() {
        addFive();
        assertArrayEquals(banks5, myList.toArray(new Object[banks5.length]));
        assertEquals(5, myList.size());
    }

    @Test
    public void testGetInfoByIndex() {
        addOne();
        assertEquals(30f, myList.get(0).getPercentUsualCredit(), 0.000001);
        assertEquals(1, myList.size());
    }

    @Test
    public void testGetInfoByIndex2() {
        addOne();
        assertEquals(43f, myList.get(0).getPercentHomeCredit(), 0.000001);
        assertEquals(1, myList.size());
    }

    @Test
    public void testGetInfoByIndex3() {
        addOne();
        assertEquals(12f, myList.get(0).getPercentCarCredit(), 0.000001);
        assertEquals(1, myList.size());
    }

    @Test
    public void testGetInfoByIndex4() {
        addOne();
        assertEquals(10, myList.get(0).getMaxMonthsUsual());
        assertEquals(1, myList.size());

    }

    @Test
    public void testGetInfoByIndex5() {
        addOne();
        assertEquals(123, myList.get(0).getMaxMonthsCarAndHome());
        assertEquals(1, myList.size());
    }


    @Test
    public void testRetainAll() {
        addFive();
        MyList myList1 = new MyList();
        myList1.add(bank1);
        myList1.add(bank2);
        myList1.add(bank3);
        myList.retainAll(myList1);
        assertTrue(myList.contains(bank1));
        assertTrue(myList.contains(bank2));
        assertTrue(myList.contains(bank3));
        assertTrue(myList.contains(bank4));
        assertFalse(myList.contains(bank5));
        assertEquals(2, myList.size());
    }

    @Test
    public void testRemoveByObject() {
        addFive();
        myList.remove(bank2);
        assertFalse(myList.contains(bank2));
        assertEquals(4, myList.size());
    }

    @Test
    public void testRemoveByIndex() {
        addFive();
        myList.remove(1);
        assertFalse(myList.contains(bank2));
        assertEquals(4, myList.size());
    }

    @Test
    public void testEquals() {
        assertEquals(bank1, bank1);
    }

    @Test
    public void testContainsAfterAddWithSmallIndex() {
        myList.add(11, bank1);
        assertEquals(bank1, myList.get(11));
        assertEquals(1, myList.size());
    }

    @Test
    public void testContainsRightElAfterAddWithBigIndex() {
        myList.add(11, bank1);
        assertTrue(myList.contains(bank1));
        assertEquals(15, myList.allSize());
    }

    @Test
    public void testContainsInRightIdxAfterAddWithBigIndex() {
        myList.add(11, bank1);
        assertTrue(myList.contains(bank1));
        assertEquals(bank1, myList.get(11));
    }

    @Test
    public void testContainsInRightIdxAfterAddWithBigIndex2() {
        myList.add(11, bank1);
        assertEquals(11, myList.indexOf(bank1));
    }

    @Test
    public void testClearList() {
        addFive();
        assertEquals(5, myList.size());
        myList.clear();
        assertEquals(0, myList.size());
    }
}
