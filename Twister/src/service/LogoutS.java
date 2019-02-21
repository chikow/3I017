/**
 * 
 */
package service;

import org.json.JSONException;
import org.json.JSONObject;

import tools.ServiceTools;
import tools.UserTools;
import tools.Data;
/**
 * @author LAOUER Walid
 *
 */
public class LogoutS {
	public static JSONObject logout(String log) {
		if (log == null) {
			return ServiceTools.serviceRefused(Data.MESSAGE_MISSING_PARAMETERS, Data.CODE_MISSING_PARAMETERS);
		}
		int id_user = UserTools.getIdUser(log);
		try {
			return UserTools.removeConnection(id_user);
		} catch (JSONException e) {
			e.printStackTrace();
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON, Data.CODE_ERROR_JSON);
		}
	}

}
