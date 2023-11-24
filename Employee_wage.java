package com.bridgelabz.Employee_Wage_Computation;
import java.util.Random;

/**
 * The EmployeeWageCalculator class models the computation of employee wages based on attendance and working hours.
 * It includes methods for calculating daily wages, total monthly wage, and working hours.
 */
public class Employee_wage {
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;
    private static final int REQ_WORKING_DAYS = 20;
    private static final int REQ_WORKING_HOURS = 100;
    private static final int WAGE_PER_HOUR = 20;

    /**
     * Computes the total employee wage for a month.
     */
    public void computeEmployeeWage() {
        Random random = new Random();
        int totalWage = 0;
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        for (int day = 1, totalWorkingHours = 0; day <= REQ_WORKING_DAYS && totalWorkingHours < REQ_WORKING_HOURS; day++) {
            int isPresent = random.nextInt(3); // 0 for absent, 1 for full time present, 2 for part time present

            int workingHours = switch (isPresent) {
                case FULL_TIME -> 8;
                case PART_TIME -> 4;
                default -> 0; // Employee is Absent
            };

            int dailyWage = calculateDailyEmployeeWage(workingHours);
            System.out.println("Day: " + day + " Wage:" + dailyWage);
            totalWage += dailyWage;
            totalWorkingHours += workingHours;

            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHours, dailyWage, totalWorkingHours);
        }

        System.out.println("Total wage for a month is " + totalWage);
    }

    /**
     * Calculates the daily employee wage based on the given working hours.
     *
     * @param workingHours Number of working hours in a day.
     * @return Daily employee wage.
     */
    private int calculateDailyEmployeeWage(int workingHours) {
        return WAGE_PER_HOUR * workingHours;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
        Employee_wage wageCalculator = new Employee_wage();
        wageCalculator.computeEmployeeWage();
    }
}
