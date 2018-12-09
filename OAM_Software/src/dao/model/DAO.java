package dao.model;

import java.sql.Connection;

/**
 * The DAO Class is an abstract class in order to manipulate all the DAO.
 * All the DAOs inherit from this class.
 * 
 * @author Liam
 *
 * @param <T>
 */
public abstract class DAO<T> {
	
	/**
	 * The Connection object to access the database.
	 */
	protected Connection connect = null;

	/**
	 * The DAO constructor.
	 * 
	 * @param conn : The Connection object
	 */
	public DAO(Connection conn){
		this.connect = conn;
	}

	/**
	 * Creation method
	 * 
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean create(T obj);

	/**
	 * Delete method
	 * 
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean delete(T obj);

	/**
	 * Update method
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);

	/**
	 * Find method
	 * 
	 * @param id
	 * @return T
	 */
	public abstract T find(int id);
}
