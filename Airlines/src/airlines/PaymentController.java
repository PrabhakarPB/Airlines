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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class PaymentController implements Initializable {
 
    @FXML
    private TextField number;

    @FXML
    private PasswordField cvv;

    @FXML
    private TextField amount;

    @FXML
    private TextField search;

    @FXML
    private Button Book;

    @FXML
    private AnchorPane payment;

    @FXML
    private TextField expiry;

    @FXML
    private TextField ticketid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ticketid.setEditable(false);
        amount.setEditable(false);
    }    
      
     Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Statement st = null;
    @FXML
    void book(ActionEvent event) {
  try {
               
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
                PreparedStatement add = con.prepareStatement("INSERT INTO payment VALUES(?,?,?,?,?)");
                add.setString(1, ticketid.getText());
                add.setString(2, amount.getText());
                add.setString(3,number.getText());
                add.setString(4, expiry.getText());
                add.setString(5, cvv.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(null, "Payment Sucessful");
                changeScenes.changeToScene(getClass(),event,"Main.fxml");
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
        @FXML
    void searchticket(ActionEvent event) {
try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
            String sql = "Select * From bookings Where ticketid=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, search.getText());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String setticketid = rs.getString("ticketid");
                ticketid.setText(setticketid);
                String setamount = rs.getString("Amount");
                amount.setText(setamount);
                
             

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }

