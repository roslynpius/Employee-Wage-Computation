package com.bridgelabz.Employee_Wage_Computation;
import java.util.Random;

/**
 * The EmployeeWage class models the computation of employee wages based on attendance and working hours.
 * It utilizes randomization for attendance checks and calculates daily wages, total monthly wage, and working hours.
 */
public class Employee_wage {   
    public static void main(String[] args)
    {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        Random random = new Random();
        final int FULL_TIME=1;
        final int PART_TIME=2;
        final int REQ_WORKING_DAYS = 20;
        final int REQ_WORKING_HOURS= 100;
        int totalWage=0;
        int workingHours=0;
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");
        for (int day = 1, totalWorkingHours = 0; day <= REQ_WORKING_DAYS && totalWorkingHours < REQ_WORKING_HOURS; day++, totalWorkingHours += workingHours)
        {
            int isPresent = random.nextInt(3); // 0 for absent, 1 for full time present, 2 for part time present
            

            switch (isPresent) {
                case FULL_TIME:
                    workingHours=8;                
                    break;

                case PART_TIME:
                    workingHours=4;
                    break;
            
                default:
                    //Employee is Absent
                    workingHours=0;
                    break;
            }
            int dailyWage=calculateDailyEmployeeWage(workingHours);
            System.out.println("Day: " + day + " Wage:" + dailyWage); 
            totalWage += dailyWage;     
            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHours, dailyWage, totalWorkingHours + workingHours);
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
