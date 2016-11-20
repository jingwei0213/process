/*
 * JFrame: displays information on a resort based on what menu options are chosen
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SummervaleResort extends JFrame implements ActionListener {

	int i; // incrementer
	
	// JMenuBar and starting information
	private JMenuBar heading = new JMenuBar();
	private JLabel start = new JLabel("View information about different rooms, dining options, and activities using the menu.");
	
	// menu for different rooms available, options and descriptions of those options
	private JMenu roomsAvailable = new JMenu("Rooms Available");
	private JMenuItem room = new JMenuItem("Standard Room");
	private JLabel roomDescription = new JLabel("Rooms contain 2 queen beds and a great view.");
	private JMenuItem suite = new JMenuItem("Hotel Suite");
	private JLabel suiteDescription = new JLabel("Luxury suites contain 2 bedrooms and a living room.");
	
	// menu for different dining options and descriptions of those options
	private JMenu dining = new JMenu("Dining options");
	private JMenuItem restaurant = new JMenuItem("Restaurant");
	private JLabel restaurantDescription = new JLabel("Our restaurant is located in the lobby. It serves delicacies from all over the world.");
	private JMenuItem buffet = new JMenuItem("Buffet");
	private JLabel buffetDescription = new JLabel("Our buffet is open 7 days a week, during breakfast, lunch, and dinner hours.");
	
	// menu for different activities, options and descriptions of those options
	private JMenu activities = new JMenu("Activities offered");
	private JMenuItem swimming = new JMenuItem("Swimming");
	private JLabel swimmingDescription = new JLabel("Our pool is open from 8am-10pm, and offers a jacuzzi and sauna.");
	private JMenuItem gym = new JMenuItem("Gym");
	private JLabel gymDescription = new JLabel("Our gym is packed with weightlifting equipment and treadmills.");
	
	// for easy access and search later on
	// array of all JMenus
	private JMenu topRow [] = {roomsAvailable, dining, activities};
	// array of all JMenuItems
	private JMenuItem menuItems [] = {room, suite, restaurant, buffet, swimming, gym};
	// array of JLabel information for JMenuItems
	private JLabel menuDescription [] = {roomDescription, suiteDescription, restaurantDescription, buffetDescription, swimmingDescription, gymDescription};
	
	// JPanel to display information
	private JPanel display = new JPanel();
	
	public SummervaleResort() {
		setTitle("Summervale Resort"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		setJMenuBar(heading); // sets top JMenuBar
		
		// menu and menu options for different rooms available
		heading.add(roomsAvailable);
		roomsAvailable.add(room); roomsAvailable.add(suite);
		
		// menu and menu options for dining
		heading.add(dining);
		dining.add(restaurant); dining.add(buffet);
		
		// menu and menu options for activities
		heading.add(activities);
		activities.add(swimming); activities.add(gym);
		
		// adds action listeners to menus
		for(i=0; i < topRow.length; i++) {
			topRow[i].addActionListener(this);
		} 
		
		// adds action listeners to all menu items
		for(i=0; i < menuItems.length; i++) {
			menuItems[i].addActionListener(this);
		}
		
		add(display); // displays JPanel
		display.add(start);	// adds starting JLabel to JPanel
	}
	
	// when option is chosen
	public void actionPerformed(ActionEvent e) {
		Object choice = e.getSource();
		
		// loops through all menu items to find match with choice
		for (i = 0; i < menuItems.length; i++) {		
			// if match is found
			if (choice == menuItems[i]) {
				// gets text from the description for that menu item
				String text = menuDescription[i].getText();
				// sets text from that menu item description to starting JLabel
				start.setText(text);
			} 			
		}
	}

	public static void main(String[] args) {
		// creates object, sets size and visibility
		SummervaleResort window = new SummervaleResort();
		window.setSize(550, 150);
		window.setVisible(true);
	}

}
