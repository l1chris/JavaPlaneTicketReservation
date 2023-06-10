package soap;


import javax.xml.ws.Endpoint;

//Endpoint publisher
public class ReservationBookingPublisher{

    public void publish() {
        Endpoint.publish("http://localhost:8090/ws/hello", new ReservationBookingService());
    }

}