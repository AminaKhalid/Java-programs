import java.util.Scanner;

public class Fibonacci {

	//Main
	public static void main (String[] args) 
    {
		//input from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter which number of the Fibonacci sequence you want: ");
		int number = sc.nextInt();
		
		//output answer
		System.out.println("Answer: "+ Fibonacci(number,0,1));
    }
	
	//Fibonacci recursive function
	static int Fibonacci(int number, int a, int b)
	{
		//if number is 0, then return a
		if(number == 0)
		{
			return a;
		}
		
		//if number is 1, then return b
		if(number == 1)
		{
			return b;
		}
		
		return Fibonacci(number-1, b, a+b);
	}
	
}