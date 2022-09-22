package com.techelevator.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lecture {


	public static void main(String[] args) {

		BankAccount acct1 = new BankAccount();
		acct1.setAccountName("Albany Branch");

		Map<Integer, BankAccount> myMap = new HashMap<>();
		myMap.put(1234,  acct1);



		List<Book> myLibrary = new ArrayList<>();

		Book book = new Book();



		Book book1 = new Book("The Shining", "Stephen King");
		System.out.println(book1.getTitle());

		book1.setTitle("It");

		System.out.println(book1.getTitle());






		Book book2 = new Book(2010,"Locke And Key", "Joe Hill");

		List<String> authors = new ArrayList<>();
		authors.add("Stephen King");
		authors.add("Joe Hill");

		Book book3 = new Book("Amazing Scary Book", authors);

		myLibrary.add(book);
		myLibrary.add(book1);
		myLibrary.add(book2);
		myLibrary.add(book3);

		System.out.println("Finished");
	}

}
