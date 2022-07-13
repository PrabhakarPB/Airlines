/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
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
public class AddFlightsController implements Initializable {

    @FXML
    private ComboBox<String> Fdestination;

    @FXML
    private ComboBox<String> Fsource;

    @FXML
    private TextField FCode;
    
    @FXML
    private AnchorPane AddFlights;
        @FXML
    private Button Back;
    @FXML
    private Button Save;

    @FXML
    private DatePicker FDate;
    @FXML
    private TextField amount;
    @FXML
    private TextField Fseats;
    /**
     * Initializes the controller class.
     * * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Fsource.getItems().addAll("Banglore","Mumbai","Delhi","Chennai");
Fsource.setValue("Banglore");
Fdestination.getItems().addAll("Banglore","Mumbai","Delhi","Chennai");
Fdestination.setValue("Mumbai");
    }  
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Statement st = null;
    @FXML
    void SaveFlights(ActionEvent event) {
      if (FCode.getText().isEmpty() || Fseats.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Information");

        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
              pstmt = con.prepareStatement("INSERT INTO flight(flightcode,flightsource,flightdestination,flightdate,flightseats,Amount) VALUES(?,?,?,?,?,?)");
                pstmt.setString(1, FCode.getText());
                pstmt.setString(2, Fsource.getValue());
                pstmt.setString(3, Fdestination.getValue());
                pstmt.setString(4,FDate.getEditor().getText());
                pstmt.setInt(5, Integer.valueOf(Fseats.getText()));
                pstmt.setString(6, amount.getText());
                pstmt.execute();
                JOptionPane.showMessageDialog(null, "Flights added");
                
                con.close();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    @FXML
    void Backbutton(ActionEvent event) throws Exception{
changeScenes.changeToScene(getClass(),event,"Adminlogin.fxml");
    }
}
