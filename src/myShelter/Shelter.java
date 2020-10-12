package myShelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Shelter {

	private static Shelter instance;

	public static Shelter getInstance() {
		if(instance == null) {
			instance = new Shelter();
		}
		return instance;
	}

	private List<Animal> animals;

	public List<Animal> getAnimals(){return this.animals;}

	public Shelter() {
		this.animals = new ArrayList<>();
	}

	public void addAnimal(String line) throws Exception {
		String[] arr = line.split(" ");
		String type = arr[1];
		String name = arr[2];
		int age = Integer.parseInt(arr[3]);
		if(type.equals("wild")) {
			int degreeOfDanger = Integer.parseInt(arr[4]);
			if(degreeOfDanger == 0) {
				degreeOfDanger = WildAnimal.PEACEFULL;
			}else if(degreeOfDanger == 1) {
				degreeOfDanger = WildAnimal.LITTLE_BIT_PEACEFULL;
			}else if(degreeOfDanger == 2) {
				degreeOfDanger = WildAnimal.NOT_PEACEFULL;
			}else if(degreeOfDanger == 3) {
				degreeOfDanger = WildAnimal.LITTLE_BIT_DANGEROUS;
			}else if(degreeOfDanger == 4) {
				degreeOfDanger = WildAnimal.DANGEROUS;
			}else if(degreeOfDanger == 5) {
				degreeOfDanger = WildAnimal.VERY_DANGEROUS;
			}else {
				throw new Exception("Input for degree of danger is not valid!");
			}
			Animal a = new WildAnimal(name, age, degreeOfDanger);
			if(animals.isEmpty()) {
				animals.add(a);
			}else {
				for(Animal an : animals) {
					if(a.equals(an)) {
						throw new NumeDejaExistentException("This animal exists already!");
					}
				}
				animals.add(a);
			}
		}
		if(type.equals("domestic")) {
			boolean interior = Boolean.parseBoolean(arr[4]);
			Animal a = new DomesticAnimal(name, age, interior);
			if(animals.isEmpty()) {
				animals.add(a);
			}else {
				for(Animal an : animals) {
					if(a.equals(an)) {
						throw new NumeDejaExistentException("This animal exists already!");
					}
				}
				animals.add(a);
			}
		}
	}


	public void addAnimal(Animal a) {
		animals.add(a);
	}

	public void listAllAnimals() {
		for(Animal a : animals) {
			System.out.println(a);
		}
	}

	public void listAllDomesticAnimals() {
		for(Animal a : animals) {
			if(a instanceof DomesticAnimal) {
				System.out.println(a);
			}
		}
	}

	public void listSortedAnimals() {
		Comparator<Animal> byName = Comparator.comparing(a->a.getName());
		animals.sort(byName);
		animals.forEach(System.out::println);
	}

	public void adoptAnAnimal(String n) {
		String[] nArr = n.split(" ");
		String name = nArr[1];
		Iterator<Animal> itr = animals.iterator();
		while(itr.hasNext()) {
			Animal a = itr.next();
			if(name.equals(a.getName())) {
				itr.remove();
			}
		}
	}

}
