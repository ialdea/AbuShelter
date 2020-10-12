package myShelter;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ShelterApp {
	
	public static void main(String[] args) throws Exception {
		
	
		
		Shelter shelter = Shelter.getInstance();
	
		MyThread t = new MyThread();
		t.setDaemon(true);
		t.start();
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter a comand.");
			String comand = in.nextLine();
			String[] arrComand = comand.split(" ");
			if(arrComand[0].equals("ADAUGA_ANIMAL")) {
				shelter.addAnimal(comand);
			}
			if(arrComand[0].equals("AFIS")) {
				shelter.listAllAnimals();
			}
			if(arrComand[0].equals("AFIS_DOMESTICE")) {
				shelter.listAllDomesticAnimals();
			}
			if(arrComand[0].equals("AFIS_SORT")) {
				shelter.listSortedAnimals();
			}
			if(arrComand[0].equals("ADOPTA")) {
				shelter.adoptAnAnimal(comand);
			}
			if(arrComand[0].equals("EXIT")) {
//				t.setIsRunning(false);
				break;
			}
		}
		
		in.close();
		
	}

}
