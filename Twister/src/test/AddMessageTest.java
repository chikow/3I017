/**
 * 
 */
package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.AddTwistS;
import service.LoginS;

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
		JSONObject obj = AddTwistS.AddTwistS("NWWUFLyVJjgvP8yHe81ul8xsMoE4cAJE", "TEESTT");
		System.out.println( obj);
	}

}
