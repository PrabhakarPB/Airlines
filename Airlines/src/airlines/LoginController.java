/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class LoginController implements Initializable {
    
    @FXML
    private AnchorPane loginPane;
    @FXML
    private TextField email;
        @FXML
    private Button loginasadmin;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
       @FXML
    private Button signup;

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
    private void loginButton(ActionEvent event) {
     
      con=mysqlconnect.ConnectDb();
    String sql="Select * from login where email=? and password=? ";
    try
    {
    pstmt=con.prepareStatement(sql);
    pstmt.setString(1,email.getText());
    pstmt.setString(2,password.getText());

    rs=pstmt.executeQuery();

    if(rs.next())
    {
    JOptionPane.showMessageDialog(null,"Login Successful");
    changeScenes.changeToScene(getClass(),event,"Main.fxml");
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
    void signupbutton(ActionEvent event)throws Exception {
changeScenes.changeToScene(getClass(),event,"SignUp.fxml");
    }
        @FXML
    void loginasadmin(ActionEvent event)throws Exception  {
 changeScenes.changeToScene(getClass(),event,"Adminlogin.fxml");
    }
}
