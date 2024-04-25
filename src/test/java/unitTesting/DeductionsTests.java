package unitTesting;

import downloadFiles.sppcw.Deductions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeductionsTests {
    private Deductions deductions;

    @BeforeEach
    public void SetUp() throws Exception {
        deductions = new Deductions();
    }

    //SetUp Tests
    @Test
    public void InitialSetUpTest() {

        assertTrue(deductions.listOfDeductions()=="no deductions");
    }

    //addDeduction Tests
    @Test
    public void RegularDeductionTest() {
        deductions.addDeduction("method of tax evasion", 5000);

        assertTrue(deductions.listOfDeductions().contains("method of tax evasion"));
        assertEquals(5000, deductions.totalDeductions());
    }

    @Test
    public void DecimalDeductionTest() {
        deductions.addDeduction("method of tax evasion", 5000.12345);

        assertTrue(deductions.listOfDeductions().contains("method of tax evasion"));
        assertEquals(5000.12345, deductions.totalDeductions());
    }

    @Test
    public void NegativeDeductionTest() {
        deductions.addDeduction("method of tax evasion", -5000.0);

        assertTrue(deductions.listOfDeductions().contains("method of tax evasion"));
        assertEquals(-5000.0, deductions.totalDeductions());
    }

    @Test
    public void NoDescripDeductionTest() {
        deductions.addDeduction("", 5000.0);

        assertTrue(deductions.listOfDeductions().contains("deductions:,"));
        assertEquals(5000.0, deductions.totalDeductions());
    }

    //totalDeductions Tests

    @Test
    public void NormalTotalDeductTest() {
        deductions.addDeduction("method of tax evasion", 5000);
        deductions.addDeduction("travel expenses", 500);

        assertEquals(5500, deductions.totalDeductions());
    }

    @Test
    public void EmptyHashMapTest() {
        assertEquals(0, deductions.totalDeductions());
    }

    @Test
    public void NegativeTotalDeductTest() {
        deductions.addDeduction("method of tax evasion", -5000);
        deductions.addDeduction("travel expenses", -500);

        assertEquals(-5500, deductions.totalDeductions());
    }

    @Test
    public void DecimalTotalDeductTest() {
        deductions.addDeduction("method of tax evasion", 1.25);
        deductions.addDeduction("travel expenses", 0.5);

        assertEquals(1.75, deductions.totalDeductions());
    }

    @Test
    public void MixNegPosDeductTest() {
        deductions.addDeduction("method of tax evasion", 5000);
        deductions.addDeduction("travel expenses", 500);
        deductions.addDeduction("tax evasion gone wrong", -4000);

        assertEquals(1500, deductions.totalDeductions());
    }


    //listOfDeductions tests

    @Test
    public void NormalDeductionsTest() {
        deductions.addDeduction("method of tax evasion", 5000);
        deductions.addDeduction("travel expenses", 500);

        assertTrue(deductions.listOfDeductions().contains("method of tax evasion") && deductions.listOfDeductions().contains("travel expenses"));

    }

    @Test
    public void NoDeductionsTest() {
        assertTrue(deductions.listOfDeductions() == "no deductions");
    }

    @Test
    public void NegativeDeductionsTest() {
        deductions.addDeduction("method of tax evasion", -5000);
        deductions.addDeduction("travel expenses", -500);

        assertTrue(deductions.listOfDeductions().contains("method of tax evasion") && deductions.listOfDeductions().contains("travel expenses"));

    }

    @Test
    public void EmptyDeductDescripTest() {
        deductions.addDeduction("", 5000);

        assertTrue(deductions.listOfDeductions().contains("deductions:,"));

    }

}
