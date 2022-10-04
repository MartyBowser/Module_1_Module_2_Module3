package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Recap {

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);


        String filePath = "C:\\Users\\Student\\instructor_repos\\te-curriculum-sept-2022\\java\\module-1\\17_File_IO_Writing\\lecture\\bankaccounts.txt";
        File myFile = new File(filePath);

        try(Scanner scan = new Scanner(myFile)){

            scanner = new Scanner(myFile);

            while(scan.hasNextLine()){
                String line = scan.nextLine();

                System.out.println("Bank Account:" + line);
            }

        } catch(FileNotFoundException ex) {
            System.out.println("File not found");
        } catch(Exception ex) {
            System.out.println("Something went wrong");
        }


        /*

            1. If we only want to make sure we catch any exception - we can just use the catch(Exception ex)
            2. If we want to catch specific Exceptions like IllegalArgumentException or FileNotFoundException
                the method that is forcing us to implement the catch will tell us
            3. If we want to keep track of custom data (like a bank account if we see suspicious activity)
                we can create our own exception to keep track of those extra fields

         */

/*
        try{

            BankAccount account = new BankAccount("My Primary Account", "123456789");

            if(account.getBalance() <= 0){
                throw new Exception("Balance less than 0");
            }

        }
        catch(SuspiciousActivityException ex) {
           System.out.println(ex.getBankAccount().getBalance());
            System.out.println(ex.getBankAccount().getAccountName());
            System.out.println(ex.getBankAccount().getAccountNumber());
        }
        catch(Exception ex) {
            // if anything goes wrong, execute this code
            System.out.println(ex.getMessage());
            ex.getStackTrace(); //typically we will put this in log but never
                                // display to a user
        }
*/

    }

}
