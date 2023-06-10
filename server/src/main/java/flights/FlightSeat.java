package flights;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(factoryMethod="createInstanceJAXB")
public class FlightSeat {

    public String seatID;
    public String aisle;
    public String row;
    public String seatClass;
    public int price;
    public boolean isReserved;
    public boolean isEmergencySeat;
    public String clientID = "";

    public FlightSeat(String aisle, String row, String seatClass, String destination, boolean isReserved, boolean isEmergencySeat, String seatID) {
        this.aisle = aisle;
        this.row = row;
        this.seatClass = seatClass;
        this.isReserved = isReserved;
        this.isEmergencySeat = isEmergencySeat;
        this.seatID = seatID;
        this.price = setSeatPrice(destination);
    }
    private static FlightSeat createInstanceJAXB() {
        return null;
    }

    public String getSeatID() {
        return this.seatID;
    }


    public int setSeatPrice(String destination) {
        int price = 400;
        switch (destination) {
            case "Paris":
                price += 200;
                break;
            case "London":
                price += 150;
                break;
            case "Barcelona":
                price += 100;
                break;
            case "Dubai":
                price += 400;
                break;
            default:
        }

        switch (this.seatClass) {
            case "First Class":
                price += 200;
                break;
            case "Economy Plus":
                price += 100;
                break;
            default:
                break;
        }

        return price;
    }

    public boolean setReserved(String clientID) {
        if (!this.isReserved) {
            this.isReserved = true;
            this.clientID = clientID;
            return true;
        }
        return false;
    }
}
