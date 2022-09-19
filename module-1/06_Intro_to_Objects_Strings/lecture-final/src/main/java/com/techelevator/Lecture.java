package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
    	String name = "Christopher";
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		String cat = "Salem";

		boolean endsWithM = cat.endsWith("m");
		System.out.println("Does Salem end with m? " + endsWithM);

		boolean endsWithT = cat.endsWith("t");
		System.out.println("Does Salem end with t? " + endsWithT);

		boolean startsWithSa = cat.startsWith("Sa");
		System.out.println("Does Salem start with Sa? " + startsWithSa);

		// Careful, it is case sensitive
		boolean startsWithsa = cat.startsWith("sa");
		System.out.println("Does Salem start with sa? " + startsWithsa);

		String city = "Cincinnati";

		int indexOfN = city.indexOf("n");
		System.out.println("First index of n is " + indexOfN);

		int lastIndexOfN = city.lastIndexOf("n");
		System.out.println("Last index of n is " + lastIndexOfN);

		System.out.println(city + " is " + city.length() + " characters long");

		String first3 = city.substring(0,3);
		System.out.println("The first 3 letters are " + first3);

		String everythingAfterIndex = city.substring(lastIndexOfN);
		System.out.println("Everything after index: " + everythingAfterIndex);

		//Spaces count as well
		String nameWithSpaces = "  Joe  ";
		System.out.println("NameWithSpaces length is " + nameWithSpaces.length());
		System.out.println("Trimmed NameWithSpaces length is " + nameWithSpaces.trim().length());

		System.out.println("City in all caps: " + city.toUpperCase());
		System.out.println("City in all lower case: " + city.toLowerCase());

		// Making everything the same case is useful for testing if one value is equal to another
		// and you don't care about it being case sensitive
		String s1 = "cat";
		String s2 = "Cat";
		if(s1.toLowerCase().equals(s2.toLowerCase())) {
			System.out.println("These are the same value when I don't care about case");
		}

		String myString = "I like cats";
		String myNewString = myString.replace("cats", "dogs");
		System.out.println(myNewString);

		String animals = "cats cats cats";
		animals = animals.replaceAll("cats", "dogs");
		System.out.println(animals);

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
