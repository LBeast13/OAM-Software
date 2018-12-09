package dao.factory;

import java.sql.Connection;

import dao.OamConnection;
import dao.model.BeltDAO;
import dao.model.DAO;
import dao.model.FamilyDAO;
import dao.model.LicenceDAO;
import dao.model.MemberDAO;
import dao.model.ResultDAO;

/**
 * The DbDAOFactory class builds all the DAOs.
 * 
 * @author Liam
 *
 */
public class DbDAOFactory extends AbstractDAOFactory{
	
	/**
	 * The Connection object to access the database.
	 */
	protected static final Connection conn = OamConnection.getInstance();  

	@Override
	public DAO getFamilyDAO() {
		
		return new FamilyDAO(conn);
	}

	@Override
	public DAO getMemberDAO() {
		
		return new MemberDAO(conn);
	}

	@Override
	public DAO getBeltDAO() {
		// TODO Auto-generated method stub
		return new BeltDAO(conn);
	}

	@Override
	public DAO getLicenceDAO() {
		// TODO Auto-generated method stub
		return new LicenceDAO(conn);
	}

	@Override
	public DAO getResultDAO() {
		// TODO Auto-generated method stub
		return new ResultDAO(conn);
	}
	
}
