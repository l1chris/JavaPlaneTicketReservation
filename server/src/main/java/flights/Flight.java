package flights;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.UUID;

@XmlRootElement(name = "flight")
@XmlType(factoryMethod="createInstanceJAXB")
public class Flight {

    public String id;
    public String date;
    public String type;
    public String departure;
    public String destination;
    public ArrayList<FlightSeat> seats = new ArrayList<>();

    public Flight() {}

    private static Flight createInstanceJAXB() {
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void initSeats() {
        switch (this.type) {
            case "Airbus":
                initAirbusSeats();
                break;
            case "Boeing":
                initBoeingSeats();
                break;
            case "Embraer":
                initEmbraerSeats();
                break;
            default:
                initAirbusSeats();
        }
    }

    public void initAirbusSeats() {
        FlightSeat seat;
        seat = new FlightSeat("01","A","First Class", destination,false,false, UUID.randomUUID().toString());
        this.seats.add(seat);
        seat = new FlightSeat("08","B","Economy Plus", destination,false,false, UUID.randomUUID().toString());
        this.seats.add(seat);
        seat = new FlightSeat("12","F","Economy", destination,false,false, UUID.randomUUID().toString());
        this.seats.add(seat);
    }
    public void initBoeingSeats() {
        FlightSeat seat;
        seat = new FlightSeat("02","B","First Class", destination,false,false, UUID.randomUUID().toString());
        this.seats.add(seat);
        seat = new FlightSeat("07","C","Economy Plus", destination,false,false, UUID.randomUUID().toString());
        this.seats.add(seat);
        seat = new FlightSeat("26","B","Economy", destination,false,false, UUID.randomUUID().toString());
        this.seats.add(seat);
    }
    public void initEmbraerSeats() {
        FlightSeat seat;
        seat = new FlightSeat("01","A","First Class",destination,false,false, UUID.randomUUID().toString());
        this.seats.add(seat);
        seat = new FlightSeat("07","D","Economy",destination,false,false, UUID.randomUUID().toString());
        this.seats.add(seat);
        seat = new FlightSeat("11","C","Economy",destination,false,false, UUID.randomUUID().toString());
        this.seats.add(seat);
    }

    public ArrayList getSeats() {
        return this.seats;
    }
}
