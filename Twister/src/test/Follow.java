package test;

import org.json.JSONObject;

import service.AddFriendS;

public class Follow {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		JSONObject o = AddFriendS.addFriend("IrqtChL3yiN4O0PAB6ZPs7clplfTfZAf", 9);
		//JSONObject o1 = AddFriendS.addFriend("p7OxPwaydulGINckYSBWI6naJW3rlSQ5", 10);
//		JSONObject o2 = AddFriendS.addFriend("p7OxPwaydulGINckYSBWI6naJW3rlSQ5", 15);
		System.out.println(o);
		
	}
}
