/**
 * 
 */
package service;

import org.json.JSONObject;

import tools.FriendTools;
import tools.ServiceTools;

/**
 * @author LAOUER Walid
 *
 */
public class RemoveFriendS {
	public static JSONObject removeFriend(String key, int id_friend) {
		if (key == null)
			return ServiceTools.serviceRefused("Paramètre(s) vide(s)", -1);
		
		boolean is_friend = FriendTools.alreadyFriend(key, id_friend);
		if (!is_friend) 
			return ServiceTools.serviceRefused("Not Friends", -2);
		
		return FriendTools.deleteFriend(key, id_friend);
	}

}
