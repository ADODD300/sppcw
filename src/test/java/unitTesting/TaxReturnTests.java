package unitTesting;

import downloadFiles.sppcw.Deductions;
import downloadFiles.sppcw.Income;
import downloadFiles.sppcw.TaxReturn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TaxReturnTests {
    private TaxReturn taxReturn;
    private Income income;
    private Deductions deductions;

    //calculateTaxableSavingsIncome Tests



    @Test
    public void BASICtaxBandTest() {
        income = new Income(45000, 4000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(3000, taxReturn.calculateTaxableSavingsIncome());

    }

    @Test
    public void HIGHERtaxBandTest() {
        income = new Income(75000, 40000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(39500, taxReturn.calculateTaxableSavingsIncome());

    }

    @Test
    public void ADDITIONALtaxBandTest() {
        income = new Income(150000, 32000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(32000, taxReturn.calculateTaxableSavingsIncome());

    }

    @Test
    public void CalcNegativeSavingsBASICTaxBandTest() {
        income = new Income(45000, -4000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(-5000, taxReturn.calculateTaxableSavingsIncome());

    }

    @Test
    public void CalcNegativeSavingsHIGHERTaxBandTest() {
        income = new Income(75000, -2000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(-2500, taxReturn.calculateTaxableSavingsIncome());

    }

    @Test
    public void CalcNegativeSavingsADDITIONALTaxBandTest() {
        income = new Income(200000, -4000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(-4000, taxReturn.calculateTaxableSavingsIncome());

    }

    //calculateTax tests

    @Test
    public void BasicTaxTest() {
        income = new Income(45000, 4000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(7200, taxReturn.calculateTax());
    }

    @Test
    public void HigherTaxTest() {
        income = new Income(75000, 13000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(20200, taxReturn.calculateTax());
    }

    @Test
    public void AdditionalTaxTest() {
        income = new Income(200000, 45000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(87350, taxReturn.calculateTax());
    }

    @Test
    public void NegativeTaxTest() {
        income = new Income(-45000, -4000);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(-12400, taxReturn.calculateTax());
    }

    @Test
    public void TaxIncomeLessThanPersonAllowanceTest() {
        income = new Income(10000, 1400);
        deductions = new Deductions();
        taxReturn = new TaxReturn(income, deductions);

        assertEquals(-320, taxReturn.calculateTax());
    }


}
