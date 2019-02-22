/**
 * 
 */
package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.AddTwistS;
import service.LoginS;
import tools.UserTools;

/**
 * @author LAOUER Walid
 *
 */
public class AddMessageTest {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, JSONException {
		JSONObject obj = AddTwistS.AddTwistS("7uocJsq4SBLqnToWn38pwTYzvFdbibpe", UserTools.generatekey());
		System.out.println( obj);
	}

}
