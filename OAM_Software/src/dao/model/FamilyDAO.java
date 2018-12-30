package dao.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Family;
import model.Member;

public class FamilyDAO extends DAO<Family> {

	/**
	 * The FamilyDAO constructor.
	 * @param conn : The connection object to access the database.
	 */
	public FamilyDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Insert a new family in the database using the family data of the parameter.
	 * @param fam : the new family.
	 */
	@Override
	public boolean create(Family fam) {
		try {

			//Builds the query for the insertion
			String query = "INSERT INTO public.\"Family\"("
					+ "fam_n, balance)"
					+ "VALUES ("
					+ fam.getFamName().get() +","
					+ fam.getBalance().get() + ")";

			//Create the new member in the database
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
										 ResultSet.CONCUR_READ_ONLY
										).executeUpdate(query);

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot insert the new Family in the Database.");
			return false;
		}
	}

	/**
	 * Delete the family with the corresponding ID from the database.
	 * 
	 * @param fam: the family to delete.
	 */
	@Override
	public boolean delete(Family fam) {
		try {

			String query = "DELETE FROM public.\"Family\" "
							+ "WHERE fam_id = " + fam.getFamId().get();

			//Delete the family using the family id
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_READ_ONLY
										).executeUpdate(query);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot delete the family from the Database.");
			return false;
		}
	}

	/**
	 * Updates the family in the database
	 * 
	 * @param fam: the family to update
	 */
	@Override
	public boolean update(Family fam) {
		
		try {

			String query = "UPDATE public.\"Member\" "
					+ "SET "
					+ "fam_n =" + fam.getFamName().get()
					+ "balance = " + fam.getBalance().get()
					+ " WHERE fam_id = " + fam.getFamId().get(); 

			//Updates the family in the dataBase using the family id
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
	 * Search the family with the specified ID in the database.
	 * 
	 * @param id: the ID of the searched family.
	 */
	@Override
	public Family find(int id) {
		
		// The family resulting of the search
		Family fam = new Family();      

		try {
			String query ="SELECT * "
						+ "FROM public.\"Family\" "
						+ "WHERE fam_id = " + id;

			//Search the family using the ID in the database
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
															ResultSet.CONCUR_READ_ONLY
															).executeQuery(query);

			//If we find the family
			if(result.first()){

				//Create the new Family using the stored data
				fam = new Family(id,
								  result.getString("fam_n"),
								  result.getDouble("balance")
								 );  
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Family not found in the Database with this ID.");
		}

		return fam;
	}

	
}
