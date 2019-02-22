/**
 * 
 */
package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import service.RemoveTwistS;

/**
 * @author LAOUER Walid
 *
 */
public class RemoveTwistTest {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, JSONException {

		JSONObject obj = RemoveTwistS.RemoveTwist("7uocJsq4SBLqnToWn38pwTYzvFdbibpe", "5c6fe1ed37ca9f3d573afdb5");
		System.out.println( obj);
	}

}
