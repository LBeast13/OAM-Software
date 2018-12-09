package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * The Result class represents a result obtained by a Member with :
 * <ul>
 * 		<li>A competition name</li>
 * 		<li>A position</li>
 * 		<li>A category</li>
 * </ul>
 * 
 * @author Liam
 * @see Member 
 */
public class Result {
	
	//Will become a Competition object in the future
	/**
	 * The name of the competition.
	 */
	private ObjectProperty<String> mComp = new SimpleObjectProperty<>();
	
	/**
	 * The position obtained in the Competition.
	 */
	private IntegerProperty mPos = new SimpleIntegerProperty();
	
	/**
	 * The category in which the result was obtained.
	 */
	private ObjectProperty<String> mCat = new SimpleObjectProperty<>();
	
	/**
	 * The default Result constructor.
	 */
	public Result(){}
	
	/**
	 * The constructor of Result.
	 * 
	 * @param comp : the competition name
	 * @param pos : the position obtained
	 * @param cat : the category
	 */
	public Result(String comp, int pos, String cat){
		this.mComp.set(comp);
		this.mPos.set(pos);
		this.mCat.set(cat);
	}
	
// Getters and Setters -----------------------------------
	
	public ObjectProperty<String> getComp() {return mComp;}
	public void setComp(ObjectProperty<String> comp) {mComp = comp;}
	
	public IntegerProperty getPos() {return mPos;}
	public void setPos(IntegerProperty pos) {mPos = pos;}
	
	public ObjectProperty<String> getCat() {return mCat;}
	public void setCat(ObjectProperty<String> cat) {mCat = cat;}
}
