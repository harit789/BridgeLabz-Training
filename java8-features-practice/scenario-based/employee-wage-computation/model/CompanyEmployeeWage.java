package model;

import java.util.List;

public class CompanyEmployeeWage {
	private String companyName;
	private int wagePerHour;
	private int maxWorkingDays;
	private int maxWorkingHours;
	private int totalEmployeeWage;
	private List<Integer> dailyWages;

	public CompanyEmployeeWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
		if (!companyName.matches("^[A-Za-z]+$")) {
			throw new IllegalArgumentException("Invalid Company Name");
		}
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxWorkingDays = maxWorkingDays;
		this.maxWorkingHours = maxWorkingHours;
	}

	public void addDailyWage(int wage) {
		dailyWages.add(wage);
	}

	public List<Integer> getDailyWages() {
		return dailyWages;
	}

	public String getcompanyName() {
		return companyName;
	}

	public int wagePerHour() {
		return wagePerHour;
	}

	public int maxWorkingDays() {
		return maxWorkingDays;
	}

	public int maxWorkingHours() {
		return maxWorkingHours;
	}

	public void setemployeeWage(int totalEmployeeWage) {
		this.totalEmployeeWage = totalEmployeeWage;
	}

	public int gettotalEmployeeWage() {
		return totalEmployeeWage;
	}

	public String toString() {
		return "Company Name:" + companyName + ", Total Wage:" + totalEmployeeWage + ", Daily Wage:" + dailyWages;
	}
}
