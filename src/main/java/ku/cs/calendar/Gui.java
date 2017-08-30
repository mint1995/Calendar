package ku.cs.calendar;



import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.FlowLayout;

public class Gui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Gui() {
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
	
	private void initialize() {
		frame = new JFrame("Calendar");
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDate = new JLabel("Date");
		panel.add(lblDate);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTime = new JLabel("Time");
		panel.add(lblTime);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		panel.add(lblNote);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		panel.add(btnAdd);
		
		JLabel lblDate_1 = new JLabel("Date");
		frame.getContentPane().add(lblDate_1, BorderLayout.NORTH);
		
		JList list = new JList();
		frame.getContentPane().add(list, BorderLayout.CENTER);
	}

}
