/*
 * Based on what is entered (name or phone number),
 * Program outputs the corresponding information
 * (If name is input, number is output, and vice versa)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFriendsPhones extends JApplet implements ActionListener {
	// initializes JLabels for description and output, JTextField, JButton
	JLabel description = new JLabel("Enter a name or phone number");
	JTextField text = new JTextField("", 10);
	JButton find = new JButton("Search");
	JLabel output = new JLabel();
	
	// 2 parallel arrays for friends' names and phone numbers
	String[] friends = {"bob", "joe", "mary", "sue", "ellen"};
	int[] numbers = {2025550115, 2025550198, 2025550136, 2025550175, 2025550112};
	
	public void init() {
		setSize(350, 100); // sets size
		setLayout(new FlowLayout()); // layout

		// adds description, text field, and search button
		add(description);
		add(text);
		add(find);
		find.addActionListener(this);

		// adds display area for phone or name
		add(output);
	}

	public void actionPerformed(ActionEvent arg0) {
		// converts inputted text to lowercase
		String input = text.getText().toLowerCase();
		
		// removes parentheses, dashes, and spaces from phone numbers using substring
		for (int i=0; i<input.length(); i++) {
			if (input.substring(i, i+1).equals("(") || input.substring(i, i+1).equals(")") || input.substring(i, i+1).equals("-")
					|| input.substring(i, i+1).equals(" ")) {
				input = input.substring(0, i) + input.substring(i+1);
				i--; // double checks there are not 2 punctuation marks or spaces in a row
			}
		}
		
		// tries to parse input as phone number
		try {			
			int phone = Integer.parseInt(input);
			// searches phone number for match in numbers array
			for (int i=0; i<5; i++) {
				if (phone == numbers[i]) {
					// holds name for that number
					String name = friends[i];
					// makes first letter of name upper case
					name = name.substring(0, 1).toUpperCase() + name.substring(1);
					// sets output as name
					output.setText(name);
				}
			}
		} 
		
		// catches error if input is not a number (for names)
		catch (NumberFormatException error) {
			// searches name for match in friends array
			for (int i=0; i<5; i++) {
				if (input.equals(friends[i])) {
					// saves corresponding phone number
					String phone = "" + numbers[i];
					// adds standard formatting for phone numbers
					phone = "(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6);
					// sets output as phone number
					output.setText(phone);
				}
			}
		}
	}
}
