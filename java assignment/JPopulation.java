/*
 * JFrame: choose a city from a dropdown to find its population
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPopulation extends JFrame implements ActionListener {

	String pop;
	// array of cities to be chosen
	String[] cities = { "Choose a city", "Los Angeles", "Chicago", "New York",
			"London", "Hong Kong", "San Francisco", "Shanghai" };
	// label: directions for user
	JLabel description = new JLabel("Choose a city to find the population: ");
	// dropdown list box
	JComboBox population = new JComboBox(cities);
	// text field for population
	JTextField totalPop = new JTextField(20);

	// constructor
	public JPopulation() {
		super("Find city populations:"); // label
		setSize(300, 150); // size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(description); // adds description
		add(population); // adds dropdown menu
		population.addActionListener(this); // allows program to read user input
		add(totalPop); // add text field for population
		setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {
		// stores which city is chosen
		int city = population.getSelectedIndex();
		
		// changes population based on chosen city
		switch (city) {
		case 0: pop = ""; break;
		case 1: pop = "3.9 million"; break;
		case 2: pop = "2.7 million"; break;
		case 3: pop = "8.4 million"; break;
		case 4: pop = "8.3 million"; break;
		case 5: pop = "7.1 million"; break;
		case 6: pop = "800,000"; break;
		case 7: pop = "14.4 million";
		}
		// sets text field to chosen city's population
		totalPop.setText(pop);
	}

	public static void main(String[] args) {
		JPopulation window = new JPopulation(); // creates JFrame window
	} 
}
