package Dane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class DbManager {
    public static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    public static final String JDBC_URL="jdbc:derby://localhost:1527/homework2"; 
    public static final String QUERY="select * from student.shoes";
    public static java.sql.Connection conn;
    
    
    
    private DbManager() { }
    
    public static boolean Connect() throws ClassNotFoundException, SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "student");
        connectionProps.put("password", "wcy");
        conn = DriverManager.getConnection(JDBC_URL, connectionProps);
        if (conn == null) {
            return false;        
        } else {
            return true;
        }    
    }
    
    public static boolean Disconnect() throws SQLException {
        if (conn == null) {
            return false;        
        } else {            
            conn.close();
            return true;        
        }
    }
    
    public static String getData() throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(QUERY);
        ResultSetMetaData rsmd = rs.getMetaData();
        String wiersz = new String();
        
        int colCount = rsmd.getColumnCount();
        wiersz = wiersz.concat("<table><tr>");
        
        for (int i = 1; i <= colCount; i++) {            
            wiersz = wiersz.concat(" <td><b> " + rsmd.getColumnName(i) + "</b></td> ");
        }        
        wiersz = wiersz.concat("</tr>");
        
        while (rs.next()) {
            wiersz = wiersz.concat("<tr>");
            for (int i = 1; i <= colCount; i++) {                
                wiersz = wiersz.concat(" <td> " + rs.getString(i) + " </td> ");            
            }            
            wiersz = wiersz.concat("</tr>");
        }
        wiersz = wiersz.concat("</table>");
        
        if (stat != null) { 
            stat.close();  
        }  
        return wiersz;    
    }
}