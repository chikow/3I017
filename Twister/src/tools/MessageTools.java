/**
 * 
 */
package tools;

import java.sql.SQLException;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.Connection;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import db.Database;

/**
 * @author LAOUER Walid
 *
 */
public class MessageTools {
	 

	/**
	 * @param key
	 * @param text
	 * @return
	 */
	

	public static JSONObject postTwist(String key ,String text, MongoCollection<Document> message_collection) throws SQLException, JSONException{
		Connection co = Database.getMySQLConnection();
		Document query = new Document();
		int user_id = UserTools.getIdFromKey(key,co);
		query.append("user_id",user_id);
		query.append("date", new Date());
		query.append("content", text);
		

		message_collection.insertOne(query);

		FindIterable<Document> f = message_collection.find(query);
		MongoCursor<Document> cur = f.iterator();

		boolean res = false;
		while(cur.hasNext()) {
			cur.next();
			res = true;
		}
		if (res) {
		return ServiceTools.serviceAccepted().put(user_id+" has been successfully", 1);
		}
		return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON, Data.CODE_ERROR_JSON);
	}

	/**
	 * @param key
	 * @param idMessage
	 * @param m
	 * @return
	 * @throws JSONException 
	 * @throws SQLException 
	 */
	public static JSONObject RemoveTwist(String key, String id,Connection conn, MongoCollection<Document> m) throws JSONException, SQLException {
		Document query = new Document();
		query.append("_id",new ObjectId(id));
		if(checkAuthor(key, id, conn, m)) {
		m.deleteOne(query);
		}

		FindIterable<Document> f = m.find(query);
		MongoCursor<Document> cur = f.iterator();

		boolean res = true;
		while(cur.hasNext()) {
			System.out.println(cur.next());
			res = false;
		}
		if (res) {
			return ServiceTools.serviceAccepted().put(key+" has been successfully", 1);
			}
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON, Data.CODE_ERROR_JSON);
	}
	public static boolean checkAuthor(String key, String id, Connection conn, MongoCollection<Document> message_collection) throws SQLException {

		int userID = UserTools.getIdFromKey(key, conn);
		Document query = new Document();
		query.append("user_id", userID);
		query.append("_id", new ObjectId(id));

		message_collection.find(query);

		FindIterable<Document> f = message_collection.find(query);
		MongoCursor<Document> cur = f.iterator();

		boolean res = false;
		while(cur.hasNext()) {

			Document obj = cur.next();

			res = true;
		}

		return res;

	}


}
