package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		Scanner userScan = new Scanner(System.in);
		System.out.println("Please enter a destination file ");
		String myPath = userScan.nextLine();

		File fizzBuzzFile = new File(myPath);
		try (PrintWriter writer = new PrintWriter(fizzBuzzFile)) {
			for (int number = 1; number <= 300; number++) {

				if (number % 3 == 0 && number % 5 == 0) {
					writer.println("FizzBuzz");
				} else if (number % 3 == 0) {
					writer.println("Fizz");
				} else if (number % 5 == 0) {
					writer.println("Buzz");
				} else {
					writer.println(number);
				}
			}

		} catch (Exception exception) {
			System.out.println("These are not the droids you are looking for");


		}
	}
}
