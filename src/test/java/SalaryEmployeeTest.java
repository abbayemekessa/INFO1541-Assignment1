import EmployeeObjects.SalaryEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    SalaryEmployee employee ;

    @BeforeEach
    void setup  () {
        employee = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
    }
    @Test
    void testCalculateWeeklyPay() {
        double weeklyPay = employee.calculateWeeklyPay();
        assertEquals(1237.02, weeklyPay, 0.01, "Weekly pay should be 1237.02 after rounding.");
    }

    @Test
    void testHolidayBonus() {
        double bonus = employee.holidayBonus();
        assertEquals(2164.54, bonus, 0.01, "Holiday bonus should be $2164.54 after rounding.");
    }
}