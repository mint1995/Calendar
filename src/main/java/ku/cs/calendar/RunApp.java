package ku.cs.calendar;

import java.sql.SQLException;
import java.util.ArrayList;

public class RunApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		Gui gui = new Gui();
//		gui.run();
		DBConnecter db = new DBConnecter();
		db.connect();
		db.getData();
	}

}
