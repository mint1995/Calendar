package ku.cs.calendar;

import java.util.ArrayList;

public class RunApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList dataBase = new ArrayList();
		dataBase.add("day1 : 12.00PM : take med");
		dataBase.add("16/3/2017 : 16.30 : meet jim");
		Gui gui = new Gui(dataBase);
		gui.run(dataBase);
	}

}
