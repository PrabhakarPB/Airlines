/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class SignUpController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private TextField fname;

         @FXML
    private Button Back;
    @FXML
    private TextField lname;

    @FXML
    private PasswordField password;

    @FXML
    private TextField mobile;

    @FXML
    private Button signUp;

    @FXML
    private AnchorPane signupPane;
    
    @FXML
    private TextField email;
Connection con=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    @FXML
    void signUpButton(ActionEvent event) {
      con=mysqlconnect.ConnectDb();
     try{
String sql="INSERT INTO login(fname,lname,mobile,email,password) VALUES(?,?,?,?,?)";
    pstmt=con.prepareStatement(sql);
    pstmt.setString(1,fname.getText());
    pstmt.setString(2,lname.getText());
    pstmt.setString(3,mobile.getText());
    pstmt.setString(4,email.getText());
    pstmt.setString(5,password.getText());
    pstmt.execute();
  if(fname.getText().length()==0)
  {
  JOptionPane.showMessageDialog(null, "Add the First Name");
  }
  else if(lname.getText().length()==0)
  {
  JOptionPane.showMessageDialog(null, "Add the Last Name");
  }
  else if(mobile.getText().length()==0)
  {
  JOptionPane.showMessageDialog(null, "Add the Mobile Number");
  }
  else if(email.getText().length()==0)
  {
  JOptionPane.showMessageDialog(null, "Add the email");
  }
  else if(password.getText().length()==0 )
  {
  JOptionPane.showMessageDialog(null, "Add the password");
  }
  else{
JOptionPane.showMessageDialog(null, fname.getText()+" is successfully added");
con.close();
  }
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e);
} 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void Backbutton(ActionEvent event)throws Exception {
         changeScenes.changeToScene(getClass(),event,"Login.fxml");

    }

}
