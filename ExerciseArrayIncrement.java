/*Program taken from practical 1 question 7 to test*/

import java.util.Arrays;
import java.util.Random;

public class ExerciseArrayIncrement {
	public static void increment(int [] a) {
		for (int i = 0; i < a.length ; i++) {
			a[i] += 1;
		}
	}
	public static void main(String[] args) {

		int N = 10;
		//declare array
		int[] a = new int[N];
		Random random = new Random();
		
		//loop through and insert random integers into a
		for(int i = 0; i < N; i++) 
		{
			a[i] = random.nextInt(100);
		}
		
		//the original array
		System.out.println("Original array : " + Arrays.toString(a));
		
		//call increment
		increment(a);
		
		//print the incremented array
		System.out.println("Incremented array : " + Arrays.toString(a));
	}
}
