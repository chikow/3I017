package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import db.Database;

import db.DBStatic;


public class testDB {
	private static Database database;


public static Connection getMySQLConnection() throws SQLException {
	if(!DBStatic.is_pooling){
		return(DriverManager.getConnection("jdbc:mysql://" + DBStatic.mysql_host + "/" + DBStatic.mysql_db, DBStatic.mysql_username, DBStatic.mysql_password));
	} else {
		if(database==null){
			database = new Database("jdbc/db");
		}
		return(database.getConnection());
	}
}



public static void main(String[] args) {
	try {
		Connection c = testDB.getMySQLConnection();
		Statement st = c.createStatement();
		
		if(c.isValid(1000))
			System.out.println("Connexion réussi !");
		
		String query = "INSERT INTO `User` (`id`, `login`, `nom`, `prenom`, `mdp`, `mail`) VALUES ('3', '3', '3', '3', '3', '3');";
		
		st.executeUpdate(query);
		st.close();
		c.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}