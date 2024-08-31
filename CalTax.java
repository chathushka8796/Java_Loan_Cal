/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caltax;

/**
 *
 * @author chathushka
 */
import java.util.Scanner;
public class CalTax {





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            System.out.println(" -----------------------------------------------------------");
            System.out.println("|           SALARY INFORMATION SYSTEM                      |");
            System.out.println(" -----------------------------------------------------------");
            System.out.println("[1] Calculate Income Tax");
            System.out.println("[2] Calculate Annual Bonus");
            System.out.println("[3] Calculate Loan Amount");
            System.out.println("Enter an option to continue >");
            
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    calculateIncomeTax(scanner);
                    break;
                case 2:
                    calculateAnnualBonus(scanner);
                    break;
                case 3:
                    calculateLoanAmount(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static void calculateIncomeTax(Scanner scanner) {
        System.out.println(" -----------------------------------------------------------");
            System.out.println("|           Calculate Income Tax                            |");
            System.out.println(" -----------------------------------------------------------");
        System.out.print("Enter Employee Name: ");
        String name = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        double tax = 0;

        if (salary > 308333) {
            tax += (salary - 308333) * 0.36;
            salary = 308333;
        }
        if (salary > 266667) {
            tax += (salary - 266667) * 0.30;
            salary = 266667;
        }
        if (salary > 225000) {
            tax += (salary - 225000) * 0.24;
            salary = 225000;
        }
        if (salary > 183333) {
            tax += (salary - 183333) * 0.18;
            salary = 183333;
        }
        if (salary > 141667) {
            tax += (salary - 141667) * 0.12;
            salary = 141667;
        }
        if (salary > 100000) {
            tax += (salary - 100000) * 0.06;
        }

        System.out.println("Monthly Income Tax for " + name + " is: Rs. " + Math.round(tax));
    }

    public static void calculateAnnualBonus(Scanner scanner) {
        System.out.println(" -----------------------------------------------------------");
            System.out.println("|           Calculate Annual Bonus                          |");
            System.out.println(" -----------------------------------------------------------");
        System.out.print("Enter Employee Name: ");
        String name = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        double annualBonus;

        if (salary < 100000) {
            annualBonus = 5000;
        } else if (salary < 200000) {
            annualBonus = salary * 0.10;
        } else if (salary < 300000) {
            annualBonus = salary * 0.15;
        } else if (salary < 400000) {
            annualBonus = salary * 0.20;
        } else {
            annualBonus = salary * 0.35;
        }

        System.out.println("Annual Bonus  " + Math.round(annualBonus));
    }

    public static void calculateLoanAmount(Scanner scanner) {
        System.out.println(" -----------------------------------------------------------");
            System.out.println("|           Calculate Loan Amount                           |");
            System.out.println(" -----------------------------------------------------------");
        System.out.print("Enter Employee Name: ");
        String name = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter Number of Years : ");
        int years = scanner.nextInt();

        if (salary < 50000) {
            System.out.println("Loan not available for salary less than Rs. 50,000.");
            return;
        }
        if (years > 5) {
            System.out.println("Maximum loan duration is 5 years.");
            return;
        }

        double monthlyInstallment = salary * 0.60;
        double interestRate = 0.15;
        int months = years * 12;

        double loanAmount = monthlyInstallment * (1 - (1 / Math.pow((1 + (interestRate / 12)), months))) / (interestRate / 12);

        System.out.println("Maximum Loan Amount for " + name + " is: Rs. " + Math.round(loanAmount));
    }
}

