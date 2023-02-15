package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class View_Accueil extends JFrame{
 
 public static void main(String[] args) {
 
 JFrame frame = new JFrame("JFrame test");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setLocationRelativeTo(null);
 
 frame.setPreferredSize(new Dimension(400, 300));
 frame.getContentPane().setBackground(Color.ORANGE);
 frame.pack();
 frame.setVisible(true);
 }




	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Accueil window = new View_Accueil();
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
	 */
	public View_Accueil() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().setForeground(new Color(69, 89, 186));
		frame.setBounds(100, 100, 609, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_Livre = new JButton("Liste des Livres");
		btn_Livre.setIcon(new ImageIcon("C:\\Users\\alexander\\Downloads\\button (2).png"));
		btn_Livre.setForeground(Color.BLACK);
		btn_Livre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				View_Livre vl;
				try {
					vl = new View_Livre();
					//vl.main(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btn_Livre.setBounds(209, 65, 222, 36);
		frame.getContentPane().add(btn_Livre);
		
		JButton btn_resa = new JButton("R\u00E9server un livre");
		btn_resa.setIcon(new ImageIcon("C:\\Users\\alexander\\Downloads\\button (12).png"));
		btn_resa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				View_resa vr = new View_resa();
		
			}
		});
		btn_resa.setBounds(300, 142, 283, 40);
		frame.getContentPane().add(btn_resa);
		
		JButton btnCrationAdhrent = new JButton("");
		btnCrationAdhrent.setIcon(new ImageIcon("C:\\Users\\alexander\\Downloads\\button.png"));
		btnCrationAdhrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_CreationAdherent vca= new View_CreationAdherent();
			}
		});
		btnCrationAdhrent.setBounds(210, 293, 204, 53);
		frame.getContentPane().add(btnCrationAdhrent);
		
		JButton btnNewButton = new JButton("RESTITUER UN LIVRE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_restitution vca= new View_restitution();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\alexander\\Downloads\\button (9).png"));
		btnNewButton.setBounds(10, 142, 259, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LISTE ADHERENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				liste_adh v2;
				try {
					v2 = new liste_adh();
					//vl.main(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_1.setBounds(209, 222, 154, 40);
		frame.getContentPane().add(btnNewButton_1);
	}
}
