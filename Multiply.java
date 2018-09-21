import java.util.Random;

public class Multiply {

	//**Pseudocode used given in assignment
	public static void main(String[] args) 
	{
		long a = 12345678L;
		long b = 87654321L;
		int m = Long.toBinaryString(a).length()/2;
		int m2 = Long.toBinaryString(b).length()/2;
		double a_l = getLower(a,m);
		double a_h = getHigher(a,m);
		
		System.out.println(a + " x " + b + "\n" + "= " + (a*b));

		multiplyLong(a,b);
	}
	
	//getLower function
	public static long getLower(long a, int m)
	{
		return (long) (a % Math.pow (2, m));
	}
	
	//getHigher function
	public static long getHigher(long a, int m)
	{
		 return (long) (a / Math.pow(2, m));
	}

	//Multiply function Q2 c
	public static double multiply(long a, long b)
	{
		int n;
		
		//n is assigned the value from maximum of a, b
		n = max(a, b);

		if(a==0 || b==0)
		{
			return 0;
		}
		
		//if n is less than or equal to 2 return a by b
		else if(n<=2)
		{
			return a*b;
		}
		
		int m = n/2;
		int m2 = n/2;
		
		long t, p, q, r, s;
		t = n/2;
		p = getHigher(a,m);
		q = getLower(a,m);
		r = getHigher(b,m2);
		s = getLower(b,m2);
		
		//formula for multiplication
		return (long) ((p*r)*Math.pow(2, 2*t) + (p*s+q*r)*Math.pow(2, t) + q*s);

	}
	
	//Get maximum number
	public static int max(long a, long b)
	{
		//if a is greater than b, then return length of a
		//else return length of b
		if(a>=b)
		{
			return String.valueOf(a).length();
		}
		else
		{
			return String.valueOf(b).length();
		}
	}

	//multiplyLong function Q2 d
	public static void multiplyLong(long a, long b) 
	{
		//Random random = new Random(); 
		System.out.println("Run-Time:");
		for(int n=0; n<100; n++)
		{
			//long a = (long)(random.nextDouble()*(2000000));
			//long b = (long)(random.nextDouble()*(2000000));
			long begin = System.nanoTime();
			multiply(a, b);
			long end = System.nanoTime();

			//System.out.println(c);
			//System.out.println(d);
			System.out.println(n + ", " + (end-begin)*1000L);
		}
	}

}