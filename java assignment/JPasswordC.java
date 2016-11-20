/*
 * Program takes in a password.
 * If password matches a password in passwords array (not case sensitive), outputs "Access Granted".
 * Otherwise, it outputs "Access Denied".
 * 
 * Hint: one of the passwords is rosebud.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPasswordC extends JApplet implements KeyListener {
	// initializes JLabels for description, access granted/denied and JTextField
	JLabel description = new JLabel("Enter a password and press enter");
	JTextField pass = new JTextField("", 8);
	JLabel match = new JLabel("Access Granted");
	JLabel noMatch = new JLabel("Access Denied");
	// array of possible passwords
	// all passwords are entirely lowercase, so case differences are ignored
	String[] passwords = { "rosebud", "redrum", "jake", "surrender", "dorothy" };

	public void init() {
		setSize(350, 200); // sets size
		setLayout(new FlowLayout()); // layout

		// adds description and textfield
		add(description);
		add(pass);
		pass.addKeyListener(this);

		// adds access granted/denied and sets them invisible
		add(match);
		add(noMatch);
		match.setVisible(false);
		noMatch.setVisible(false);
	}

	public void keyPressed(KeyEvent arg0) {
		// sets both access granted/denied invisible when different letters are
		// entered
		match.setVisible(false);
		noMatch.setVisible(false);

		// stores key value that is entered
		int key = arg0.getKeyCode();
		// holds text that is entered
		// converts entered text to lowercase so differences in case are ignored
		String entered = pass.getText().toLowerCase();

		// confirms that Enter key was pressed
		if (key == KeyEvent.VK_ENTER) {
			
			// if what was entered matches any of the 5 passwords
			if (entered.equals(passwords[0]) || entered.equals(passwords[1]) || entered.equals(passwords[2]) || entered.equals(passwords[3]) || 
					entered.equals(passwords[4])) {
				// display "access granted"
				match.setVisible(true);
			}

			// if what was entered does not match any of the 5 passwords
			else {
				// display "access denied"
				noMatch.setVisible(true);
			}
		}

	}

	// unnecessary methods
	public void keyTyped(KeyEvent arg0) {}
	public void keyReleased(KeyEvent arg0) {}
}
