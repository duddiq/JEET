package lab1;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
public class DbManager {
    public static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL="jdbc:derby:D:\\Dane\\Michał\\Studia\\Semestr 5\\JEET\\Lab1\\db\\ludzie"; 
    public static final String QUERY="select * from app.untitled";
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        java.sql.Connection conn=DriverManager.getConnection(JDBC_URL);
        System.out.println("Połączono");
        
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(QUERY);
        ResultSetMetaData rsmd = rs.getMetaData();

        int colCount = rsmd.getColumnCount();

        for(int i=1; i<= colCount; i++)
            System.out.print(rsmd.getColumnName(i)+ " | ");

        while (rs.next()){
            System.out.println("");
            for (int i=1;i<=colCount;i++)
                System.out.print(rs.getString(i)+ " \t| ");
        }
        if (stat!=null) 
            stat.close();
        if (conn!=null) 
            conn.close();
        System.out.println("\nRozłączono");
    }
}
*/

public final class DbManager {
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL="jdbc:derby:D:\\Dane\\Michał\\Studia\\Semestr 5\\JEET\\Lab1\\db\\ludzie"; 
    public static final String QUERY="select * from app.untitled";
    private static java.sql.Connection conn;
    
    private DbManager() { }
    
    public static boolean Connect() throws ClassNotFoundException, SQLException {        
        conn = DriverManager.getConnection(JDBC_URL);
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
        
        for (int i = 1; i <= colCount; i++) {            
            wiersz = wiersz.concat(rsmd.getColumnName(i) + " \t| ");        
        }        
        wiersz = wiersz.concat("\r\n");
        
        while (rs.next()) {
            System.out.println("");
            for (int i = 1; i <= colCount; i++) {                
                wiersz = wiersz.concat(rs.getString(i) + " \t| ");            
            }            
            wiersz = wiersz.concat("\r\n");        
        }
        
        if (stat != null) { stat.close();  }  return wiersz;    } }