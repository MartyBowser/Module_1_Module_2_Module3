package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        String filePath = "bankaccounts.txt";
        File file = new File(filePath);

        String outputPath = "receipt.txt";
        File receipt = new File(outputPath);

        try(Scanner fileScan = new Scanner(file);
            PrintWriter writer = new PrintWriter(receipt)
        ) {

            while(fileScan.hasNextLine()){
                String line = fileScan.nextLine();

                String[] lineParts = line.split(",");

                String merchant = lineParts[0];
                BigDecimal amount = new BigDecimal(lineParts[1]);

                // similar to Integer.parseInt
                // it expects a date in a format of YYYY-MM-DD
                LocalDate date = LocalDate.parse(lineParts[2]);

                Transaction transaction = new Transaction(amount, merchant, date);
                transactions.add(transaction);
            }

            BigDecimal sum = new BigDecimal("0.00");
            for(Transaction t : transactions) {
                sum = sum.add(t.getAmountOfTransaction());
            }

            writer.println("Total Transactions Received: " + transactions.size());
            writer.println("Total sum: " + sum);
            writer.println("Date Received: " + LocalDate.now());


        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        }

        System.out.println("Finished");

        /*
        List<Accountable> accounts = new ArrayList<>();
        accounts.add(new BankAccount("Primary","123"));
        accounts.add(new CreditCardAccount());

        //There are two ways to initialize a BigDecimal

        //I recommend:
        BigDecimal value = new BigDecimal("3.14");

        //You can also:
        BigDecimal value2 = BigDecimal.valueOf(2);
        BigDecimal value3 = BigDecimal.valueOf(3.14);

        //Built in values
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;

        //for comparison, we have to use .compareTo
        // instead of >, <, >=, <=

        //if value is less than or equal to value2
        if(value.compareTo(value2) <= 0) {
            System.out.println("value2 is larger than or equal to value");
        }

        if(value.compareTo(value2) == 0) {
            System.out.println("value is equal to value2");
        }

        if(value.compareTo(value2) >= 0) {
            System.out.println("value is greater than or equal to value 2 ");
        } */
    }
}
