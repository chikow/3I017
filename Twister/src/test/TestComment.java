package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.AddCommentS;
import service.AddTwistS;
import service.LoginS;
import servlet.AddTwist;
import tools.UserTools;

public class TestComment {

	public static void main(String[] args) throws SQLException, JSONException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
//		JSONObject obj = AddTwistS.AddTwistS("7uocJsq4SBLqnToWn38pwTYzvFdbibpe", UserTools.generatekey());
//		System.out.println( obj);
		
//		JSONObject o = AddCommentS.postComment("ZC2ggG3SW3mOMxZVUe33hNkIdPj40S3p", "5c746125f9d3f5613bf66a20", "I like this post");
//		System.out.println(o);
//
//		JSONObject ob = AddCommentS.postComment("ZC2ggG3SW3mOMxZVUe33hNkIdPj40S3p", "5c746125f9d3f5613bf66a20", "!(Tech web is amazing)");
//		System.out.println(ob);
		
		JSONObject obj = AddCommentS.listComments("IrqtChL3yiN4O0PAB6ZPs7clplfTfZAf", "5c746125f9d3f5613bf66a20");
		System.out.println(obj);
		
	}

}
