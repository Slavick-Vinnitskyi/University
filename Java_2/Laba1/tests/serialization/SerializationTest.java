package serialization;

import model.entities.*;
import model.list.MyList;
import org.junit.jupiter.api.Test;
import serialization.Serialization;

import java.io.IOException;
import java.io.ObjectStreamException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SerializationTest {

    @Test
    void writeTrain() {
        BankSystem train = new BankSystem();
        Serialization<BankSystem> rw = new Serialization<>();

        //начала проверяем, работает ли запись с классом model.entities.BankSystem
        try {
            assertTrue(rw.writeObj(train, "testFile"));
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Test
    void writeReadObj() throws Exception {


        MyList train1 = new MyList(); // создали новый список и заполнили его
        MyList tempTrain1 = new MyList();
        MainBank bank1 = new Bank1(1f, 2f, 3f, 4, 7);
        MainBank bank2 = new Bank2(3f, 8f, 21f, 5, 17);
        MainBank bank3 = new Bank3(8f, 7f, 31f, 9, 41);
        train1.add(bank1);
        train1.add(bank2);
        train1.add(bank3);


        Serialization<MyList> rw1 = new Serialization<>();

        //Потом проверка с сохранием списка
        assertTrue(rw1.writeObj(train1, "test1File"));
        try {
            tempTrain1 = rw1.readObj("test1File"); // прочитали файл в созданый список

        } catch (ObjectStreamException ex) {}

//?        tempTrain1 = train1;
        System.out.println(tempTrain1.get(0).maxMonthsCarAndHome);
        System.out.println(train1.get(0).maxMonthsCarAndHome);
        assertEquals(tempTrain1.get(0), train1.get(0));
        assertEquals(tempTrain1.get(1), train1.get(1));
        assertEquals(tempTrain1.get(2), train1.get(2));
        assertEquals(tempTrain1, train1);

    }

    @Test
    void testWriteReadAsSequence() {
        MyList train1 = new MyList(); // создали новый список и заполнили его
        MyList tempTrain = new MyList();
        MainBank bank1 = new Bank1(1f, 2f, 3f, 4, 7);
        MainBank bank2 = new Bank2(3f, 8f, 21f, 5, 17);
        MainBank bank3 = new Bank3(8f, 7f, 31f, 9, 41);
        train1.add(bank1);
        train1.add(bank2);
        train1.add(bank3);

        Serialization<MyList> rw1 = new Serialization<>();
        try {
            assertTrue(rw1.writeObjAsSequence(train1, "test1File"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            tempTrain = rw1.readObjAsSequence("test1File"); // прочитали файл в созданый список
        } catch (Exception ignored) {
        }
        assertEquals(train1, tempTrain);
        System.out.println();

        // Проверочный массив
        float[][] carriageValuesFloat = {
                {1.0f, 2.0f, 3.0f},
                {3f, 8f, 21f},
                {8f, 7f, 31f}
        };
        int[][] carriageValuesInt = {
                {4, 7},
                {5, 17},
                {9, 41}
        };

        int j = 0;
        for (int i = 0; i < tempTrain.size(); i++) { // Проверяем каждый элемент, сравнивая с правильными значениями

            assertEquals(carriageValuesFloat[i][0], tempTrain.getpercentUsualCredit(i), 0.1);
            assertEquals(carriageValuesFloat[i][1], tempTrain.getpercentHomeCredit(i), 0.1);
            assertEquals(carriageValuesFloat[i][2], tempTrain.getpercentCarCredit(i), 0.1);
            assertEquals(carriageValuesInt[i][0], tempTrain.getmaxMonthsUsual(i));
            assertEquals(carriageValuesInt[i][1], tempTrain.maxMonthsCarAndHome(i));
        }
    }

    @Test
    void testWriteToTxt() throws IOException {

        BankSystem train = new BankSystem();
        Serialization<BankSystem> rw = new Serialization<>();
        assertTrue(rw.writeToTxt("test3File.txt", train)); // если true, то все ок

    }

    @Test
    void testReadFromTxt() throws IOException {
        BankSystem train = new BankSystem();
        // Проверочный массив
        float[][] banksValuesFloat = {
                {30f, 14f, 84f},
                {31f, 15f, 85f},
                {32f, 16f, 86f}
        };
        int[][] banksValuesInt = {
                {44, 90},
                {45, 91},
                {46, 92}
        };

        Serialization<BankSystem> rw = new Serialization<>();
        train = rw.readFromTxt("test3File.txt");


        int j = 0;
        //Проверка float значений обьекта
        for (int i = 0; i < train.banks.length; i++) { // Проверяем каждый элемент, сравнивая с правильными значениями
            assertEquals(train.banks[i].percentUsualCredit, banksValuesFloat[i][j], 0.1);
            j++;
            assertEquals(train.banks[i].percentHomeCredit, banksValuesFloat[i][j], 0.1);
            j++;
            assertEquals(train.banks[i].percentCarCredit, banksValuesFloat[i][j], 0.1);
            j = 0;
        }
//        Проверка float значений обьекта
        for (int i = 0; i < train.banks.length; i++) {
            assertEquals(banksValuesInt[i][j], train.banks[i].maxMonthsUsual);
            j++;
            assertEquals(banksValuesInt[i][0], train.banks[i].maxMonthsCarAndHome);
            j = 0;
        }
    }
}