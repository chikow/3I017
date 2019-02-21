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
import tools.UserTools;

/**
 * @author LAOUER Walid
 *
 */
public class AddFriendS {
	public static JSONObject addFriend(int id_user, int id_friend) {
		if (id_user == 0 || id_friend==0)
			return ServiceTools.serviceRefused(Data.MESSAGE_MISSING_PARAMETERS, Data.CODE_MISSING_PARAMETERS);
		Connection co=null;
		try {
			co = Database.getMySQLConnection();
		boolean is_friend = FriendTools.alreadyFriend(id_user, id_friend, co);
		if (is_friend) {
			co.close();
			return ServiceTools.serviceRefused(Data.MESSAGE_USER_ALREADY_FRIEND, Data.CODE_USER_ALREADY_FRIEND);
		}
		return FriendTools.insertFriend(id_user, id_friend, co);
		} catch (JSONException | SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_SQL, Data.CODE_ERROR_SQL);
		}finally {
			if ((!DBStatic.is_pooling) && (co != null))
				try {
					co.close();
				} catch (SQLException e) {
					System.err.println("Error closing connexion : " + e.getMessage());

					e.printStackTrace();
				}
		}
	}

}
