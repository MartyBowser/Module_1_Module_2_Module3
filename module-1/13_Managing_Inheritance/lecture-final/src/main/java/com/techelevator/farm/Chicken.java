package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	@Override
	public String getSound() {

		for(int i = 0; i < 3; i++) {
			// something happening
		}

		return "I'm a chicken " + super.getSound();
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}
