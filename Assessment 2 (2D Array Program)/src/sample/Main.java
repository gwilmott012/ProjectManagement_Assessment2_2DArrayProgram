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

    private String[] getTable(String input) {
        String[] strings = input.split(" ");
        String tmp = new String();

        Label Column0Row1 = new Label("Row 1 "), Column0Row2 = new Label("Row 2 "), Column0Row3 = new Label("Row 3 "), Column0Row4 = new Label("Row 4 "), Column0Row5 = new Label("Row 5 "), Column0Row6 = new Label("Row 6 "), Column0Row7 = new Label("Row 7 "), Column0Row8 = new Label("Row 8 "), Column0Row9 = new Label("Row 9 "), Column0Row10 = new Label("Row 10"), Column0Row11 = new Label("Row 11"), Column0Row12 = new Label("Row 12");
        Label Row0 = new Label("A B C   D E F");
        Label Row1 = new Label(), Row2 = new Label(), Row3 = new Label(), Row4 = new Label(), Row5 = new Label(), Row6 = new Label(), Row7 = new Label(), Row8 = new Label(), Row9 = new Label(), Row10 = new Label(), Row11 = new Label(), Row12 = new Label();

        try {

            for (int i = 0; i < 6; i++) {
                tmp += i != 0 ? " " : "";
                tmp += strings[i];
                tmp += i == 2 ? "  " : "";
            }
            Row1.setText(tmp);
            tmp = "";

            for (int i = 6; i < 12; i++) {
                tmp += i != 6 ? " " : "";
                tmp += strings[i];
                tmp += i == 8 ? "  " : "";
            }
            Row2.setText(tmp);
            tmp = "";

            for (int i = 12; i < 18; i++) {
                tmp += i != 12 ? " " : "";
                tmp += strings[i];
                tmp += i == 14 ? "  " : "";
            }
            Row3.setText(tmp);
            tmp = "";

            for (int i = 18; i < 24; i++) {
                tmp += i != 18 ? " " : "";
                tmp += strings[i];
                tmp += i == 20 ? "  " : "";
            }
            Row4.setText(tmp);
            tmp = "";

            for (int i = 24; i < 30; i++) {
                tmp += i != 24 ? " " : "";
                tmp += strings[i];
                tmp += i == 26 ? "  " : "";
            }
            Row5.setText(tmp);
            tmp = "";

            for (int i = 30; i < 36; i++) {
                tmp += i != 30 ? " " : "";
                tmp += strings[i];
                tmp += i == 32 ? "  " : "";
            }
            Row6.setText(tmp);
            tmp = "";

            for (int i = 36; i < 42; i++) {
                tmp += i != 36 ? " " : "";
                tmp += strings[i];
                tmp += i == 38 ? "  " : "";
            }
            Row7.setText(tmp);
            tmp = "";

            for (int i = 42; i < 48; i++) {
                tmp += i != 42 ? " " : "";
                tmp += strings[i];
                tmp += i == 44 ? "  " : "";
            }
            Row8.setText(tmp);
            tmp = "";

            for (int i = 48; i < 54; i++) {
                tmp += i != 48 ? " " : "";
                tmp += strings[i];
                tmp += i == 50 ? "  " : "";
            }
            Row9.setText(tmp);
            tmp = "";

            for (int i = 54; i < 60; i++) {
                tmp += i != 54 ? " " : "";
                tmp += strings[i];
                tmp += i == 56 ? "  " : "";
            }
            Row10.setText(tmp);
            tmp = "";

            for (int i = 60; i < 66; i++) {
                tmp += i != 60 ? " " : "";
                tmp += strings[i];
                tmp += i == 62 ? "  " : "";
            }
            Row11.setText(tmp);
            tmp = "";

            for (int i = 66; i < 72; i++) {
                tmp += i != 66 ? " " : "";
                tmp += strings[i];
                tmp += i == 68 ? "  " : "";
            }
            Row12.setText(tmp);
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("That is not enough " + ex.getMessage() + ".");
        }

        GridPane.setConstraints(Column0Row1, 0, 1);
        GridPane.setConstraints(Column0Row2, 0, 2);
        GridPane.setConstraints(Column0Row3, 0, 3);
        GridPane.setConstraints(Column0Row4, 0, 4);
        GridPane.setConstraints(Column0Row5, 0, 5);
        GridPane.setConstraints(Column0Row6, 0, 6);
        GridPane.setConstraints(Column0Row7, 0, 7);
        GridPane.setConstraints(Column0Row8, 0, 8);
        GridPane.setConstraints(Column0Row9, 0, 9);
        GridPane.setConstraints(Column0Row10, 0, 10);
        GridPane.setConstraints(Column0Row11, 0, 11);
        GridPane.setConstraints(Column0Row12, 0, 12);
        GridPane.setConstraints(Row0, 1, 0);
        GridPane.setConstraints(Row1, 1, 1);
        GridPane.setConstraints(Row2, 1, 2);
        GridPane.setConstraints(Row3, 1, 3);
        GridPane.setConstraints(Row4, 1, 4);
        GridPane.setConstraints(Row5, 1, 5);
        GridPane.setConstraints(Row6, 1, 6);
        GridPane.setConstraints(Row7, 1, 7);
        GridPane.setConstraints(Row8, 1, 8);
        GridPane.setConstraints(Row9, 1, 9);
        GridPane.setConstraints(Row10, 1, 10);
        GridPane.setConstraints(Row11, 1, 11);
        GridPane.setConstraints(Row12, 1, 12);

        return new String[]{
                Column0Row1.getText(),
                Column0Row2.getText(),
                Column0Row3.getText(),
                Column0Row4.getText(),
                Column0Row5.getText(),
                Column0Row5.getText(),
                Column0Row6.getText(),
                Column0Row7.getText(),
                Column0Row8.getText(),
                Column0Row9.getText(),
                Column0Row10.getText(),
                Column0Row11.getText(),
                Column0Row12.getText(),
                Row0.getText(),
                Row1.getText(),
                Row2.getText(),
                Row3.getText(),
                Row4.getText(),
                Row5.getText(),
                Row6.getText(),
                Row7.getText(),
                Row8.getText(),
                Row9.getText(),
                Row10.getText(),
                Row11.getText(),
                Row12.getText()
        };
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
