/*Array copy by iteration*/

import java.util.Arrays;

public class Exercise {

	public static void main(String[] args) 
	{
		int[] a = {56, 14, -46, 15, 36, 99, 77, 18, 29, 49};
		
		//assign b to be the length of a
		int b[] = new int[a.length];

		//loop through array a and insert each into aray b
		for (int i = 0; i < a.length; ++i) {
			b[i] = a[i];
		}

		// check its not a clone
		a[0] = -1;
		System.out.println(Arrays.toString(b)); // print a string representation of the array
	}

}

