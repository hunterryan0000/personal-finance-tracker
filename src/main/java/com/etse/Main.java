package com.etse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

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
            input.nextLine(); //consume next line

            switch (choice) {
                case 1:
                    System.out.println("Add a transaction type: ");
                    String type = input.nextLine();
                    if (!type.equalsIgnoreCase("Income") && !type.equalsIgnoreCase("Expense")) {
                        throw new RuntimeException("Invalid input, please enter Income or Expense");
                    }

                    System.out.println("Add an amount for your transaction: ");
                    BigDecimal amount = input.nextBigDecimal();
                    input.nextLine(); //consume next line

                    System.out.println("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(input.nextLine());

                    tm.addTransactions(type, amount, date);
                    break;
                case 2:
                    tm.printSummary();
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
