/**
 * 
 */
package service;

import java.sql.SQLException;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.MongoCollection;

import db.Database;
import tools.Data;
import tools.MessageTools;
import tools.ServiceTools;

/**
 * @author LAOUER Walid
 *
 */
public class RemoveTwistS {
	public static JSONObject RemoveTwist(String key,String idMessage) throws SQLException, JSONException {
		MongoCollection<Document> m = Database.getMongoMessage();
		if(key == null || idMessage==null ) {
			return ServiceTools.serviceRefused(Data.MESSAGE_MISSING_PARAMETERS, Data.CODE_MISSING_PARAMETERS);
			
		}
		return MessageTools.RemoveTwist(key, idMessage , m);
		}

}
