package ku.cs.calendar;
//Poramain Keawpan 5710404446 
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

public class CalendarTest {

	@Test
	public void ScrpitTest() {
		ArrayList data = new ArrayList();
		data.add("test");
		Assert.assertEquals(Script.changeArrayToList(data)[0], "test");
	}
	
	@Test
	public void addDataTest() throws SQLException{
		DBConnecter db = new DBConnecter();
		db.connect();
		db.addData("01/01/2017", "01.00", "test1");
		db.connect();
		db.addData("01/01/2017", "01.00", "test2");
		db.connect();
		Assert.assertEquals(Script.changeArrayToList(db.getData())[0], "01/01/2017 : 01.00 : test1");
	}
	
	@Test
	//check if delete obj.1 and still have obj.2
	public void delete2DataTest() throws SQLException{
		DBConnecter db = new DBConnecter();
		db.connect();
		db.delete("01/01/2017", "01.00", "test1");
		db.connect();
		Assert.assertEquals(Script.changeArrayToList(db.getData())[0], "01/01/2017 : 01.00 : test2");
	}
	
	@Test
	//check if delete all obj.
	public void deleteDataTest() throws SQLException{
		DBConnecter db = new DBConnecter();
		db.connect();
		db.delete("01/01/2017", "01.00", "test2");
		db.connect();
		Assert.assertTrue(db.getData().isEmpty());
	}
	
}
