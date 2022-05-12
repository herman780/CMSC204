
public class DataSetGen<T extends Measurable> 
{
	private double the_Sum;
	
	private T max;
	
	private double theCount;
	
	public DataSetGen()
	{
		the_Sum = 0.0;
		
		max = null;
		
		theCount = 0;
	}
	
	public void add (T x)
	{
		the_Sum = the_Sum + x.getMeasure();
		
		if(theCount == 0 || max.getMeasure() < x.getMeasure())
		{
			max = x;
		}
		
		theCount++;
	}
	
	public double getAverage()
	{
		if(theCount == 0)
		{
			return 0;
		}
		
		else 
		{
			return the_Sum / theCount;
		}
	}
	
	public T getMaximum()
	{
		return max;
	}

}
