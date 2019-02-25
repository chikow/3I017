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

import org.json.JSONArray;
import db.DBStatic;
import db.Database;
import tools.Data;
import tools.MessageTools;
import tools.ServiceTools;
import tools.UserTools;

/**
 * @author LAOUER Walid
 *
 */
public class AddTwistS {
	public static JSONObject AddTwist(String key, String text) throws InstantiationException, IllegalAccessException{
		if(key == null || text==null ) {
			return ServiceTools.serviceRefused(Data.MESSAGE_MISSING_PARAMETERS, Data.CODE_MISSING_PARAMETERS);

		}
		MongoCollection<Document> m = Database.getMongoMessage();
		Connection co=null;
		try {
			co = Database.getMySQLConnection();

			int id_user = UserTools.getIdFromKey(key, co);
			if( id_user==0) {
				co.close();
				return ServiceTools.serviceRefused(Data.MESSAGE_USER_NOT_CONNECTED, Data.CODE_USER_NOT_CONNECTED);
			}
			return MessageTools.postTwist(id_user, text , m);
		}catch(SQLException s) {
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_SQL, Data.CODE_ERROR_SQL);
		}

		catch(JSONException e) {
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON, Data.CODE_ERROR_JSON);
		}finally {
			if ((!DBStatic.is_pooling) && (co != null))
				try {
					co.close();
				} catch (SQLException e) {
					System.err.println("Error closing connexion : " + e.getMessage());

					e.printStackTrace();
				}
		}

	}

	public static JSONObject listTwists(String key, String orderAsc, String nbTwist) throws InstantiationException, IllegalAccessException {
		if(key==null || nbTwist == null)
			return ServiceTools.serviceRefused(Data.MESSAGE_MISSING_PARAMETERS, Data.CODE_MISSING_PARAMETERS);
		MongoCollection<Document> m = Database.getMongoMessage();
		Connection co=null;
		try {
			co = Database.getMySQLConnection();

			int id_user = UserTools.getIdFromKey(key, co);
			if( id_user==0) {
				co.close();
				return ServiceTools.serviceRefused(Data.MESSAGE_USER_NOT_CONNECTED, Data.CODE_USER_NOT_CONNECTED);
			}
			//Si il pr�cise pas d'ordre, ordre croissant
			boolean ord;
			if (orderAsc == null)
				ord = false;
			else
				ord = Boolean.parseBoolean(orderAsc);
			int nb_twist = Integer.parseInt(nbTwist);

			JSONArray array = MessageTools.listTwist(UserTools.getLogin(id_user), nb_twist, ord, m);
			return ServiceTools.serviceAccepted().put("My twists",array);
		}catch(SQLException s) {
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_SQL, Data.CODE_ERROR_SQL);
		}

		catch(JSONException e) {
			return ServiceTools.serviceRefused(Data.MESSAGE_ERROR_JSON, Data.CODE_ERROR_JSON);
		}finally {
			if ((!DBStatic.is_pooling) && (co != null))
				try {
					co.close();
				} catch (SQLException e) {
					System.err.println("Error closing connexion : " + e.getMessage());

					e.printStackTrace();
				}
		}
	}
}
