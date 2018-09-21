import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Collisions {
	
	//initialise variable values
	private static int col = 0; //number of collisions for a=41
	private static int col1 = 0; //number of collisions for a=17
	static private int oldCol = 0; //number of collisions using old hash code
	
	public static void main(String[] args) 
	{
		//create hash table of numbers
        HashMap <Integer, Integer> m = new HashMap<>();
        HashMap <Integer, Integer> m1 = new HashMap<>();
        HashMap <Integer, Integer> old = new HashMap<>();
        
	try {
		//read in file using scanner
		Scanner in = new Scanner(new File("C:\\Users\\amina\\eclipse-workspace\\Assignment 3\\words.txt"));
		
		while(in.hasNext()) 
		{
			//store called function into result
			int result = poly_accumulation(in.next(), 41);
			
			//if this map contains a mapping for the specified key, increment col - number of collisions for a=41
			if (m.containsKey(result))
			{
				m.put(result, m.get(result) + 1);
				col++;
			}
			 else 
			 {
                 m.put(result, 1);
			 }
		}
		
	} catch (Exception e) {e.printStackTrace();}
	
	//output number of collisions
	System.out.println("collisions using polynomial accumulation with a = 41: " + col);
	
	try {
		//read in file again using scanner
		Scanner in = new Scanner(new File("C:\\Users\\amina\\eclipse-workspace\\Assignment 3\\words.txt"));
		
		while(in.hasNext()) 
		{
			//store called function into result1
			int result1 = poly_accumulation(in.next(), 17);
			
			//if this map contains a mapping for the specified key, increment col1 - number of collisions for a=17
			if (m1.containsKey(result1))
			{
				m1.put(result1, m1.get(result1) + 1);
				col1++;
			}
			else 
			 {
                m1.put(result1, 1);
			 }
		}
		
		//output number of collisions
		System.out.println("collisions using polynomial accumulation with a = 17: " + col1);
		
	} catch (Exception e) {e.printStackTrace();}
	

	//old hash code function
    try {
    	
    	//scan file
        Scanner in = new Scanner(new File("C:\\Users\\amina\\eclipse-workspace\\Assignment 3\\words.txt"));

        while ((in.hasNext())) 
        {
            String str = in.next();
            
            //store called function into result_oldHash variable
            int result_oldHash = Old_Hash_Code(str);

            //if this map contains a mapping for the specified key, increment oldCol
            if (old.containsKey(result_oldHash)) 
            {
                old.put(result_oldHash, (old.get(result_oldHash)) + 1);
                oldCol++;

            } else 
            {
                old.put(result_oldHash, 1);
            }
        }

        //output number of collisions
        System.out.println("collisions which occur using the old Java hash code function: " + oldCol);


    } catch (Exception e) {e.printStackTrace();}
	
	}

	//function to calculate value of collision for a=41 and a=17
	private static int poly_accumulation(String s, int a) 
	{
		int hash = 0;
		for (int i = 0; i < s.length(); i++) 
		{
			hash = (a * hash) + s.charAt(i);
		}                                                 
		return hash;
	}

	//old function used given in assignment
	private static int Old_Hash_Code(String str) {
		int hash = 0;
		int skip = Math.max(1, str.length() / 8);
		for (int i = 0; i < str.length(); i += skip) 
		{
			hash = (hash * 37) + str.charAt(i);
		}
		return hash;
	}

}
