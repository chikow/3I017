package test;

import org.json.JSONObject;

import service.comments.RemoveCommentS;

public class RemoveCoommentTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		JSONObject o = RemoveCommentS.DeleteComment("HTtpisS8qHDUtpQOhhLNKyIaGrAsINFL", "5c72611b13acf63d1ac10fe1", "5c72618a0b636c3c8fbeaf20");
		System.out.println(o);
	}
}
