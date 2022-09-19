package com.techelevator;

import java.util.Scanner;

public class TempConvert {

    public static void main(String[] args) {

        // Enter the temperature
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the temperature:");
        String temperatureStr = scan.nextLine();
        int temperature = Integer.parseInt(temperatureStr);
        // Enter c or F
        System.out.println("is the temperature in (c)elsuis,");
        String temperatureType = scan.nextLine();
        //if the temp is C
        if (temperatureType.equalsIgnoreCase("C")) {
            // use the formulas for conversion
            double temperatureFarenheit = temperature * 1.8 + 32;
            System.out.println(temperature + temperatureType + "is" + temperatureFarenheit + "F");
            //otherwise if the temp is F
        } else if (temperatureType.equals("F")) {
            //use other formula for conversion and store in new var
            double temperatureCelsius = (temperature - 32) / 1.8;
            System.out.println(temperature + temperatureType + "is" + temperatureCelsius + "C");
            // display the old and new

            //

        }
    }


}
