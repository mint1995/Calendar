package ku.cs.calendar;
//Poramain Keawpan 5710404446 
import static org.junit.Assert.*;

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
	public void addDataTest(){
		
	}
	

}
