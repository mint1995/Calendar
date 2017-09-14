package ku.cs.calendar;
//Poramain Keawpan 5710404446 
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
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
            String dbURL = "jdbc:sqlite:newDB.db";
            conn = DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
 
    public ArrayList<String> getData() throws SQLException {
    	 String query = "Select * from date_table";
         java.sql.Statement statement = conn.createStatement();
         ResultSet resultSet = statement.executeQuery(query);
         ArrayList output = new ArrayList();
         
         while (resultSet.next()) {
        	String year = resultSet.getString(1);
        	String month = resultSet.getString(2);
        	String date = resultSet.getString(3);
         	String note = resultSet.getString(4);

         	output.add(date+"/"+month+"/"+year+"-"+note);
         }
         
         // close connection
         conn.close();
         
         return output;
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
