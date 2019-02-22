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

		JSONObject obj = RemoveTwistS.RemoveTwist("NWWUFLyVJjgvP8yHe81ul8xsMoE4cAJE", "5c6e8563a24c5b6a9967e869");
		System.out.println( obj);
	}

}
