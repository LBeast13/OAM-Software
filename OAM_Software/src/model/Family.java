package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Family {
	
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
	public Family(String famName, double balance){
		this.mFamName.set(famName);
		this.mBalance.set(balance);
	}
	
// Getters and setters ----------------------------------------
	
	public ObjectProperty<String> getFamName() {return mFamName;}
	public void setFamName(ObjectProperty<String> famName) {this.mFamName = famName;}
	
	public DoubleProperty getBalance() {return mBalance;}
	public void setBalance(DoubleProperty balance) {this.mBalance = balance;}
	
}
