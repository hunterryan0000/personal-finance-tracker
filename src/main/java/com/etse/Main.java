package com.etse;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TransactionManager tm = new TransactionManager();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        System.out.println("***********************************************************************************************************************");
        System.out.println("***********************************************************************************************************************");
        System.out.println("**************************                                                                   **************************");
        System.out.println("**************************                    PERSONAL FINANCE TRACKER                       **************************");
        System.out.println("**************************                                                                   **************************");
        System.out.println("***********************************************************************************************************************");
        System.out.println("***********************************************************************************************************************");

        while (running) {
            System.out.println();
            System.out.println("Choose an option: (1) Add Transaction (2) View Summary (3) Exit");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Transaction type (Income/Expense): ");
                    String type = input.nextLine();
                    if (!type.equalsIgnoreCase("Income") && !type.equalsIgnoreCase("Expense")) {
                        System.out.println("Invalid input, please enter Income or Expense");
                        break;
                    }

                    System.out.println("Add an amount for your transaction: ");
                    BigDecimal amount = input.nextBigDecimal();
                    if (amount.compareTo(BigDecimal.ZERO) < 0) {
                        System.out.println("Invalid input, please enter a positive decimal number");
                        break;
                    }
                    input.nextLine(); //consume next line

                    System.out.println("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(input.nextLine());

                    tm.addTransactions(new Transaction(type, amount, date));
                    break;
                case 2:
                    // Here we capture the summary string and print it
                    String summary = tm.printSummary();
                    System.out.println(summary);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
            }
        }
        input.close();
    }
}
