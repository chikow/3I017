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
	public static JSONObject removeFriend(int id_user, int id_friend) {
		if (id_user== 0)
			return ServiceTools.serviceRefused("Paramètre(s) vide(s)", -1);
		
		boolean is_friend = FriendTools.alreadyFriend(id_user, id_friend);
		if (!is_friend) 
			return ServiceTools.serviceRefused("Not Friends", -2);
		
		return FriendTools.deleteFriend(id_user, id_friend);
	}

}
