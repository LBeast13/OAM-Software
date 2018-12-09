package dao.model;

import java.sql.Connection;

import model.Licence;

public class LicenceDAO extends DAO<Licence>{

	public LicenceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Licence obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Licence obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Licence obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Licence find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
