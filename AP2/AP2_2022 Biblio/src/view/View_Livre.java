package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import controller.mainMVC;
import model.model;

import java.awt.List;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Livre {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Livre window = new View_Livre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public View_Livre() throws SQLException {
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
		
		List list = new List();
		list.setBounds(48, 63, 298, 125);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("FERMER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(299, 21, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		System.out.println(mainMVC.getM().getListLivre().size());
	
		for (int i=0;i!=mainMVC.getM().getListLivre().size();i++)
		{
			
			list.add(mainMVC.getM().getListLivre().get(i).Ligne());
		
		}
		
			
	}
}
