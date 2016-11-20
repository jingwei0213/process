/*
 * Lottery game: pick 6 numbers from 1 to 30
 * (Do not uncheck any boxes -- it will be recorded that you picked the same number twice)
 * The computer then generates 6 numbers on its own
 * If at least 3 of your numbers match the computers', you get a prize!
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JLottery2 extends JFrame implements ItemListener, ActionListener {
	int i;

	// for menu
	JMenuBar heading = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenuItem about = new JMenuItem("About");

	// description and checkboxes for numbers from 0-30
	JLabel description = new JLabel("Pick 6 numbers");
	JCheckBox zero = new JCheckBox("0");
	JCheckBox one = new JCheckBox("1");
	JCheckBox two = new JCheckBox("2");
	JCheckBox three = new JCheckBox("3");
	JCheckBox four = new JCheckBox("4");
	JCheckBox five = new JCheckBox("5");
	JCheckBox six = new JCheckBox("6");
	JCheckBox seven = new JCheckBox("7");
	JCheckBox eight = new JCheckBox("8");
	JCheckBox nine = new JCheckBox("9");
	JCheckBox ten = new JCheckBox("10");
	JCheckBox eleven = new JCheckBox("11");
	JCheckBox twelve = new JCheckBox("12");
	JCheckBox thirteen = new JCheckBox("13");
	JCheckBox fourteen = new JCheckBox("14");
	JCheckBox fifteen = new JCheckBox("15");
	JCheckBox sixteen = new JCheckBox("16");
	JCheckBox seventeen = new JCheckBox("17");
	JCheckBox eighteen = new JCheckBox("18");
	JCheckBox nineteen = new JCheckBox("19");
	JCheckBox twenty = new JCheckBox("20");
	JCheckBox twentyOne = new JCheckBox("21");
	JCheckBox twentyTwo = new JCheckBox("22");
	JCheckBox twentyThree = new JCheckBox("23");
	JCheckBox twentyFour = new JCheckBox("24");
	JCheckBox twentyFive = new JCheckBox("25");
	JCheckBox twentySix = new JCheckBox("26");
	JCheckBox twentySeven = new JCheckBox("27");
	JCheckBox twentyEight = new JCheckBox("28");
	JCheckBox twentyNine = new JCheckBox("29");
	JCheckBox thirty = new JCheckBox("30");

	// stores checkboxes 0-30 in array
	JCheckBox checkboxes[] = { zero, one, two, three, four, five, six, seven, eight,
			nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen,
			seventeen, eighteen, nineteen, twenty, twentyOne, twentyTwo,
			twentyThree, twentyFour, twentyFive, twentySix, twentySeven,
			twentyEight, twentyNine, thirty };
	// stores numbers 0-30 in array
	int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
			17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
	// picks 6 random numbers from 0 to 30 (not including 31)
	int[] random = new Random().ints(0, 31).distinct().limit(6).toArray();
	// initializes array for chosen numbers
	int[] chosen = new int[6];
	// counters
	int arrayCounter;
	int counter;
	JLabel output = new JLabel(); // displays results

	public JLottery2() {
		setTitle("Lottery Number Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(600, 300);

		// Menu
		setJMenuBar(heading);
		heading.add(file); file.add(about);
		
		// action listeners for menu
		file.addActionListener(this);
		about.addActionListener(this);

		// adds description
		add(description);
		// adds all checkboxes and item listeners to those checkboxes
		for (counter = 0; counter < checkboxes.length; counter++) {
			add(checkboxes[counter]);
			checkboxes[counter].addItemListener(this);
		}
		// adds result output
		add(output);
	}

	// when checkbox is checked
	public void itemStateChanged(ItemEvent arg0) {
		// loops through checkboxes array to find a match
		for (counter = 0; counter < checkboxes.length; counter++) {
			// if match is found (program cannot tell difference between checking and unchecking a box)
			if (checkboxes[counter].isFocusOwner()) {
				// sets an element in chosen array as the corresponding value in numbers array  
				chosen[arrayCounter] = numbers[counter];
				// increments array counter, so next checkbox element is stored in the next space in array
				arrayCounter++;
			}
		}

		// when user has chosen 6 elements
		if (arrayCounter >= 6) {
			// disable all checkboxes
			for (counter = 0; counter < checkboxes.length; counter++) {
				checkboxes[counter].setEnabled(false);
			}

			// display randomly selected numbers
			String outputRandom = "Random numbers:";
			for (counter = 0; counter < random.length; counter++) {
				outputRandom += " " + random[counter];
			}
			outputRandom += ". ";

			// display player's numbers
			String outputChosen = "Chosen numbers: ";
			for (int randCount = 0; randCount < chosen.length; randCount++) {
				outputChosen += " " + chosen[randCount];
			}
			outputChosen += ". ";

			// calculate number of matches by comparing chosen numbers and randomly selected numbers
			int matches = 0;
			for (int chosenCount = 0; chosenCount < chosen.length; chosenCount++) {
				for (int randCount = 0; randCount < random.length; randCount++) {
					if (chosen[chosenCount] == random[randCount]) {
						matches++;
					}
				}
			}

			// calculate award based on # matches 
			int award = 0;
			switch (matches) {
			case 3: award = 100; break;
			case 4: award = 10000; break;
			case 5: award = 50000; break;
			case 6: award = 1000000;
			}
			String awardString = "Award: $" + award + ".";

			// outputs randomly selected numbers, chosen numbers, and award amount
			output.setText(outputRandom + outputChosen + awardString);
		}
	}

	// when user clicks About, displays name, course, section #, MEID
	public void actionPerformed(ActionEvent arg0) {
		Object choice = arg0.getSource();
		if (choice == about) {
			JOptionPane.showMessageDialog(null,"Brian Chan\nCIS263AA\nSection #21446\nBRI2214441");
		}
	}

	public static void main(String[] args) {
		// creates object
		JLottery2 window = new JLottery2();
		window.setVisible(true);
	}

}
