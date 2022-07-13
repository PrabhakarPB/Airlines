/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class TicketCancelController implements Initializable {
    
    @FXML
    private DatePicker canceldate;

    @FXML
    private TextField Ticketid;

    @FXML
    private Button Cancel;
    @FXML
    private Button Back;
    @FXML
    private TextField FCode;

    @FXML
    private AnchorPane CancePanel;
    @FXML
    private TextField Cancelid;
    @FXML
    private TextField SearchTicket;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       Ticketid.setEditable(false);
    FCode.setEditable(false); 
    }  
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Statement st = null;
    
     private void cancel()
  {try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();
  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
  String qyery ="Delete From bookings where ticketid="+Ticketid.getText();          
  Statement del=con.createStatement();
  del.executeUpdate(qyery);
  }
  catch(Exception e)
          {
           JOptionPane.showMessageDialog(null, e);
          }
  }
  int CId=0;
  private void CountCancelid()
  {
  try
  {
  st=con.createStatement();
  rs=st.executeQuery("Select  Max(cancelid) From ticketcancellation");
  rs.next();
  CId=rs.getInt(1)+1;
  
  }
  catch(Exception e)
  {
 JOptionPane.showMessageDialog(null, e);
  }
  }
  
      @FXML
    void Cancel(ActionEvent event) {
    if (FCode.getText().isEmpty()||Ticketid.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Invalid Information");

        } else {
            try {CountCancelid();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
                PreparedStatement add = con.prepareStatement("INSERT INTO ticketcancellation VALUES(?,?,?,?)");
                add.setInt(1,CId);      
                add.setString(2,Ticketid.getText());
                add.setString(3,FCode.getText());
                add.setString(4,canceldate.getEditor().getText());
                
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                cancel();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @FXML
    void SeatchTicket(ActionEvent event) {
try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
            String sql = "Select * From bookings Where ticketid=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, SearchTicket.getText());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String setticketid = rs.getString("ticketid");
                Ticketid.setText(setticketid);
                String setcode = rs.getString("flightcode");
                FCode.setText(setcode);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        @FXML
    void Backbutton(ActionEvent event) throws Exception{
 changeScenes.changeToScene(getClass(),event,"Main.fxml");
    }
}