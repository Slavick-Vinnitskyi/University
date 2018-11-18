package model.entities;

import model.entities.Bank3;
import model.entities.MainBank;
import org.junit.Test;

import static org.junit.Assert.*;

public class Bank3Test {
    private MainBank bank = new Bank3(43.2f, 17.9f, 18.0f, 60, 120);

    @Test
    public void testGetMaxMonthsUsual() {
        assertEquals(60, bank.getMaxMonthsUsual());
    }

    @Test
    public void testGetMaxMonthsCarAndHome() {
        assertEquals(120, bank.getMaxMonthsCarAndHome());
    }

    @Test
    public void testGetPercentUsualCredit() {
        assertEquals(43.2f, bank.getPercentUsualCredit(), 0.000000000001);
    }

    @Test
    public void testGetPercentHomeCredit() {
        assertEquals(17.9f, bank.getPercentHomeCredit(), 0.000000000001);
    }

    @Test
    public void testGetPercentCarCredit() {
        assertEquals(18.0f, bank.getPercentCarCredit(), 0.000000000001);
    }
}