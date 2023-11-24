package com.bridgelabz.Employee_Wage_Computation;
import java.util.Random;

/**
 * The EmployeeWageCalculator class models the computation of employee wages for multiple companies.
 */
public class Employee_wage {

    /**
     * Computes the total employee wage for a company.
     *
     * @param companyName     Name of the company.
     * @param wagePerHour     Wage per hour for the company.
     * @param workingDays     Number of working days per month.
     * @param workingHours    Number of working hours per day.
     */
    public static void computeEmployeeWage(String companyName, int wagePerHour, int workingDays, int workingHours) {
        Random random = new Random();
        int totalWage = 0;
        System.out.printf("Company: %s\n", companyName);
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        for (int day = 1, totalWorkingHours = 0; day <= workingDays && totalWorkingHours < workingDays * workingHours; day++) {
            int isPresent = random.nextInt(3); // 0 for absent, 1 for full time present, 2 for part time present

            int workingHoursToday = switch (isPresent) {
                case 1 -> 8;
                case 2 -> 4;
                default -> 0; // Employee is Absent
            };

            int dailyWage = calculateDailyEmployeeWage(wagePerHour, workingHoursToday);
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
     * Calculates the daily employee wage based on the given wage per hour and working hours.
     *
     * @param wagePerHour    Wage per hour.
     * @param workingHours   Number of working hours in a day.
     * @return Daily employee wage.
     */
    private static int calculateDailyEmployeeWage(int wagePerHour, int workingHours) {
        return wagePerHour * workingHours;
    }

    public static void main(String[] args) {
        // Example usage for two companies
        computeEmployeeWage("ABC", 25, 20, 50);
        computeEmployeeWage("XYZ", 30, 22, 25);
    }
}
