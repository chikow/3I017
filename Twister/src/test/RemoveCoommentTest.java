package test;

import org.json.JSONObject;

import service.AddCommentS;
import service.RemoveCommentS;

public class RemoveCoommentTest {
	public static void main(String[] args) {
		JSONObject o = RemoveCommentS.DeleteComment("gH3sTZjvbZvwmpdS6kMVpYdT7ySBNBuf", "5c703d21734d266e4f8dff5a");
		System.out.println(o);
	}
}
