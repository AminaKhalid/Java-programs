/*Write a generic method to exchange the positions of two different elements in an array.*/

public class ExchangePosition {

		public static <E> void swap(E[] a, int i, int j) {
			E temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}