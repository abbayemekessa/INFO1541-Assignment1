import EmployeeObjects.HourlyEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {

    private HourlyEmployee employee;

    @BeforeEach
    void setup() {
        employee = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
    }
    @Test
    void testIncreaseHours_PositiveValue() {
        employee.increaseHours(5);
        assertEquals(5.0, employee.getHoursWorked(),
                "Hours worked should be 5 after adding 5.");
    }

    @Test
    void testIncreaseHours_NegativeValue() {
        employee.increaseHours(-3);
        assertEquals(0.0, employee.getHoursWorked(),
                "Hours worked should remmain 0 after adding -3.");
    }

    @Test
    void testIncreaseHours_ZeroValue() {
        employee.increaseHours(0);
        assertEquals(0.0, employee.getHoursWorked(),
                "Hours worked should remmain 0 after adding 0.");
    }

    @Test
    void testIncreaseHours_MultipleCalls() {
        employee.increaseHours(4);
        employee.increaseHours(2);
        employee.increaseHours(-1);
        assertEquals(6.0, employee.getHoursWorked(),
                "Hours worked should be 6 after multiple valid calls.");
    }

    @Test
    void testCalculateWeeklyPay_RegularHours() {
        employee.increaseHours(35); // Setting hours worked to 35
        double weeklyPay = employee.calculateWeeklyPay();
        assertEquals(1149.75, weeklyPay,0.01, "Weekly pay should be $1149.75 for 35 hours.");
    }

    @Test
    void testCalculateWeeklyPay_OvertimeHours() {
        employee.increaseHours(45); // Setting hours worked to 45
        double weeklyPay = employee.calculateWeeklyPay();
        assertEquals(1560.38, weeklyPay, 0.01,"Weekly pay should be $1560.38 for 45 hours.");
    }

    @Test
    void testAnnualRaise() {
        employee.annualRaise();
        assertEquals(34.49, employee.getWage(), 0.01, "Wage should be correctly increased to 34.49 after annual raise.");
    }
}