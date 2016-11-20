/*
 * Creates Java window with names of 5 friends
 * When you click OK, 1 of the friends' names disappears and another's appears.
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class JDisappearingFriends extends JFrame implements ActionListener {
	int i = 1;
	JLabel label = new JLabel("Your friends: "); // starting text
	JLabel a = new JLabel("Aaron"); // names of friends
	JLabel b = new JLabel("Bobby");
	JLabel c = new JLabel("Carla");
	JLabel d = new JLabel("David");
	JLabel e = new JLabel("Eddie");
	JLabel f = new JLabel("Frank");
	JButton button = new JButton("OK"); // button text
	
	
	public JDisappearingFriends() {
		super("Friends"); // sets title 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stops program on window close
		setLayout(new FlowLayout());
		
		// adds starting label, names, and button
		add(label); 
		add(a);
		add(b);
		add(c);
		add(d);
		add(e);
		add(f);
		f.setVisible(false); // sets Frank invisible
		add(button);
		// keeps track of when button is pressed
		button.addActionListener(this);		
	}	

	// changes name based on button press
	public void actionPerformed(ActionEvent event) {
		// adds and removes name based on value of i
		if (i == 6) {
			f.setVisible(false);
			e.setVisible(true);
			i = 1;
		} else if (i == 5) {
			e.setVisible(false);
			d.setVisible(true);
			i = 6;
		} else if (i == 4) {
			d.setVisible(false);
			c.setVisible(true);	
			i = 5;
		} else if (i == 3) {
			c.setVisible(false);
			b.setVisible(true);
			i = 4;
		} else if (i == 2) {
			b.setVisible(false);
			a.setVisible(true);
			i = 3;
		} else {			
			a.setVisible(false);
			f.setVisible(true);
			i = 2;
		}
		// System.out.println(i); // for debugging
	}
	
	public static void main(String[] args) {
		JDisappearingFriends friends = new JDisappearingFriends(); // creates new JFrame
		friends.setSize(300, 100); // sets height and width
		friends.setVisible(true); // makes JFrame visible

	}

}
