import gui.SoapGUI;
import gui.RestGUI;
import rest.RESTFlightData;
import soap.ArrayListOfFlight;
import soap.ReservationBooking;
import soap.ReservationBookingServiceService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.*;

import java.io.StringReader;
import java.util.UUID;


public class ClientMain {


    public static void main(String[] args) throws JAXBException {
        UUID clientID = UUID.randomUUID();

        // SOAP
        ReservationBookingServiceService service = new ReservationBookingServiceService();
        ReservationBooking reservationBooking = service.getReservationBookingServicePort();
        ArrayListOfFlight flights = reservationBooking.getFlights();
        SoapGUI soapGUI = new SoapGUI("SOAP-GUI", flights, reservationBooking, clientID);

        // REST
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/rest");
        WebTarget employeeWebTarget = webTarget.path("flights");
        Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();

        String s = response.readEntity(String.class);

        JAXBContext jaxbContext = JAXBContext.newInstance(RESTFlightData.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        RESTFlightData restFlightData = (RESTFlightData) jaxbUnmarshaller.unmarshal(new StringReader(s));
        RestGUI restGUI = new RestGUI("REST-GUI", restFlightData.flights, clientID);

    }
}
