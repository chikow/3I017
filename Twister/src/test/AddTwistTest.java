/**
 * 
 */
package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.AddCommentS;
import service.AddTwistS;
import service.LoginS;
import tools.UserTools;

/**
 * @author LAOUER Walid
 *
 */
public class AddTwistTest {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws SQLException, JSONException, InstantiationException, IllegalAccessException {
		JSONObject obj = AddTwistS.AddTwist("x36mHm0DTnciwuLEffkGyZrtR6QthzA7", "Message 1");
		
		System.out.println(obj);
	}

}
