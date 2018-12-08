package dao;

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
	 * 
	 * 
	 * @return a Family object that interacts with the database.
	 */
	public abstract DAO getFamilyDAO();
	
	public abstract DAO getMemberDAO();
	
	public abstract DAO getBeltDAO();
	
	public abstract DAO getLicenceDAO();
	
	public abstract DAO getResultDAO();
	   
	//Méthode permettant de récupérer les Factory
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
	    	case DB_DAO_FACTORY:
	    		return new DAOFactory();
	    	
	    	default:
	    		return null;
	    }
	 }

}
