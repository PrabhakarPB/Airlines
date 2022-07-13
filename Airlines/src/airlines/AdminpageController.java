/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class AdminpageController implements Initializable {
    @FXML
    private Button addflights;
    @FXML
    private Button Back;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    void addflights(ActionEvent event) throws Exception{
  changeScenes.changeToScene(getClass(),event,"AddFlights.fxml");
    }
      @FXML
    void Backbutton(ActionEvent event) throws Exception{
  changeScenes.changeToScene(getClass(),event,"Adminlogin.fxml");
    }
}
