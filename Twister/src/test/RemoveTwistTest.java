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
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws SQLException, JSONException, InstantiationException, IllegalAccessException {

		JSONObject obj = RemoveTwistS.RemoveTwist("HTtpisS8qHDUtpQOhhLNKyIaGrAsINFL", "5c70532c2708574bf0b7c7e8");
		System.out.println( obj);
	}

}
