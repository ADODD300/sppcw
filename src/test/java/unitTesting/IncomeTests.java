package unitTesting;

import downloadFiles.sppcw.Income;
import downloadFiles.sppcw.Rate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IncomeTests {
    //SetUp Tests
    private static Income income;

    @Test
    public void RegularSetUp() {
        income = new Income(5000, 400);

        assertTrue(income.getWorkIncome() == 5000);
        assertTrue(income.getSavingsIncome() == 400);
    }

    @Test
    public void NegativeSetUp() {
        income = new Income(-5000, -400);

        assertTrue(income.getWorkIncome() == -5000);
        assertTrue(income.getSavingsIncome() == -400);
    }

    @Test
    public void DecimalSetUp() {
        income = new Income(5000.001, 400.0123);

        assertTrue(income.getWorkIncome() == 5000.001);
        assertTrue(income.getSavingsIncome() == 400.0123);
    }

    //getWorkIncome and getSavingsIncome Tests

    @Test
    public void RegularOutputTest() {
        income = new Income(5000, 400);

        assertEquals(5000, income.getWorkIncome());
        assertEquals(400, income.getSavingsIncome());
    }

    @Test
    public void NegativeOutputTest() {
        income = new Income(-5000, -400);

        assertEquals(-5000, income.getWorkIncome());
        assertEquals(-400, income.getSavingsIncome());

    }

    @Test
    public void DecimalOutputTest() {
        income = new Income(5000.01, 400.123);

        assertEquals(5000.01, income.getWorkIncome());
        assertEquals(400.123, income.getSavingsIncome());

    }

    //TaxBand Tests

    @Test
    public void BASICtest() {
        income = new Income(25000, 4000);

        assertTrue(Rate.BASIC == income.taxBand());
    }

    @Test
    public void HIGHERtest() {
        income = new Income(130000, 12000);

        assertTrue(Rate.HIGHER == income.taxBand());
    }

    @Test
    public void ADDITIONALtest() {
        income = new Income(250000, 40000);

        assertTrue(Rate.ADDITIONAL == income.taxBand());
    }

    @Test
    public void NegativeInputTest() {
        income = new Income(-25000, -4000);

        assertTrue(Rate.BASIC == income.taxBand());
    }

    @Test
    public void BASIClowerLimitTest() {
        income = new Income(0, 0);

        assertTrue(Rate.BASIC == income.taxBand());
    }

    @Test
    public void BASICupperLimitTest() {
        income = new Income(45000, 5000);

        assertTrue(Rate.BASIC == income.taxBand());
    }

    @Test
    public void HIGHERlowerLimitTest() {
        income = new Income(45000, 5001);

        assertTrue(Rate.HIGHER == income.taxBand());
    }

    @Test
    public void HIGHERupperLimitTest() {
        income = new Income(149000, 1000);

        assertTrue(Rate.HIGHER == income.taxBand());
    }

    @Test
    public void ADDITIONALlowerimitTest() {
        income = new Income(145000, 5001);

        assertTrue(Rate.ADDITIONAL == income.taxBand());
    }


}
