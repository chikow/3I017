package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBStatic;
import db.Database;

/**
 * @author LAOUER Walid
 *
 */
public class UserTools {
	
	
	public static boolean userExist(String log) {
		Connection co = null;
		Statement st = null;
		ResultSet res = null;
		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "SELECT user_login from users where user_login = '"+log+"'";
			res = st.executeQuery(query);
			
			if (res.next()) {
				return true;
			}
			
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			try {
				res.close();
				st.close();
				co.close();
			} catch (SQLException ignore) {}
		}
		return false;
	}

	public static boolean mailExist(String mail) {
		Connection co = null;
		Statement st = null;
		ResultSet res = null;
		
		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "SELECT * from users where user_mail = '"+ mail + "'";
			res = st.executeQuery(query);
			if (res.next()) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			try {
				res.close();
				st.close();
				co.close();
			} catch (SQLException ignore) {}
		}
		return false;
	}

	public static JSONObject insertUser(String login, String nom, String prenom, String mail, String mdp) {
		Connection co = null;
		Statement st = null;

		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "INSERT INTO users (`user_id`, `user_login`, `user_nom`, `user_prenom`, `user_mail`, `user_password`) VALUES(null,'" + login + "','" + nom + "','" + prenom + "','" + mail + "','" + mdp + "')";
			st.executeUpdate(query);

		} catch (SQLException s) {
			s.printStackTrace();
			return ServiceTools.serviceRefused("SQLException:", 1000);
		} finally {
			try {
				st.close();
				co.close();
			} catch (SQLException s) {}
		}
		return ServiceTools.serviceAccepted();
		
	}

	public static boolean checkPassword(String log, String mdp) {
		Connection co = null;
		Statement st = null;
		ResultSet res = null;
		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "SELECT * from users where user_login = '" + log + "' and user_password= '"+mdp+"'";
			res = st.executeQuery(query);
			if (res.next()) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			try {
				res.close();
				st.close();
				co.close();
			} catch (SQLException ignore) {}
		}
		return false;

	}

	public static int getIdUser(String log) {
		Connection co = null;
		Statement st = null;
		ResultSet res = null;
		int id_user = 0;
		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "SELECT user_id FROM users WHERE user_login= \""+log+"\";";
			//System.out.println("ici passe par la requete");
			res = st.executeQuery(query);
			//System.out.println(res.getInt("user_id"));
			if (res.next()) {
				System.out.println("il existe bien un resultat");
				id_user = res.getInt("user_id");
			}
		} catch (Exception e) 
		{
			System.err.println("Error userExists : " + e.getMessage());
			return id_user;
		
		} finally {
			try {
				res.close();
				st.close();
				if ((!DBStatic.is_pooling) && (co != null))
					co.close();
			} catch (SQLException e)
			{
				System.err.println("Error closing connexion : " + e.getMessage());
			}
		}
		return id_user;
	}

	public static boolean userConnected(int id_user) {
		Connection co = null;
		Statement st = null;
		ResultSet res = null;
		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "SELECT * FROM connection WHERE user_id = '"+id_user+"'";
			res = st.executeQuery(query);
			
			if (res.next()) {
				return true;
			}
			
		} catch (Exception e) 
		{
			System.err.println("Error userConnected : " + e.getMessage());
			return false;
		} finally {
			try {
				res.close();
				st.close();
				if ((!DBStatic.is_pooling) && (co != null))
					co.close();
			} catch (SQLException e)
			{
				System.err.println("Error closing connexion : " + e.getMessage());
			}
		}
		return false;
	}

	/**
	 * @param key
	 * @throws JSONException 
	 */
	public static JSONObject removeConnection(int user_id) throws JSONException {
		// TODO Auto-generated method stub
		Connection co = null;
		Statement st = null;
		//int res = null;
		try {
			co = Database.getMySQLConnection(); //user_login= \""+log+"\";"
			st = co.createStatement();
			String query = "DELETE FROM connection WHERE user_id = '"+user_id+"'";
			st.executeUpdate(query);
		}catch (Exception e) 
		{
			System.err.println("Error removeConnection " + e.getMessage());
			return ServiceTools.serviceRefused("Error", 7);
		} finally {
			try {
				st.close();
				if ((!DBStatic.is_pooling) && (co != null))
					co.close();
			} catch (SQLException e)
			{
				System.err.println("Error closing connexion : " + e.getMessage());
			}
		}
		return ServiceTools.serviceAccepted().put("User Disconnected", 001);
		
	}
	private static String generatekey() {
		String chars = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
		String key = "";
		for (int i=0; i<32; i++) {
			int r = new Random().nextInt(chars.length());
			key += chars.charAt(r);
		}
		return key;
	}

	/**
	 * @param log
	 * @param mdp
	 * @return
	 * @throws JSONException 
	 */
	public static JSONObject insertConnexion(String log, String mdp) throws JSONException {
		Connection co = null;
		Statement st = null;
		String key = generatekey();

		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "INSERT INTO connection (`user_id`, `key`) VALUES('" + getIdUser(log) + "','" + key + "')";
			st.executeUpdate(query);

		} catch (SQLException s) {
			s.printStackTrace();
			return ServiceTools.serviceRefused("SQLException:", 1000);
		} finally {
			try {
				st.close();
				co.close();
			} catch (SQLException s) {}
		}
		return ServiceTools.serviceAccepted().put(log+" signed in", 001);
	}
	
	
	public static JSONArray searchUserByLogin(String login)
	{
		//TO DO
		return new JSONArray();
	}

	



}
