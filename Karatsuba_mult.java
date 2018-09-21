import java.util.Scanner;
public class Karatsuba_mult 
{
	////**Pseudocode used given in assignment
	public static void main(String[] args) 
	{
		//object of Karatsuba_mult class
		Karatsuba_mult kar = new Karatsuba_mult();
		
		//scan in user input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number: ");
		int num1 = sc.nextInt();

		System.out.println("Enter second number ");
		int num2 = sc.nextInt();
		
		//store answer in result
		long result = kar.MultiplyFast(num1, num2);
		System.out.println("\nProduct of the two numbers: "+ result);
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
	
	//MultiplyFast function Q3 a and c
	public long MultiplyFast(long a, long b)
	{
		int n = max(a, b);

		if(a==0 || b==0)
		{
			return 0;
		}
		else if(n<=10)
		{
			return a*b;
		}

		int m = Long.toBinaryString(a).length()/2;
		int m2 = Long.toBinaryString(b).length()/2;

		long o, p, q, r, s;
		o = Math.floorDiv(n, 2);
		p = getHigher(a, m);
		q = getLower(a, m);
		r = getHigher(b, m2);
		s = getLower(b, m2);

		long u, w, v;
		u = MultiplyFast(p, r);
		w = MultiplyFast(q, s);
		v = MultiplyFast(q - p, s - r);
		
		//karatsuba multiplication formula
		return (long) ((u*2)*Math.pow(2, 2*o) + (u + w - v)*Math.pow(2, o) + w);

	}

	/* Function to calculate maximum number */
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
}