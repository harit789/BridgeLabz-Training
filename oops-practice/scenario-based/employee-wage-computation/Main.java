public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        Employee employee = new Employee("John Doe");
        EmployeeWageService wageService = new EmployeeWageService();

        wageService.calculateMonthlyWage(employee);

        System.out.println(employee);
    }
}
