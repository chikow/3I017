/**
 * 
 */
package tools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

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
		if(user_id ==0)
			return ServiceTools.serviceRefused(Data.MESSAGE_USER_NOT_CONNECTED, Data.CODE_USER_NOT_CONNECTED);
		System.out.println("user connected!");
		query.append("login", UserTools.getLogin(user_id));
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
	public static JSONObject RemoveTwist(String key, String id_message,Connection conn, MongoCollection<Document> m) throws JSONException, SQLException {
		int user_id = UserTools.getIdFromKey(key,conn);
		if(user_id ==0)
			return ServiceTools.serviceRefused(Data.MESSAGE_USER_NOT_CONNECTED, Data.CODE_USER_NOT_CONNECTED);
		
		Document query = new Document();
		query.append("_id",new ObjectId(id_message));
		FindIterable<Document> fi = m.find(query);
		MongoCursor<Document> c = fi.iterator();
		boolean message_exist = false;
		while(c.hasNext()) {
			System.out.println(c.next());
			System.out.println("twist exist");
			message_exist = true;
		}
		if(checkAuthor(key, id_message, conn, m)) {
			m.deleteOne(query);
		}
		if(message_exist)
			return ServiceTools.serviceAccepted().put(UserTools.getLogin(UserTools.getIdFromKey(key, conn))+" twist has been removed successfully", 1);
		else
			return ServiceTools.serviceAccepted().put(UserTools.getLogin(UserTools.getIdFromKey(key, conn))+" has no twist to remove", 1);

	}

	public static boolean checkAuthor(String key, String id_message, Connection conn, MongoCollection<Document> message_collection) throws SQLException {

		int userID = UserTools.getIdFromKey(key, conn);
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
		Document comments = new Document();
		ObjectId objectId = genererObjectId(message_collection);
		comments.append("id_comment", objectId);
		GregorianCalendar c = new GregorianCalendar();

		comments.put("date", c.getTime());

		Document auteur = new Document();
		auteur.append("login", UserTools.getLogin(UserTools.getIdFromKey(key, co)));
		comments.append("author",auteur);
		comments.append("content", text);
		comments.append("idMessage", id_message);

		Document content = new Document("comments", comments);
		Document push = new Document("$push", content);
		Document filter = new Document("_id", new ObjectId(id_message));

		message_collection.updateOne(filter, push);
		comments.append("idMessage", id_message);
		//		Bson filter = new Document("_id", new ObjectId(id_message));
		//		Bson Q = new Document(UserTools.getLogin(UserTools.getIdFromKey(key, co)), text);
		//		Bson query = new Document("comments", Q);
		//		Bson updateOperationDocument = new Document("$push", query);
		//		message_collection.updateOne(filter, updateOperationDocument);
		return ServiceTools.serviceAccepted().put("Comment has been added", 1);
	}

	public static JSONObject removeComment(String id_message, String id_comment, MongoCollection<Document> message_collection) throws JSONException {
		Bson filter = new Document("id_comment", new ObjectId(id_comment));
		Bson query = new Document("comments", filter);
		Document msg_query = new Document("$pull", query);
		System.out.println(msg_query.toString());
		Bson updateOperationDocument = new Document("_id", new ObjectId(id_message));
		message_collection.updateOne(updateOperationDocument, msg_query);
		//		if(found != null)
		//			System.out.println("element found");
		//		Bson updateOperationDocument = new Document("$pull", query);
		//		message_collection.updateOne(filter, updateOperationDocument);
		//MongoCursor<Document> c = message_collection.find().iterator();

		//		while(c.hasNext())
		//			System.out.println("test");
		return ServiceTools.serviceAccepted().put("Comment deleted", 1);
	}

	public static ObjectId genererObjectId(MongoCollection<Document> message_collection)
	{

		ObjectId id;
		while(true)
		{
			id = new ObjectId();
			Document query = new Document();
			/*
			 * When <boolean> is true, $exists matches the documents that contain the field,
			 * including documents where the field value is null. If <boolean> is false, 
			 * the query returns only the documents that do not contain the field.
			 * This query will select all documents in the message collection where the id_comment field value
			 * does not equal to id*/
			query.append("id_comment", new Document("$exists", true).append("$ne", id));
			Document f = message_collection.find(query).first();
			//System.out.println(query.toString());
			//FindIterable<Document> cursor = message_collection.find(query);
			//if (((Document) cursor).size() != 0)
			break;
		}
		return id;
	}

}
