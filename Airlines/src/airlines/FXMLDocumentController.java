/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
/**
 *
 * @author PRABHAKAR BUDKULEY
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button next;

    @FXML
    private Circle c3;

    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    void next(ActionEvent event)throws Exception {
        changeScenes.changeToScene(getClass(),event,"Login.fxml");

    }
}
