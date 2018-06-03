import org.junit.Test;

import static org.junit.Assert.*;

public class CreditActionTest {
    @Test
    public void CreditActionTest() {
        CreditAction creditAction = new CreditAction(3);
        MyList myList = new MyList();
        myList.addToList(new Bank1(43.2f, 17.9f, 18.0f, 60, 120));
        myList.addToList(new Bank2(55.6f, 19.9f, 22.0f, 48, 180));
        myList.addToList(new Bank3(49.9f, 19.9f, 19.9f, 72, 240));
        assertEquals(creditAction.getNewCredit(myList,1,100,10),100.0f,0.0000001);

        try {
            assertEquals(creditAction.getMaxMonthsCredit(myList,1),60);
        }catch (MyException e){
            System.out.println(e.getNumb());
            e.purpose();
        }
        assertEquals(creditAction.MinMaxCredit(myList,1),17.9f,0.00000001);
        assertEquals(creditAction.MinMaxMonths(myList,1),180);



    }

}