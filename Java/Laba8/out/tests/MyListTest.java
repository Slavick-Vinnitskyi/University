import org.junit.Test;
import static org.junit.Assert.*;

public class MyListTest {
    @Test
    public void MyListTest(){
            MyList myList = new MyList();
            assertEquals(myList.size(),0);
            assertEquals(myList.allSize(),10);
            CreditAction creditAction = new CreditAction(7);
            assertEquals(myList.allSize(),10);
            myList.addToList(new Bank1(43.2f, 17.9f, 18.0f, 60, 120));
            assertEquals(myList.allSize(),10);
            assertEquals(myList.getpercentUsualCredit(0), 43.2f,0.0000001 );
            assertEquals(myList.getpercentHomeCredit(0), 17.9f,0.0000001 );
            assertEquals(myList.getpercentCarCredit(0), 18.0f,0.0000001 );
            assertEquals(myList.getmaxMonthsUsual(0), 60);
            assertEquals(myList.maxMonthsCarAndHome(0), 60);
            assertEquals(myList.size(),1);
    }
}