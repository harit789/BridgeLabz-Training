package service;

import java.util.*;

import model.CompanyEmployeeWage;

public class EmployeeWageBuilder implements EmployeeWageBuilderInterface {
	 private List<CompanyEmployeeWage> companies;
	    private Map<String, CompanyEmployeeWage> companyMap;

	    public EmployeeWageBuilder() {
	        companies = new ArrayList<>();
	        companyMap = new HashMap<>();
	    }

	    @Override
	    public void addCompanyEmpWage(String companyName,
	                                  int wagePerHour,
	                                  int maxWorkingDays,
	                                  int maxWorkingHours) {

	        CompanyEmployeeWage company = new CompanyEmployeeWage(companyName,
	                wagePerHour, maxWorkingDays, maxWorkingHours);

	        companies.add(company);
	        companyMap.put(companyName, company);
	    }

	    @Override
	    public void computeEmpWage() {

	        for (CompanyEmployeeWage company : companies) {

	            int totalWorkingHours = 0;
	            int totalWorkingDays = 0;

	            while (totalWorkingHours <= company.maxWorkingHours()
	                    && totalWorkingDays < company.maxWorkingDays()) {

	                totalWorkingDays++;

	                int empCheck = (int) (Math.random() * 3);
	                int empHours = 0;

	                switch (empCheck) {
	                    case 1:
	                        empHours = 8;  // full time
	                        break;
	                    case 2:
	                        empHours = 4;  // part time
	                        break;
	                    default:
	                        empHours = 0;  // absent
	                }

	                int dailyWage = empHours * company.wagePerHour();
	                company.addDailyWage(dailyWage);

	                totalWorkingHours += empHours;
	            }

	            int totalWage = totalWorkingHours * company.wagePerHour();
	            company.setemployeeWage(totalWage);
	        }
	    }

	    @Override
	    public int getTotalWage(String companyName) {

	        CompanyEmployeeWage company = companyMap.get(companyName);

	        if (company == null) {
	            throw new IllegalArgumentException("Company not found");
	        }

	        return company.gettotalEmployeeWage();
	    }
}
