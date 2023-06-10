package rest;

import flights.Flight;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@XmlRootElement(name = "RESTFlightData")
@XmlType(factoryMethod="createInstanceJAXB")
@XmlAccessorType(XmlAccessType.FIELD)
public class RESTFlightData {

    @XmlElement(name = "Flight")
    public List<Flight> flights = null;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }


    private static RESTFlightData createInstanceJAXB() {
        return null;
    }



    public RESTFlightData() {}

}
