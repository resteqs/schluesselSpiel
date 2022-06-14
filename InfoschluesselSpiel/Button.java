import javax.swing.*;

public class Button	{
	
	public Button(String jButtonName)	{
		privat String jButtonName; 
	}
	
	public static void main(String[] args)	{
		JFrame myJFrame = new JFrame();
		myJFram.setTitle("JButton Beispiel");
		JPanel panel = new JPanel();
		
		//JButton mit Text angegebenem Text wird erstellt
		JButtom button = new JButton(jButtonName);
		
		//JButton wird dem Panel hinzugefügt
		panel.add(button);
		
		myJFrame.add(panel);
		
		//Buttongröße wird angepasst, dass der Inhalt hinenpasst
		myJFrame.pack();
		
		myJFrame.setVisible(true);
	}
}