/**
 * 
 */
package service;

import java.sql.Connection;
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
	public static JSONObject RemoveTwist(String key,String tweet_id) throws SQLException, JSONException {
		MongoCollection<Document> m = Database.getMongoMessage();
		Connection c = Database.getMySQLConnection();
		if(key == null || tweet_id==null ) {
			return ServiceTools.serviceRefused(Data.MESSAGE_MISSING_PARAMETERS, Data.CODE_MISSING_PARAMETERS);
			
		}
		return MessageTools.RemoveTwist(key, tweet_id ,c , m);
		}

}
