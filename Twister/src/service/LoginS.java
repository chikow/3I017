package service;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import db.DBStatic;
import db.Database;
import tools.Data;
import tools.ServiceTools;
import tools.UserTools;

/**
 * @author LAOUER Walid
 *
 */
public class LoginS {

	public static JSONObject login(String log, String mdp) {
		if ((log == null) || (mdp == null)) 
			return ServiceTools.serviceRefused(Data.MESSAGE_MISSING_PARAMETERS, Data.CODE_MISSING_PARAMETERS);

		Connection co=null;
		try {
			co = Database.getMySQLConnection();
			boolean is_user = UserTools.userExist(log, co);
			if (!is_user) {
				co.close();
				return ServiceTools.serviceRefused(Data.MESSAGE_USER_DOES_NOT_EXIST, Data.CODE_USER_DOES_NOT_EXIST);
			}
			boolean pssd_ok = UserTools.checkPassword(log, mdp, co);
			if (!pssd_ok) {
				co.close();
				return ServiceTools.serviceRefused(Data.MESSAGE_INCORRECT_PASSWORD, Data.CODE_INCORRECT_PASSWORD);
			}
			int id_user = UserTools.getIdUser(log, co);

			boolean connect_ok = UserTools.userConnected(id_user, co);
			if (connect_ok) {
				co.close();
				return ServiceTools.serviceRefused(Data.MESSAGE_USER_ALREADY_CONNECTED, Data.CODE_USER_ALREADY_CONNECTED);	
			}
			return UserTools.insertConnexion(log, mdp, co);
			} catch (SQLException | JSONException s) {
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


