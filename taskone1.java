import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String pnr;

    public User(String username, String password, String pnr) {
        this.username = username;
        this.password = password;
        this.pnr = pnr;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPnr() {
        return pnr;
    }
}

class Reservation {
    private String passengerName;
    private String trainNumber;
    private String classType;
    private String dateOfJourney;
    private String destination;
    private String pnr;

    public Reservation(String passengerName, String trainNumber, String classType, String dateOfJourney, String destination, String pnr) {
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.destination = destination;
        this.pnr = pnr;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getDestination() {
        return destination;
    }

    public String getPnr() {
        return pnr;
    }
}

class ReservationSystem {
    private List<User> users;
    private Reservation[] reservations;
    private int reservationCount;

    public ReservationSystem() {
        users = new ArrayList<>();
        reservations = new Reservation[5];
        reservationCount = 0;
    }

    public void addUser(String username, String password, String pnr) {
        User user = new User(username, password, pnr);
        users.add(user);
    }

    public boolean loginUser(String username, String password, String pnr) {
        for (User user : users) {
            if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password) && user.getPnr().equals(pnr)) {
                return true;
            }
        }
        return false;
    }

    public void makeReservation(String passengerName, String trainNumber, String classType, String dateOfJourney, String destination, String pnr) {
        Reservation reservation = new Reservation(passengerName, trainNumber, classType, dateOfJourney, destination, pnr);
        reservations[reservationCount] = reservation;
        reservationCount++;
        System.out.println("Reservation successful!");
    }

    public void cancelReservation(String pnrNumber) {
        boolean found = false;
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i] != null && reservations[i].getPnr().equals(pnrNumber)) {
                System.out.println("Reservation Details:");
                System.out.println("Passenger Name: " + reservations[i].getPassengerName());
                System.out.println("Train Number: " + reservations[i].getTrainNumber());
                System.out.println("Class Type: " + reservations[i].getClassType());
                System.out.println("Date of Journey: " + reservations[i].getDateOfJourney());
                System.out.println("Destination: " + reservations[i].getDestination());
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Press OK to confirm cancellation...");
            Scanner scanner = new Scanner(System.in);
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("OK")) {
                System.out.println("Cancellation successful!");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("Reservation not found.");
        }
    }
}

public class taskone1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        System.out.println("Enter the number of users: ");
        int numUsers = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < numUsers; i++) {
            System.out.println("Enter details of user: " + (i + 1));
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.print("PNR: ");
            String pnr = scanner.nextLine();

            reservationSystem.addUser(username, password, pnr);
        }

        System.out.print("Login here : \n");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("PNR: ");
        String pnr = scanner.nextLine();

        for(int i=0;i<2;i++)
        {
            if (reservationSystem.loginUser(username, password, pnr)) {
                System.out.println("Login successful!");
                System.out.println("1. Make Reservation");
                System.out.println("2. Cancel Reservation");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                        System.out.print("Passenger Name: ");
                        String passengerName = scanner.nextLine();
                        System.out.print("Train Number: ");
                        String trainNumber = scanner.nextLine();
                        System.out.print("Class Type: ");
                        String classType = scanner.nextLine();
                        System.out.print("Date of Journey: ");
                        String dateOfJourney = scanner.nextLine();
                        System.out.print("Destination: ");
                        String destination = scanner.nextLine();
                        System.out.print("PNR: ");
                        String reservationPnr = scanner.nextLine();
                        reservationSystem.makeReservation(passengerName, trainNumber, classType, dateOfJourney, destination, reservationPnr);
                        break;
                    case 2:
                        System.out.print("Enter PNR Number: ");
                        String pnrNumber = scanner.nextLine();
                        reservationSystem.cancelReservation(pnrNumber);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } 
            else {
                System.out.println("Login failed!!");
            }
        }
       
    }
}
