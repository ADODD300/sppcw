package testCases;

import downloadFiles.sppcw.Deductions;
import downloadFiles.sppcw.Income;
import downloadFiles.sppcw.Rate;
import downloadFiles.sppcw.TaxReturn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCase3 {

    private Income income;
    private Deductions deductions;

    private TaxReturn taxReturn;


    @BeforeEach
    public void setUp() throws Exception {
        income = new Income(100000, 70000);

        deductions = new Deductions();
        deductions.addDeduction("Travel Costs", -500);

        taxReturn = new TaxReturn(income, deductions);

    }


    //Income Tests
    @Test
    public void getWorkIncomeTest() {

        assertEquals(100000, income.getWorkIncome());
    }

    @Test
    public void getSavingsIncomeTest() {
        assertEquals(70000, income.getSavingsIncome());
    }

    @Test
    public void taxBandTest() {
        assertEquals(Rate.ADDITIONAL, income.taxBand());
    }

    //Deduction Tests
    @Test
    public void addDeductionTest() {

        assertTrue(deductions.listOfDeductions().contains("Travel Costs"));
    }

    @Test
    public void totalDeductionsTest() {

        assertEquals(-500, deductions.totalDeductions());
    }

    @Test
    public void listOfDeductionsTest() {

        assertEquals("deductions:Travel Costs,", deductions.listOfDeductions());
    }

    //TaxReturn Tests
    @Test
    public void calculateTaxableSavingsIncomeTest() {
        assertEquals(70000, taxReturn.calculateTaxableSavingsIncome());
    }

    @Test
    public void calculateTaxTest() {
        assertEquals(53825, taxReturn.calculateTax());
    }

}
