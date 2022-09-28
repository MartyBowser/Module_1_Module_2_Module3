package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		//explicit cast
		double x = 5.2;
		int y = (int) x;


		Singable actuallyAChicken= new Chicken();

		Singable[] singables =
				new Singable[] {new Cow(), new Chicken(), new Pig(), new Tractor()};

		for (Singable singable : singables) {

			if(singable instanceof Chicken) {
				Chicken c = (Chicken) singable;
				c.layEgg();
			}

			if(singable instanceof FarmAnimal){
				FarmAnimal f = (FarmAnimal) singable;
				f.doSomething();
			}

			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}
