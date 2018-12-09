package dao.model;

import java.sql.Connection;

import model.Family;

public class FamilyDAO extends DAO<Family> {

	public FamilyDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Family obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Family obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Family obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Family find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
