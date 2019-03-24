package test;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.comments.AddCommentS;

public class AddComment {

	public static void main(String[] args) throws SQLException, JSONException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

		
	JSONObject o = AddCommentS.postComment("CQPvKBRmyXsRYHrqZ6P0yLHT6y3y6WPu", "5c751d64d131316d05c87603", "my message :BPGM of all times");
	System.out.println(o);

		
		
	}

}
