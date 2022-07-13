
package airlines;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
/**
 *
 * @author PRABHAKAR BUDKULEY
 */
public class mysqlconnect {
   Connection con=null;
   public static Connection ConnectDb()
   {
   try
   {
       Class.forName("com.mysql.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost/airlines","root","");
   return con;
   }
   catch(Exception e)
   {
   JOptionPane.showMessageDialog(null, e);
   return null;
   }
   }

 
  /*  public static ObservableList<PassengersTable> getDataPassengers()
   {
   Connection con=ConnectDb();
   ObservableList<PassengersTable> passengerslist=FXCollections.observableArrayList();
   
   try
   {
   PreparedStatement ps=con.prepareStatement("Select * From passengers");
   ResultSet rs=ps.executeQuery();
   while(rs.next())
   {
   passengerslist.add(new PassengersTable(Integer.parseInt(rs.getString("Pid")),rs.getString("Pname"),rs.getString("pnationality"),rs.getString("pgender"),rs.getString("Ppnumber"),rs.getString("Paddress"),rs.getString("Pphone")));
   }
   }
   catch(Exception e)
   {
  JOptionPane.showMessageDialog(null, e);
   }
   return passengerslist;
   }*/
}
