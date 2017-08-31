package ku.cs.calendar;

import java.util.ArrayList;

public class virtualDB {
	private static ArrayList dataBase = new ArrayList();
	
	public static void addData(String data){
		dataBase.add(data);
		//System.out.println("success");
	}
	
	public static ArrayList getData(){
		return dataBase;
		
	}
}
