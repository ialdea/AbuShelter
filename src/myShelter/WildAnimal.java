package myShelter;

public class WildAnimal extends Animal{
	
	public final static int PEACEFULL = 0;
	public final static int LITTLE_BIT_PEACEFULL = 1;
	public final static int NOT_PEACEFULL = 2;
	public final static int LITTLE_BIT_DANGEROUS = 3;
	public final static int DANGEROUS = 4;
	public final static int VERY_DANGEROUS = 5;
	
	public WildAnimal(String name, int age, int degreeOfDanger) {
		super(name, age);
	}
	

	
}
