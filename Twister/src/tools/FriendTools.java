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
	 * @throws SQLException 
	 */
	public static boolean alreadyFriend(int id_user, int id_friend, Connection co) throws SQLException {
		Statement st = null;
		ResultSet res = null;
		st = co.createStatement();
		String query = "SELECT * FROM follow WHERE user_id1= \""+id_user+"\"AND user_id2 = \""+id_friend+"\";";
		//System.out.println("ici passe par la requete");
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
	 * @param id_friend
	 * @return
	 * @throws JSONException 
	 * @throws SQLException 
	 */
	public static JSONObject insertFriend(int id_user, int id_friend, Connection co) throws JSONException, SQLException {
		Statement st = null;
		st = co.createStatement();
		String query = "INSERT INTO follow (`follow_date`,`user_id1`, `user_id2`) VALUES( NOW(),'"+ id_user + "','" + id_friend + "')";
		st.executeUpdate(query);

		st.close();


		return ServiceTools.serviceAccepted().put(UserTools.getLogin(id_user)+": invitation sent to "+UserTools.getLogin(id_friend), 001);
	}



	/**
	 * @param key
	 * @param id_friend
	 * @return
	 * @throws SQLException 
	 * @throws JSONException 
	 */
	public static JSONObject unfollow(int id_user, int id_friend, Connection co) throws SQLException, JSONException {
		Statement st = null;
		st = co.createStatement();
		String query = "DELETE FROM follow WHERE user_id1 = '"+id_user+"' AND user_id2 = '"+id_friend+"'";
		st.executeUpdate(query);
		st.close();
		return ServiceTools.serviceAccepted().put(UserTools.getLogin(id_user)+" has unfollow "+UserTools.getLogin(id_friend), 1);
	}

}
