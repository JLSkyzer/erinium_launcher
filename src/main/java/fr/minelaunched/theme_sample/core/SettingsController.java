package fr.minelaunched.theme_sample.core;

import javafx.fxml.Initializable;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
//    private HashMap<String, Object> dataFields;

    private String settingsTabsBgColor = "#20398c";
    private String settingsTabsBgBorderColor = "#374777";
    private String settingsTabsThemeColor = "#5a76d4";
    private String settingsTabsInputsTextColor = "#393777";
    private String settingsTabsTextColor = "#ffffff";

    @Override
    public void initialize(URL location, ResourceBundle resources){

        /*Object settingsTabsBg = dataFields.get("settingsTabsBg");
        Object settingsTabsBgBorder = dataFields.get("settingsTabsBgBorder");
        Object settingsTabsTheme = dataFields.get("settingsTabsTheme");
        Object settingsTabsInputsText = dataFields.get("settingsTabsInputsText");
        Object settingsTabsText = dataFields.get("settingsTabsText");

        if(dataFields.containsKey("settingsTabsBg")){
            Color color = Color.web(settingsTabsBg.toString());
            color = color.deriveColor(0, 1.0, 1.0, 1.0);
            settingsTabsBgColor = color.toString();
        }
        if(dataFields.containsKey("settingsTabsBgBorder")){
            Color color = Color.web(settingsTabsBgBorder.toString());
            color = color.deriveColor(0, 1.0, 1.0, 1.0);
            settingsTabsBgBorderColor = color.toString();
        }
        if(dataFields.containsKey("settingsTabsTheme")){
            Color color = Color.web(settingsTabsTheme.toString());
            color = color.deriveColor(0, 1.0, 1.0, 1.0);
            settingsTabsThemeColor = color.toString();
        }
        if(dataFields.containsKey("settingsTabsInputsText")){
            Color color = Color.web(settingsTabsInputsText.toString());
            color = color.deriveColor(0, 1.0, 1.0, 1.0);
            settingsTabsInputsTextColor = color.toString();
        }
        if(dataFields.containsKey("settingsTabsText")){
            Color color = Color.web(settingsTabsText.toString());
            color = color.deriveColor(0, 1.0, 1.0, 1.0);
            settingsTabsTextColor = color.toString();
        }*/

    }

}
