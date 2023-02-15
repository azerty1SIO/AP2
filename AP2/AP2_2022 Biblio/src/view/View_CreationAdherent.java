package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import controller.mainMVC;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



public class View_CreationAdherent {

	private JFrame frame;
  
	private JTextField txtNumroDadhrent;
	private JTextField txtNom;
	private JTextField txtPrnom;
	private JTextField txtEmail;
	private JLabel lblNewLabel_1;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_CreationAdherent window = new View_CreationAdherent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View_CreationAdherent() {
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
	

			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("INSCRIPTION");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\alexander\\Downloads\\button (4).png"));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(161, 11, 172, 33);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(10, 115, 46, 14);
			frame.getContentPane().add(lblNewLabel_2);
			
			txtNumroDadhrent = new JTextField();
			txtNumroDadhrent.setText("Numéro d'adhérent");
			txtNumroDadhrent.setBounds(103, 55, 110, 34);
			frame.getContentPane().add(txtNumroDadhrent);
			txtNumroDadhrent.setColumns(10);
			
			txtNom = new JTextField();
			txtNom.setText("Nom");
			txtNom.setBounds(20, 100, 86, 29);
			frame.getContentPane().add(txtNom);
			txtNom.setColumns(10);
			
			txtPrnom = new JTextField();
			txtPrnom.setText("Prénom");
			txtPrnom.setBounds(20, 140, 86, 29);
			frame.getContentPane().add(txtPrnom);
			txtPrnom.setColumns(10);
			
			JButton btnNewButton = new JButton("VALIDER");
	
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\alexander\\Downloads\\button (3).png"));
			btnNewButton.setBounds(164, 204, 133, 33);
			frame.getContentPane().add(btnNewButton);
			
			txtEmail = new JTextField();
			txtEmail.setText("Email");
			txtEmail.setBounds(22, 180, 86, 33);
			frame.getContentPane().add(txtEmail);
			txtEmail.setColumns(10);
			
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\alexander\\Desktop\\bibliotheque.jpg"));
			lblNewLabel_1.setBounds(0, 0, 434, 261);
			frame.getContentPane().add(lblNewLabel_1);
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						mainMVC.getM().creationAdherent(txtNumroDadhrent.getText(), txtNom.getText(),txtPrnom.getText() , txtEmail.getText());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
		}
	



}
