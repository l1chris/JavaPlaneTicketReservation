
package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flightSeat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightSeat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seatID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aisle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="row" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seatClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isReserved" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isEmergencySeat" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="clientID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightSeat", propOrder = {
    "seatID",
    "aisle",
    "row",
    "seatClass",
    "price",
    "isReserved",
    "isEmergencySeat",
    "clientID"
})
public class FlightSeat {

    protected String seatID;
    protected String aisle;
    protected String row;
    protected String seatClass;
    protected int price;
    protected boolean isReserved;
    protected boolean isEmergencySeat;
    protected String clientID;

    /**
     * Gets the value of the seatID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatID() {
        return seatID;
    }

    /**
     * Sets the value of the seatID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatID(String value) {
        this.seatID = value;
    }

    /**
     * Gets the value of the aisle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAisle() {
        return aisle;
    }

    /**
     * Sets the value of the aisle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAisle(String value) {
        this.aisle = value;
    }

    /**
     * Gets the value of the row property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRow() {
        return row;
    }

    /**
     * Sets the value of the row property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRow(String value) {
        this.row = value;
    }

    /**
     * Gets the value of the seatClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatClass() {
        return seatClass;
    }

    /**
     * Sets the value of the seatClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatClass(String value) {
        this.seatClass = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the isReserved property.
     * 
     */
    public boolean isIsReserved() {
        return isReserved;
    }

    /**
     * Sets the value of the isReserved property.
     * 
     */
    public void setIsReserved(boolean value) {
        this.isReserved = value;
    }

    /**
     * Gets the value of the isEmergencySeat property.
     * 
     */
    public boolean isIsEmergencySeat() {
        return isEmergencySeat;
    }

    /**
     * Sets the value of the isEmergencySeat property.
     * 
     */
    public void setIsEmergencySeat(boolean value) {
        this.isEmergencySeat = value;
    }

    /**
     * Gets the value of the clientID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * Sets the value of the clientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientID(String value) {
        this.clientID = value;
    }

}
