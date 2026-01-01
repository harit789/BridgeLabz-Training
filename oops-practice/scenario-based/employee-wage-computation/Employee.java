public class Employee {

    private String name;
    private int totalHours;
    private int totalDays;
    private int totalWage;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public int getTotalHours() { return totalHours; }
    public int getTotalDays() { return totalDays; }
    public int getTotalWage() { return totalWage; }

    public void addWorkDay(int hours, int wage) {
        this.totalHours += hours;
        this.totalDays++;
        this.totalWage += wage;
    }
    @Override
    public String toString() {
        return "\nEmployee: " + name +
               "\nDays Worked: " + totalDays +
               "\nHours Worked: " + totalHours +
               "\nTotal Wage: Rs " + totalWage + "\n";
    }
}
