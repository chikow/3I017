/**
 * 
 */
package service;

import org.json.JSONObject;



import tools.MessageTools;
import tools.ServiceTools;

/**
 * @author LAOUER Walid
 *
 */
public class AddCommentS {
	public static JSONObject postComment(String key, int id_message, String text) {
		if(key == null || text==null || id_message==0) {
			//return MessageTools.postTwist(key, text);
		}
		return ServiceTools.serviceAccepted();	
		}

}
