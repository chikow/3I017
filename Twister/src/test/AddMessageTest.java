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
		JSONObject obj = AddTwistS.AddTwistS("HTtpisS8qHDUtpQOhhLNKyIaGrAsINFL", "Life is beautiful, enjoy it");
		System.out.println( obj);
	}

}
