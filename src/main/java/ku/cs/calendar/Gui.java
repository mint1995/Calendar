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
	JList list;
	JComboBox dateBox;
	DBConnecter dataBase = new DBConnecter();

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
		frame.setBounds(100, 100, 650, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		final JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		dataBase.connect();
		String[] data = null;
		if(dataBase.getData().isEmpty()){
			data = new String[1];
			data[0] = "no data";
		}
		else{
			dataBase.connect();
			data = Script.changeArrayToList(dataBase.getData());
		}
		list = new JList(data);
		frame.getContentPane().add(list, BorderLayout.CENTER);
		
		final JLabel lblDate = new JLabel("Date");
		panel.add(lblDate);
		
		String[] date = new String[30];
		for(int i=0;i<30;i++){
			if(i<9){
				date[i] = "0"+(i+1);
			}
			else{
				date[i] = (i+1)+"";
			}
		}
		dateBox = new JComboBox(date);
		panel.add(dateBox);
		
		String[] month = new String[12];
		for(int i=0;i<12;i++){
			if(i<9){
				month[i] = "0"+(i+1);
			}
			else{
				month[i] = (i+1)+"";
			}
		}
		final JComboBox monthBox = new JComboBox(month);
		
		panel.add(monthBox);
		
		String[] year = new String [20];
		for(int i=0;i<20;i++){
			year[i] = (2017+i)+"";
		}
		final JComboBox yearBox = new JComboBox(year);
		panel.add(yearBox);
		
		final JLabel lblTime = new JLabel("Time");
		panel.add(lblTime);
		
		String[] hour = new String[24];
		for(int i=0;i<24;i++){
			if(i<9){
				hour[i] = "0"+(i+1);
			}
			else{
				hour[i] = (i+1)+"";
			}
		}
		final JComboBox hourBox = new JComboBox(hour);
		panel.add(hourBox);
		
		String[] minute = new String[61];
		for(int i=0;i<61;i++){
			if(i<10){
				minute[i] = "0"+i;
			}
			else{
				minute[i] = i+"";
			}
		}
		final JComboBox minuteBox = new JComboBox(minute);
		panel.add(minuteBox);
		
		final JLabel lblNote = new JLabel("Note");
		panel.add(lblNote);
		
		noteField = new JTextField();
		panel.add(noteField);
		noteField.setColumns(10);
		
		final JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	String day = (String) dateBox.getSelectedItem();
		    	String month = (String) monthBox.getSelectedItem();
		    	String year = (String) yearBox.getSelectedItem();
		    	String hour = (String) hourBox.getSelectedItem();
		    	String minute = (String) minuteBox.getSelectedItem();
		    	String note = noteField.getText();
		    	
		    	String date = day+"/"+month+"/"+year; 
		    	String time = hour+"."+minute;
		    	
		    	try {
		    		dataBase.connect();
					dataBase.addData(date, time, note);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	//refresh window
		    	try {
		    		dataBase.connect();
					list = new JList(Script.changeArrayToList(dataBase.getData()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	frame.getContentPane().add(list, BorderLayout.CENTER);
		    	frame.revalidate();
		    	
		    	//reset input field
		    	noteField.setText("");
		    }
		});
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String day = (String) dateBox.getSelectedItem();
		    	String month = (String) monthBox.getSelectedItem();
		    	String year = (String) yearBox.getSelectedItem();
		    	String hour = (String) hourBox.getSelectedItem();
		    	String minute = (String) minuteBox.getSelectedItem();
		    	String note = noteField.getText();
		    	
		    	String date = day+"/"+month+"/"+year; 
		    	String time = hour+"."+minute;
		    	
		    	dataBase.connect();
				try {
					dataBase.delete(date, time, note);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//refresh window
				try {
		    		dataBase.connect();
					list = new JList(Script.changeArrayToList(dataBase.getData()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				frame.getContentPane().add(list, BorderLayout.CENTER);
		    	frame.revalidate();
		    	
		    	//reset input field
		    	noteField.setText("");
			}
			
			
		});
		panel.add(btnDelete);
		
		monthBox.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(monthBox.getSelectedIndex()==1){
					
					panel.remove(lblDate);
					panel.remove(dateBox);
					panel.remove(monthBox);
					panel.remove(yearBox);
					panel.remove(lblTime);
					panel.remove(hourBox);
					panel.remove(minuteBox);
					panel.remove(lblNote);
					panel.remove(noteField);
					panel.remove(btnAdd);
					
					String[] date = new String[28];
					
					for(int i=0;i<28;i++){
						if(i<9){
							date[i] = "0"+(i+1);
						}
						else{
							date[i] = (i+1)+"";
						}
					}
					
					dateBox = new JComboBox(date);
					
					panel.add(lblDate);
					panel.add(dateBox);
					panel.add(monthBox);
					panel.add(yearBox);
					panel.add(lblTime);
					panel.add(hourBox);
					panel.add(minuteBox);
					panel.add(lblNote);
					panel.add(noteField);
					panel.add(btnAdd);
					panel.revalidate();
				}
				else{						
						panel.remove(lblDate);
						panel.remove(dateBox);
						panel.remove(monthBox);
						panel.remove(yearBox);
						panel.remove(lblTime);
						panel.remove(hourBox);
						panel.remove(minuteBox);
						panel.remove(lblNote);
						panel.remove(noteField);
						panel.remove(btnAdd);
						
						String[] date = new String[30];
						
						for(int i=0;i<30;i++){
							if(i<9){
								date[i] = "0"+(i+1);
							}
							else{
								date[i] = (i+1)+"";
							}
						}
						
						dateBox = new JComboBox(date);
						
						panel.add(lblDate);
						panel.add(dateBox);
						panel.add(monthBox);
						panel.add(yearBox);
						panel.add(lblTime);
						panel.add(hourBox);
						panel.add(minuteBox);
						panel.add(lblNote);
						panel.add(noteField);
						panel.add(btnAdd);
						panel.revalidate();
				}
			}
			
		});
		
		JLabel lblDate_1 = new JLabel("Date");
		frame.getContentPane().add(lblDate_1, BorderLayout.NORTH);
	}

}
