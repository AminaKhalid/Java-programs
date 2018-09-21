import javax.swing.JOptionPane;

public class WelcomeJOptionPane {
	
	
	public static void main(String[] args) 
	{
		String name;
		name = JOptionPane.showInputDialog(null, "What's your name?");
		
		JOptionPane.showMessageDialog(null, "Hello, " + name);
		
		System.exit(0);

	}

}
