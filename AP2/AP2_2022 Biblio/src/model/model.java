package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import view.View_restitution;

import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;



public class model {

	private Connection con;
	private ArrayList<LIVRE> ListLivre;
	private ArrayList<AUTEUR> ListAuteur;
	private ArrayList<ADHERENT> ListAdherent;
	

	public ArrayList<LIVRE> getListLivre() {
		return ListLivre;
	}

	public void getAll() throws SQLException {
		//on vide les listes pour les recharger
		ListAdherent.clear();
		ListAuteur.clear();
		ListLivre.clear();
		//ListHistorique.clear();


		ListLivre=new ArrayList<LIVRE> ();
		ListAuteur=new ArrayList<AUTEUR> ();
		ListAdherent=new ArrayList<ADHERENT> ();
		
		
		ResultSet résultats;
		String requete;
		Statement stmt = con.createStatement();

		//*********************************************
		//CREATION DES AUTEURS
		//*********************************************
		requete = "SELECT * FROM auteur";
		résultats = stmt.executeQuery(requete);
		while (résultats.next()) {
			AUTEUR a=new AUTEUR(résultats.getString(1), résultats.getString(2), résultats.getString(3), résultats.getString(4),résultats.getString(5));
			ListAuteur.add(a);
		}

		//*********************************************
		//CREATION DES LIVRES
		//*********************************************
		requete = "SELECT * FROM livre";
		résultats = stmt.executeQuery(requete);

		while (résultats.next()) {
			LIVRE l=new LIVRE(résultats.getString(1), résultats.getString(2), résultats.getInt(3));
			ListLivre.add(l);
		}


		//*********************************************
		//CREATION DES ADHERENTS
		//*********************************************
		requete = "SELECT * FROM adherent";
		résultats = stmt.executeQuery(requete);

		while (résultats.next()) {
			ADHERENT ad=new ADHERENT(résultats.getString(1), résultats.getString(2),  résultats.getString(3), résultats.getString(4));
			ListAdherent.add(ad);
		}


		//*********************************************
		//AJOUT liste de livre � ADHERENT
		//AJOUT de l'emprunteur � LIVRE
		//*********************************************
		requete = "SELECT ISBN,adherent FROM livre, adherent WHERE livre.adherent = adherent.num";
		résultats = stmt.executeQuery(requete);
		String ISBN,numadherent ;
		while (résultats.next()) {
			ISBN= résultats.getString(1);
			numadherent=résultats.getString(2);
			findlivre(ISBN).setEmprunteur(findadherent(numadherent));
			findadherent(numadherent).ajouterLivre(findlivre(ISBN));
		}



		//*********************************************
		//Ajout de l'auteur au LIVRE
		//*********************************************
		requete = "SELECT ISBN,auteur FROM livre, auteur WHERE livre.auteur = auteur.num";
		résultats = stmt.executeQuery(requete);
		String numauteur ;
		while (résultats.next()) {
			ISBN= résultats.getString(1);
			numauteur=résultats.getString(2);
			findlivre(ISBN).setAuteur(findauteur(numauteur));

		}


		/*

		System.out.println("nb Livre :"+ListLivre.size());
		System.out.println("nb Adherent :"+ListAdherent.size());
		System.out.println("nb Auteur :"+ListAuteur.size());
		 */
		System.out.println("chargement BDD OK");

	}
	public AUTEUR findauteur(String num)
	{
		for(int i=0;i<ListAuteur.size();i++)
		{
			if(ListLivre.get(i).getISBN().equals(num))
			{
				return ListAuteur.get(i);
			}
		}

		return null;
	}

	public LIVRE findlivre(String ISBN)
	{
		for(int i=0;i<ListLivre.size();i++)
		{
			if(ListLivre.get(i).getISBN().equals(ISBN))
			{
				return ListLivre.get(i);
			}
		}

		return null;
	}
	public ADHERENT findadherent(String num)
	{
		for(int i=0;i<ListAdherent.size();i++)
		{
			if(ListAdherent.get(i).getNum().equals(num))
			{
				return ListAdherent.get(i);
			}
		}

		return null;
	}

	public void setListLivre(ArrayList<LIVRE> listLivre) {
		ListLivre = listLivre;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public model() throws SQLException, ClassNotFoundException {
		ListLivre=new ArrayList<LIVRE> ();
		ListAuteur=new ArrayList<AUTEUR> ();
		ListAdherent=new ArrayList<ADHERENT> ();
		String BDD = "ap3";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";


		Class.forName("com.mysql.jdbc.Driver");

		Connection conn;

		conn = DriverManager.getConnection(url, user, passwd);
		this.con = conn;
		System.out.println("Connection OK");

	}

	public void emprunter_livre(String ad, String l) throws SQLException
	{		

		String requete;
		Statement stmt = con.createStatement();

		requete = "UPDATE livre set adherent="+ad+" WHERE ISBN="+l+";";
		stmt.executeUpdate(requete);

	}

	public void restituer_livre(String i) throws SQLException {
		String requete;
		Statement stmt = con.createStatement();

		requete = "UPDATE livre set adherent="+null+" WHERE ISBN="+i+";";
		stmt.executeUpdate(requete);
			
		}
	public void creationAdherent(String num,String prenom,String nom,String email) throws SQLException,ClassNotFoundException{
		String requete2= "INSERT INTO ADHERENT VALUES('"+num+"','"+nom+"', '"+prenom+"','"+email+"')";
		Class.forName("com.mysql.jdbc.Driver");
		String BDD = "ap3";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";
		Connection conn= DriverManager.getConnection(url, user, passwd);
		Statement stmt2 = conn.createStatement();
		stmt2.executeUpdate(requete2);
	
	
	}
	public void lstadherent(String ad, String l) throws SQLException
	{		

		String requete;
		Statement stmt = con.createStatement();

		requete = "select count nom";
		stmt.executeUpdate(requete);
		}

	//* Je parcours ma liste
	
	public ADHERENT findadherent2(String num)
	{
		for(int i=0;i<ListAdherent.size();i++)
		{
			if(ListAdherent.get(i).getNum().equals(num))
			{
				return ListAdherent.get(i);
			}
		}

		return null;
	}
	

	 
	

	}



