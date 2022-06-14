import javax.swing.*;



public class Button	{

	private String jButtonName;
	
	public Button(String jButtonName)
	{

	}
	
	public void main(String[] args)	{
		JFrame myJFrame = new JFrame();
		myJFrame.setTitle("JButton Beispiel");
		JPanel panel = new JPanel();
		
		//JButton mit Text angegebenem Text wird erstellt
		JButton button = new JButton(jButtonName);
		
		//JButton wird dem Panel hinzugefügt
		panel.add(button);
		
		myJFrame.add(panel);
		
		//Buttongröße wird angepasst, dass der Inhalt hinenpasst
		myJFrame.pack();
		
		myJFrame.setVisible(true);
	}
}