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

		JSONObject obj = RemoveTwistS.RemoveTwist("NWWUFLyVJjgvP8yHe81ul8xsMoE4cAJE", "5c6f540d3bc2f844015727e7");
		System.out.println( obj);
	}

}
