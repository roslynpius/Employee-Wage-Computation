package com.bridgelabz.Employee_Wage_Computation;
import java.util.Random;

/**
 * The EmpWageBuilder class models the computation of employee wages for a specific company.
 */
class EmpWageBuilder {

    private final String companyName;
    private final int wagePerHour;
    private final int workingDays;
    private final int workingHours;

    int totalWage;

    /**
     * Constructor to initialize company-specific parameters.
     *
     * @param companyName   Name of the company.
     * @param wagePerHour   Wage per hour for the company.
     * @param workingDays   Number of working days per month.
     * @param workingHours  Number of working hours per day.
     */
    public EmpWageBuilder(String companyName, int wagePerHour, int workingDays, int workingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.workingHours = workingHours;
        totalWage=0;
    }

    /**
     * Computes the total employee wage for the company.
     */
    public void computeEmployeeWage() {
        Random random = new Random();
        System.out.printf("Company: %s\n", companyName);
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        for (int day = 1, totalWorkingHours = 0; day <= workingDays && totalWorkingHours < workingDays * workingHours; day++) {
            int isPresent = random.nextInt(3); // 0 for absent, 1 for full time present, 2 for part time present

            int workingHoursToday = switch (isPresent) {
                case 1 -> 8;
                case 2 -> 4;
                default -> 0; // Employee is Absent
            };

            int dailyWage = calculateDailyEmployeeWage(workingHoursToday);
            System.out.println("Day: " + day + " Wage:" + dailyWage);
            totalWage += dailyWage;
            totalWorkingHours += workingHoursToday;

            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHoursToday, dailyWage, totalWorkingHours);
        }

        System.out.println("Total wage for the month at " + companyName + " is " + totalWage);
        System.out.println();
        System.out.println();
    }

    /**
     * Calculates the daily employee wage based on the given working hours.
     *
     * @param workingHours   Number of working hours in a day.
     * @return Daily employee wage.
     */
    private int calculateDailyEmployeeWage(int workingHours) {
        return wagePerHour * workingHours;
    }
}

public class Employee_wage {
    public static void main(String[] args) {
        // Example usage for two companies
        EmpWageBuilder companyA = new EmpWageBuilder("ABC", 25, 20, 8);
        companyA.computeEmployeeWage();

        EmpWageBuilder companyB = new EmpWageBuilder("XYZ", 30, 22, 9);
        companyB.computeEmployeeWage();
    }
}

