package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.json.JSONObject;

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
		// TODO Auto-generated method stub
		return false;
	}

	public static int getIdUser(String log) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static boolean userConnect(int id_user) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param key
	 */
	public static void removeConnection(String key) {
		// TODO Auto-generated method stub
		
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
	 */
	public static JSONObject Login(String log, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}

	



}
