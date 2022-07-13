/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
   @FXML
    private Button cancel;

    @FXML
    private Button Passengers;

    @FXML
    private Button book;

    @FXML
    private AnchorPane main;

    @FXML
    private Button flights;

       @FXML
    void PassengersButton(ActionEvent event) throws Exception{
changeScenes.changeToScene(getClass(),event,"AddPassengers.fxml");
    }

     @FXML
    void flightsbutton(ActionEvent event) throws Exception{
changeScenes.changeToScene(getClass(),event,"DisplayFlights.fxml");
    }

    @FXML
    void book(ActionEvent event) throws Exception{
changeScenes.changeToScene(getClass(),event,"Book.fxml");
    }

    @FXML
    void cancel(ActionEvent event) throws Exception{
changeScenes.changeToScene(getClass(),event,"TicketCancel.fxml");
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
}
