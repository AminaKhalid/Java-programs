
import javax.swing.JOptionPane;

public class WordLength {

	public static void main(String[] args) {
		
		String myWord;
		myWord = JOptionPane.showInputDialog(null, "Enter a word: ");
		
		int wordLength = myWord.length();
		
		String message = "There are " +wordLength+ " letters in " +myWord;
		
		JOptionPane.showMessageDialog(null, message);
		
		System.exit(0);

	}

}
