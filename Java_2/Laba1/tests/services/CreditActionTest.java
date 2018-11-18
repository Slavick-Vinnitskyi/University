package services;

import model.entities.Bank1;
import model.entities.Bank2;
import model.entities.Bank3;
import exceptions.MyException;
import model.list.MyList;
import org.junit.Test;
import services.CreditAction;

import static org.junit.Assert.*;

public class CreditActionTest {
    private CreditAction creditAction = new CreditAction(3);
    private MyList myList = new MyList();

    private void addThree() {
        myList.add(new Bank1(43.2f, 17.9f, 18.0f, 60, 120));
        myList.add(new Bank2(55.6f, 19.9f, 22.0f, 48, 180));
        myList.add(new Bank3(49.9f, 19.9f, 19.9f, 72, 240));
    }

    @Test
    public void testGetNewCredit() {
        addThree();
        assertEquals(creditAction.getNewCredit(myList, 1, 100, 10), 100.0f, 0.0000001);
    }

    @Test
    public void testGetMaxMonthsCredit() {
        addThree();
        try {
            assertEquals(creditAction.getMaxMonthsCredit(myList, 1), 60);
        } catch (MyException e) {
            System.out.println(e.getNumb());
            e.purpose();
        }
    }

    @Test
    public void testMinMaxCredit() {
        addThree();
        assertEquals(creditAction.MinMaxCredit(myList, 1), 60,0.000000001);
    }

    @Test
    public void testMinMaxMonths() {
        addThree();
        assertEquals(creditAction.MinMaxMonths(myList, 1), 180);
    }
}