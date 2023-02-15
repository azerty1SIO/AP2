package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import controller.mainMVC;
import model.LIVRE;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class View_restitution {

	private JFrame frame;
	private JTextField textField_ISBN;
	private JLabel ISBN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_restitution window = new View_restitution();
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
	public View_restitution() {
		try {
			mainMVC.getM().getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		textField_ISBN = new JTextField();
		textField_ISBN.setBounds(160, 112, 86, 20);
		frame.getContentPane().add(textField_ISBN);
		textField_ISBN.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISBN :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(87, 112, 100, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");

		btnNewButton.setBounds(157, 155, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lbl_info_livre = new JLabel("lbl_info_livre");
		lbl_info_livre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_info_livre.setForeground(Color.BLUE);
		lbl_info_livre.setBounds(28, 189, 173, 43);
		frame.getContentPane().add(lbl_info_livre);
		
		JButton btnNewButton_1 = new JButton("RESTITUER UN LIVRE");
		btnNewButton_1.setBounds(140, 21, 149, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = 
				new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\alexander\\Desktop\\bibliotheque.jpg"));
		lblNewLabel_2.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LIVRE i;
				i=mainMVC.getM().findlivre(textField_ISBN.getText());
				if(i==null)
				{
				 lbl_info_livre.setText("ISBN non trouv�");
				}
				else
				{
					if(i.getEmprunteur()!=null)
					{
						try {
							mainMVC.getM().restituer_livre(i.getISBN());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lbl_info_livre.setText(i.getTitre());
						btnNewButton.setEnabled(false);
					}
				}
			}
		}
				
			
		);
	}
		
	
			


	}

