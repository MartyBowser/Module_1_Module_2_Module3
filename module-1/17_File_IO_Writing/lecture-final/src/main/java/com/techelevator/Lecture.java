package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		//The File class works with both files and directories

		String baseDir = "C:\\Users\\Student";
		String examplesDir = baseDir + "\\examples";
		File directory = new File(examplesDir);

		// we can check if a directory or file already exists
		if(directory.exists()){
			System.out.println(examplesDir + " already exists");
		} else {
			// we can create a new directory if it does not yet exist
			boolean successfullyCreated = directory.mkdir();
			if(successfullyCreated) {
				System.out.println("Successfully created directory " + examplesDir);
			} else {
				System.out.println("Unable to create");
			}
		}

		String fileName = "count.txt";
		File newFile = new File(directory, fileName);


		if(newFile.exists()){
			System.out.println("File already exists");
		} else {
			newFile.createNewFile();
		}

		System.out.println(newFile.getName());
		System.out.println(newFile.getAbsolutePath());
		System.out.println("Size: " + newFile.length());

		// if we want to check if it's a directory or a file
		if(directory.isFile()) {
			System.out.println("This is a file");
		} else {
			System.out.println("This is a directory");
		}

		if(newFile.isFile()) {
			System.out.println("This is a file");
		} else {
			System.out.println("This is a directory");
		}


		// Writing to a file - THIS WILL OVERWRITE ALL EXISTING CONTENTS
		try(PrintWriter writer = new PrintWriter(newFile)){
			//writer.println("Hello World!");
		}

		// Writing to a file - THIS WILL APPEND TO EXISTING FILE CONTENTS
		try(PrintWriter writer = new PrintWriter(new FileOutputStream(newFile, true))) {
			//writer.println("Another line being appended");
			for(int i = 0; i <= 100; i++) {

				//if(i % 3 == 0) {
					writer.println(i);
				//}

			}
		}

		File fizzBuzzFile = new File(directory, "fizzBuzz.txt");
		fizzBuzzFile.createNewFile();
		try(Scanner fileScan = new Scanner(newFile);
			PrintWriter writer = new PrintWriter(fizzBuzzFile)) {

			while(fileScan.hasNextLine()){
				String line = fileScan.nextLine();

				int num = Integer.parseInt(line);
				if(num % 3 == 0 && num % 5 == 0) {
					writer.println("Fizz Buzz");
				} else if(num % 3 == 0) {
					writer.println("Fizz");
				} else if(num % 5 == 0) {
					writer.println("Buzz");
				} else {
					writer.println(line);
				}
			}


		} catch(FileNotFoundException ex) {
			System.out.println("Unable to open file");
		}

	}

}
