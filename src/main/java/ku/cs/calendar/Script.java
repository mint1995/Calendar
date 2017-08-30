package ku.cs.calendar;

import java.util.ArrayList;

public class Script {
	public static String[] changeArrayToList(ArrayList array){
		int size = array.size();
		String[] list = new String[size];
		for(int i=0; i<size; i++){
			list[i]=(String) array.get(i);
		}
		return list;
	}
}
