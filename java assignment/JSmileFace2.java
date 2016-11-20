/*
 * Program that has a button to turn that frown upside down
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Color;

public class JSmileFace2 extends JFrame implements ActionListener {

	// initializes JButton and JPanel
	JButton change = new JButton("Turn that frown upside down!");
	JPanel panel = new JPanel();
	int i = 0;

	// constructor
	public JSmileFace2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel); // adds JPanel
		panel.setLayout(new FlowLayout());
		// sets color to yellow
		panel.setBackground(Color.YELLOW);
		panel.add(change); // adds button
		change.addActionListener(this); // allows button to receive user input

	}

	public void paint(Graphics draw1) {
		super.paint(draw1);
		Graphics2D draw = (Graphics2D) draw1;
		draw.drawOval(50, 170, 70, 70); // face
		draw.fillOval(73, 185, 3, 5); // left eye
		draw.fillOval(93, 185, 3, 5); // right eye
		// if button count is on even number, shows frown		
		if (i % 2 == 0) {			
			draw.drawArc(48, 200, 75, 75, 30, 120); // frown
		} 
		// if button count is on odd number, shows smile
		else {
			draw.drawArc(48, 150, 75, 75, 210, 120); // smile
		}		
	}

	// when button is pressed
	public void actionPerformed(ActionEvent arg0) {
		i++; // increments i
		repaint(); // calls paint method again
	}

	public static void main(String[] args) {
		// creates window
		JSmileFace2 window = new JSmileFace2();
		window.setVisible(true);
		window.setSize(300, 300);
	}

}
