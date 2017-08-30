package ku.cs.calendar;

import java.util.ArrayList;

public class RunApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList dataBase = new ArrayList();
		dataBase.add("day1");
		dataBase.add("day2");
		Gui gui = new Gui(dataBase);
		gui.run(dataBase);
	}

}
