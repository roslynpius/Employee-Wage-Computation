package com.bridgelabz.Employee_Wage_Computation;
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
}

/**
 * The EmpWageBuilder class implements the IEmpWageBuilder interface.
 */
class EmpWageBuilder implements IEmpWageBuilder {

    private static final int MAX_NUM_OF_COMPANIES = 10;
    private final CompanyEmpWage[] companyEmpWages;
    private int numOfCompanies;

    /**
     * Constructor to initialize the array of CompanyEmpWage objects.
     */
    public EmpWageBuilder() {
        companyEmpWages = new CompanyEmpWage[MAX_NUM_OF_COMPANIES];
        numOfCompanies = 0;
    }

    /**
     * Adds a company with its details to the array.
     *
     * @param companyName   Name of the company.
     * @param wagePerHour   Wage per hour for the company.
     * @param workingDays   Number of working days per month.
     * @param workingHours  Number of working hours per day.
     */
    @Override
    public void addCompany(String companyName, int wagePerHour, int workingDays, int workingHours) {
        if (numOfCompanies < MAX_NUM_OF_COMPANIES) {
            companyEmpWages[numOfCompanies] = new CompanyEmpWage(companyName, wagePerHour, workingDays, workingHours);
            numOfCompanies++;
        } else {
            System.out.println("Cannot add more companies. Maximum limit reached.");
        }
    }

    /**
     * Computes the total employee wage for all managed companies.
     */
    @Override
    public void computeEmployeeWages() {
        for (int i = 0; i < numOfCompanies; i++) {
            computeEmployeeWage(companyEmpWages[i]);
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

        System.out.println("Total wage for the month at " + companyEmpWage.getCompanyName() + " is " + totalWage);
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
}

public class Employee_wage {
    public static void main(String[] args) {
        IEmpWageBuilder empWageBuilder = new EmpWageBuilder();

        // Adding companies
        empWageBuilder.addCompany("ABC", 25, 20, 8);
        empWageBuilder.addCompany("XYZ", 30, 22, 9);

        // Computing employee wages for all companies
        empWageBuilder.computeEmployeeWages();
    }
}
