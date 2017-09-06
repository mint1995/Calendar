package ku.cs.calendar;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
 * This program demonstrates making JDBC connection to a SQLite database.
 * @author www.codejava.net
 *
 */
public class DBConnecter {
	
	private Connection conn;
	
	public void connect(){
		try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:carlendar.db";
            conn = DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
 
    public void getData() throws SQLException {
    	 String query = "Select * from carlendarData";
         java.sql.Statement statement = conn.createStatement();
         ResultSet resultSet = statement.executeQuery(query);
         
         while (resultSet.next()) {
         	String date = resultSet.getString(1);
         	String time = resultSet.getString(2);
         	String note = resultSet.getString(3);

         	System.out.println("Date:"+date+" Time:"+time+" Note: "+note);
         }
         
         // close connection
         conn.close();
    }
    
    public void addData(String date,String time,String note) throws SQLException{
//    	INSERT INTO table_name (column1, column2, column3, ...)
//    	VALUES (value1, value2, value3, ...);
    	String sql = "INSERT INTO carlendarData(Date, Time, Note) VALUES(?,?,?)";
    	PreparedStatement pstmt = conn.prepareStatement(sql);{
    		pstmt.setString(1, date);
            pstmt.setString(2, time);
            pstmt.setString(3, note);
            pstmt.executeUpdate();
    	}
    	
    	// close connection
        conn.close();
    }
    
    public void delete(String date, String time, String note) throws SQLException {
        String sql = "DELETE FROM carlendarData WHERE (date = ? AND time = ? AND note = ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);{
            pstmt.setString(1, date);
            pstmt.setString(2, time);
            pstmt.setString(3, note);
            pstmt.executeUpdate();
        }
        
        // close connection
        conn.close();
    }
}
