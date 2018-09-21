/*Create a class ArrayEquals which checks two 1 dimensional arrays for equality. The
class should have the following methods:*/

public class ArrayEquals {

	// return true if two integer arrays have same length and all
	// corresponding pairs of integers are equal
	public static boolean equal_array(int[] a, int[] b) {

		if (a==b)
		{// checks for same array reference
			return true;
		}
		
		if (a==null || b==null)  // checks for null arrays
			{
				return false;
			}

		int length = a.length;
		if (b.length != length)  // arrays should be of equal length
			return false;

		for (int i=0; i<length; i++)// compare array values
		{
			if (a[i] != b[i])
				return false;
		}

		return true;
	}

	// test client
	public static void main(String[] args) 
	{
		//declare arrays a b c d
		int[] a = { 3, 1, 4, 1, 5 };
		int[] b = { 3, 1, 4, 1 };
		int[] c = { 3, 1, 4, 1, 5 };
		int[] d = { 2, 7, 1, 8, 2 };

		//test to see if they are equal
		System.out.println(equal_array(a, a));
		System.out.println(equal_array(a, b));
		System.out.println(equal_array(a, c));
		System.out.println(equal_array(a, d));
	}
}

