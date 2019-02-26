package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.AddCommentS;
import service.AddTwistS;
import service.LoginS;
import servlet.AddTwist;
import tools.UserTools;

public class AddComment {

	public static void main(String[] args) throws SQLException, JSONException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

		
	JSONObject o = AddCommentS.postComment("ZC2ggG3SW3mOMxZVUe33hNkIdPj40S3p", "5c746125f9d3f5613bf66a20", "I like this post");
	System.out.println(o);

		
		
	}

}
