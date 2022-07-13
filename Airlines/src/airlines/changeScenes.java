/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PRABHAKAR BUDKULEY
 */
public class changeScenes {
    public static void changeToScene(Class aClass,Event aEvent,String sceneFileStr)throws Exception
    { 
    Parent root=FXMLLoader.load(aClass.getResource(sceneFileStr));
    Scene scene=new Scene(root);
     Stage mainStage=(Stage)((Node)aEvent.getSource()).getScene().getWindow();
    mainStage.setScene(scene);
    mainStage.show();
    }
}
