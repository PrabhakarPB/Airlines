/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author PRABHAKAR BUDKULEY
 */
public class DisplayFlightsController implements Initializable {
    @FXML
    private TableColumn<FlightsDetails, String> Famount;

    @FXML
    private TableColumn<FlightsDetails, String> Fdestination;

    @FXML
    private Button Back;
    @FXML
    private TableView<FlightsDetails> FlightsTable;

    @FXML
    private TableColumn<FlightsDetails, String> Fsource;

    @FXML
    private TableColumn<FlightsDetails, String> Fcode;
   @FXML
    private TableColumn<FlightsDetails, String> fseats;
    @FXML
    private TableColumn<FlightsDetails, String> Fdate;
ObservableList<FlightsDetails> table=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      try{  Connection con=mysqlconnect.ConnectDb();
        ResultSet rs=con.createStatement().executeQuery("Select * From flight");
        while(rs.next())
        {
        table.add(new FlightsDetails(rs.getString("flightcode"),rs.getString("flightsource"),rs.getString("flightdestination"),rs.getString("flightdate"),rs.getString("flightseats"),rs.getString("Amount")));
        }
      }
      catch(Exception e)
      {
      
      }
      Fcode.setCellValueFactory(new PropertyValueFactory<>("flightcode"));
      Fsource.setCellValueFactory(new PropertyValueFactory<>("flightsource"));
          Fdestination.setCellValueFactory(new PropertyValueFactory<>("flightdestination"));
              Fdate.setCellValueFactory(new PropertyValueFactory<>("flightdate"));
          fseats.setCellValueFactory(new PropertyValueFactory<>("flightseats"));
                  Famount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
FlightsTable.setItems(table);
    }    
    @FXML
    void Backbutton(ActionEvent event)throws Exception {
changeScenes.changeToScene(getClass(),event,"Main.fxml");
    }

}
