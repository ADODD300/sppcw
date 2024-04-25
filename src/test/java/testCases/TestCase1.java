package testCases;

import downloadFiles.sppcw.Deductions;
import downloadFiles.sppcw.Income;
import downloadFiles.sppcw.Rate;
import downloadFiles.sppcw.TaxReturn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCase1 {

    private Income income;
    private Deductions deductions;

    private TaxReturn taxReturn;


    @BeforeEach
    public void setUp() throws Exception {
        income = new Income(40000, 5000);

        deductions = new Deductions();
        deductions.addDeduction("Travel Costs", 500);
        deductions.addDeduction("Charitable donations", 750);

        taxReturn = new TaxReturn(income, deductions);

    }


    //Income Tests
    @Test
    public void getWorkIncomeTest() {

        assertEquals(40000.0, income.getWorkIncome());
    }

    @Test
    public void getSavingsIncomeTest() {
        assertEquals(5000.0, income.getSavingsIncome());
    }

    @Test
    public void taxBandTest() {
        assertEquals(Rate.BASIC, income.taxBand());
    }

    //Deduction Tests
    @Test
    public void addDeductionTest() {

        assertTrue(deductions.listOfDeductions().contains("Travel Costs") && deductions.listOfDeductions().contains("Charitable donations"));
    }

    @Test
    public void totalDeductionsTest() {

        assertEquals(1250, deductions.totalDeductions());
    }

    @Test
    public void listOfDeductionsTest() {

        assertEquals("deductions:Travel Costs,Charitable donations,", deductions.listOfDeductions());
    }

    //TaxReturn Tests
    @Test
    public void calculateTaxableSavingsIncomeTest() {
        assertEquals(4000.0, taxReturn.calculateTaxableSavingsIncome());
    }

    @Test
    public void calculateTaxTest() {
        assertEquals(6150.0, taxReturn.calculateTax());
    }

}
