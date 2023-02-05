package fr.minelaunched.theme_sample.core;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class LauncherController implements Initializable {

    private HashMap<String, Object> dataFields;

    @FXML
    private ImageView crackemailfield;
    @FXML
    private ImageView customemailfield;
    @FXML
    private ImageView passwordfield;
    @FXML
    private AnchorPane launcher_ui;

    public void initialize(URL location, ResourceBundle resources) {

        Object emailfieldimg = dataFields.get("emailfield");
        Object passwordfieldimg = dataFields.get("passwordfield");
        Object playbtnhover = dataFields.get("playbtnhover");

        /*Object settingsTabsBg = dataFields.get("settingsTabsBg");
        Object settingsTabsBgBorder = dataFields.get("settingsTabsBgBorder");
        Object settingsTabsTheme = dataFields.get("settingsTabsTheme");
        Object settingsTabsInputsText = dataFields.get("settingsTabsInputsText");
        Object settingsTabsText = dataFields.get("settingsTabsText");*/

        if (dataFields.containsKey("emailfield")){
            Image image = new Image(emailfieldimg.toString());
            crackemailfield.setImage(image);
            customemailfield.setImage(image);
        }
        if (dataFields.containsKey("passwordfield")){
            Image image = new Image(passwordfieldimg.toString());
            passwordfield.setImage(image);
        }
    }
}
