/**
 * 
 */
package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import db.Database;

/**
 * @author LAOUER Walid
 *
 */
public class SessionTools {
	
	/**
	 * @param key
	 * @return
	 */
	public static int getIdFromKey(String key,Connection co) throws SQLException {
		Statement st = null;
		ResultSet res = null;
		int id_user = 0;
		
			st = co.createStatement();
			String query = "SELECT user_id FROM sessions WHERE session_key= \""+key+"\";";
			res = st.executeQuery(query);

			if (res.next()) {
				//System.out.println("il existe bien un resultat");
				id_user = res.getInt("user_id");
			}
			res.close();
			st.close();
			if(id_user==0)
				System.out.println("Utilisateur non connecte ");
			return id_user;
	}


	public static void sessionUpdate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis() - 1800000);
		//30 * 60 * 1000 = 1800000ms  -> 30min
		try {
			Connection connexion = Database.getMySQLConnection();
			String sql = "DELETE FROM sessions where session_start < ?";
			PreparedStatement ps = connexion.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE);
			ps.setTimestamp(1, timestamp);
			ps.executeUpdate();
			ps.close();
			connexion.close();
		} catch (SQLException e) {
			
		}
	}
}
