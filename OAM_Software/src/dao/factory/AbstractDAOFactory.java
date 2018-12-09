package dao.factory;

import dao.model.DAO;

/**
 * Abstract class in order to choose a DAO System.
 * Only the Database DAO is implemented.
 * This class is useful in order to avoid big changes in the software when
 * we change the data storage type. 
 * 
 * @author Liam
 *
 */
public abstract class AbstractDAOFactory {

	/**
	 * Constant to choose the Database DAO type
	 */
	public static final int DB_DAO_FACTORY = 0;


	/**
	 * This method will return a Family DAO Object that interacts with the database.
	 * 
	 * @return a Family DAO object.
	 */
	public abstract DAO getFamilyDAO();

	/**
	 * This method will return a Member DAO Object that interacts with the database.
	 * 
	 * @return a Member DAO object.
	 */
	public abstract DAO getMemberDAO();

	/**
	 * This method will return a Belt DAO Object that interacts with the database.
	 * 
	 * @return a Belt DAO object.
	 */
	public abstract DAO getBeltDAO();

	/**
	 * This method will return a Licence DAO Object that interacts with the database.
	 * 
	 * @return a Licence DAO object.
	 */
	public abstract DAO getLicenceDAO();

	/**
	 * This method will return a Result DAO Object that interacts with the database.
	 * 
	 * @return a Result DAO object.
	 */
	public abstract DAO getResultDAO();

	/**
	 * This method allows to get the factories.
	 * 
	 * @param type : to choose the Data Access type
	 * @return The chosen factory
	 */
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
			case DB_DAO_FACTORY:
				return new DbDAOFactory();

			default:
				return null;
		}
	}

}
