package ku.cs.calendar;
//Poramain Keawpan 5710404446 


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import java.awt.GridLayout;

public class Gui {

	private JFrame frame;
	private JTextField noteField;
	private JList list;
	private JComboBox dateBox;
	private DBConnecter dataBase = new DBConnecter();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Gui() throws SQLException {
		dataBase.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void run() {
		try {
			Gui window = new Gui();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() throws SQLException {
		frame = new JFrame("Calendar");
		frame.setBounds(100, 100, 250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		DatePicker dp  = new DatePicker();
//		dataBase.connect();
//		dp.addMark(dataBase.getData());
		final JPanel panel = new JPanel();
		panel.add(dp);
		
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
