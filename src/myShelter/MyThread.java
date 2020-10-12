package myShelter;


public class MyThread extends Thread{
	
	private boolean isRunning = true;
	
	public void setIsRunning(boolean isRun) {this.isRunning = isRun;}
	
		@Override
		public void run() {
			while(isRunning) {
				int numberOfAnimals = Shelter.getInstance().getAnimals().size();
				System.out.println(numberOfAnimals);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

}
