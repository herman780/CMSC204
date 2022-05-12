import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               while(true)
	               {
	            	   
	            	   int _Direction = 10;
	            	   direction = carQueue.deleteQueue();
	            	   x = x+10;	
	            	   
	            	   switch(direction)
	            	   {
	            	   		case 0:
	            	   			y = y - _Direction;
	            	   			break;
	            	   			
	            	   		case 1:
	            	   			y = y + _Direction;
	            	   			break;
	            	   			
	            	   		case 2:
	            	   			x = x + _Direction;
	            	   			break;
	            	   			
	            	   		case 3:
	            	   			x = x - _Direction;
	            	   			break;
	            	   			
	            	   }
	            	   
	            	   if(x < 0 || x > 300)
	            	   {
	            		   _Direction = _Direction * -1;
	            	   }
	            	   if(y < 0 || y > 400)
	            	   {
	            		   _Direction = _Direction * -1;
	            	   }
	            	   
	            	   switch(direction)
	            	   {
	            	   
	            	   		case 0: 
	            	   			y = y - _Direction;
	            	   			break;
	            	   		case 1:
	            	   			y = y + _Direction;
	            	   			break;
	            	   		case 2:
	            	   			x = x + _Direction;
	            	   			break;
	            	   		case 3:
	            	   			x = x - _Direction;
	            	   			break;
	            	   }
	            	   repaint();
	            	   Thread.sleep(delay*1000);
	   
	               }
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	System.out.println("Officially Done");
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}
