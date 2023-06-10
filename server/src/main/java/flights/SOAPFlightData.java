package flights;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


@XmlType(factoryMethod="createInstanceJAXB")
public class SOAPFlightData {
    // Data
    private static final int FLIGHTSPERPLANEPERDAY = 3;
    private static final String[] DATES = new String[]{"2021-12-6", "2021-12-7", "2021-12-8", "2021-12-9",
            "2021-12-10", "2021-12-11", "2021-12-12"};
    private static final String[] DESTINATIONS = new String[]{"Paris", "London", "Barcelona", "Dubai"};

    public ArrayList<Flight> flights = new ArrayList<>();

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    private static SOAPFlightData createInstanceJAXB() {
        return null;
    }

    public SOAPFlightData() {
        init();
    }

    public void init() {
        Flight flight;
        Random ran = new Random();
        for (int i = 0; i < DATES.length; i++) {
            for (int j = 0; j < FLIGHTSPERPLANEPERDAY - 1; j++) {

                // Airbus
                flight = new Flight();
                flight.setId(UUID.randomUUID().toString());
                flight.setType("Airbus");
                flight.setDeparture("Frankfurt");
                flight.setDestination(DESTINATIONS[ran.nextInt(DESTINATIONS.length)]);
                flight.setDate(DATES[i]);
                flight.initSeats();
                flights.add(flight);

                // Boeing
                flight = new Flight();
                flight.setId(UUID.randomUUID().toString());
                flight.setType("Boeing");
                flight.setDeparture("Chicago");
                flight.setDestination(DESTINATIONS[ran.nextInt(DESTINATIONS.length)]);
                flight.setDate(DATES[i]);
                flight.initSeats();
                flights.add(flight);

                // Airbus
                flight = new Flight();
                flight.setId(UUID.randomUUID().toString());
                flight.setType("Embraer");
                flight.setDeparture("Sao Paulo");
                flight.setDestination(DESTINATIONS[ran.nextInt(DESTINATIONS.length)]);
                flight.setDate(DATES[i]);
                flight.initSeats();
                flights.add(flight);
            }
        }
    }
}
