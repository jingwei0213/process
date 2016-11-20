/*
 * Price calculator for photo session (JFrame):
 * Price is based on the number of subjects and session location
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPhotoFrame extends JFrame implements ItemListener {

	// initializes prices
	final int BASE = 40;
	final int TWO = 75;
	final int PET = 95;
	final int LOCATION = 90;
	int subjectPrice;
	int locationPrice;
	
	// labels
	JLabel description = new JLabel("Photo Session Price Calculator");
	JLabel subject = new JLabel("Choose portrait subject:");
	JLabel sessionLocation = new JLabel("Choose session location:");
	
	// set of mutually exclusive checkboxes for portrait subject
	ButtonGroup subjectChoice = new ButtonGroup();
	JCheckBox basePrice = new JCheckBox("1 person: $" + BASE,	false);
	JCheckBox twoSubjects = new JCheckBox("2 or more subjects: $" + TWO, false);
	JCheckBox petPrice = new JCheckBox("Pet: $" + PET, false);
	
	// set of mutually exclusive checkboxes for session location
	ButtonGroup locationChoice = new ButtonGroup();
	JCheckBox inStudio = new JCheckBox("Studio: Free", false);
	JCheckBox onLocation = new JCheckBox("On location: $" + LOCATION, false);
	
	// lists the total price
	JLabel priceLabel = new JLabel("Total Price:");
	JLabel totalPrice = new JLabel();
	
	// constructor
	public JPhotoFrame() {
		super("Photo Session Price Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// adds labels
		add(description);
		
		// portrait subject criteria
		add(subject);
		add(basePrice);
		add(twoSubjects);
		add(petPrice);
		
		// session location criteria
		add(sessionLocation);
		add(inStudio);
		add(onLocation);
		
		// price information
		add(priceLabel);
		add(totalPrice);
		
		// allow program to know if user has checked checkbox
		basePrice.addItemListener(this);
		twoSubjects.addItemListener(this);
		petPrice.addItemListener(this);
		onLocation.addItemListener(this);
		
		// makes portrait subject choices mutually exclusive
		subjectChoice.add(basePrice);
		subjectChoice.add(twoSubjects);
		subjectChoice.add(petPrice);
		
		// makes location choices mutually exclusive
		locationChoice.add(inStudio);
		locationChoice.add(onLocation);
	}
	
	public void itemStateChanged(ItemEvent a) {
		// tracks changes
		Object choice = a.getSource();
		int chosen = a.getStateChange();
		
		// if base price option is chosen
		if(choice == basePrice) {
			if(chosen == ItemEvent.SELECTED) {
				subjectPrice = BASE;
			} else {
				subjectPrice -= BASE;
			} 
		} 
		
		// if 2 or more subjects
		else if(choice == twoSubjects) {
			if(chosen == ItemEvent.SELECTED) {
				subjectPrice = TWO;
			} else {
				subjectPrice -= TWO;
			} 
		} 
		
		// if pet is added
		else if (choice == petPrice) {
			if(chosen == ItemEvent.SELECTED) {
				subjectPrice = PET;
			} else {
				subjectPrice -= PET;
			} 
		} 
		
		// on location photos
		else if (choice == onLocation) {
			if(chosen == ItemEvent.SELECTED) {
				locationPrice = LOCATION;
			} else {
				locationPrice -= LOCATION;
			} 
		} 
		
		int combinedPrice = subjectPrice + locationPrice; // combines price for subject and location
		totalPrice.setText("$" + combinedPrice); // gives total price
	}
	
	public static void main(String[] args) {
		JPhotoFrame calc = new JPhotoFrame(); // creates object
		calc.setSize(200, 300); // sets size
		calc.setVisible(true); // sets visible
	}

	

}
