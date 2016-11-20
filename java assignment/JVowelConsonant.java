/*
 * JFrame: vowel or consonant?
 * On startup, program displays 8 random letters.
 * When you click a letter, the letter disappears, the program tells you whether that letter was a vowel or consonant, and a new letter emerges in its place.
 * This continues until you go through 19 letters of the alphabet, and then the program restarts.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JVowelConsonant extends JFrame implements ActionListener {
	
	int counter;
	int choice;
	// creates 26 JButtons, each with its own letter
	private JButton	a = new JButton("A");
	private JButton	b = new JButton("B");
	private JButton	c = new JButton("C");
	private JButton	d = new JButton("D");
	private JButton	e = new JButton("E");
	private JButton	f = new JButton("F");
	private JButton	g = new JButton("G");
	private JButton	h = new JButton("H");
	private JButton	i = new JButton("I");
	private JButton	j = new JButton("J");
	private JButton	k = new JButton("K");
	private JButton	l = new JButton("L");
	private JButton	m = new JButton("M");
	private JButton	n = new JButton("N");
	private JButton	o = new JButton("O");
	private JButton	p = new JButton("P");
	private JButton	q = new JButton("Q");
	private JButton	r = new JButton("R");
	private JButton	s = new JButton("S");
	private JButton	t = new JButton("T");
	private JButton	u = new JButton("U");
	private JButton	v = new JButton("V");
	private JButton	w = new JButton("W");
	private JButton	x = new JButton("X");
	private JButton	y = new JButton("Y");
	private JButton	z = new JButton("Z");
	
	// creates three JPanels
	private JPanel one = new JPanel();
	private JPanel two = new JPanel();
	private JPanel three = new JPanel();
	 
	// creates initial label
	private JLabel vowelOrConsonant = new JLabel("Vowel or consonant?");
	
	// places letters in an array, so they can be easily accessed
	private JButton letters [] = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
	
	// generates 25 random numbers from 0-25 stores them in an array 
	// this will be used to randomly select JButtons in the letters array
	int[] randomNumbers = new Random().ints(0, 26).distinct().limit(26).toArray();	
	
	public JVowelConsonant() {
		super("Vowel or Consonant?"); // title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(2,2,2,4)); // two-by-two grid
		
		// first JPanel
		add(one);
		// four letters are placed in this JPanel
		for(counter = 0; counter < 4; counter++) {
			// takes number from randomized array of numbers from 0-25
			choice = randomNumbers[counter];
			// plugs this number into letters array to get random letter
			one.add(letters[choice]);
		}

		// second JPanel
		add(two);
		// 4 more random letters are placed into this JPanel
		for(counter = 4; counter < 8; counter++) {
			choice = randomNumbers[counter];
			two.add(letters[choice]);
		}
		
		// third JPanel
		add(three);
		// identifies if button's letter is vowel or consonant
		three.add(vowelOrConsonant);
		
		setSize(410,150); 
		
		// adds action listeners to all 26 buttons
		for (int actionCounter = 0; actionCounter < letters.length; actionCounter++) {
			letters[actionCounter].addActionListener(this);
		}
		
	}
	
	public void actionPerformed(ActionEvent arg) {
		Object pick = arg.getSource();
		
		// figures out if a certain button is a vowel
		if ((pick == a) || (pick == e) || (pick == i) || (pick == o) || (pick == u)) {
			vowelOrConsonant.setText("Vowel");
		} 
		
		// otherwise, outputs consonant
		else {
			vowelOrConsonant.setText("Consonant");
		}
		
		JButton chosenButton = (JButton)pick;
		// makes the button that was chosen invisible
		chosenButton.setVisible(false);
		try {
			choice = randomNumbers[counter]; // finds the next random letter
			// figures out the JPanel of the chosen button
			Object jpanel = chosenButton.getParent();
			if (jpanel == one) {
				// if button was in 1st JPanel, adds a random letter to first JPanel
				one.add(letters[choice]); 
			} else if (jpanel == two){
				// if button was in 2nd JPanel, adds a random letter to 2nd JPanel
				two.add(letters[choice]);
			}
			counter++; // increments counter
		} 
		
		// if counter exceeds 25 (size of letters and random integers array)
		catch (ArrayIndexOutOfBoundsException out) {
			counter = 0; // resets counter to zero
			// creates another JVowelConsonant object for user to continue to use
			JVowelConsonant game = new JVowelConsonant();
			game.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		JVowelConsonant game = new JVowelConsonant(); // creates object
		game.setVisible(true); 
	}
	

}
