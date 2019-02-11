/**
 * 
 */
package service;

import org.json.JSONObject;

import tools.ServiceTools;
import tools.UserTools;

/**
 * @author LAOUER Walid
 *
 */
public class LogoutS {
	public static JSONObject logout(String key) {
		if (key == null) {
			return ServiceTools.serviceRefused("Paramètre(s) vide(s)", -1);
		}
		UserTools.removeConnection(key);
		return new JSONObject();
	}

}
