package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {
	private static Database database;
	private DataSource dataSource;
	
	/**
	 * @param jndiname
	 * @throws SQLException
	 */
	public Database(String jndiname) throws SQLException {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/" + jndiname);
		} catch (NamingException e) {
			// Handle error that it's not configured in JNDI.
			throw new SQLException(jndiname + " is missing in JNDI! : " + e.getMessage());
		}
	}
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
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