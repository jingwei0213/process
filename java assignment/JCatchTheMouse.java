/*
 * Game: click the button with an X
 * After you click the button with an X ten times, it outputs your accuracy in clicking the button with the X inside it.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCatchTheMouse extends JFrame implements ActionListener {
	// description, JPanel, and congrats message
	JLabel description = new JLabel("Click the button with an X");
	JPanel panel1 = new JPanel();
	JLabel congrats = new JLabel();
	
	// 48 JButtons
	JButton one = new JButton("");
	JButton two = new JButton("");
	JButton three = new JButton("");
	JButton four = new JButton("");
	JButton five = new JButton("");
	JButton six = new JButton("");
	JButton seven = new JButton("");
	JButton eight = new JButton("");
	JButton nine = new JButton("");
	JButton ten = new JButton("");
	JButton eleven = new JButton("");
	JButton twelve = new JButton("");
	JButton thirteen = new JButton("");
	JButton fourteen = new JButton("");
	JButton fifteen = new JButton("");
	JButton sixteen = new JButton("");
	JButton seventeen = new JButton("");
	JButton eighteen = new JButton("");
	JButton nineteen = new JButton("");
	JButton twenty = new JButton("");
	JButton twentyOne = new JButton("");
	JButton twentyTwo = new JButton("");
	JButton twentyThree = new JButton("");
	JButton twentyFour = new JButton("");
	JButton twentyFive = new JButton("");
	JButton twentySix = new JButton("");
	JButton twentySeven = new JButton("");
	JButton twentyEight = new JButton("");
	JButton twentyNine = new JButton("");
	JButton thirty = new JButton("");
	JButton thirtyOne = new JButton("");
	JButton thirtyTwo = new JButton("");
	JButton thirtyThree = new JButton("");
	JButton thirtyFour = new JButton("");
	JButton thirtyFive = new JButton("");
	JButton thirtySix = new JButton("");
	JButton thirtySeven = new JButton("");
	JButton thirtyEight = new JButton("");
	JButton thirtyNine = new JButton("");
	JButton forty = new JButton("");
	JButton fortyOne = new JButton("");
	JButton fortyTwo = new JButton("");
	JButton fortyThree = new JButton("");
	JButton fortyFour = new JButton("");
	JButton fortyFive = new JButton("");
	JButton fortySix = new JButton("");
	JButton fortySeven = new JButton("");
	JButton fortyEight = new JButton("");

	// places 48 JButtons in an array
	JButton buttons[] = { one, two, three, four, five, six, seven, eight, nine,
			ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen,
			seventeen, eighteen, nineteen, twenty, twentyOne, twentyTwo,
			twentyThree, twentyFour, twentyFive, twentySix, twentySeven,
			twentyEight, twentyNine, thirty, thirtyOne, thirtyTwo, thirtyThree,
			thirtyFour, thirtyFive, thirtySix, thirtySeven, thirtyEight,
			thirtyNine, forty, fortyOne, fortyTwo, fortyThree, fortyFour,
			fortyFive, fortySix, fortySeven, fortyEight };
	
	// generates random number from 0-47 to reference array
	int rand1 = (int) (Math.random()*48);
	int prev;
	double clicks; // stores # clicks
	double hits; // stores # hits
	String x = "X"; // X to be displayed on one of the buttons
	
	public JCatchTheMouse() {
		setTitle("Click X");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel1);
		panel1.setLayout(new GridLayout(8, 6)); // sets grid layout on JPanel for buttons
		setSize(275, 285);
				
		// uses for loop to add all buttons, add action listeners to those buttons
		for (int count = 0; count < buttons.length; count++) {
			panel1.add(buttons[count]);
			buttons[count].addActionListener(this);
		}
		
		// displays X on a random button
		buttons[rand1].setText(x);
		// stores random button number
		prev = rand1;
		// sets rest of the window to flow layout
		setLayout(new FlowLayout());
		// adds congratulation message
		add(congrats);
		add(description);
	}
	
	// when user clicks a button 
	public void actionPerformed(ActionEvent arg0) {
		clicks++; // increments number of clicks
		
		Object choice = arg0.getSource();
		// if the button selected had an X
		if (choice == buttons[prev]) {
			// generates new random number
			int rand2 = (int) (Math.random()*48);
			// removes X from previous button
			buttons[prev].setText("");
			// adds X to new button
			buttons[rand2].setText(x);
			// sets prev to new random number for later access
			prev = rand2;
			hits++; // increments number of hits
		}		

		// when # hits equal 10
		if (hits >= 10) {
			// sets all buttons invisible
			for (int i=0; i<buttons.length; i++) {
				buttons[i].setVisible(false);
			}
			// calculates user's percentage
			double percent = (hits / clicks);
			// converts decimal to percent
			percent *= 100;
			// rounds percent to nearest whole number
			long percentage = Math.round(percent);
			// congratulations message
			String congratsMsg = "Congratulations! Your percentage is " + percentage + "%.";
			// sets JLabel congrats to this message
			congrats.setText(congratsMsg);
			description.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		// creates object
		JCatchTheMouse window = new JCatchTheMouse();
	}

	
}
