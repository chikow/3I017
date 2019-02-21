package service;

import org.json.JSONException;
import org.json.JSONObject;

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
			return ServiceTools.serviceRefused("Wrong Argument", 0);
		
		boolean is_user = UserTools.userExist(log);
		if (!is_user) 
			return ServiceTools.serviceRefused("User does not exists", 1);
		
		boolean pssd_ok = UserTools.checkPassword(log, mdp);
		if (!pssd_ok)
			return ServiceTools.serviceRefused("Wrong password", 2);
		
		int id_user = UserTools.getIdUser(log);
		
		boolean connect_ok = UserTools.userConnected(id_user);
		if (connect_ok)
			return ServiceTools.serviceRefused("Already Connected", 3);	
		
		
		
		try {
			return UserTools.insertConnexion(log, mdp);
		} catch (JSONException e) {
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON, Data.CODE_ERROR_JSON);
		}
	}

}


