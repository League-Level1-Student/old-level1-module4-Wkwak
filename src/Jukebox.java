/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
	
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	
	JFrame frame = new JFrame("Jukebox");

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());
		
	}
		
           public void run() {

		// 3. Find an mp3 on your computer or on the Internet.
		// 4. Create a Song
        	   // Song song = new Song("Piotr Ilich Tchaikovsky - 1812 Overture (Finale).mp3");
        	   // Song song2 = new Song("TWO DOOR CINEMA CLUB WHAT YOU KNOW.mp3");

		// 5. Play the Song
        	   //song.play();

		/*
		 * 6. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
        	   	frame.setVisible(true);
       		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	
       		JPanel panel = new JPanel();
       		JButton button = new JButton();
       		JButton button2 = new JButton();
       		
       		button2.addActionListener(this);
       		button.addActionListener(this);
       		
       		button2.setText("Cinema Club");
       		button.setText("1812 Overture");
       		
       		label1 = loadImage("CinemaClub.png");
       		label2 = loadImage("TchaikovskyCover.jpg");
       		
       	
       		panel.add(label1);
       		panel.add(label2);
       		panel.add(button);
       		panel.add(button2);
       		
       		frame.add(panel);
       		frame.pack();
        	   
          }
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("1812 Overture")){
			 Song song = new Song("Piotr Ilich Tchaikovsky - 1812 Overture (Finale).mp3");
			 song.stop();
			 song.play();
		}
		if(e.getActionCommand().equals("Cinema Club")) {
			Song song2 = new Song("TWO DOOR CINEMA CLUB WHAT YOU KNOW.mp3");
			song2.stop();
			song2.play();
		}
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

