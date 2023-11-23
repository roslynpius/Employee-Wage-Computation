package com.bridgelabz.Employee_Wage_Computation;
import java.util.Random;

public class Employee_wage {   
    public static void main(String[] args)
    {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        Random random = new Random();
        final int FULL_TIME=1;
        final int PART_TIME=2;
        final int WORKING_DAYS = 20;
        int totalWage=0;
        
        for(int day=1;day<=WORKING_DAYS;day++)
        {
            int isPresent = random.nextInt(3); // 0 for absent, 1 for full time present, 2 for part time present
            int workingHours=0;

            switch (isPresent) {
                case FULL_TIME:
                    workingHours=8;                
                    break;

                case PART_TIME:
                    workingHours=4;
                    break;
            
                default:
                    //Employee is Absent
                    break;
            }
            int dailyWage=calculateDailyEmployeeWage(workingHours);
            System.out.println("Day: " + day + " Wage:" + dailyWage); 
            totalWage += dailyWage;     
        }
        System.out.println("Total wage for a month is " + totalWage);
    }

    /*
    @param : workingHours - no. of working hours
    @desc : Calculate daily employee wage
    */
    private static int calculateDailyEmployeeWage(int workingHours) {

        final int WAGE_PER_HOUR = 20;
        
        int dailyWage = WAGE_PER_HOUR * workingHours;

        return dailyWage;
    }
}
