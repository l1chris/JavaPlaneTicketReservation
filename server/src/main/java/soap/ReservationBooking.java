package soap;

import flights.Flight;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ReservationBooking {

    @WebMethod ArrayList<Flight> getFlights();
    @WebMethod boolean requestReservation(String clientID, String seatID);


}
