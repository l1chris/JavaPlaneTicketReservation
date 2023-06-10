package rest;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "RESTFlightData")
@XmlAccessorType(XmlAccessType.FIELD)
public class RESTFlightData {
    @XmlElement(name = "Flight")
    public List<Flight> flights;

    public RESTFlightData() {}

}
