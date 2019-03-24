package test;



import org.json.JSONObject;

import service.user.CreatUserS;



/**
 * @author LAOUER Walid
 *
 */
public class CreateUserTest {


	public static void main(String[] args) throws InstantiationException, IllegalAccessException {


		JSONObject obj = CreatUserS.createUser("Delpaxll","del", "Pax", "Dellpax@gmail.com", "1234");
		System.out.println(obj.toString());
		System.out.println("heeeeey");

		
	}


}
