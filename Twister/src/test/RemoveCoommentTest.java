package test;

import org.json.JSONObject;

import service.AddCommentS;
import service.RemoveCommentS;

public class RemoveCoommentTest {
	public static void main(String[] args) {
		JSONObject o = RemoveCommentS.DeleteComment("gH3sTZjvbZvwmpdS6kMVpYdT7ySBNBuf", "5c70532c2708574bf0b7c7e8", "5c705345b5669f2da29f5571");
		System.out.println(o);
	}
}
