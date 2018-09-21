public class SplitInteger 
{

	public static void main(String[] args)
	{
		//number to be split
		long a = 123456789L;
		
		int m = Long.toBinaryString(a).length()/2;
		double a_l = getLower(a,m);		//lower part of a, m
		double a_h = getHigher(a,m);	//higher part of a, m
		
		//print output
		System.out.println(Long.toBinaryString(a) + "\n" + Long.toBinaryString((long) a_h) + "-" + Long.toBinaryString((long) a_l));
	}
	
	//getLower function
	public static double getLower(long a, int m)
	{
		return a % Math.pow (2, m);
	}
	
	//getHigher function
	public static double getHigher(long a, int m)
	{
		 return a / Math.pow(2, m);
	}

}