/**
 * 
 */
package service;

import org.json.JSONException;
import org.json.JSONObject;

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
		
		boolean is_friend = FriendTools.alreadyFriend(id_user, id_friend);
		if (is_friend) 
			return ServiceTools.serviceRefused("Already Friends", -2);
		
		try {
			return FriendTools.insertFriend(id_user, id_friend);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON, Data.CODE_ERROR_JSON);
	}

}
