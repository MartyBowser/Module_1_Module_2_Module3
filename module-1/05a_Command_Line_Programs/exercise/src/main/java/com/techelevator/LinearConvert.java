package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		//Enter the measurement
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the measurement");
		String measurementStr = scan.nextLine();

		double length = Double.parseDouble(measurementStr);


		System.out.println("is the measurement in (M)eters, or (F)eet,");
		String measurementType = scan.nextLine();
		if (measurementType.equals("F")) {



			double lengthInFeet = length * 0.3048;
			System.out.println(length + measurementStr + " is " + lengthInFeet + "M");
			//if measurement is Feet
		}
		else if (measurementType.equals("M")) {
		double lengthInMeters = length * 3.2808399;
		System.out.println(length + measurementStr + " is " + lengthInMeters + "F");

			//if measurement is Meters


		} else{
			System.out.println("Enter M or F");
		}

	}
}
