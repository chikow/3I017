/**
 * 
 */
package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.twist.AddTwistS;

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
		JSONObject obj = AddTwistS.AddTwist("5gfg4dFe80BpqrPFsH8hYuIO65Lmmq76", "MESSAAGE");
		
		System.out.println(obj);
	}

}
