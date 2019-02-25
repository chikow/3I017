/**
 * 
 */
package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.AddCommentS;
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
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws SQLException, JSONException, InstantiationException, IllegalAccessException {
		//JSONObject obj = AddTwistS.AddTwist("ZC2ggG3SW3mOMxZVUe33hNkIdPj40S3p", "Message 1");
		//JSONObject obj = AddTwistS.listTwists("ZC2ggG3SW3mOMxZVUe33hNkIdPj40S3p", "false", "4");
		JSONObject obj = AddCommentS.listComments("IrqtChL3yiN4O0PAB6ZPs7clplfTfZAf", "5c746125f9d3f5613bf66a20");
		System.out.println(obj);
	}

}
