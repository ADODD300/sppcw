package testCases;

import downloadFiles.sppcw.Deductions;
import downloadFiles.sppcw.Income;
import downloadFiles.sppcw.Rate;
import downloadFiles.sppcw.TaxReturn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCase2 {

    private Income income;
    private Deductions deductions;

    private TaxReturn taxReturn;


    @BeforeEach
    public void setUp() throws Exception {
        income = new Income(12000, 100000);

        deductions = new Deductions();

        taxReturn = new TaxReturn(income, deductions);

    }


    //Income Tests
    @Test
    public void getWorkIncomeTest() {

        assertEquals(12000.0, income.getWorkIncome());
    }

    @Test
    public void getSavingsIncomeTest() {
        assertEquals(100000.0, income.getSavingsIncome());
    }

    @Test
    public void taxBandTest() {
        assertEquals(Rate.HIGHER, income.taxBand());
    }

    //Deduction Tests

    @Test
    public void totalDeductionsTest() {

        assertEquals(0, deductions.totalDeductions());
    }

    @Test
    public void listOfDeductionsTest() {

        assertEquals("no deductions", deductions.listOfDeductions());
    }

    //TaxReturn Tests
    @Test
    public void calculateTaxableSavingsIncomeTest() {
        assertEquals(99500, taxReturn.calculateTaxableSavingsIncome());
    }

    @Test
    public void calculateTaxTest() {
        assertEquals(29800.0, taxReturn.calculateTax());
    }

}
