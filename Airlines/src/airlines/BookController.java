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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class BookController implements Initializable {

    @FXML
    private TextField Pname;

    @FXML
    private TextField amount;

    @FXML
    private TextField search;

    @FXML
    private TextField gender;

    @FXML
    private TextField nationality;

    @FXML
    private TextField flightcode;
 @FXML
    private Button Back;
    @FXML
    private Button Book;

    @FXML
    private TextField Ppnumber;

    @FXML
    private TextField SearchFlights;
    @FXML
    private TextField Passid;

    @FXML
    private AnchorPane Bolok;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Passid.setEditable(false);
        Pname.setEditable(false);
        gender.setEditable(false);
        nationality.setEditable(false);
        Ppnumber.setEditable(false);
        flightcode.setEditable(false);
        amount.setEditable(false);
    }    
        @FXML
    void Search(ActionEvent event) {
  try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
            String sql = "Select * From passengers Where pid=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, search.getText());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String setid = rs.getString("PId");
                Passid.setText(setid);
                String setname = rs.getString("PName");
                Pname.setText(setname);
                String setnationality = rs.getString("PNat");
                nationality.setText(setnationality);
                String setgender = rs.getString("PGen");
                gender.setText(setgender);
                String setppnumber = rs.getString("PPnumber");
                Ppnumber.setText(setppnumber);
             

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }                                  
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Statement st = null;
 
    

    @FXML
    void SearchFlights(ActionEvent event) {
try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
            String sql = "Select * From flight Where flightcode=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, SearchFlights.getText());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String setcode = rs.getString("flightcode");
                flightcode.setText(setcode);
                String setamount = rs.getString("Amount");
                amount.setText(setamount);
                
             

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    int TId = 0;

    private void Countflight() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select  Max(ticketid) From bookings");
            rs.next();
            TId = rs.getInt(1) + 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    void BookFlights(ActionEvent event) {
if (Pname.getText().isEmpty() || gender.getText().isEmpty() || amount.getText().isEmpty() || Ppnumber.getText().isEmpty() || nationality.getText().isEmpty()||Passid.getText().isEmpty()||flightcode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Information");

        } else {
            try {
                Countflight();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
                PreparedStatement add = con.prepareStatement("INSERT INTO bookings VALUES(?,?,?,?,?,?,?)");
                add.setInt(1, TId);
                add.setString(2, Pname.getText());
                add.setString(3,flightcode.getText());
                add.setString(4, gender.getText());
                add.setString(5, Ppnumber.getText());
                add.setString(6, amount.getText());
                add.setString(7, nationality.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ticket Booked");
                changeScenes.changeToScene(getClass(),event,"Payment.fxml");
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
     @FXML
    void Backbutton(ActionEvent event) throws Exception{
changeScenes.changeToScene(getClass(),event,"Main.fxml");
    }
}
