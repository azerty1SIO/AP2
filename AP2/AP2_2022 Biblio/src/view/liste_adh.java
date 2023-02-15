package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.desktop.SystemEventListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import controller.mainMVC;

public class liste_adh {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					liste_adh window = new liste_adh();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public liste_adh() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(127, 68, 147, 91);
		frame.getContentPane().add(list);
		
		JLabel listeadh = new JLabel("LISTE ADHERENT");
		listeadh.setBounds(150, 11, 118, 14);
		frame.getContentPane().add(listeadh);
		
	
	
	}}
	
	 
	    
	  

