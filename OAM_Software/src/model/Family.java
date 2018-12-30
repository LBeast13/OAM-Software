package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Family {
	
	/**
	 * The Family ID
	 */
	private IntegerProperty mFamId = new SimpleIntegerProperty();
	
	/**
	 * The name of the Family
	 */
	private ObjectProperty<String> mFamName = new SimpleObjectProperty<String>();
	
	/**
	 * The total balance of the Family.
	 */
	private DoubleProperty mBalance = new SimpleDoubleProperty();
	
	/**
	 * The default Family constructor.
	 */
	public Family(){}
	
	/**
	 * The Family constructor.
	 * 
	 * @param famName : the name of the Family
	 * @param balance : the total balance
	 */
	public Family(int famId, String famName, double balance){
		this.mFamId.set(famId);
		this.mFamName.set(famName);
		this.mBalance.set(balance);
	}
	
// Getters and setters ----------------------------------------
	
	public IntegerProperty getFamId() {return mFamId;}
	public void setFamId(IntegerProperty mFamId) {this.mFamId = mFamId;}

	public ObjectProperty<String> getFamName() {return mFamName;}
	public void setFamName(ObjectProperty<String> famName) {this.mFamName = famName;}
	
	public DoubleProperty getBalance() {return mBalance;}
	public void setBalance(DoubleProperty balance) {this.mBalance = balance;}
	
}
