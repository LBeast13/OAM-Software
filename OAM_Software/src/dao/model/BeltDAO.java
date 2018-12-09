package dao.model;

import java.sql.Connection;

import model.Belt;

public class BeltDAO extends DAO<Belt>{

	public BeltDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Belt obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Belt obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Belt obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Belt find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
