/*
 * JFrame: Click the center button to change one of the 4 side panels to a completely random color
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JColorFrame extends JFrame implements ActionListener {
	// creates JButtons for each region
	private JButton center = new JButton("Click to change color");
	private JButton north = new JButton("North");
	private JButton south = new JButton("South");
	private JButton east = new JButton("East");
	private JButton west = new JButton("West");
	
	// places JButtons into array to make it easier to set background color later
	private JButton regions [] = {north, south, east, west};
	int i;
	int choice;
	
	public JColorFrame() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// adds JButtons to respective regions
		add(center, BorderLayout.CENTER);
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		
		// allows center button to know when user is clicking on it
		center.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// creates random values from 0-255 for rgb values to create random color
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);
		
		// when i reaches 4, i is reset to 0 to avoid ArrayIndexOutOfBoundsException for regions array
		if (i == 4) { i = 0; }
		
		// changes background color of one of the other regions
		regions[i].setBackground(new Color(r, g, b));
		i++; // increments i so next button click changes color of another region
	}
	
	public static void main(String[] args) {
		JColorFrame colors = new JColorFrame(); // creates JColorFrame
		colors.setSize(300,300); 
		colors.setVisible(true);
	}
	

}
