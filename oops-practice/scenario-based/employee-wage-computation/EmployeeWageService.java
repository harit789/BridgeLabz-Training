import java.util.Random;

public class EmployeeWageService {

    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;
    private static final int MAX_DAYS = 20;
    private static final int MAX_HOURS = 100;

    private Random random = new Random();

    private int getDailyHours() {
        int empCheck = random.nextInt(3);   // 0 = absent, 1 = part time, 2 = full time

        switch (empCheck) {
            case 2:
                return FULL_DAY_HOUR;
            case 1:
                return PART_TIME_HOUR;
            default:
                return 0;
        }
    }

    public void calculateMonthlyWage(Employee employee) {
        System.out.println("Calculating wages...");

        while (employee.getTotalDays() < MAX_DAYS && employee.getTotalHours() < MAX_HOURS) {
            int hours = getDailyHours();
            int wage = hours * WAGE_PER_HOUR;
            employee.addWorkDay(hours, wage);
        }

        System.out.println("Finished calculating.");
    }
}
