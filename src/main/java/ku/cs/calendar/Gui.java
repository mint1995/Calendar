package ku.cs.calendar;



import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;

public class Gui {

	private JFrame frame;
	private JTextField dateField;
	private JTextField timeField;
	private JTextField noteField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Gui(ArrayList dataBase) {
		initialize(dataBase);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void run(ArrayList dataBase) {
		try {
			Gui window = new Gui(dataBase);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initialize(ArrayList dataBase) {
		frame = new JFrame("Calendar");
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDate = new JLabel("Date");
		panel.add(lblDate);
		
		dateField = new JTextField();
		panel.add(dateField);
		dateField.setColumns(10);
		
		JLabel lblTime = new JLabel("Time");
		panel.add(lblTime);
		
		timeField = new JTextField();
		panel.add(timeField);
		timeField.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		panel.add(lblNote);
		
		noteField = new JTextField();
		panel.add(noteField);
		noteField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	String date = dateField.getText();
		    	String time = timeField.getText();
		    	String note = noteField.getText();
		    	
		    	
		    }
		});
		panel.add(btnAdd);
		
		JLabel lblDate_1 = new JLabel("Date");
		frame.getContentPane().add(lblDate_1, BorderLayout.NORTH);
		
		JList list = new JList(Script.changeArrayToList(dataBase));
		frame.getContentPane().add(list, BorderLayout.CENTER);
	}

}
