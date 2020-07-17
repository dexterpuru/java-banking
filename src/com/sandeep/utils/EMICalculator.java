package com.sandeep.utils;

public class EMICalculator {
    public static int calculateEMIAmount(int amount, int months) {
        int emiAmount = 0;
        try {
            emiAmount = amount / months; // if months = 0, then exception is thrown
            // statements below will not get executed when the above statement will cause an
            // exception
            System.out.println("Emi calculated : " + emiAmount);
            return emiAmount;
        } catch (ArithmeticException ae) {
            System.out.println("Number of months is 0 , so no emi calculated");
        } finally {
            System.out.println("EMI calculation is done");
        }
        // rest of the program is executed
        System.out.println("Thanks for using our service");
        return emiAmount;
    }

    public static int calculateNumberOfEMIs(int amount, int emiAmount) {
        int months = 0;
        try {
            months = amount / emiAmount; // if emiAmount = 0, then exception is thrown
            // statements below will not get executed when the above statement will cause an
            // exception
            System.out.println("Number of months : " + months);
            return months;
        } catch (ArithmeticException ae) {
            System.out.println("Emi amountis 0 , so nothing calculated");
        } finally {
            System.out.println("EMI calculation is done");
        }
        // rest of the program is executed
        System.out.println("Thanks for using our service");
        return months;
    }
}
