package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {
	private static Database database=null;
	private DataSource dataSource;
	
	/**
	 * Constructeur d'une base de donn�es.
	 * @param name Le nom du driver pour �tablir la connexion.
	 * @throws SQLException.
	 */
	public Database(String name) throws SQLException {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/" + name);
		} catch (NamingException e) {
			// Handle error that it's not configured in JNDI.
			throw new SQLException(name + " is missing in JNDI! : " + e.getMessage());
		}
	}
	
	/**
	 * �tablir une connexion.
	 * @return La connexion �tablie.
	 * @throws SQLException.
	 */
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	/**
	 * �tablis une connexion vers notre base de donn�es MySQL.
	 * @return La connexion MySQL �tablie.
	 * @throws SQLException.
	 */
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
}