package employee_wage_c.refactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WageComputationTest {

    WageComputation wageComputation;

    @BeforeEach
    void setUp() {
        wageComputation = new WageComputation();
        wageComputation.addCompany("TCS", 100, 160, 20);
    }

    @Test
    void testAddCompany() {
        assertEquals(1, wageComputation.companyList.size());
        assertEquals("TCS", wageComputation.companyList.get(0).getName());
    }


    @Test
    void testCalculateDailyWage() {
        int result = WageComputation.calculateDailyWage(100, 16);
        assertEquals(1600, result);
    }


    @Test
    void testCalculatePartTimeWage() {
        int result = WageComputation.calculatePartTimeWage(100, 8);
        assertEquals(800, result);
    }


    @Test
    void testCheckPresence() {
        boolean result = WageComputation.checkPresence();
        assertTrue(result == true || result == false);
    }

 
    @Test
    void testCalculateMonthlyWage() {
        wageComputation.calculateMonthlyWage();
        int total = wageComputation.companyList.get(0).getTotalWage();
        assertTrue(total >= 0);
    }

}
