/**
 * 
 */
package service;

import org.json.JSONObject;



import tools.MessageTools;

/**
 * @author LAOUER Walid
 *
 */
public class AddCommentS {
	public static JSONObject postComment(String key, int id_message, String text) {
		return MessageTools.postComment(key, id_message, text);
	}

}
