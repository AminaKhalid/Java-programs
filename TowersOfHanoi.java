/*Write a recursive Java implementation of the Towers of Hanoi problem for any n [10]
(use a Scanner to read n from the console)?*/

import java.util.Scanner;

public class TowersOfHanoi {

	//main
	public static void main(String[] args) 
	{
		//create new object
		TowersOfHanoi towersOfHanoi = new TowersOfHanoi();

		//print user input using scanner
		System.out.print("Enter number of discs: ");
		Scanner scanner = new Scanner(System.in);
		int discs = scanner.nextInt();

		//call function
		towersOfHanoi.solve(discs, "A", "B", "C");
	}

	public void solve(int n, String x, String y, String z) //x, y, z are the 3 poles used
	//n is the number of discs
	{
		//if n is equal to 1, print start to end poll
		if (n == 1) 
		{
			System.out.println(x + " -> " + z);
		} 
		else 
		{
			//else use recursive solution - 2 calls
			solve(n - 1, x, z, y);
			System.out.println(x + " -> " + z);
			solve(n - 1, y, x, z);
		}
	}
}
