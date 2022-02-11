package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameController extends Program implements Initializable {

    @FXML
    private Button menu;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button change;
    

    @FXML
    private ImageView image;

    @FXML
    private AnchorPane parent;

    @FXML
    private ImageView dark;

    @FXML
    private Label test;

    private int player = 0;

    @FXML
    private Button play;

    ArrayList<Button> buttons;

    boolean isLightMode=Program.background;

    public static boolean winner;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttons = new ArrayList<>(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9));
        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
        if(isLightMode){
            setLightMode();
        }
        else{
            setDarkMode();
        }
        isLightMode=!isLightMode;
    }

    @FXML
    void resetGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        test.setText("Tic-Tac-Toe");
    }

    private void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            try {
                checkIfGameIsOver();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void setPlayerSymbol(Button button) {
        if (player % 2 == 0) {
            test.setText("Turn O");
            button.setText("X");
            player = 1;
        } else {
            test.setText("Turn X");
            button.setText("O");
            player = 0;
        }
    }

    public void checkIfGameIsOver() throws IOException {
        for (int a = 0; a < 8; a++) {
            if (b1.getText().equals("X") && b2.getText().equals("X") && b3.getText().equals("X")) {
                test.setText("X win!");
                winner=true;
                Win();
                break;
            } else if (b1.getText().equals("O") && b2.getText().equals("O") && b3.getText().equals("O")) {
                test.setText("O win!");
                winner=false;
                Win();
                break;
            }
            if (b4.getText().equals("X") && b5.getText().equals("X") && b6.getText().equals("X")) {
                test.setText("X win!");
                winner=true;
                Win();
                break;
            } else if (b4.getText().equals("O") && b5.getText().equals("O") && b6.getText().equals("O")) {
                test.setText("O win!");
                winner=false;
                Win();
                break;
            }
            if (b7.getText().equals("X") && b8.getText().equals("X") && b9.getText().equals("X")) {
                test.setText("X win!");
                winner=true;
                Win();
                break;
            } else if (b7.getText().equals("O") && b8.getText().equals("O") && b9.getText().equals("O")) {
                test.setText("O win!");
                winner=false;
                Win();
                break;
            }
            if (b1.getText().equals("X") && b5.getText().equals("X") && b9.getText().equals("X")) {
                test.setText("X win!");
                winner=true;
                Win();
                break;
            } else if (b1.getText().equals("O") && b5.getText().equals("O") && b9.getText().equals("O")) {
                test.setText("O win!");
                winner=false;
                Win();
                break;
            }
            if (b3.getText().equals("X") && b5.getText().equals("X") && b7.getText().equals("X")) {
                test.setText("X win!");
                winner=true;
                Win();
                break;
            } else if (b3.getText().equals("O") && b5.getText().equals("O") && b7.getText().equals("O")) {
                test.setText("O win!");
                winner=false;
                Win();
                break;
            }
            if (b1.getText().equals("X") && b4.getText().equals("X") && b7.getText().equals("X")) {
                test.setText("X win!");
                winner=true;
                Win();
                break;
            } else if (b1.getText().equals("O") && b4.getText().equals("O") && b7.getText().equals("O")) {
                test.setText("O win!");
                winner=false;
                Win();
                break;
            }
            if (b2.getText().equals("X") && b5.getText().equals("X") && b8.getText().equals("X")) {
                test.setText("X win!");
                winner=true;
                Win();
                break;
            } else if (b2.getText().equals("O") && b5.getText().equals("O") && b8.getText().equals("O")) {
                test.setText("O win!");
                winner=false;
                Win();
                break;
            }
            if (b3.getText().equals("X") && b6.getText().equals("X") && b9.getText().equals("X")) {
                test.setText("X win!");
                winner=true;
                Win();
                break;
            } else if (b3.getText().equals("O") && b6.getText().equals("O") && b9.getText().equals("O")) {
                test.setText("O win!");
                winner=false;
                Win();
                break;
            }
        }
    }

    public void Win() throws IOException {
        menu.getScene().getWindow().hide();
        Stage signup=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("xWin.fxml"));
        Scene scene=new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }

    private void setLightMode(){
        parent.getStylesheets().remove("styles/DarkMode.css");
        parent.getStylesheets().add("styles/LightMode.css");
        javafx.scene.image.Image img=new javafx.scene.image.Image("image/dark.png");
        image.setImage(img);
    }

    private void setDarkMode(){
        parent.getStylesheets().remove("styles/LightMode.css");
        parent.getStylesheets().add("styles/DarkMode.css");
        javafx.scene.image.Image img=new javafx.scene.image.Image("image/light.png");
        image.setImage(img);
    }

    public void MenuButton(ActionEvent event) throws IOException {
        menu.getScene().getWindow().hide();
        Stage signup=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene=new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }

    public void PlayButton(ActionEvent event) throws IOException {
        play.getScene().getWindow().hide();
        Stage signup=new Stage();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Game.fxml")));
        Scene scene=new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }

    public void ChangeButton(ActionEvent event) {
        if(isLightMode){
            setLightMode();
            Change();
        }
        else{
            setDarkMode();
            Change();
        }
        isLightMode=!isLightMode;
    }
}
