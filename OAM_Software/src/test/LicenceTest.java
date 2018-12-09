package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Licence;

public class LicenceTest {
	
	private static ArrayList<Licence> licencesTest = new ArrayList<Licence>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Case 1
		Calendar calendar = new GregorianCalendar(13,8,2018);
		//licencesTest.add(new Licence("AAAAAA",false,"BBBBBB", calendar));
		
		//Case 2
		calendar = new GregorianCalendar(19,10,2019);
		//licencesTest.add(new Licence("BBBBBB",true,"CCCCCC", calendar));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetId() {
		//for(Licence l : licencesTest){
			assertEquals("The ID is correct.",true ,licencesTest.get(0).getId().get().equals("AAAAAA"));
		//}
		
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCountry() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCountry() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExpirDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetExpirDate() {
		fail("Not yet implemented");
	}

}
