package model;

import java.time.LocalDate;
import java.util.Calendar;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;


/**
 * The Licence Class represents a Licence of a Member with :
 * <ul>
 * 		<li>An ID</li>
 * 		<li>A type (national or international)</li>
 * 		<li>A country</li>
 * 		<li>An expiration date</li>
 * </ul>
 * @author Liam
 * 
 * @see Member
 *
 */
public class Licence {
	
	/**
	 * The Licence ID Number.
	 */
	private ObjectProperty<String> mId = new SimpleObjectProperty<>();
	
	/**
	 * The type of the Licence.
	 * 0 = National
	 * 1 = International
	 */
	private BooleanProperty mType = new SimpleBooleanProperty();	

	/**
	 * The country of the Licence.
	 */
	private ObjectProperty<String> mCountry = new SimpleObjectProperty<>();
	
	/**
	 * The expiration date for the Licence.
	 */
	private ObjectProperty<LocalDate> mExpirDate = new SimpleObjectProperty<LocalDate>();
	
	
	/**
	 * The default Licence contructor.
	 */
	public Licence(){}
	
	/**
	 * The constructor of Licence.
	 * @param id : The id of the Licence
	 * @param type : The type of the Licence (0 = National, 1 = International)
	 * @param country : The country of the Licence
	 * @param expirDate : The expiration date of the Licence
	 */
	public Licence(String id, boolean type, String country, LocalDate expirDate){
		this.mId.set(id);
		this.mType.set(type);
		this.mCountry.set(country);
		this.mExpirDate.set(expirDate);
	}
	
// Getters and setters ----------------------------------
	
	public ObjectProperty<String> getId() {return mId;}
	public void setId(ObjectProperty<String> id) {this.mId = id;}
	
	public BooleanProperty getType() {return mType;}
	public void setType(BooleanProperty type) {this.mType = type;}
	
	public ObjectProperty<String> getCountry() {return mCountry;}
	public void setCountry(ObjectProperty<String> country) {this.mCountry = country;}
	
	public ObjectProperty<LocalDate> getExpirDate() {return mExpirDate;}
	public void setExpirDate(ObjectProperty<LocalDate> expirDate) {this.mExpirDate = expirDate;}
}
