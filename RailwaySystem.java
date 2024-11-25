/*
Ensure that the filename is exactly RailwaySystemApp.java.
Save your file with the correct name.
Filename: RailwaySystemApp.java
Class Name: public class RailwaySystemApp*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

class Train {
    private int id;
    private String name;
    private String scheduledArrival;
    private String scheduledDeparture;
    private List<String> stations;
    private int delay;

    public Train(int id, String name, String scheduledArrival, String scheduledDeparture, List<String> stations, int delay) {
        this.id = id;
        this.name = name;
        this.scheduledArrival = scheduledArrival;
        this.scheduledDeparture = scheduledDeparture;
        this.stations = stations;
        this.delay = delay;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScheduledArrival() {
        return scheduledArrival;
    }

    public String getScheduledDeparture() {
        return scheduledDeparture;
    }

    public List<String> getStations() {
        return stations;
    }

    public int getDelay() {
        return delay;
    }
}

class Passenger {
    private String name;
    private String fromStation;
    private String toStation;
    private String travelDate;
    private String coach;
    private String seat;
    private boolean paymentStatus;

    public Passenger(String name, String fromStation, String toStation, String travelDate) {
        this.name = name;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.travelDate = travelDate;
        this.paymentStatus = false;
    }

    public String getName() {
        return name;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public String getCoach() {
        return coach;
    }

    public String getSeat() {
        return seat;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void allocateSeat(String coach, String seat) {
        this.coach = coach;
        this.seat = seat;
    }
}

class RailwaySystem {
    private List<Train> trains;
    private List<Passenger> passengers;

    public RailwaySystem() {
        this.trains = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void displayTrains() {
        for (Train train : trains) {
            System.out.println("Train: " + train.getName());
            System.out.println("Stations: " + String.join(", ", train.getStations()));
            System.out.println("Scheduled Arrival: " + train.getScheduledArrival());
            System.out.println("Scheduled Departure: " + train.getScheduledDeparture());
            System.out.println("Delay: " + train.getDelay() + " minutes");
            System.out.println("----------------------------");
        }
    }

    public void displayPassengers() {
        for (Passenger passenger : passengers) {
            System.out.println("Passenger: " + passenger.getName());
            System.out.println("From Station: " + passenger.getFromStation());
            System.out.println("To Station: " + passenger.getToStation());
            System.out.println("Travel Date: " + passenger.getTravelDate());
            System.out.println("Payment Status: " + (passenger.isPaymentStatus() ? "Paid" : "Not Paid"));
            System.out.println("Coach: " + passenger.getCoach());
            System.out.println("Seat: " + passenger.getSeat());
            System.out.println("----------------------------");
        }
    }
}

public class RailwaySystemApp 
{
    public static void main(String[] args) 
{
        RailwaySystem railwaySystem = new RailwaySystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Railway System Menu");
            System.out.println("1. Add Train");
            System.out.println("2. Display Trains");
            System.out.println("3. Book Ticket");
            System.out.println("4. Display Passengers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter train details:");
                    System.out.print("Train ID: ");
                    int trainId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Train Name: ");
                    String trainName = scanner.nextLine();
                    System.out.print("Scheduled Arrival: ");
                    String scheduledArrival = scanner.nextLine();
                    System.out.print("Scheduled Departure: ");
                    String scheduledDeparture = scanner.nextLine();
                    System.out.print("Stations (comma-separated): ");
                    String[] stationArray = scanner.nextLine().split(",");
                    List<String> stations = Arrays.asList(stationArray);
                    System.out.print("Delay (minutes): ");
                    int delay = scanner.nextInt();
                    
                    Train train = new Train(trainId, trainName, scheduledArrival, scheduledDeparture, stations, delay);
                    railwaySystem.addTrain(train);
                    System.out.println("Train added successfully.");
                    break;

                case 2:
                    System.out.println("List of Trains:");
                    railwaySystem.displayTrains();
                    break;

                case 3:
                    System.out.println("Enter passenger details:");
                    System.out.print("Passenger Name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("From Station: ");
                    String fromStation = scanner.nextLine();
                    System.out.print("To Station: ");
                    String toStation = scanner.nextLine();
                    System.out.print("Travel Date: ");
                    String travelDate = scanner.nextLine();

                    Passenger passenger = new Passenger(passengerName, fromStation, toStation, travelDate);
                    railwaySystem.addPassenger(passenger);
                    System.out.println("Passenger booked successfully.");
                    break;

                case 4:
                    System.out.println("List of Passengers:");
                    railwaySystem.displayPassengers();
                    break;

                case 5:
                    System.out.println("Exiting Railway System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
