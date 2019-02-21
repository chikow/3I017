/**
 * 
 */
package service;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import db.DBStatic;
import db.Database;
import tools.Data;
import tools.FriendTools;
import tools.ServiceTools;

/**
 * @author LAOUER Walid
 *
 */
public class RemoveFriendS {
	public static JSONObject removeFriend(int id_user, int id_friend) {
		if (id_user== 0)
			return ServiceTools.serviceRefused("Paramètre(s) vide(s)", -1);
		
		Connection co=null;
		try {
			co = Database.getMySQLConnection();
		boolean is_friend = FriendTools.alreadyFriend(id_user, id_friend, co);
		if (!is_friend) {
			co.close();
			return ServiceTools.serviceRefused("Not Friends", -2);
		}
		return FriendTools.unfollow(id_user, id_friend, co);
		}catch(SQLException s){
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_SQL, Data.CODE_ERROR_SQL);
		}catch(JSONException e){
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON, Data.CODE_ERROR_JSON);
		}finally {
			try {
				if ((!DBStatic.is_pooling) && (co != null))
					co.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Error closing connexion : " + e.getMessage());
			}
		}
	}
}
