package sample;


import enums.ClassType;
import enums.PersonType;
import enums.SeatType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.lang.System.out;


public class Main extends Application {

    Button viewSeats, newBooking, saveBooking, cancelBooking;
    Stage window;
    Scene main, _newBooking;
    GridPane gridMain, gridNew, gridView;
    Text seats = new Text(50, 150, " ");
    SeatingArray seatingArray = new SeatingArray();

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            window = primaryStage;
            window.setTitle("2D Array Program");

            out.println(seatingArray.AllocateSeat("George", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Alan", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Esther", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Nicola", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Jill", PersonType.Adult, ClassType.First, SeatType.Window));
            out.println(seatingArray.AllocateSeat("Harry Potter", PersonType.Child, ClassType.Business, SeatType.Aisle));

            CustomerArray ca =  CustomerArray.getInstance();

            gridMain = new GridPane();
            gridNew = new GridPane();
            gridView = new GridPane();
            viewSeats = new Button("View Seats");
            viewSeats.setOnAction(e -> {

                seats.setText(seatingArray.toString());
                seats.setFont(Font.font("Monospaced", 27));

                GridPane.setConstraints(seats, 0, 3);
                gridMain.getChildren().add(seats);
            });
            newBooking = new Button("New Booking");
            newBooking.setOnAction(e -> window.setScene(_newBooking));
            saveBooking = new Button("Save");
            cancelBooking = new Button("Cancel");

            GridPane.setConstraints(newBooking, 0, 0);
            GridPane.setConstraints(viewSeats, 1, 0);
            GridPane.setConstraints(saveBooking, 0, 0);
            GridPane.setConstraints(cancelBooking, 33, 0);

            gridMain.setPadding(new Insets(10));
            gridMain.setVgap(8);
            gridMain.setHgap(10);

            gridNew.setPadding(new Insets(10));
            gridNew.setVgap(8);
            gridNew.setHgap(10);

            gridView.setPadding(new Insets(10));
            gridView.setVgap(8);
            gridView.setHgap(10);

            gridMain.getChildren().addAll(newBooking, viewSeats);
            gridNew.getChildren().addAll(saveBooking, cancelBooking);
            gridNew.setAlignment(Pos.BOTTOM_LEFT);


            //Form
            //TextField nameInput = new TextField();

            //Set Scenes
            main = new Scene(gridMain, 450, 460);
            _newBooking = new Scene(gridNew, 450, 460);

            window.setScene(main);
            window.show();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

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
