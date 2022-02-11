package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class MenuController extends Program implements Initializable {
    private boolean isLightMode=Program.background;

    @FXML
    private AnchorPane parent;

    @FXML
    private ImageView image;

    @FXML
    private Button change;

    @FXML
    private Button play;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(isLightMode){
            setLightMode();
        }
        else{
            setDarkMode();
        }
        isLightMode=!isLightMode;
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

    public void PlayButton(ActionEvent event) throws IOException {
        play.getScene().getWindow().hide();
        Stage signup=new Stage();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Game.fxml")));
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
}
