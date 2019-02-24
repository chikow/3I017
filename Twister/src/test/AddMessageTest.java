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
		//AddTwistS.AddTwist("wVW4dN6JcBLhKCLvSOGnFKWF2MKf6txs", "Give more and Excpect less");
		JSONObject obj = AddTwistS.listTwists("wVW4dN6JcBLhKCLvSOGnFKWF2MKf6txs", "false", "2");
		System.out.println(obj);
	}

}
