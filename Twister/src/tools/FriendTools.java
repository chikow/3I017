/**
 * 
 */
package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

import db.DBStatic;
import db.Database;

/**
 * @author LAOUER Walid
 *
 */
public class FriendTools {

	/**
	 * Verifie si id_friend est deja ami avec id_user
	 * @param id_user
	 * @param id_friend
	 * @return
	 */
	public static boolean alreadyFriend(int id_user, int id_friend) {
		Connection co = null;
		Statement st = null;
		ResultSet res = null;
		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "SELECT * FROM follow WHERE user_id1= \""+id_user+"\"AND user_id2 = \""+id_friend+"\";";
			//System.out.println("ici passe par la requete");
			res = st.executeQuery(query);
			if (res.next()) {
				return true;
			}
			return false;
		}catch (Exception e)
		{
			System.err.println("Error alreadyFriend : " + e.getMessage());
			return false;
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

	/**
	 * @param key
	 * @param id_friend
	 * @return
	 * @throws JSONException 
	 */
	public static JSONObject insertFriend(int id_user, int id_friend) throws JSONException {
		Connection co = null;
		Statement st = null;

		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "INSERT INTO follow (`follow_date`,`user_id1`, `user_id2`) VALUES( NOW(),'"+ id_user + "','" + id_friend + "')";
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
		return ServiceTools.serviceAccepted().put(getLogin(id_user)+": invitation sent to "+getLogin(id_friend), 001);
	}

	private static String getLogin(int id) {
		Connection co = null;
		Statement st = null;
		ResultSet res = null;
		try {
			co = Database.getMySQLConnection();
			st = co.createStatement();
			String query = "SELECT user_login FROM users WHERE user_id = "+id+";";
			//System.out.println("ici passe par la requete");
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

	/**
	 * @param key
	 * @param id_friend
	 * @return
	 */
	public static JSONObject deleteFriend(int id_user, int id_friend) {
		// TODO Auto-generated method stub
		return null;
	}

}
