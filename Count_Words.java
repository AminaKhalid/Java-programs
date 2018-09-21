import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;

public class Count_Words 
{ 
	public static void main(String[] args) 
	{ 
		// Create new HashMap objects 
		HashMap <String, Integer> count = new HashMap <String, Integer>();

		try { 
			//file open using Buffer Reader
			BufferedReader reader = new BufferedReader(new FileReader("sample_text.txt")); 
			String read;

			//reading from file 
			while ((read = reader.readLine())!= null) { 
				int start = -1;
				// process each characters  
				for (int i = 0; i < read.length(); i++) { 
		 
					//determine if character is a letter
					if ((!Character.isLetter(read.charAt(i)))) 
					{
						if (i - start > 1) 
						{ 
							//copy word from input string
							// if letter, then copy 
							if (Character.isLetter(read.charAt(i)))
							{
								i++;
							}
							  String occurance = read.substring(start + 1, i);
							
							// Check if word exists
							if (count.containsKey(occurance)) 
							{ 
								//number of occurrences for this word  
								count.put(occurance, count.get(occurance) + 1);
							} else 
							{ 
								// if the word already exists, its frequency is increased
								count.put(occurance, 1);
							} 
						} 
						//reset current position
						start = i;
					} 
				} 
			} 
			// Close buffer reader 
		reader.close();
		} catch (Exception e) 
		{
			System.out.println("The file doesn't exist ");
		} 

		//sorting the output to find the top 10 most frequently used words

		//create array List 
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.addAll(count.values());
		
		//sort in reverse order
		Collections.sort(numbers, Collections.reverseOrder());

		int end = -1;
		for (Integer mapped : numbers) 
		{ 
			if (end == mapped)
				continue;
			end = mapped;
			
			//loop to print all of the hash keys
			for (String print : count.keySet()) 
			{ 
				 //value contained
				if (count.get(print) == mapped)  
					System.out.println(print + "--" + mapped);
			}   
		} 
	} 
} 