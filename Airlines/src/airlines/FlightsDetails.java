/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author PRABHAKAR BUDKULEY
 */
public class FlightsDetails {
  String flightcode,flightsource,flightdestination,flightdate,Amount,flightseats;

    public FlightsDetails(String flightcode, String flightsource, String flightdestination, String flightdate, String Amount, String flightseats) {
        this.flightcode = flightcode;
        this.flightsource = flightsource;
        this.flightdestination = flightdestination;
        this.flightdate = flightdate;
        this.Amount = Amount;
        this.flightseats = flightseats;
    }

    public String getFlightcode() {
        return flightcode;
    }

    public void setFlightcode(String flightcode) {
        this.flightcode = flightcode;
    }

    public String getFlightsource() {
        return flightsource;
    }

    public void setFlightsource(String flightsource) {
        this.flightsource = flightsource;
    }

    public String getFlightdestination() {
        return flightdestination;
    }

    public void setFlightdestination(String flightdestination) {
        this.flightdestination = flightdestination;
    }

    public String getFlightdate() {
        return flightdate;
    }

    public void setFlightdate(String flightdate) {
        this.flightdate = flightdate;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getFlightseats() {
        return flightseats;
    }

    public void setFlightseats(String flightseats) {
        this.flightseats = flightseats;
    }
    
  

}
