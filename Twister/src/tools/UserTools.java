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


	public static boolean userExist(String log, Connection co) throws SQLException {
		Statement st = null;
		ResultSet res = null;

		st = co.createStatement();
		String query = "SELECT user_login from users where user_login = '"+log+"'";
		res = st.executeQuery(query);

		if (res.next()) {
			return true;
		}
		res.close();
		st.close();

		return false;

	}

	
	
	public static boolean mailExist(String mail, Connection co) throws SQLException {
		Statement st = null;
		ResultSet res = null;

		st = co.createStatement();
		String query = "SELECT * from users where user_mail = '"+ mail + "'";
		res = st.executeQuery(query);
		if (res.next()) {
			return true;
		}
		res.close();
		st.close();



		return false;
	}

	public static JSONObject insertUser(String login, String nom, String prenom, String mail, String mdp, Connection co) throws  SQLException, JSONException {
		Statement st = null;

		st = co.createStatement();
		String query = "INSERT INTO users (`user_id`, `user_login`, `user_nom`, `user_prenom`, `user_mail`, `user_password`) VALUES(null,'" + login + "','" + nom + "','" + prenom + "','" + mail + "','" + mdp + "')";
		st.executeUpdate(query);

		st.close();
		co.close();

		System.out.println("insert user");
		return ServiceTools.serviceAccepted().put(login+" has been successfully", 1);

	}

	public static boolean checkPassword(String log, String mdp, Connection co) throws SQLException {
		Statement st = null;
		ResultSet res = null;

		st = co.createStatement();
		String query = "SELECT * from users where user_login = '" + log + "' and user_password= '"+mdp+"'";
		res = st.executeQuery(query);
		if (res.next()) {
			return true;
		}

		res.close();
		st.close();

		return false;

	}

	public static int getIdUser(String log, Connection co) throws SQLException {
		Statement st = null;
		ResultSet res = null;
		int id_user = 0;
		st = co.createStatement();
		String query = "SELECT user_id FROM users WHERE user_login= \""+log+"\";";
		//System.out.println("ici passe par la requete");
		res = st.executeQuery(query);
		//System.out.println(res.getInt("user_id"));
		if (res.next()) {
			System.out.println("il existe bien un resultat");
			id_user = res.getInt("user_id");
		}


		res.close();
		st.close();



		return id_user;
	}

	public static boolean userConnected(int id_user, Connection co) throws SQLException {
		Statement st = null;
		ResultSet res = null;
		st = co.createStatement();
		String query = "SELECT * FROM sessions WHERE user_id = '"+id_user+"'";
		res = st.executeQuery(query);

		if (res.next()) {
			return true;
		}


		res.close();
		st.close();


		return false;
	}

	/**
	 * @param key
	 * @throws JSONException 
	 */
	public static JSONObject removeConnection(int user_id, Connection co) throws JSONException, SQLException {
		// TODO Auto-generated method stub
		Statement st = null;
		//int res = null;
		st = co.createStatement();
		String query = "DELETE FROM sessions WHERE user_id = '"+user_id+"'";
		st.executeUpdate(query);

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
	 * @param co 
	 * @return
	 * @throws JSONException 
	 * @throws SQLException 
	 */
	public static JSONObject insertConnexion(String log, String mdp, Connection co) throws JSONException, SQLException {
		Statement st = null;
		String key = generatekey();


		st = co.createStatement();
		String query = "INSERT INTO sessions (`user_id`, `session_key`) VALUES('" + getIdUser(log, co) + "','" + key + "')";
		st.executeUpdate(query);


		st.close();


		return ServiceTools.serviceAccepted().put(log+" signed in", 001);
	}

	public static String getLogin(int id) {
		Connection co = null;
		Statement st = null;
		ResultSet res = null;
		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "SELECT user_login FROM users WHERE user_id = "+id+";";
			res = st.executeQuery(query);
			if (res.next()) {
				return res.getString(1);
			}
			return null;
		}catch (Exception e)
		{
			System.err.println("Error getLogin : " + e.getMessage());
			return null;
		}finally
		{
			try
			{
				res.close();
				st.close();
				if ((!DBStatic.is_pooling) && (co != null))
					co.close();
			}
			catch(SQLException e)
			{
				System.err.println("Error closing connexion : " + e.getMessage());
			}
		}
	}

	public static JSONArray searchUserByLogin(String login)
	{
		//TO DO
		return new JSONArray();
	}



	/**
	 * @param key
	 * @return
	 */
	public static int getIdFromKey(String key,Connection co) throws SQLException {
		Statement st = null;
		ResultSet res = null;
		int id_user = 0;
		
			st = co.createStatement();
			String query = "SELECT user_id FROM sessions WHERE session_key= \""+key+"\";";
			res = st.executeQuery(query);

			if (res.next()) {
				System.out.println("il existe bien un resultat");
				id_user = res.getInt("user_id");
			}
			res.close();
			st.close();
			return id_user;
	}
	
}
	





