package service;
import org.json.JSONObject;

import jdk.nashorn.internal.runtime.UserAccessorProperty;
import tools.Data;
import tools.ServiceTools;
import tools.UserTools;

/**
 * @author BELAREF Nail
 *
 */
public class SearchS {
	public static JSONObject SearchS(String key, String query) {
		if (key==null || query == null) {
			ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON,Data.CODE_ERROR_JSON);
		}
		return ServiceTools.serviceAccepted();
	}
}
