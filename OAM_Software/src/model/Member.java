package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Member {
	
	/**
	 * The Member ID.
	 */
	private IntegerProperty mId = new SimpleIntegerProperty();
	
	/**
	 * The ID of the Family the member is part of.
	 */
	private IntegerProperty mIdFam = new SimpleIntegerProperty();
	
	/**
	 * The First name of the Member.
	 */
	private ObjectProperty<String> mFirstName = new SimpleObjectProperty<>();
	
	/**
	 * The Family Name of the Member
	 */
	private ObjectProperty<String> mFamName = new SimpleObjectProperty<>();
	
	/**
	 * The born date of the Member
	 */
	private ObjectProperty<LocalDate> mBorn = new SimpleObjectProperty<>();
	
	/**
	 * The email address of the Member.
	 */
	private ObjectProperty<String> mEmail = new SimpleObjectProperty<>();
	
	/**
	 * The address of the Member.
	 */
	private ObjectProperty<String> mAddress = new SimpleObjectProperty<>();
	
	/**
	 * The phone number of the Member.
	 */
	private ObjectProperty<String> mPhone = new SimpleObjectProperty<>();
	
	/**
	 * The DNI number of the Member.
	 */
	private ObjectProperty<String> mDni = new SimpleObjectProperty<>();
	
	/**
	 * The height of the Member.
	 */
	private DoubleProperty mHeight = new SimpleDoubleProperty();
	
	/**
	 * The weight of the Member.
	 */
	private DoubleProperty mWeight = new SimpleDoubleProperty();
	
	/**
	 * True if the Member participates in the League.
	 */
	private BooleanProperty mLeague = new SimpleBooleanProperty();
	
	/**
	 * True if the Member is part of Technification group.
	 */
	private BooleanProperty mTechGroup = new SimpleBooleanProperty();
	
	/**
	 * The category training of the Member (baby, child, adult, musculation).
	 * 1 = baby
	 * 2 = child
	 * 3 = adult
	 * 4 = musculation
	 */
	private ObjectProperty<String> mTraining = new SimpleObjectProperty<>();
	
	/**
	 * All the belts obtained by the Member.
	 */
	private ObjectProperty<ArrayList<Belt>> mBelts = new SimpleObjectProperty<>();
	
	/**
	 * All the licences (national and international) of the Member
	 */
	private ObjectProperty<ArrayList<Licence>> mLicences = new SimpleObjectProperty<>();
	
	/**
	 * All the competition results of the Member.
	 */
	private ObjectProperty<ArrayList<Result>> mResults = new SimpleObjectProperty<>();
	
	public Member(int id, int idFam, String firstN, String famN, LocalDate born, 
			String email, String add, String phone, String dni, double height, 
			double weight, boolean league, boolean techGroup, String training) {
		
		this.mId.set(id);
		this.mIdFam.set(idFam);
		this.mFirstName.set(firstN);
		this.mFamName.set(famN);
		this.mBorn.set(born);
		this.mEmail.set(email);
		this.mAddress.set(add);
		this.mPhone.set(phone);
		this.mDni.set(dni);
		this.mHeight.set(height);
		this.mWeight.set(weight);
		this.mLeague.set(league);
		this.mTechGroup.set(techGroup);
		this.mTraining.set(training);
		this.mBelts.set(new ArrayList<Belt>());
		this.mLicences.set(new ArrayList<Licence>());
		this.mResults.set(new ArrayList<Result>());
	}
	
	/**
	 * The default Member constructor.
	 */
	public Member(){};

	
	
	
// Getters and Setter --------------------------------------------
	
	public IntegerProperty getId() {return mId;}
	public void setId(IntegerProperty id) {this.mId = id;}
	
	public IntegerProperty getIdFam() {return mIdFam;}
	public void setIdFam(IntegerProperty idFam) {this.mIdFam = idFam;}
	
	public ObjectProperty<String> getFirstName() {return mFirstName;}
	public void setFirstName(ObjectProperty<String> firstN) {this.mFirstName = firstN;}
	
	public ObjectProperty<String> getFamName() {return mFamName;}
	public void setFamName(ObjectProperty<String> famN) {this.mFamName = famN;}
	
	public ObjectProperty<LocalDate> getBorn() {return mBorn;}
	public void setBorn(ObjectProperty<LocalDate> born) {this.mBorn = born;}
	
	public ObjectProperty<String> getEmail() {return mEmail;}
	public void setEmail(ObjectProperty<String> email) {this.mEmail = email;}
	
	public ObjectProperty<String> getAddress() {return mAddress;}
	public void setAddress(ObjectProperty<String> ad) {this.mAddress = ad;}
	
	public ObjectProperty<String> getPhone() {return mPhone;}
	public void setPhone(ObjectProperty<String> phone) {this.mAddress = phone;}
	
	public ObjectProperty<String> getDni() {return mDni;}
	public void setDni(ObjectProperty<String> ad) {this.mAddress = ad;}
	
	public DoubleProperty getHeight() {return mHeight;}
	public void setHeight(DoubleProperty height) {this.mHeight = height;}
	
	public DoubleProperty getWeight() {return mWeight;}
	public void setWeight(DoubleProperty weight) {this.mWeight = weight;}
	
	public BooleanProperty getLeague() {return mLeague;}
	public void setLeague(BooleanProperty league) {this.mLeague = league;}
	
	public BooleanProperty getTechGroup() {return mTechGroup;}
	public void setTechGroup(BooleanProperty techGroup) {this.mTechGroup = techGroup;}
	
	public ObjectProperty<String> getTraining() {return mTraining;}
	public void setTraining(ObjectProperty<String> train) {this.mTraining = train;}

}
