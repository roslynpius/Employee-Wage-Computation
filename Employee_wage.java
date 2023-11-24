package com.bridgelabz.Employee_Wage_Computation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The IEmpWageBuilder interface defines methods for managing employee wages for multiple companies.
 */
interface IEmpWageBuilder {

    /**
     * Adds a company with its details.
     *
     * @param companyName   Name of the company.
     * @param wagePerHour   Wage per hour for the company.
     * @param workingDays   Number of working days per month.
     * @param workingHours  Number of working hours per day.
     */
    void addCompany(String companyName, int wagePerHour, int workingDays, int workingHours);

    /**
     * Computes the total employee wage for all managed companies.
     */
    void computeEmployeeWages();

    /**
     * Gets the total wage for a specific company.
     *
     * @param companyName   Name of the company.
     * @return Total wage for the company.
     */
    int getTotalWageByCompany(String companyName);
}

/**
 * The EmpWageBuilder class implements the IEmpWageBuilder interface.
 */
class EmpWageBuilder implements IEmpWageBuilder {

    private final List<CompanyEmpWage> companyEmpWages;

    /**
     * Constructor to initialize the list of CompanyEmpWage objects.
     */
    public EmpWageBuilder() {
        companyEmpWages = new ArrayList<>();
    }

    /**
     * Adds a company with its details to the list.
     *
     * @param companyName   Name of the company.
     * @param wagePerHour   Wage per hour for the company.
     * @param workingDays   Number of working days per month.
     * @param workingHours  Number of working hours per day.
     */
    @Override
    public void addCompany(String companyName, int wagePerHour, int workingDays, int workingHours) {
        companyEmpWages.add(new CompanyEmpWage(companyName, wagePerHour, workingDays, workingHours));
    }

    /**
     * Computes the total employee wage for all managed companies.
     */
    @Override
    public void computeEmployeeWages() {
        for (CompanyEmpWage companyEmpWage : companyEmpWages) {
            computeEmployeeWage(companyEmpWage);
        }
    }

    /**
     * Gets the total wage for a specific company.
     *
     * @param companyName   Name of the company.
     * @return Total wage for the company.
     */
    @Override
    public int getTotalWageByCompany(String companyName) {
        for (CompanyEmpWage companyEmpWage : companyEmpWages) {
            if (companyEmpWage.getCompanyName().equals(companyName)) {
                return companyEmpWage.getTotalWage();
            }
        }
        return 0; // Return 0 if company not found
    }

    /**
     * Computes the total employee wage for a specific company.
     *
     * @param companyEmpWage CompanyEmpWage object representing the company details.
     */
    private void computeEmployeeWage(CompanyEmpWage companyEmpWage) {
        Random random = new Random();
        int totalWageForMonth = 0;
        System.out.printf("Company: %s\n", companyEmpWage.getCompanyName());
        System.out.printf("%5s     %5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs", "Daily Total Wage");

        for (int day = 1, totalWorkingHours = 0; day <= companyEmpWage.getWorkingDays() && totalWorkingHours < companyEmpWage.getWorkingDays() * companyEmpWage.getWorkingHours(); day++) {
            int isPresent = random.nextInt(3); // 0 for absent, 1 for full time present, 2 for part-time present

            int workingHoursToday = switch (isPresent) {
                case 1 -> 8;
                case 2 -> 4;
                default -> 0; // Employee is Absent
            };

            int dailyWage = calculateDailyEmployeeWage(companyEmpWage.getWagePerHour(), workingHoursToday);
            int dailyTotalWage = totalWageForMonth + dailyWage;
            System.out.println("Day: " + day + "       " + workingHoursToday + "            " + dailyWage + "        " + (totalWorkingHours + workingHoursToday) + "              " + dailyTotalWage);
            totalWageForMonth = dailyTotalWage;
            totalWorkingHours += workingHoursToday;
            companyEmpWage.addDailyWage(dailyWage);
        }

        System.out.println("Total wage for the month at " + companyEmpWage.getCompanyName() + " is " + totalWageForMonth);
        System.out.println();
        System.out.println();
        companyEmpWage.setTotalWage(totalWageForMonth);
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

/**
 * The CompanyEmpWage class represents the details of a specific company.
 */
class CompanyEmpWage {

    private final String companyName;
    private final int wagePerHour;
    private final int workingDays;
    private final int workingHours;
    private final List<Integer> dailyWages;
    private int totalWage;

    /**
     * Constructor to initialize company-specific parameters.
     *
     * @param companyName   Name of the company.
     * @param wagePerHour   Wage per hour for the company.
     * @param workingDays   Number of working days per month.
     * @param workingHours  Number of working hours per day.
     */
    public CompanyEmpWage(String companyName, int wagePerHour, int workingDays, int workingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.workingHours = workingHours;
        this.dailyWages = new ArrayList<>();
        this.totalWage = 0;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getWorkingHours() {
        return workingHours;
    }


    public int getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public void addDailyWage(int wage) {
        dailyWages.add(wage);
    }
}

public class Employee_wage {
    public static void main(String[] args) {
        IEmpWageBuilder empWageBuilder = new EmpWageBuilder();

        // Adding companies
        empWageBuilder.addCompany("CompanyA", 25, 20, 8);
        empWageBuilder.addCompany("CompanyB", 30, 22, 9);

        // Computing employee wages for all companies
        empWageBuilder.computeEmployeeWages();

        // Querying total wage for a specific company
        String queriedCompany = "CompanyA";
        int totalWage = empWageBuilder.getTotalWageByCompany(queriedCompany);
        System.out.println("Query Result:");
        System.out.println("Total wage for " + queriedCompany + " is " + totalWage);
    }
}
