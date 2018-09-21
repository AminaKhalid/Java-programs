import java.util.Scanner;

//Declare class
public class StringPermute 
{

	//Main
	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		//use scanner to input string from user
		System.out.println("Enter a String: ");
		String str = sc.next();
		
		//call permute function
		permute("" + str);

	}
	
	//Method created to calculate permutation of inputted string
	public static void permute(String str)
    {
        permute("", str);
    }
    
	//Function of Permutation of String, recursive call to function.
	public static void permute(String permutation, String str)
    {    
		//if the length of the string is equal to 0
        if(str.length() == 0)
        {
        	//print the permutation inputted
            System.out.println(permutation);
        }
        else
        {
        	int i;
        	//loop through each character of string
            for (i = 0; i<str.length(); i++)
            {    
            	//character is taken out, characters that are left are passed to the permutation method again.
                permute(permutation+str.charAt(i), str.substring(0, i)+str.substring(i+1, str.length()));
            }
        }
    }
}