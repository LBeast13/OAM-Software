package dao.model;

import java.sql.Connection;

import model.Result;

public class ResultDAO extends DAO<Result>{

	public ResultDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Result obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Result obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Result obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Result find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
