import org.junit.Test;

import static org.junit.Assert.*;

public class Bank3Test {
    @Test
    public void test3() {
        MainBank bank = new Bank3(43.2f, 17.9f, 18.0f, 60, 120);
        assertEquals(60,bank.getMaxMonthsUsual());
        assertEquals(120,bank.getMaxMonthsCarAndHome());
        assertEquals(43.2f,bank.getPercentUsualCredit(),0.000000000001);
        assertEquals(17.9f,bank.getPercentHomeCredit(),0.000000000001);
        assertEquals(18.0f,bank.getPercentCarCredit(),0.000000000001);
    }
}