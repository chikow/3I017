/**
 * 
 */
package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.twist.RemoveTwistS;

/**
 * @author LAOUER Walid
 *
 */
public class RemoveTwistTest {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws SQLException, JSONException, InstantiationException, IllegalAccessException {

		JSONObject obj = RemoveTwistS.RemoveTwist("CQPvKBRmyXsRYHrqZ6P0yLHT6y3y6WPu", "5c75341a7e5702223faba495");
		System.out.println( obj);
	}

}
