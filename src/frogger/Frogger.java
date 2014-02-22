package frogger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Timer;

public class Frogger extends JFrame {
	/**
  * 
  */
	private static final long serialVersionUID = 1L;
	Cast cast = new Cast();
	View view = new View(cast);
	int currentSpeedOfGame = 1;
	int widthOfGame = 700;
	int heightOfGame = 225;
	Frog frog = new Frog(view);
	String keyPressed;
	Timer timer;
	boolean isPaused = false;
	private JPanel text;
	private JTextField display; 
	Strobe strobe = new Strobe(view, cast, frog, this);

	public Frogger() {

	}

	public static void main(String[] args) {
		new Frogger().run();
	}

	private void run() {
		this.setResizable(false);
		add(view);
//here im trying to add the counter at the top
		text = new JPanel();
		this.add(text, BorderLayout.NORTH);
		text.setLayout(new GridLayout(1,1));
		display = new JTextField(30);
		display.setPreferredSize(new Dimension(100, 50));
		display.setHorizontalAlignment(JTextField.LEFT);
		display.setFont(new Font("Courier", Font.PLAIN,20));
		display.setVisible(true);
		display.setEditable(false);
		display.setBackground(Color.white);
		text.add(display);
		display.setText("Hello and Welcome to Frogger! The current score is 0");
		//here is where we set focusable true so that nothing freezes
		
		this.setFocusable(true);
		
		pack();
		setSize(widthOfGame, heightOfGame);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		cast.addSprite(frog);
		timer = new Timer(true);
		timer.schedule(strobe, 0, 40); // 25 times a second

		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					keyPressed = "u";
					frog.setKeyPressed(keyPressed);
					frog.update();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					keyPressed = "d";
					frog.setKeyPressed(keyPressed);
					frog.update();
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					keyPressed = "l";
					frog.setKeyPressed(keyPressed);
					frog.update();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					keyPressed = "r";
					frog.setKeyPressed(keyPressed);
					frog.update();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				return;
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				return;
			}
		});
	}

	public String getKeyPressed() {
		return keyPressed;
	}
	
	public void notifyDisplay(int numOfWins) {
		if (numOfWins == 0) {
			display.setText("WELCOME TO FROGGER! Number of wins currently is 0");
			return;
		}
		display.setText("Number of Wins: " + numOfWins);
	}

}