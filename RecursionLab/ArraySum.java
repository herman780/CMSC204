
public class ArraySum {
	
	public int sumOfArray (Integer[] a, int index)
	{
		int sum = 0;
		
		if(index == 0)
		{
			return a[index];
		}
		else
		{
			sum = a[index] + sumOfArray(a, index-1);
			
			return sum;
					
		}
		
		
		
	}

}
