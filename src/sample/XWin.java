package sample;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class XWin extends GameController implements Initializable {

    @FXML
    private AnchorPane Win;

    @FXML
    private Button ok;

    @FXML
    private Label text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(isLightMode){
            setLightMode();
        }
        else{
            setDarkMode();
        }
        isLightMode=!isLightMode;

        if(winner)
            text.setText("!!  X Win  !!");
        else
            text.setText("!!  0 Win  !!");
    }

    public void OkButton(ActionEvent event) throws IOException {
        Win.getScene().getWindow().hide();
        Stage signup=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene scene=new Scene(root);
        signup.setScene(scene);
        signup.show();
    }

    private void setLightMode(){
        Win.getStylesheets().remove("styles/DarkMode.css");
        Win.getStylesheets().add("styles/LightMode.css");
    }

    private void setDarkMode(){
        Win.getStylesheets().remove("styles/LightMode.css");
        Win.getStylesheets().add("styles/DarkMode.css");
    }
}
