package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.ADHERENT;
import model.LIVRE;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import controller.mainMVC;
import java.awt.Label;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class View_resa {

	private JFrame frame;
	private JTextField textField_numAd;
	private JTextField textField_ISBN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_resa window = new View_resa();
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
	public View_resa() {
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

		JLabel lblNewLabel = new JLabel("Num\u00E9ro Adh\u00E9rent");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 46, 154, 29);
		frame.getContentPane().add(lblNewLabel);

		textField_numAd = new JTextField();
		textField_numAd.setBounds(157, 53, 111, 20);
		frame.getContentPane().add(textField_numAd);
		textField_numAd.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ISBN LIVRE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(26, 151, 87, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textField_ISBN = new JTextField();
		textField_ISBN.setEnabled(false);
		textField_ISBN.setBounds(157, 148, 111, 20);
		frame.getContentPane().add(textField_ISBN);
		textField_ISBN.setColumns(10);

		JButton btnNewButton = new JButton("RESERVER");

		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(93, 229, 122, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_valid_ad = new JButton("Valider");

		btnNewButton_valid_ad.setBounds(283, 52, 89, 23);
		frame.getContentPane().add(btnNewButton_valid_ad);

		JLabel lbl_info_ad = new JLabel("Veuillez entrer le num\u00E9ro de l'adh\u00E9rent");
		lbl_info_ad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_info_ad.setForeground(Color.BLUE);
		lbl_info_ad.setBounds(70, 91, 317, 14);
		frame.getContentPane().add(lbl_info_ad);

		JButton btnNewButton_valid_ISBN = new JButton("Valider");

		btnNewButton_valid_ISBN.setEnabled(false);
		btnNewButton_valid_ISBN.setBounds(283, 147, 89, 23);
		frame.getContentPane().add(btnNewButton_valid_ISBN);

		JLabel lbl_info_livre = new JLabel("");
		lbl_info_livre.setBounds(93, 176, 279, 14);
		frame.getContentPane().add(lbl_info_livre);

		JLabel lbl_info_fin = new JLabel("");
		lbl_info_fin.setBounds(234, 229, 192, 19);
		frame.getContentPane().add(lbl_info_fin);
		
		JButton btnNewButton_1 = new JButton("FERMER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(337, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\alexander\\Desktop\\bibliotheque.jpg"));
		lblNewLabel_2.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_2);
		btnNewButton_valid_ad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADHERENT ad;
				ad=mainMVC.getM().findadherent(textField_numAd.getText());
				if(ad==null)
					lbl_info_ad.setText("Adh�rent non trouv�!");
				else
				{
					
					textField_numAd.setEnabled(false);
					lbl_info_ad.setText("Nom adh�rent : "+ad.getNom());
					textField_ISBN.setEnabled(true);
					btnNewButton_valid_ISBN.setEnabled(true);
					lbl_info_livre.setText("Veuillez entrer un num�ro d'ISBN � r�server");
				}
			}
		});

		btnNewButton_valid_ISBN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LIVRE l;
				l=mainMVC.getM().findlivre(textField_ISBN.getText());
				if(l==null)
				{
					lbl_info_livre.setText("Livre non trouv�");
				}
				else
				{
					if(l.getEmprunteur()==null)
					{
						lbl_info_livre.setText(l.getTitre());
						btnNewButton.setEnabled(true);
						lbl_info_livre.setEnabled(false);
					}
					else
					{
						lbl_info_livre.setText("Erreur Livre indisponible");
					}
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainMVC.getM().emprunter_livre(textField_numAd.getText(), textField_ISBN.getText());
					btnNewButton.setEnabled(false);
					lbl_info_fin.setText("Le livre a bien �t� emprunt�");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}
}
