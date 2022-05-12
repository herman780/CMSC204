import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	

	public int _Car = 0;
	
	Queue<Integer> theDifferentDirections;
	
	Random theRandomDirections;
	
	public int deleteQueue()
	{
		return theDifferentDirections.remove();
	}
	
	public CarQueue()
	{
		theDifferentDirections = new LinkedList<>();
		theRandomDirections = new Random();
		
	
		theDifferentDirections.add(theRandomDirections.nextInt(4));
		theDifferentDirections.add(theRandomDirections.nextInt(4));
		theDifferentDirections.add(theRandomDirections.nextInt(4));
		theDifferentDirections.add(theRandomDirections.nextInt(4));
		theDifferentDirections.add(theRandomDirections.nextInt(4));
		theDifferentDirections.add(theRandomDirections.nextInt(4));
		
	}
	
	public void addToQueue()
	{
		class theRUnDifferentDirections implements Runnable {

			@Override
			public void run() {
				
				try {
					
				while(true)
					{
						
						theDifferentDirections.add(theRandomDirections.nextInt(4));
				
						Thread.sleep(100);
					
					}
				
				
				} catch (InterruptedException t) {
					t.printStackTrace();
				}
				
			}
			
			
		}
		
		Runnable newCar = new theRUnDifferentDirections();
		Thread carDirectThread = new Thread(newCar);
		carDirectThread.start();
		
	}

}
