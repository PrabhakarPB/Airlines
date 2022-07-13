/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class AdminloginController implements Initializable {
  @FXML
    private PasswordField adminpassword;

    @FXML
    private TextField adminid;

    @FXML
    private Button back;

    @FXML
    private Button login;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     Connection con=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
        @FXML
    void adminlogin(ActionEvent event) throws Exception{
   con=mysqlconnect.ConnectDb();
    String sql="Select * from adminlogin where adminid=? and adminpassword=? ";
    try
    {
    pstmt=con.prepareStatement(sql);
    pstmt.setString(1,adminid.getText());
    pstmt.setString(2,adminpassword.getText());

    rs=pstmt.executeQuery();

    if(rs.next())
    {
    JOptionPane.showMessageDialog(null,"Login Successful");
    changeScenes.changeToScene(getClass(),event,"adminpage.fxml");
    }
    else
    {
    JOptionPane.showMessageDialog(null, "Invalid Email or password");
    }
    }
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(null,e);
    }
    }

    @FXML
    void back(ActionEvent event)throws Exception {
  changeScenes.changeToScene(getClass(),event,"Login.fxml");
    }
}
