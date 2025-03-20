import EmployeeObjects.CommissionEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommissionEmployeeTest {

    CommissionEmployee employee;

    @BeforeEach
    void setUp() {
        employee =  new CommissionEmployee("Clint", "Barton",
                6847, "Sales", "Customer Representative", .0265);
    }

    @Test
    void testIncreaseSales_PositiveValue() {
        employee.increaseSales(500);
        assertEquals(500.0, employee.getSales(), "Sales should be 500 after adding 500.");
    }

    @Test
    void testIncreaseSales_NegativeValue() {
        employee.increaseSales(-200);
        assertEquals(0.0, employee.getSales(), "Sales should be 500 after adding 500.");
    }

    @Test
    void testIncreaseSales_MultipleValue() {
        employee.increaseSales(300);
        employee.increaseSales(-150);
        employee.increaseSales(200);
        assertEquals(500.0, employee.getSales(), "Sales should be 500 after valid additions.");
    }


    @Test
    void testAnnualRaise() {
        employee.annualRaise(); // first raise (0.265 + 0.002)
        employee.annualRaise(); // Second raise (0.285 + 0.002)
        assertEquals(0.0305, employee.getRate(), 0.0001, "Rate should be 0.0305 after two raises.");
    }

    @  Test
    void testHolidayBonus() {
        double bonus = employee.holidayBonus();
        assertEquals(0.0, bonus, "Holiday bonus for commission employees should always be 0.");
    }
}