package com.bridgelabz.Employee_Wage_Computation;
import java.util.Random;

/**
 * The CompanyEmpWage class represents the details of a specific company.
 */
class CompanyEmpWage {
    final String COMPANY_NAME;
    final int WAGE_PER_HOUR;
    final int WORKING_DAYS;
    final int WORKING_HOURS;
    int total_wage;

    /**
     * Constructor to initialize company-specific parameters.
     *
     * @param companyName   Name of the company.
     * @param wagePerHour   Wage per hour for the company.
     * @param workingDays   Number of working days per month.
     * @param workingHours  Number of working hours per day.
     */
    public CompanyEmpWage(String companyName, int wagePerHour, int workingDays, int workingHours) {
        this.COMPANY_NAME = companyName;
        this.WAGE_PER_HOUR = wagePerHour;
        this.WORKING_DAYS = workingDays;
        this.WORKING_HOURS = workingHours;
        total_wage=0;
    }

    public String getCompanyName() {
        return COMPANY_NAME;
    }

    public int getWagePerHour() {
        return WAGE_PER_HOUR;
    }

    public int getWorkingDays() {
        return WORKING_DAYS;
    }

    public int getWorkingHours() {
        return WORKING_HOURS;
    }
}

/**
 * The EmpWageBuilder class manages the employee wage for multiple companies.
 */
class EmpWageBuilder {

    private final CompanyEmpWage[] companyEmpWages;

    /**
     * Constructor to initialize the array of CompanyEmpWage objects.
     *
     * @param numOfCompanies Number of companies to manage.
     */
    public EmpWageBuilder(int numOfCompanies) {
        companyEmpWages = new CompanyEmpWage[numOfCompanies];
    }

    /**
     * Adds a company with its details to the array.
     *
     * @param index           Index to add the company.
     * @param companyEmpWage  CompanyEmpWage object representing the company details.
     */
    public void addCompany(int index, CompanyEmpWage companyEmpWage) {
        companyEmpWages[index] = companyEmpWage;
    }

    /**
     * Computes the total employee wage for all managed companies.
     */
    public void computeEmployeeWages() {
        for (CompanyEmpWage companyEmpWage : companyEmpWages) {
            if (companyEmpWage != null) {
                computeEmployeeWage(companyEmpWage);
            }
        }
    }

    /**
     * Computes the total employee wage for a specific company.
     *
     * @param companyEmpWage CompanyEmpWage object representing the company details.
     */
    private void computeEmployeeWage(CompanyEmpWage companyEmpWage) {
        Random random = new Random();
        int totalWage = 0;
        System.out.printf("Company: %s\n", companyEmpWage.getCompanyName());
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        for (int day = 1, totalWorkingHours = 0; day <= companyEmpWage.getWorkingDays() && totalWorkingHours < companyEmpWage.getWorkingDays() * companyEmpWage.getWorkingHours(); day++) {
            int isPresent = random.nextInt(3); // 0 for absent, 1 for full time present, 2 for part time present

            int workingHoursToday = switch (isPresent) {
                case 1 -> 8;
                case 2 -> 4;
                default -> 0; // Employee is Absent
            };

            int dailyWage = calculateDailyEmployeeWage(companyEmpWage.getWagePerHour(), workingHoursToday);
            System.out.println("Day: " + day + " Wage:" + dailyWage);
            totalWage += dailyWage;
            totalWorkingHours += workingHoursToday;

            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHoursToday, dailyWage, totalWorkingHours);
        }
        companyEmpWage.total_wage=totalWage;//saving total wage of company
        System.out.println("Total wage for the month at " + companyEmpWage.getCompanyName() + " is " + totalWage);
        System.out.println();
        System.out.println();
    }

    /**
     * Calculates the daily employee wage based on the given working hours.
     *
     * @param wagePerHour    Wage per hour.
     * @param workingHours   Number of working hours in a day.
     * @return Daily employee wage.
     */
    private int calculateDailyEmployeeWage(int wagePerHour, int workingHours) {
        return wagePerHour * workingHours;
    }
}

public class Employee_wage{
    public static void main(String[] args) {
        EmpWageBuilder empWageBuilder = new EmpWageBuilder(2);

        // Adding companies
        empWageBuilder.addCompany(0, new CompanyEmpWage("CompanyA", 25, 20, 8));
        empWageBuilder.addCompany(1, new CompanyEmpWage("CompanyB", 30, 22, 9));

        // Computing employee wages for all companies
        empWageBuilder.computeEmployeeWages();
    }
}
