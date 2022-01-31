// I worked on the homework assignment alone, using only course materials.
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import java.util.Collections;
import java.util.Optional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Linda Duong
 * @version 1.0
 * This class represents a space to create problem ideation forms
 */
public class StarterUpper extends Application {

    private static ArrayList<StartUpIdea> startUpObjects;
    private ListView<String> listView;

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        listView = new ListView<>();
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Image image = new Image(new FileInputStream("Start_up.jpeg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(800);
        File ideas = new File("StartUpIdeas.txt");

        Label q1 = new Label("What is the problem?");
        Label q2 = new Label("Who is the target customer?");
        Label q3 = new Label("How badly does the customer NEED this problem fixed (1-10)?");
        Label q4 = new Label("How many people do you know who might experience this problem?");
        Label q5 = new Label("How big is the target market?");
        Label q6 = new Label("Who are the competitors/existing solutions?");
        Label q7 = new Label("What are the Startup Costs/Expenses needed?");
        Label q8 = new Label("Why would users care about your service or product?");
        Label q9 = new Label("What are the legal risks?");
        TextField a1 = new TextField();
        TextField a2 = new TextField();
        TextField a3 = new TextField();
        TextField a4 = new TextField();
        TextField a5 = new TextField();
        TextField a6 = new TextField();
        TextField a7 = new TextField();
        TextField a8 = new TextField();
        TextField a9 = new TextField();

        Button submitForm = new Button("Submit");
        submitForm.setStyle("-fx-base: #b6e7c9;");
        startUpObjects = new ArrayList<StartUpIdea>();
        submitForm.setOnAction(event -> {
                if (verifyString(a1) && verifyString(a2) && verifyInt(a3) && verifyInt(a4) && verifyInt(a5)
                    && verifyString(a6) && verifyInt(a7) && verifyString(a8) && verifyString(a9)) {
                    StartUpIdea idea = new StartUpIdea(a1.getText(), a2.getText(), Integer.valueOf(a3.getText()),
                        Integer.valueOf(a4.getText()), Integer.valueOf(a5.getText()), a6.getText());
                    idea.setProblem(a1.getText());
                    idea.setTargetCustomer(a2.getText());
                    idea.setCustomerNeed(Integer.valueOf(a3.getText()));
                    idea.setKnownPeopleWithProblem(Integer.valueOf(a4.getText()));
                    idea.setTargetMarketSize(Integer.valueOf(a5.getText()));
                    idea.setCompetitors(a6.getText());
                    idea.setCosts(Integer.valueOf(a7.getText()));
                    idea.setUserWhy(a8.getText());
                    idea.setRisks(a9.getText());
                    startUpObjects.add(idea);
                    Media yehaw = new Media(new File("yehaw.mp3").toURI().toString());
                    MediaPlayer yehawPlayer = new MediaPlayer(yehaw);
                    yehawPlayer.play();
                    listView.getItems().add(a1.getText());
                    a1.setText("");
                    a2.setText("");
                    a3.setText("");
                    a4.setText("");
                    a5.setText("");
                    a6.setText("");
                    a7.setText("");
                    a8.setText("");
                    a9.setText("");
                }
            });
        Button sort = new Button();
        sort.setStyle("-fx-base: coral;");
        sort.setText("Sort");
        sort.setOnAction(new EventHandler<ActionEvent>() { //anonymous inner class
                public void handle(ActionEvent event) {
                    Collections.sort(startUpObjects);
                    FileUtil.saveIdeasToFile(startUpObjects, ideas);
                }
            });
        Button save = new Button("Save");
        save.setStyle("-fx-base: aqua;");
        save.setOnAction(event -> {
                FileUtil.saveIdeasToFile(startUpObjects, ideas);
            });
        Button reset = new Button("Reset");
        reset.setStyle("-fx-base: crimson;");
        reset.setOnAction(event -> {
                if (startUpObjects.size() != 0) {
                    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setTitle("Reset");
                    confirm.setHeaderText("Are you sure?");
                    confirm.setContentText("Once the form is reset, you will not be able to go back!");
                    Optional<ButtonType> okOrCancel = confirm.showAndWait();
                    if (okOrCancel.get() == ButtonType.OK) {
                        if (ideas.exists()) {
                            startUpObjects.clear();
                            listView.getItems().clear();
                            ideas.delete();
                            a1.setText("");
                            a2.setText("");
                            a3.setText("");
                            a4.setText("");
                            a5.setText("");
                            a6.setText("");
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            });
        Button remove = new Button("Remove");
        remove.setStyle("-fx-base: yellow;");
        remove.setOnAction(event -> {
                Media beep = new Media(new File("beepSound.mp3").toURI().toString());
                MediaPlayer beepPlayer = new MediaPlayer(beep);
                beepPlayer.play();
                int selectedIdea = listView.getSelectionModel().getSelectedIndex();
                if (startUpObjects.size() != 0 && selectedIdea != -1) {
                    listView.getItems().remove(selectedIdea);
                    startUpObjects.remove(selectedIdea);
                    if (ideas.exists()) {
                        FileUtil.saveIdeasToFile(startUpObjects, ideas);
                    }
                }
            });

        HBox buttons = new HBox();
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(submitForm, sort, reset, save, remove);

        HBox forImage = new HBox();
        forImage.setAlignment(Pos.CENTER);
        forImage.getChildren().add(imageView);

        VBox root = new VBox();
        root.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().addAll(forImage, q1, a1, q2, a2, q3, a3, q4, a4, q5, a5, q6, a6, q7, a7, q8, a8, q9, a9,
                                buttons, listView);

        stage.setTitle("Problem Ideation Form");
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Verifies String input and creates Alerts depending on the error
     * @param item the current TextField item
     * @return boolean value of whether the textfield is valid or not
     */
    private boolean verifyString(TextField item) {
        boolean valid = true;
        if (item.getText().length() == 0) {
            Media oops = new Media(new File("oops.mp3").toURI().toString());
            MediaPlayer oopsPlayer = new MediaPlayer(oops);
            oopsPlayer.play();
            Alert empty = new Alert(Alert.AlertType.ERROR);
            empty.setTitle("Error");
            empty.setHeaderText("Empty Field.");
            empty.setContentText("The input field is empty, please try again.");
            empty.showAndWait();
            return !valid;
        }
        try {
            Integer.parseInt(item.getText());
            Media oops = new Media(new File("oops.mp3").toURI().toString());
            MediaPlayer oopsPlayer = new MediaPlayer(oops);
            oopsPlayer.play();
            Alert wrongInput = new Alert(Alert.AlertType.ERROR);
            wrongInput.setTitle("Error");
            wrongInput.setHeaderText("Wrong input type");
            wrongInput.setContentText("Input must be a string, please try again");
            wrongInput.showAndWait();
            return !valid;
        } catch (NumberFormatException e) {
            return valid;
        }
    }

    /**
     * Verifies int input and creates Alerts depending on the error
     * @param item the current TextField item
     * @return boolean value of whether the textfield is valid or not
     */
    private boolean verifyInt(TextField item) {
        boolean valid = true;
        if (Integer.valueOf(item.getText().length()) == 0) {
            Media oops = new Media(new File("oops.mp3").toURI().toString());
            MediaPlayer oopsPlayer = new MediaPlayer(oops);
            oopsPlayer.play();
            Alert empty = new Alert(Alert.AlertType.ERROR);
            empty.setTitle("Error");
            empty.setHeaderText("Empty Field.");
            empty.setContentText("The input field is empty, please try again.");
            empty.showAndWait();
            return !valid;
        }
        try {
            // if this does not work then that means item is string
            Integer.parseInt(item.getText());
        } catch (NumberFormatException e) {
            Media oops = new Media(new File("oops.mp3").toURI().toString());
            MediaPlayer oopsPlayer = new MediaPlayer(oops);
            oopsPlayer.play();
            Alert wrongInput = new Alert(Alert.AlertType.ERROR);
            wrongInput.setTitle("Error");
            wrongInput.setHeaderText("Wrong input type");
            wrongInput.setContentText("Input must be an integer, try again");
            wrongInput.showAndWait();
            return !valid;
        }
        if (Integer.valueOf(item.getText()) < 0) {
            Media oops = new Media(new File("oops.mp3").toURI().toString());
            MediaPlayer oopsPlayer = new MediaPlayer(oops);
            oopsPlayer.play();
            Alert negValue = new Alert(Alert.AlertType.ERROR);
            negValue.setTitle("Error");
            negValue.setHeaderText("Negative input value");
            negValue.setContentText("Number is negative, please try again");
            negValue.showAndWait();
            return !valid;
        }
        return valid;
    }

    /**
     * Launches the javafx program
     * @param args arguments passed in
     */
    public static void main(String[] args) {
        launch();
    }

}
