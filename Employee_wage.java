package com.bridgelabz.Employee_Wage_Computation;
import java.util.Random;

public class Employee_wage {   
    public static void main(String[] args)
    {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        Random random = new Random();
        final int FULL_TIME=1;
        int isPresent = random.nextInt(2); // 0 for absent, 1 for full time present

        if (isPresent == FULL_TIME){
            System.out.println("Employee is Present");
        } 
        else {
            System.out.println("Employee is Absent");
        }
    }
}
