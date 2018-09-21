/*Write a Java function which prints a representation of a 2 dimensional array*/

import java.util.Arrays;

public class twoDArray 
{

	public static void main(String [] args) 
	{
		int [][] a = new int[5][5];
		System.out.println(toString(a));
	}

	public static String toString(int [][] a) 
	{
		//declare aString
		String aString = "";

		//loop through rows and columns
		for(int row = 0; row < a.length; row++) 
		{
			for(int col = 0; col < a[row].length; col++) 
			{
				//print the rows and columns in the matrix form
				aString = aString + " " + a[row][col];
			}
			aString = aString + "\r\n";
		}
		return aString;
	}
}
