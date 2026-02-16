package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeWageBuilderTest {

    @Test
    void givenCompanyShouldReturnValidTotalWage() {

        EmpWageBuilder builder = new EmpWageBuilder();

        builder.addCompanyEmpWage("Wipro", 20, 20, 100);
        builder.computeEmpWage();

        int totalWage = builder.getTotalWage("Wipro");

        assertTrue(totalWage >= 0);
    }

    @Test
    void givenInvalidCompanyShouldThrowException() {

        EmpWageBuilder builder = new EmpWageBuilder();

        assertThrows(IllegalArgumentException.class,
                () -> builder.getTotalWage("Unknown"));
    }
}

