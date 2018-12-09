package dao.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import model.Member;

public class MemberDAO extends DAO<Member>{
	
	public MemberDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Member obj) {
		return false;
	}

	public boolean delete(Member obj) {
		return false;
	}

	public boolean update(Member obj) {
		return false;
	}

	/**
	 * Finds and returns Member in the database using the id
	 * 
	 * @param id : the id of the searched member
	 */
	public Member find(int id) {
		
		// The member resulting of the search
		Member memb = new Member();      

		try {
			//Search the member using the ID in the database
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * "
															+ "FROM member"
															+ " WHERE mbr_id = " + id);
			//If we match with a member
			if(result.first()){
				
				ResultSet resultTrain = this.connect.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT training_group "
																+ "FROM train "
																+ "WHERE train_id = " + result.getInt("train"));
				//Create the new Member using the stored data
				memb = new Member(
						id,
						result.getInt("fam_id"),
						result.getString("first_n"),
						result.getString("fam_n"),
						result.getDate("born").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
						result.getString("email"),
						result.getString("address"),
						result.getString("phone"),
						result.getString("dni"),
						result.getDouble("height"),
						result.getDouble("weight"),
						result.getBoolean("league"),
						result.getBoolean("tech_group"),
						resultTrain.getString("training_group"
								));  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memb;
	}
}
