package dao.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

/**
 * The MemberDAO access the database in order to get, to update, to delete or to insert data.
 * 
 * @author Liam
 *
 */
public class MemberDAO extends DAO<Member>{
	
	/**
	 * The MemberDAO constructor.
	 * @param conn : The connection object to access the database.
	 */
	public MemberDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Insert a new member in the Member table of the database.
	 * 
	 * @param memb : the new Member to add to the database.
	 * 
	 * @return if the insertion ws successful or not.
	 */
	public boolean create(Member memb) {
		
		//Data preparation for the query
		String [] data = prepareDataQuery(memb);
		
		//Remove the coma of this string
		data[19] = data[19].substring(0, data[19].length()-1);
		
		try {
			
			//Builds the query for the insertion
			String query = "INSERT INTO public.\"Member\"("
						+ "mbr_id, fam_id, "
						+ "first_n, fam_n, "
						+ "born, email, "
						+ "address, zip_code, "
						+ "city, country, "
						+ "phone, dni, "
						+ "height, weight, "
						+ "league, tech_group, "
						+ "train_id, active, "
						+ "picture_path, dni_path)"
					+ "VALUES (";
			
			//Puts all the formated data in the query
			for(int i=0; i<data.length; i++){
				query = query + data[i];
			}
			query = query + ")";
			
			
			//Create the new member in the database
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
										 ResultSet.CONCUR_READ_ONLY
										).executeUpdate(query);
												
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot insert the new Member in the Database.");
			return false;
		}
	}

	/**
	 * Deletes the member passed in parameter from the DataBase using the ID as primary key.
	 * 
	 * @param memb : the member to delete
	 * 
	 * @return if the deletion was successful or not.
	 */
	public boolean delete(Member memb) {
		try {
			
			String query = "DELETE FROM public.\"Member\" "
					+ "WHERE mbr_id = " + memb.getId().get();
			
			//Delete the member using the id
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
										 ResultSet.CONCUR_READ_ONLY
										).executeUpdate(query);
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot delete the member from the Database.");
			return false;
		}
	}

	/**
	 * Modify an existing Member in the Database.
	 * 
	 * @param memb : the member containing the updated values.
	 * @return if the update was successful or not.
	 */
	public boolean update(Member memb) {
		
		//Data preparation for the query
		String [] data = prepareDataQuery(memb);
		
		data[19] = data[19].substring(0, data[19].length()-1);
		data[0] = data[0].substring(0, data[0].length()-1);
		
		try {

			String query = "UPDATE public.\"Member\" "
						+ "SET "
						+ "fam_id =" + data[1]
						+ "first_n =" + data[2]
						+ "fam_n = " + data[3]
						+ "born = " +  data[4]
						+ "email = " + data[5]
						+ "address = " + data[6]
						+ "zip_code = " + data[7]
						+ "city = " + data[8]
						+ "country = " + data[9]
						+ "phone = " + data[10]
						+ "dni = " + data[11]
						+ "height = " + data[12]
						+ "weight = " + data[13]
						+ "league = " + data[14]
						+ "tech_group = " + data[15]
						+ "train_id = " + data[16]
						+ "active = " + data[17]
						+ "picture_path = " + data[18]
						+ "dni_path = " + data[19]
						+ " WHERE mbr_id = " + data[0]; 

			//Updates the member in the dataBase using the id
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
										 ResultSet.CONCUR_READ_ONLY
										).executeUpdate(query);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot update the member's data in the Database.");
			return false;
		}
	}

	/**
	 * Finds and returns Member in the database using the id.
	 * We do a natural Join between the Member table and the Train Table to get the training_group.
	 * 
	 * @param id : the id of the searched member
	 * 
	 * @return a Member object built with the data in the database.
	 */
	public Member find(int id) {
		
		// The member resulting of the search
		Member memb = new Member();      

		try {
			
			String query ="SELECT * "
						+ "FROM public.\"Member\" "
						+ "NATURAL JOIN  public.\"Train\""
						+ "WHERE mbr_id = " + id;
			
			//Search the member using the ID in the database
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
															ResultSet.CONCUR_READ_ONLY
															).executeQuery(query);
			
			//If we find the member
			if(result.first()){
				
				//Create the new Member using the stored data
				memb = new Member(
						id,
						result.getInt("fam_id"),
						result.getString("first_n"),
						result.getString("fam_n"),
						result.getDate("born").toLocalDate(),
						result.getString("email"),
						result.getString("address"),
						result.getInt("zip_code"),
						result.getString("city"),
						result.getString("country"),
						result.getString("phone"),
						result.getString("dni"),
						result.getDouble("height"),
						result.getDouble("weight"),
						result.getBoolean("league"),
						result.getBoolean("tech_group"),
						result.getString("training_group"),
						result.getString("picture_path"),
						result.getString("dni_path"));  
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Member not found in the Database with this ID.");
		}
		
		return memb;
	}

	/**
	 * Test if the object is null in order to prepare the query.
	 * If the object is null we do not add single quotes.
	 * 
	 * @param obj : the object to test
	 * @return the prepared String query.
	 */
	private static String createQueryNullTest(Object obj){
		
		String query = "";
		
		//If it is an int or a double
		if(obj instanceof Double || obj instanceof Integer){
			if(obj.equals(0) || obj.equals(0.0))
				query = "null,";
			else
				query = obj + ",";
				
		}
		else{
			if(obj == null)
				query = obj + ",";
			else
				query = "'" + obj + "',";
		}
		
		return query;
	}

	/**
	 * Prepare all the data for the query (for the create and update methods)
	 * @param memb : the Member who will be used to get the data
	 * @return a String array containing all the formated data
	 */
	private static String[] prepareDataQuery(Member memb){
		
		String [] queryData = new String[20];
		
		queryData[0] = memb.getId().get() + ",";
		queryData[1] = memb.getIdFam().get() + ",";
		queryData[2] = createQueryNullTest(memb.getFirstName().get());
		queryData[3] = createQueryNullTest(memb.getFamName().get());
		queryData[4] = createQueryNullTest(memb.getBorn().get());
		queryData[5] = createQueryNullTest(memb.getEmail().get());
		queryData[6] = createQueryNullTest(memb.getAddress().get());
		queryData[7] = createQueryNullTest(memb.getZipCode().get());
		queryData[8] = createQueryNullTest(memb.getCity().get());	
		queryData[9] = createQueryNullTest(memb.getCountry().get());
		queryData[10] = createQueryNullTest(memb.getPhone().get());
		queryData[11] = createQueryNullTest(memb.getDni().get());
		queryData[12] = createQueryNullTest(memb.getHeight().get());
		queryData[13] = createQueryNullTest(memb.getWeight().get());
		queryData[14] = createQueryNullTest(memb.getLeague().get());
		queryData[15] = createQueryNullTest(memb.getTechGroup().get());
		
		queryData[17] = memb.isActive() + ","; 
		queryData[18] = createQueryNullTest(memb.getPicturePath().get());		
		queryData[19] = createQueryNullTest(memb.getDniScanPath().get());

		int trainId = 0;
		
		switch(memb.getTraining().get()){
			case "baby":
				trainId = 1;
				break;	
			case "child":	
				trainId = 2;
				break;	
			case "adult":
				trainId = 3;
				break;	
			case "musculation":
				trainId = 4;
				break;		
		}
		
		queryData[16] = Integer.toString(trainId) +",";
		
		return queryData;
	}
}
