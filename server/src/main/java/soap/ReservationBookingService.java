package soap;

import flights.Flight;
import flights.SOAPFlightData;
import flights.FlightSeat;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

//Service Implementation
@WebService(endpointInterface = "soap.ReservationBooking")
public class ReservationBookingService implements ReservationBooking {

    ArrayList<String> clientsWithReservation = new ArrayList<>();
    ArrayList<Flight> flights;

    public ReservationBookingService() {
        SOAPFlightData flightData = new SOAPFlightData();
        this.flights = flightData.getFlights();
    }

    @Override
    public ArrayList<Flight> getFlights() {
        return this.flights;
    }

    @Override
    public boolean requestReservation(String clientID, String seatID) {
        if (this.clientsWithReservation.contains(clientID)) {
            return false;
        }
        System.out.println("seatID: " + seatID);
        for (int i = 0; i < this.flights.size(); i++) {
            for (int j = 0; j < this.flights.get(i).getSeats().size(); j++) {
                FlightSeat seat = (FlightSeat) this.flights.get(i).getSeats().get(j);
                if (seat.getSeatID().equals(seatID)) {
                    System.out.println("seat found");
                    if (seat.setReserved(clientID)) {
                        System.out.println("Successful reservation from Client: " + clientID);
                        this.clientsWithReservation.add(clientID);
                        return true;
                    }
                }

            }
        }
        return false;
    }
}