package myShelter;

public class DomesticAnimal extends Animal{
	
	private boolean interior;
	
	public boolean getInterior() {return this.interior;}
	
	public void setInterior(boolean interior) {this.interior = interior;}
	
	public DomesticAnimal (String name, int age, boolean interior) {
		super(name, age);
		this.interior = interior;
	}

}
