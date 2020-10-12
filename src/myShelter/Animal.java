package myShelter;

public abstract class Animal {
	
	private String name;
	private int age; 
	
	public String getName() {return this.name;}
	public int getAge() {return this.age;}
	
	public void setName(String n) {this.name = n;}
	public void setAge(int a ) {age = a;}
	
	public Animal() {}

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name+", "+age;
	}
	
	@Override
	public boolean equals(Object anotherAnimal) {
		if(anotherAnimal instanceof WildAnimal ) {
			WildAnimal wa = (WildAnimal) anotherAnimal;
			return this.name.equals(wa.getName());
		}
		if(anotherAnimal instanceof DomesticAnimal) {
			DomesticAnimal da = (DomesticAnimal) anotherAnimal;
			return this.name.equals(da.getName());
		}
		return false;
	}
}
