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
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class AddPassengersController implements Initializable {
  @FXML
    private TextField Pphone;

    @FXML
    private TextField PName;

    @FXML
    private TextField Ppnumber;

    @FXML
    private TextField Search;
    @FXML
    private Button Save;

    @FXML
    private TextField Pid;
 @FXML
    private Button Back;
    @FXML
    private TextField PAddress;

    @FXML
    private ComboBox<String> pnationality;
    @FXML
    private Button Update;
    @FXML
    private ComboBox<String> pgender;
    @FXML
    private AnchorPane AddPassengers;
  
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
ObservableList<String> Nationality=FXCollections.observableArrayList("INDIA", "US", "UK", "AUSTALIA");
pnationality=new ComboBox<String>(Nationality);
pnationality.getItems().addAll("INDIA", "US", "UK", "AUSTALIA");
pnationality.setValue("INDIA");
ObservableList<String> gender=FXCollections.observableArrayList("Male", "Female");
pgender=new ComboBox<String>(gender);
pgender.getItems().addAll("MALE", "FEMALE");
pgender.setValue("MALE");
    }  
        Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Statement st = null;
        int PId = 0;

    private void CountPassengers() {
     
           try {
            st = con.createStatement();
            rs = st.executeQuery("Select MAX(PId) from passengers");
            rs.next();
            PId = rs.getInt(1) + 1;
        } catch (Exception e) {
            
JOptionPane.showMessageDialog(null, e);
        }
    }

    private void clear() {
        PName.setText("");
        Ppnumber.setText("");
        PAddress.setText("");
        Pphone.setText("");
    }

    
     @FXML
    void SaveHandler(ActionEvent event) {
   if (PName.getText().isEmpty() || Ppnumber.getText().isEmpty() || PAddress.getText().isEmpty() || Pphone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Information");

        } else {
       try {
                CountPassengers();
               
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
                PreparedStatement add = con.prepareStatement("INSERT INTO passengers VALUES(?,?,?,?,?,?,?)");
                add.setInt(1, PId);
                add.setString(2, PName.getText());
                add.setString(3, pnationality.getValue());
                add.setString(4, pgender.getValue());
                add.setString(5, Ppnumber.getText());
                add.setString(6, PAddress.getText());
                add.setString(7, Pphone.getText());
                add.execute();
                JOptionPane.showMessageDialog(null, "PASSENGER ADDED SUCCESSFULLY");
                //DisplayPassengers();
                clear();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
   }
    }
       @FXML
    void Update(ActionEvent event) {
 try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
            String value = Pid.getText();
            String query = "UPDATE passengers SET PName=?,PNat=?,PGen=?,PPnumber=?,PAdress=?,PPhone=? WHERE PId=" + value;
            PreparedStatement add = con.prepareStatement(query);
            add.setString(1, PName.getText());
            add.setString(2, pnationality.getValue());
            add.setString(3, pgender.getValue());
            add.setString(4, Ppnumber.getText());
            add.setString(5, PAddress.getText());
            add.setString(6, Pphone.getText());
            add.executeUpdate();
            JOptionPane.showMessageDialog(null, "PASSENGER UPDATED SUCCESSFULLY");
            
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        @FXML
    void Search(ActionEvent event) {
  try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "");
            String sql = "Select * From passengers Where PId=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Search.getText());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String setid = rs.getString("PId");
                Pid.setText(setid);
                String setname = rs.getString("PName");
                PName.setText(setname);
                String setnationality = rs.getString("PNat");
                pnationality.setValue(setnationality);
                String setgender = rs.getString("PGen");
                pgender.setValue(setgender);
                String setppnumber = rs.getString("PPnumber");
                Ppnumber.setText(setppnumber);
                String setaddress = rs.getString("PAdress");
                PAddress.setText(setaddress);
                String setphone = rs.getString("PPhone");
                Pphone.setText(setphone);

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
