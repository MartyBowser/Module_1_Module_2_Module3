package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// you can't make a list of primitives (like int) but you can use the wrapper class
		// and it will work the same (Integer) ( double -> Double) (boolean -> Boolean)
		List<Integer> ages = new ArrayList<>();
		ages.add(37);
		ages.add(25);
		ages.add(0);

		List<Double> moneyAmounts = new ArrayList<>();
		moneyAmounts.add(1.25);
		moneyAmounts.add(2.75);

		List<Boolean> booleanList = new ArrayList<>();
		booleanList.add(true);
		booleanList.add(false);
		booleanList.add(true);

		List<String> avengers = new ArrayList<String>();
		avengers.add("Captain America");
		avengers.add("Thor");
		avengers.add("Hulk");
		avengers.add("Spider-man");

		List<Character> charList = new ArrayList<>();
		charList.add('C');
		charList.add('A');
		charList.add('T');


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// the for loop
		for(int i = 0; i < avengers.size(); i++) {
			String avenger = avengers.get(i);
			System.out.println(avenger);
		}

		// the foreach loop
		for(String hero : avengers) {
			System.out.println(hero);
		}

		int[] myArray = {1,2,5,7};
		for(int myInt : myArray) {
			System.out.println(myInt);
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		avengers.add("Thor");
		for(String hero : avengers) {
			System.out.println(hero);
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		avengers.add(2, "Scarlet Witch");
		for(String hero : avengers) {
			System.out.println(hero);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		avengers.remove(2);
		for(String hero : avengers) {
			System.out.println(hero);
		}

		System.out.println("************************");

		avengers.remove("Thor");
		for(String hero : avengers) {
			System.out.println(hero);
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean isInList = avengers.contains("Thor");
		System.out.println(isInList);

		while(avengers.contains("Thor")) {
			avengers.remove("Thor");

			/*if(avengers.contains("Hulk")) {
				break;
			} */
		}

		for(String hero : avengers){
			System.out.println(hero);
		}

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfHulk = avengers.indexOf("Hulk");
		System.out.println(indexOfHulk);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// We can take a list and convert it to an array
		String[] avengersArray = avengers.toArray(new String[0]);
		for(String hero : avengersArray){
			System.out.println(hero);
		}

		// We can take an array and convert it back to a list
		List<String> secondListOfAvengers = Arrays.asList(avengersArray);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(1);
		intList.add(5);
		intList.add(7);

		Collections.sort(intList);

		for(int value : intList){
			System.out.println(value);
		}

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(intList);
		for(int value : intList) {
			System.out.println(value);
		}

		System.out.println("####################");
		System.out.println("      FILTER EXAMPLE");
		System.out.println("####################");
		System.out.println();

		List<String> names = new ArrayList<>();
		names.add("Christopher");
		names.add("Craig");
		names.add("Heather");

		//filter out all the names that start with C and put them in their own list
		List<String> startsWithC = new ArrayList<>();
		for(String name : names) {

			if(name.startsWith("C")) {
				startsWithC.add(name);
			}
		}

		for(String name : startsWithC) {
			System.out.println(name);
		}

	}
}
