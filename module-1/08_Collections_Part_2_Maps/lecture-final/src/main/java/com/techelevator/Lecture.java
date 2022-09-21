package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, Boolean> map = new HashMap<>();
		map.put("A", true);
		map.put("B", false);

		Map<String, String> map2 = new HashMap<>();
		map2.put("Christopher", "Columbus, OH");
		map2.put("Craig", "Cleveland, OH");

		Map<Integer, String> map3 = new HashMap<>();
		map3.put(555555555, "Christopher Guarnera");
		map3.put(123456789, "Craig Royer");

		Map<String, Person> map4 = new HashMap<>();
		map4.put("Christopher", new Person());

		// If you want to keep track of order you can use LinkedHashMap
		Map<String, String> sortedMap = new LinkedHashMap<>();



		System.out.println("******** GETTING VALUES *********");

		String name = map3.get(123456789);
		System.out.println(name);

		String city = map2.get("Christopher");
		System.out.println(city);

		System.out.println("******** ITERATE THROUGH VALUES *********");
		for(String value : map3.values()) {
			System.out.println(value);
		}

		System.out.println("******** ITERATE THROUGH KEYS *********");
		for(Integer key : map3.keySet()) {
			System.out.println(key);
		}

		for(String key : map2.keySet()) {
			System.out.println(key);
		}

		System.out.println("******** CHECK IF KEY EXISTS *********");
		if(map3.containsKey(123456789)) {
			System.out.println("We contain this key 123456789");
		}

		System.out.println("******** UPDATE A VALUE *********");

		String oldName = map3.get(123456789);
		System.out.println("Old value:" + oldName);

		map3.put(123456789, "Bob");

		String newName = map3.get(123456789);
		System.out.println("New value:" + newName);

		System.out.println("******** ITERATE THROUGH KEY AND VALUE *********");

		for( Map.Entry<Integer, String> entry : map3.entrySet()){
			System.out.println("Key is " + entry.getKey() + " and value is " + entry.getValue());
		}

		System.out.println("******** REMOVE FROM MAP *********");

		map3.remove(123456789);
		for( Map.Entry<Integer, String> entry : map3.entrySet()){
			System.out.println("Key is " + entry.getKey() + " and value is " + entry.getValue());
		}

		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		// Similar to list except it enforces that every item is unique
		Set<String> characters = new HashSet<>();

		characters.add("Rey");
		characters.add("Ben");
		characters.add("Luke");
		characters.add("Luke");
		characters.add("Luke");
		characters.add("Luke");
		characters.add("Luke");

		for(String character : characters) {
			System.out.println(character);
		}

		List<String> characterList = new ArrayList<>();
		for(String character: characters) {
			characterList.add(character);
		}

	}

}
