import java.math.BigInteger;
import java.util.Random;

public class Karatsuba_BigInt
{
	//Main Q3 d
	public static void main(String[] args)
	{
		BigInteger a = BigInteger.valueOf(123456789);
		BigInteger b = BigInteger.valueOf(987654321);

		BigInteger result = MultiplyFast(a, b);
		System.out.println("answer = " + result);

		
		
		//Karatsuba_BigInt obj = new Karatsuba_BigInt();

		Random rnd = new Random();
		for(int n = 10; n <= 10000000;n=n+500000 ) {

			BigInteger a2 = randomBigInteger(n, rnd);

			double r1 =timeit(n, rnd);
			System.out.println(n+"   " +r1);

		}
}

	//Big Integer getHigher function
	public static BigInteger getHigher(BigInteger a, int m, int base) 
	{
		return a.divide(new BigInteger(String.valueOf(base)).pow(m));
	}

	//Big Integer getLower function
	public static BigInteger getLower(BigInteger a, int m, int base) 
	{
		return a.mod(new BigInteger(String.valueOf(base)).pow(m));
	}

	//MultiplyFast function in BigInteger
	public static BigInteger MultiplyFast(BigInteger a1, BigInteger b1) 
	{
		long a = a1.longValue();
		long b = b1.longValue();

		int n = max(a1, b1);

		if(n<=10)
		{
			return a1.multiply(b1);
		}

		int m = Long.toBinaryString(a).length()/2;
		int m2 = Long.toBinaryString(b).length()/2;

		BigInteger p, q, r, s;
		long o;

		o = Math.floorDiv(n, 2);
		BigInteger y = BigInteger.valueOf(o);

		p = getHigher(a1, m, 2);
		q = getLower(a1, m, 2);
		r = getHigher(b1, m2, 2);
		s = getLower(b1, m2, 2);

		BigInteger u, w, v;
		u = MultiplyFast(p, r);
		w = MultiplyFast(q, s);
		v = MultiplyFast(q.subtract(p), s.subtract(r));

		BigInteger two = BigInteger.valueOf(2);
		BigInteger power = BigInteger.valueOf((long) Math.pow(2, 2*o));
		BigInteger power2 = BigInteger.valueOf((long) Math.pow(2, o));

		//karatsuba multiplication formula in BigInteger
		return (BigInteger) ((u.multiply(two)).multiply(power)).add(((u.add(w)).subtract(v)).multiply(power2).add(w));

	}

	//Max function using BigInteger
	private static int max(BigInteger a, BigInteger b) {

		//if a is greater than b, then return length of a
		//else return length of b

		if (a.compareTo(b)==1)

		{
			return String.valueOf(a).length();
		}
		else
		{
			return String.valueOf(b).length();
		}
	}

	//test (multiplyLong function using BigInteger)

	static BigInteger randomBigInteger(int ndigits, Random rnd) {
		BigInteger r = new BigInteger(ndigits, rnd);
		while(r.bitLength() != ndigits) {
			r = new BigInteger(ndigits, rnd);
		}
		return r;
	}

	//Q3 e
	public static double timeit(int N, Random rnd) {
		long runs = 0;
		long runsPerRound = 10;
		long begin = System.currentTimeMillis();
		long end;
		long n_seconds = 2;
		long t_max = 1000L * n_seconds;
		BigInteger a = new BigInteger(N, rnd);      
		BigInteger b = new BigInteger(N, rnd);

		do {
			for (long i = 0; i < runsPerRound; ++i) {
				BigInteger res =MultiplyFast(a,b);

			}
			end = System.currentTimeMillis();
			runs += runsPerRound;
			runsPerRound = (long)(runsPerRound * 1.6);
	        } while (runs < Integer.MAX_VALUE / 2 &&
	                ((end - begin) < t_max) );
	        return (0.001d * (end - begin)) / runs;
	    }
		
}