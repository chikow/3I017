/**
 * 
 */
package tools;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.Connection;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.UpdateResult;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

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
		if(user_id ==0)
			return ServiceTools.serviceRefused(Data.MESSAGE_USER_NOT_CONNECTED, Data.CODE_USER_NOT_CONNECTED);
		System.out.println("user connected!");
		query.append("user_id",user_id);
		query.append("date", new Date());
		query.append("content", text);
		List<String> d = new ArrayList<String>();
		query.append("comments", d);

		message_collection.insertOne(query);

		FindIterable<Document> f = message_collection.find(query);
		MongoCursor<Document> cur = f.iterator();

		boolean res = false;
		while(cur.hasNext()) {
			cur.next();
			res = true;
		}
		if (res) {
		return ServiceTools.serviceAccepted().put(UserTools.getLogin(user_id)+" twist has been posted successfully", 1);
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
		
		FindIterable<Document> fi = m.find(query);
		MongoCursor<Document> c = fi.iterator();
		boolean message_exist = false;
		while(c.hasNext()) {
			System.out.println(c.next());
			System.out.println("twist exist");
			message_exist = true;
		}
		if(checkAuthor(key, id, conn, m)) {
			//System.out.println("heyyy"+m.deleteOne(query));
			m.deleteOne(query);
		}
//		else {
//			System.out.println("message not deleted");
//			return ServiceTools.serviceRefused(Data.MESSAGE_USER_NOT_CONNECTED, Data.CODE_USER_NOT_CONNECTED);
//		}
		FindIterable<Document> f = m.find(query);
		MongoCursor<Document> cur = f.iterator();
		boolean res = true;
		while(cur.hasNext()) {
			System.out.println("message not deleted");
			System.out.println(cur.next());
			res = false;
		}
		if (res) {
			if(message_exist)
				return ServiceTools.serviceAccepted().put(UserTools.getLogin(UserTools.getIdFromKey(key, conn))+" twist has been removed successfully", 1);
			else
				return ServiceTools.serviceAccepted().put(UserTools.getLogin(UserTools.getIdFromKey(key, conn))+" has no twist to remove", 1);
		}
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON, Data.CODE_ERROR_JSON);
	}
	
	public static boolean checkAuthor(String key, String id_message, Connection conn, MongoCollection<Document> message_collection) throws SQLException {

		int userID = UserTools.getIdFromKey(key, conn);
//		if(userID==0)
//			return false;
		Document query = new Document();
		query.append("user_id", userID);
		query.append("_id", new ObjectId(id_message));

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

	public static JSONObject postComment(String key, String id_message, String text, MongoCollection<Document> message_collection, Connection co) throws JSONException, SQLException {
		// TODO Auto-generated method stub
		//JSONObject comment = new  JSONObject();
		//comment.put(text, 1);//doit-on mettre une clé incrementable pour pouvoir ordonné les comments plus tard et faire des classification
		Bson filter = new Document("_id", new ObjectId(id_message));
		Bson Q = new Document(UserTools.getLogin(UserTools.getIdFromKey(key, co)), text);
		Bson query = new Document("comments", Q);
		Bson updateOperationDocument = new Document("$addToSet", query);
		message_collection.updateOne(filter, updateOperationDocument);
		//query.append("_id", new ObjectId(id_message));
		//cur.next().append("test ", text);
		return ServiceTools.serviceAccepted().put("Comment has been added", 1);
	}

	public static JSONObject removeComment(String id_message, int id_user, MongoCollection<Document> message_collection) throws JSONException {
		Bson filter = new Document("_id", new ObjectId(id_message));
		Document query = new Document("comments", new ObjectId("1"));
		Document found = (Document) message_collection.find(query).first();
		if(found != null)
			System.out.println("element found");
		Bson updateOperationDocument = new Document("$pull", query);
		message_collection.updateOne(filter, updateOperationDocument);
		//MongoCursor<Document> c = message_collection.find().iterator();
		
//		while(c.hasNext())
//			System.out.println("test");
		return ServiceTools.serviceAccepted().put("Comment deleted", 1);
	}


}
