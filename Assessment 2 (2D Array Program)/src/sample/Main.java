package sample;


import enums.ClassType;
import enums.PersonType;
import enums.SeatType;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.io.*;

import static java.lang.System.out;

public class Main extends Application {
    private Button viewSeats, newBooking, saveBooking, cancelNewBooking, showCancelBooking, cancelBooking, searchBooking;
    private ComboBox adultOrChild, classType, seatType;
    private TextField name, cancelBookingName;
    private Stage window;
    private Scene main, _newBooking, _cancelBooking;
    private GridPane gridMain, gridNew, gridView, gridCancel;
    private Text seats, _name, _adultOrChild, _classType, _seatType, message, _cancelBookingName, _reservation, _description;
    private SeatingArray seatingArray = new SeatingArray();

    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            window = primaryStage;
            window.setTitle("2D Array Program");

            /*out.println(seatingArray.AllocateSeat("George", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Alan", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Esther", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Nicola", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Jill", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Harry Potter", PersonType.Child, ClassType.Business, SeatType.Aisle));*/

            CustomerArray ca =  CustomerArray.getInstance();
            
            
            // Instantiating grids and buttons
            gridMain = new GridPane();
            gridNew = new GridPane();
            gridView = new GridPane();
            gridCancel = new GridPane();
            viewSeats = new Button("View Seats");
            newBooking = new Button("New Booking");
            saveBooking = new Button("Save");
            cancelNewBooking = new Button("Cancel");
            cancelBooking = new Button("Cancel");
            searchBooking = new Button("Search");
            showCancelBooking = new Button("Cancel Booking");
            
            name = new TextField();
            cancelBookingName = new TextField();
            adultOrChild = new ComboBox(FXCollections.observableArrayList(PersonType.values()));
            classType = new ComboBox(FXCollections.observableArrayList(ClassType.values()));
            seatType = new ComboBox(FXCollections.observableArrayList(SeatType.values()));
            
            seats = new Text(50, 150, " ");
            _name = new Text(50, 150, "Name: ");
            _adultOrChild = new Text(50, 150,"Adult Or Child? ");
            _seatType = new Text(50, 150,"Which Seat? ");
            _classType = new Text(50, 150,"Which Class? ");
            _cancelBookingName = new Text(50,150, "Name:");
            _reservation = new Text(50, 150, "");
            _description = new Text(50, 150, "");
            message = new Text(50, 150, "");
            message.setFill(new javafx.scene.paint.Color(1f, 0f, 0f, 1f));
            message.setFont(new Font(16));

            // Setting buttons onClick and width's
            newBooking.setOnAction(e -> NewBooking());
            viewSeats.setOnAction(e -> ViewSeats());
            saveBooking.setOnAction(e -> SaveBooking());
            cancelNewBooking.setOnAction(e -> CancelNewBooking());
            cancelBooking.setOnAction(e -> CancelBooking());
            SetWidth();

            // Aligning buttons to various spots on grid
            GridPane.setConstraints(newBooking, 0, 0);
            GridPane.setConstraints(viewSeats, 1, 0);
            GridPane.setConstraints(showCancelBooking, 2, 0);
            GridPane.setConstraints(saveBooking, 0, 46);
            GridPane.setConstraints(cancelNewBooking, 3, 46);
            GridPane.setConstraints(_name, 0, 0);
            GridPane.setConstraints(name, 0, 1);
            GridPane.setConstraints(_adultOrChild, 1, 0);
            GridPane.setConstraints(adultOrChild, 1, 1);
            GridPane.setConstraints(_seatType, 2, 0);
            GridPane.setConstraints(seatType, 2, 1);
            GridPane.setConstraints(_classType, 3, 0);
            GridPane.setConstraints(classType, 3, 1);
            //GridPane.setConstraints(_description, 0, 0);
            GridPane.setConstraints(cancelBookingName, 1, 0);
            GridPane.setConstraints(_cancelBookingName, 0, 0);
            GridPane.setConstraints(searchBooking, 2, 0);


