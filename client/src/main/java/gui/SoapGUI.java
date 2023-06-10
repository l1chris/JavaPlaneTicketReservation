package gui;


import soap.ArrayListOfFlight;
import soap.Flight;
import soap.FlightSeat;
import soap.ReservationBooking;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class SoapGUI {

    private JFrame frame;

    private JComboBox dateComboBox;
    private JComboBox departureComboBox;
    private JComboBox planeComboBox;
    private JComboBox destinationComboBox;
    private JComboBox classComboBox;
    private JComboBox seatComboBox;
    private JComboBox mealComboBox;
    private JLabel priceField;


    public ReservationBooking reservationBooking;
    public UUID clientID;
    public List<Flight> flights;

    public ArrayList<String> planeTypes;
    public ArrayList<String> flightDates;
    public ArrayList<String> departures;

    public String[] flightClasses = {"First Class", "Economy Plus", "Economy"};
    public String[] meals = {"Standard", "Vegetarian", "Vegan"};
    public HashMap<String, String> seatsById = new HashMap<>();
    public HashMap<String, Integer> seatsByPrice = new HashMap<>();


    public SoapGUI(String title, ArrayListOfFlight flights, ReservationBooking reservationBooking, UUID clientID) {
        this.frame = new JFrame(title);
        this.reservationBooking = reservationBooking;
        this.clientID = clientID;
        this.flights = flights.getItem();
        initData();
        initGUI();
    }

    public void closeFrame() {
        this.frame.dispose();
    }

    private void initData() {
        planeTypes = new ArrayList<>();
        flightDates = new ArrayList<>();
        departures = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            if (!planeTypes.contains(flight.getType())) {
                planeTypes.add(flight.getType());
            }
            if (!flightDates.contains(flight.getDate())) {
                flightDates.add(flight.getDate());
            }
            if (!departures.contains(flight.getDeparture())) {
                departures.add(flight.getDeparture());
            }
        }
    }

    private Object[] getDestinations() {
        ArrayList<String> des = new ArrayList<>();
        String selectedDeparture = this.departureComboBox.getSelectedItem().toString();
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getDeparture() == selectedDeparture) {
                des.add(flights.get(i).getDestination());
            }
        }
        return des.toArray();
    }

    private Object[] getFlightsForSelection() {
        ArrayList<String> flightsForSelection = new ArrayList<>();
        String selectedDeparture = this.departureComboBox.getSelectedItem().toString();
        String selectedDestination = this.destinationComboBox.getSelectedItem().toString();
        for (int i = 0; i < flights.size(); i++) {
            if ((flights.get(i).getDeparture() == selectedDeparture) && (flights.get(i).getDestination() == selectedDestination)) {
                flightsForSelection.add(flights.get(i).getType());
            }
        }
        return flightsForSelection.toArray();
    }

    private Object[] getSeats() {
        ArrayList<String> seats = new ArrayList<>();
        String selectedPlaneType = this.planeComboBox.getSelectedItem().toString();
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getType() == selectedPlaneType) {
                List<FlightSeat> list = flights.get(i).getSeats();
                for (int j = 0; j < list.size(); j++) {
                    if ((list.get(j).getSeatClass().equals(classComboBox.getSelectedItem().toString())) && (!list.get(j).isIsReserved())) {
                        String seatString = list.get(j).getAisle() + " " + list.get(j).getRow();
                        seats.add(seatString);
                        seatsById.put(seatString, list.get(j).getSeatID());
                        seatsByPrice.put(seatString, list.get(j).getPrice());
                    }
                }

            }
        }
        return seats.toArray();
    }

    private String getSeatPrice() {
        String priceAsString = "";
        String selectedSeat = this.seatComboBox.getSelectedItem().toString();
        int price = seatsByPrice.get(selectedSeat);
        priceAsString = String.valueOf(price);
        return priceAsString;
    }

    private void initGUI() {
        this.frame.setBounds(100, 100, 450, 300);
        this.frame.setSize(600, 500);
        this.frame.setDefaultCloseOperation(2);


        JPanel panelInfo = new JPanel();
        frame.getContentPane().add(panelInfo, BorderLayout.NORTH);
        panelInfo.setLayout(new GridLayout(0, 2, 0, 0));


        /*
        // Date ComboBox
        */
        JLabel label = new JLabel("Select Date");
        panelInfo.add(label);
        dateComboBox = new JComboBox();
        dateComboBox.setModel(new DefaultComboBoxModel(flightDates.toArray()));
        dateComboBox.setSelectedIndex(0);
        dateComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                departureComboBox.setVisible(false);
                departureComboBox.setModel(new DefaultComboBoxModel(departures.toArray()));
                departureComboBox.setVisible(true);
                destinationComboBox.setVisible(false);
                planeComboBox.setVisible(false);
                classComboBox.setVisible(false);
                seatComboBox.setVisible(false);
                mealComboBox.setVisible(false);
                priceField.setVisible(false);
            }
        });
        panelInfo.add(dateComboBox);


        /*
        // Departure ComboBox
        */
        label = new JLabel("Select Departure");
        panelInfo.add(label);
        departureComboBox = new JComboBox();
        departureComboBox.setVisible(false);
        departureComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                destinationComboBox.setVisible(false);
                destinationComboBox.setModel(new DefaultComboBoxModel(getDestinations()));
                destinationComboBox.setVisible(true);
                planeComboBox.setVisible(false);
                classComboBox.setVisible(false);
                seatComboBox.setVisible(false);
                mealComboBox.setVisible(false);
                priceField.setVisible(false);
            }
        });
        panelInfo.add(departureComboBox);

        /*
        // Destination ComboBox
        */
        label = new JLabel("Select Destination");
        panelInfo.add(label);
        destinationComboBox = new JComboBox();
        destinationComboBox.setVisible(false);
        destinationComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                planeComboBox.setVisible(false);
                planeComboBox.setModel(new DefaultComboBoxModel(getFlightsForSelection()));
                planeComboBox.setVisible(true);
                classComboBox.setVisible(false);
                seatComboBox.setVisible(false);
                mealComboBox.setVisible(false);
                priceField.setVisible(false);
            }
        });
        panelInfo.add(destinationComboBox);

        /*
        // Plane ComboBox
        */
        label = new JLabel("Select Plane");
        panelInfo.add(label);
        planeComboBox = new JComboBox();
        planeComboBox.setVisible(false);
        planeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classComboBox.setVisible(false);
                classComboBox.setModel(new DefaultComboBoxModel(flightClasses));
                classComboBox.setVisible(true);
                seatComboBox.setVisible(false);
                mealComboBox.setVisible(false);
                priceField.setVisible(false);
            }
        });
        panelInfo.add(planeComboBox);


        // Class ComboBox

        label = new JLabel("Select Flight Class");
        panelInfo.add(label);
        classComboBox = new JComboBox();
        classComboBox.setVisible(false);
        classComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seatComboBox.setVisible(false);
                seatComboBox.setModel(new DefaultComboBoxModel(getSeats()));
                seatComboBox.setVisible(true);
                mealComboBox.setVisible(false);
            }
        });
        panelInfo.add(classComboBox);


        // Seat ComboBox

        label = new JLabel("Select Seat");
        panelInfo.add(label);
        seatComboBox = new JComboBox();
        seatComboBox.setVisible(false);
        seatComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mealComboBox.setVisible(false);
                mealComboBox.setModel(new DefaultComboBoxModel(meals));
                mealComboBox.setVisible(true);
            }
        });
        panelInfo.add(seatComboBox);


        // Meal ComboBox

        label = new JLabel("Select Meal");
        panelInfo.add(label);
        mealComboBox = new JComboBox();
        mealComboBox.setVisible(false);
        mealComboBox.setModel(new DefaultComboBoxModel(meals));
        mealComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                priceField.setVisible(false);
                priceField.setText(getSeatPrice());
                priceField.setVisible(true);
            }
        });
        panelInfo.add(mealComboBox);


        // Price Field

        label = new JLabel("Price: ");
        panelInfo.add(label);
        priceField = new JLabel("2000");
        priceField.setVisible(false);
        panelInfo.add(priceField);


        JPanel panelButtons = new JPanel();
        this.frame.getContentPane().add(panelButtons, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("Cancel");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeFrame();
            }
        });
        panelButtons.add(btnNewButton);


        btnNewButton = new JButton("Confirm");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seatString = seatComboBox.getSelectedItem().toString();
                String seatID = seatsById.get(seatString);
                boolean success = reservationBooking.requestReservation(clientID.toString(), seatID);
                if (success) {
                    String successMessage = "Successful reseservation!";
                    String titleMessage = "Sucessful Reservation";
                    JOptionPane.showMessageDialog(null, successMessage, titleMessage, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String failureMessage = "The Reservation was not successful!\nThe seat might already have been reserved,\n or you have already made a reservation.\n:(";
                    String titleMessage = "Unsuccessful Reservation";
                    JOptionPane.showMessageDialog(null, failureMessage, titleMessage, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        panelButtons.add(btnNewButton);

        frame.setVisible(true);
    }


}