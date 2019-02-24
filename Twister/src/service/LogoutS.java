/**
 * 
 */
package service;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import db.Database;
import tools.Data;
import tools.ServiceTools;
import tools.UserTools;
/**
 * @author LAOUER Walid
 *
 */
public class LogoutS {
	public static JSONObject logout(String key) {
		if (key == null) {
			return ServiceTools.serviceRefused(Data.MESSAGE_MISSING_PARAMETERS, Data.CODE_MISSING_PARAMETERS);
		}
	
		Connection co=null;
		try {
			co = Database.getMySQLConnection();
			return UserTools.removeConnection(key, co);
		} catch (JSONException | SQLException s) {
			s.printStackTrace();
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_SQL, Data.CODE_ERROR_SQL);
		}finally {
			try {
				co.close();
			} catch (SQLException e) {
				System.err.println("Error closing connexion : " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
