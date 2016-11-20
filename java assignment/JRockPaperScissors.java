/*
 * Java Applet
 * 
 * Rock, paper, scissors game against the computer (the computer chooses randomly)
 * Records 
 * - your choice and the computer's choice
 * - your and the computer's score
 * - the number of wins, ties, and losses
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRockPaperScissors extends JApplet implements ActionListener {
	// label and font for game name
	Font large = new Font("Arial", Font.BOLD, 30);
	JLabel rockPaper = new JLabel("Rock, Paper, Scissors");
	
	// label and font for instructions
	Font medium = new Font("Arial", Font.BOLD, 15);
	JLabel oneButton = new JLabel("Choose one button");
	JLabel results = new JLabel("------Results------");
	
	// panels for holding result information
	JPanel panel1 = new JPanel();
	JPanel panel1a = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel1b = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel1c = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel1d = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel1e = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	// buttons
	JButton rock = new JButton("Rock");
	JButton paper = new JButton("Paper");
	JButton scissors = new JButton("Scissors");
	
	// for results
	JLabel yourPick = new JLabel();
	JLabel dashes = new JLabel();
	JLabel compPick = new JLabel();
	JLabel winner = new JLabel();
	JLabel you = new JLabel();
	JLabel computer = new JLabel();
	JLabel ties = new JLabel();
	
	// # games player has won, tied, or lost
	JLabel won = new JLabel();
	JLabel tied = new JLabel();
	JLabel lost = new JLabel();
	
	// stores scores, ties, and wins
	int yourScore;
	int compScore;
	int tieCount;
	int win;
	
	public void init() {
		setSize(450, 295);
		setLayout(new FlowLayout());
		// game name
		add(rockPaper); rockPaper.setFont(large);
		// instructions
		add(oneButton); oneButton.setFont(medium); 
		
		// buttons and action listeners
		add(rock); add(paper); add(scissors);
		rock.addActionListener(this);
		paper.addActionListener(this);
		scissors.addActionListener(this);
		
		// panel and labels for results
		add(panel1);
		panel1.setLayout(new GridLayout(5,1));
		panel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel1.add(panel1a); panel1.add(panel1b); panel1.add(panel1c); panel1.add(panel1d); panel1.add(panel1e);
		panel1a.add(results); results.setFont(medium); results.setVisible(false);		
		panel1b.add(yourPick); panel1b.add(dashes); panel1b.add(compPick);
		panel1c.add(winner);
		panel1d.add(you); panel1d.add(computer); panel1d.add(ties);
		panel1e.add(won); panel1e.add(tied); panel1e.add(lost);  
	}
	
	public void actionPerformed(ActionEvent arg0) {		
		results.setVisible(true);
		// generates random number from 0-2 for computer's choice
		int computerChoice = (int) (Math.random() * 3);
		// stores possible choices for computer
		String[] picks = {"rock", "paper", "scissors"};
		// outputs what computer picked
		compPick.setText("Computer picked " + picks[computerChoice]);
		
		Object choice = arg0.getSource();
		// if user chose rock
		if (choice == rock) {
			yourPick.setText("You picked rock");
			// computer chose rock
			if (picks[computerChoice].equals("rock")) {
				tieCount++; win = 0;
			} 
			// computer chose paper
			else if (picks[computerChoice].equals("paper")) {
				compScore++; win = -1;
			} 
			// computer chose scissors
			else if (picks[computerChoice].equals("scissors")) {
				yourScore++; win = 1;
			} 
		} 
		// if user chose paper
		else if (choice == paper) {
			yourPick.setText("You picked paper");
			// computer chose rock			
			if (picks[computerChoice].equals("rock")) {
				yourScore++; win = 1;
			} 
			// computer chose paper
			else if (picks[computerChoice].equals("paper")) {
				tieCount++; win = 0;
			} 
			// computer chose scissors
			else if (picks[computerChoice].equals("scissors")) {
				compScore++; win = -1;
			} 
		} 
		// if user chose scissors
		else if (choice == scissors) {
			yourPick.setText("You picked scissors");
			// computer chose rock			
			if (picks[computerChoice].equals("rock")) {
				compScore++; win = -1;
			} 
			// computer chose paper
			else if (picks[computerChoice].equals("paper")) {
				yourScore++; win = 1;
			} 
			// computer chose scissors
			else if (picks[computerChoice].equals("scissors")) {
				tieCount++; win = 0;
			} 
		}
		dashes.setText("------");
		
		String winString = "Winner: ";
		// based on matchup, determines winner
		if (win == -1) {
			winner.setText(winString + "computer");
		} else if (win == 0) {
			winner.setText(winString + "none");
		} else if (win == 1) {
			winner.setText(winString + "you");
		}
		
		// outputs scores for user, computer, and ties
		you.setText("You: " + yourScore);		
		computer.setText("Computer: " + compScore);
		ties.setText("Ties: " + tieCount);	
		
		// tally that shows # games player has won, tied or lost
		won.setText("Games you have won: " + yourScore);
		tied.setText("tied: " + tieCount);	
		lost.setText("lost: " + compScore);		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}
	
}
