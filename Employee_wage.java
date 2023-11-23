package com.bridgelabz.Employee_Wage_Computation;
import java.util.Random;

public class Employee_wage {   
    public static void main(String[] args)
    {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        Random random = new Random();
        final int FULL_TIME=1;
        int isPresent = random.nextInt(2); // 0 for absent, 1 for full time present
        int workingHours=0;

        if (isPresent == FULL_TIME){
            System.out.println("Employee is Present");
            workingHours=8;
        } 
        else {
            System.out.println("Employee is Absent");
        }
        //Usecase 2: calculate_daily_employee_wage
        calculateDailyEmployeeWage(workingHours);
    }
    
    /*
    @param : workingHours - no. of working hours
    @desc : Calculate daily employee wage
    */
    private static void calculateDailyEmployeeWage(int workingHours) {

        final int WAGE_PER_HOUR = 20;
        int dailyWage = WAGE_PER_HOUR * workingHours;

        System.out.println("Daily Employee Wage: " + dailyWage);
    }
}
