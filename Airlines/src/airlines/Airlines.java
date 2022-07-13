/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PRABHAKAR BUDKULEY
 */
public class Airlines extends Application {
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stg=primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("AddFlights.fxml"));
        primaryStage.setTitle("Airlines");
        primaryStage.setScene(new Scene(root,1180,750));
       primaryStage.show();
    }
    public void changeScene(String fxml)throws Exception
    {
    Parent pane=FXMLLoader.load(getClass().getResource(fxml));
    stg.getScene().setRoot(pane);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