            // Setting grids padding, vertical gap and horizontal gap
            gridMain.setPadding(new Insets(10));
            gridMain.setVgap(8);
            gridMain.setHgap(10);
            gridNew.setPadding(new Insets(10));
            gridNew.setVgap(8);
            gridNew.setHgap(10);
            gridView.setPadding(new Insets(10));
            gridView.setVgap(8);
            gridView.setHgap(10);
            gridCancel.setPadding(new Insets(10));
            gridCancel.setVgap(8);
            gridCancel.setHgap(10);

            // adding children to grids
            gridMain.getChildren().addAll(newBooking, viewSeats, showCancelBooking);
            gridNew.getChildren().addAll(saveBooking, cancelNewBooking, _name, name, _adultOrChild, adultOrChild, _seatType, seatType, _classType, classType);
            
            gridCancel.getChildren().addAll(searchBooking, cancelBookingName, _cancelBookingName, _reservation);//_description);
            //gridNew.setAlignment(Pos.BOTTOM_LEFT);

            //Set Scenes
            main = new Scene(gridMain, 475, 460);
            _newBooking = new Scene(gridNew, 475, 460);
            _cancelBooking = new Scene(gridCancel, 475, 460);

            window.setScene(main);
            
            CancelBooking();
            window.show();
        } catch (IllegalArgumentException ex) {
            ex.getMessage();
        } catch (Exception ex){
            ex.getMessage();
        }
    }

    private void SetWidth() {
        name.setMinWidth(100);
        adultOrChild.setMinWidth(100);
        seatType.setMinWidth(100);
        classType.setMinWidth(100);
        saveBooking.setMinWidth(100);
        saveBooking.setMinHeight(30);
        cancelNewBooking.setMinWidth(100);
        cancelNewBooking.setMinHeight(30);
    }

    private void SaveBooking() {
        String _AdultOrChild = adultOrChild.getValue().toString();
        String _SeatType = seatType.getValue().toString();
        String _ClassType = classType.getValue().toString();
        Customer customer = new Customer(name.toString(), PersonType.valueOf(_AdultOrChild), ClassType.valueOf(_ClassType), SeatType.valueOf(_SeatType));

        String message = seatingArray.AllocateSeat(customer.name, customer.adultOrChild, customer.classType, customer.preferredSeat);

        if (message == "Seat allocation successful") {
            window.setScene(main);
            if (gridMain.getChildren().contains(seats)) {
                viewSeats.fire();
            }
        } else {
            this.message.setText(message);
            GridPane.setConstraints(this.message, 0, 2);
            gridNew.getChildren().add(this.message);
            GridPane.setColumnSpan(this.message, 10);
            GridPane.setConstraints(saveBooking, 0, 43);
            GridPane.setConstraints(cancelNewBooking, 3, 43);
        }

        String customers = seatingArray.toString();

        FileWriter writer = null;

        try {
            writer = new FileWriter("Customers.txt");
            writer.write(customers);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void CancelNewBooking() {
        window.setScene(main);
        if (gridMain.getChildren().contains(seats)) {
            viewSeats.fire();
        }

    }

    private void CancelBooking() {
        window.setScene(_cancelBooking);
        AlertBox.display("", "\r\nEnter the customer name then click search to find the reservation.\r\n");
    }

    private void NewBooking() {
        name.setText("");
        adultOrChild.getSelectionModel().clearSelection();
        seatType.getSelectionModel().clearSelection();
        classType.getSelectionModel().clearSelection();
        window.setScene(_newBooking);
    }

    private void ViewSeats() {
        seats.setText(seatingArray.toString());
        seats.setFont(Font.font("Monospaced", 27));

        if (!gridMain.getChildren().contains(seats))
        {
            GridPane.setConstraints(seats, 0, 3);
            gridMain.getChildren().add(seats);
        }
    }

    @SuppressWarnings("unused")
	private boolean isInt(TextField input, String message){
        try {
            int age = Integer.parseInt(message);
            out.println("User is: " + age);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            out.println("Error: " + message + " is not a number");
            return false;
        }
    }

    @SuppressWarnings("unused")
	private boolean isAlphabet(String input){
        String[] strings = input.split("");

        for (int i = 0; i < strings.length; i++) {
            for(char letter = 'A'; letter <= 26; letter++){
                if(strings[i].equalsIgnoreCase(""+letter)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
