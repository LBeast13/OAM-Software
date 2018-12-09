package model;

import java.time.LocalDate;
import java.util.Calendar;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * The Belt class represents a Martial Art Belt with :
 * <ul>
 * 		<li>A color</li>
 * 		<li>An obtention date</li>
 * </ul>
 * @author Liam
 *
 */
public class Belt {
	
	/**
	 * The color of the Belt.
	 */
	private ObjectProperty<String> mColor = new SimpleObjectProperty<String>();
	
	/**
	 * The obtention date of the Belt.
	 */
	private ObjectProperty<LocalDate> mObtenDate = new SimpleObjectProperty<LocalDate>();

	/**
	 * The default Belt constructor
	 */
	public Belt(){}
	
	/**
	 * The constructor of Belt
	 * @param color : the color of the Belt
	 * @param obtenDate : the Obtention date of the Belt.
	 */
	public Belt(String color, LocalDate obtenDate){
		this.mColor.set(color);
		this.mObtenDate.set(obtenDate);
	}
	
// Getters and Setters -------------------------------
	
	public ObjectProperty<String> getColor() {return mColor;}
	public void setColor(ObjectProperty<String> color) {mColor = color;}
	
	public ObjectProperty<LocalDate> getObtenDate() {return mObtenDate;}
	public void setObtenDate(ObjectProperty<LocalDate> obtenDate) {mObtenDate = obtenDate;}
}
