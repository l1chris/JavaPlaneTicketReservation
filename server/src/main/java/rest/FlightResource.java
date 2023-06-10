package rest;

import flights.Flight;
import flights.FlightSeat;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


@Path( "flights" )
public class FlightResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getFlights() throws JAXBException {
        StringWriter sw = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(RESTFlightData.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(flightData, sw);

        String xmlString = sw.toString();
        return xmlString;
    }

    @Path("{seatID}")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response reserveSeat(@PathParam("seatID") String seatID, String clientID) {
        System.out.println("ClientID: " + clientID);
        System.out.println("SeatID: " + seatID);
        for (int i = 0; i < flightData.flights.size(); i++) {
            for (int j = 0; j < flightData.flights.get(i).seats.size(); j++) {
                // TODO If flight is not reserved, set it to reserved
                if (flightData.flights.get(i).seats.get(j).seatID.equals(seatID)) {
                    if (flightData.flights.get(i).seats.get(j).setReserved(clientID)) {
                        return Response.status(200).build();
                    }

                }

            }
        }
        //status code 404
        return Response.status(404).build();
    }

    // Data
    private static final int FLIGHTSPERPLANEPERDAY = 3;
    private static final String[] DATES = new String[]{"2021-12-6", "2021-12-7", "2021-12-8", "2021-12-9",
            "2021-12-10", "2021-12-11", "2021-12-12"};
    private static final String[] DESTINATIONS = new String[]{"Paris", "London", "Barcelona", "Dubai"};

    //RESTFlightData flightData = new RESTFlightData();

    static RESTFlightData flightData = new RESTFlightData();
    static
    {
        System.out.println("New Data");
        flightData.setFlights(new ArrayList<Flight>());

        Flight flight;
        Random ran = new Random();

        for (int i = 0; i < DATES.length; i++) {
            for (int j = 0; j < FLIGHTSPERPLANEPERDAY - 1; j++) {
                FlightSeat seat;

                // Airbus
                flight = new Flight();
                flight.setId(UUID.randomUUID().toString());
                flight.setType("Airbus");
                flight.setDeparture("Frankfurt");
                flight.setDestination(DESTINATIONS[ran.nextInt(DESTINATIONS.length)]);
                flight.setDate(DATES[i]);
                seat = new FlightSeat("01","A","First Class", flight.destination,false,false, UUID.randomUUID().toString());
                flight.getSeats().add(seat);
                seat = new FlightSeat("08","B","Economy Plus", flight.destination,false,false, UUID.randomUUID().toString());
                flight.getSeats().add(seat);
                seat = new FlightSeat("12","F","Economy", flight.destination,false,false, UUID.randomUUID().toString());
                flight.getSeats().add(seat);
                flightData.getFlights().add(flight);

                // Boeing
                flight = new Flight();
                flight.setId(UUID.randomUUID().toString());
                flight.setType("Boeing");
                flight.setDeparture("Chicago");
                flight.setDestination(DESTINATIONS[ran.nextInt(DESTINATIONS.length)]);
                flight.setDate(DATES[i]);
                seat = new FlightSeat("02","B","First Class", flight.destination,false,false, UUID.randomUUID().toString());
                flight.getSeats().add(seat);
                seat = new FlightSeat("07","C","Economy Plus", flight.destination,false,false, UUID.randomUUID().toString());
                flight.getSeats().add(seat);
                seat = new FlightSeat("26","B","Economy", flight.destination,false,false, UUID.randomUUID().toString());
                flight.getSeats().add(seat);
                flightData.getFlights().add(flight);

                // Embraer
                flight = new Flight();
                flight.setId(UUID.randomUUID().toString());
                flight.setType("Embraer");
                flight.setDeparture("Sao Paulo");
                flight.setDestination(DESTINATIONS[ran.nextInt(DESTINATIONS.length)]);
                flight.setDate(DATES[i]);
                seat = new FlightSeat("01","A","First Class",flight.destination,false,false, UUID.randomUUID().toString());
                flight.getSeats().add(seat);
                seat = new FlightSeat("07","D","Economy",flight.destination,false,false, UUID.randomUUID().toString());
                flight.getSeats().add(seat);
                seat = new FlightSeat("11","C","Economy",flight.destination,false,false, UUID.randomUUID().toString());
                flight.getSeats().add(seat);
                flightData.getFlights().add(flight);
            }
        }

    }
}