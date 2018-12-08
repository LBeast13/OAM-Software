package dao;


public class DbDAOFactory extends AbstractDAOFactory{
	
	protected static final Connection conn = SdzConnection.getInstance();  

	@Override
	public DAO getFamilyDAO() {
		
		return new FamilyDAO();
	}

	@Override
	public DAO getMemberDAO() {
		
		return new MemberDAO();
	}

	@Override
	public DAO getBeltDAO() {
		// TODO Auto-generated method stub
		return new BeltDAO();
	}

	@Override
	public DAO getLicenceDAO() {
		// TODO Auto-generated method stub
		return new LicenceDAO();
	}

	@Override
	public DAO getResultDAO() {
		// TODO Auto-generated method stub
		return new ResultDAO();
	}
	
}
