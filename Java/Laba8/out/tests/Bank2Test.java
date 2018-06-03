import org.junit.Test;

import static org.junit.Assert.*;

public class Bank2Test {
    @Test
    public void test2() {
        MainBank bank = new Bank2(55.6f, 19.9f, 22.0f, 48, 180);
        assertEquals(48,bank.getMaxMonthsUsual());
        assertEquals(180,bank.getMaxMonthsCarAndHome());
        assertEquals(55.6f,bank.getPercentUsualCredit(),0.000000000001);
        assertEquals(19.9f,bank.getPercentHomeCredit(),0.000000000001);
        assertEquals(22.0f,bank.getPercentCarCredit(),0.000000000001);
    }

}