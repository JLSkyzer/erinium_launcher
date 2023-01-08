package fr.minelaunched.theme_sample.core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.*;

public class ApplicationController implements Initializable {
    private Stage stage;
    private boolean doGameFilesInstallationBeforeRunGame = false;
    private boolean doGameFilesInstallationFromLauncherUI = true;
    private boolean isWindowMoveable = true;
    private boolean isWindowMoveableOnOutScreen = true;
    private boolean isStatutServerMCEnabled = false;
    private boolean isNewsMLEnabled = false;

    /*@FXML
    private Button btnServerMinecraftStatut;*/

    @FXML
    private Button btnHome;
    @FXML
    private Button btnNewsML;
    @FXML
    private StackPane stackpane;
    @FXML
    private ImageView backgroundframe;
    @FXML
    private AnchorPane anchorepane;
    @FXML
    private Button app_close_btn;
    @FXML
    private Button app_reduce_btn;

    public ApplicationController(Stage stage) {
        this.stage = stage;
        stage.setTitle("Erinium Launcher");
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.centerOnScreen();
        stage.setResizable(false);
    }

    private HashMap<String, Object> dataFields;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
//        setManagedAll(btnServerMinecraftStatut, isStatutServerMCEnabled);
        setManagedAll(btnNewsML, isNewsMLEnabled);

        Object backgroundImg = dataFields.get("background");
        Object backgroundframeImg = dataFields.get("backgroundframe");
        /*---------- Button ----------*/
        Object closebutton = dataFields.get("closebutton");
        Object closebuttonhover = dataFields.get("closebuttonhover");
        Object reducebutton = dataFields.get("reducebutton");
        Object reducebuttonhover = dataFields.get("reducebuttonhover");

        if (dataFields.containsKey("background")){
            String backgroundImgString = new String(backgroundImg.toString());
            Background bgimage = new Background(new BackgroundImage(new Image(backgroundImgString), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1280, 720, true, true, true, true) /*BackgroundSize.DEFAULT*/));
            stackpane.setBackground(bgimage);
        }
        if (dataFields.containsKey("backgroundframe")){
            String backgroundFrameImgString = new String(backgroundframeImg.toString());
            Image image = new Image(backgroundFrameImgString);
            backgroundframe.setImage(image);
        }
        if (dataFields.containsKey("closebutton")) {
            String closebuttonString = new String(closebutton.toString());
            String closebuttonhoverString = new String(closebuttonhover.toString());
            Background closebtnimage = new Background(new BackgroundImage(new Image(closebuttonString), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(35, 35, false, false, true, false)));
            Background closebtnhoverimage = new Background(new BackgroundImage(new Image(closebuttonhoverString), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(35, 35, false, false, true, false)));
            app_close_btn.setBackground(closebtnimage);
            app_close_btn.setOnMouseEntered(e -> app_close_btn.setBackground(closebtnhoverimage));
            app_close_btn.setOnMouseExited(e -> app_close_btn.setBackground(closebtnimage));
        }
        if (dataFields.containsKey("reducebutton")) {
            String reducebuttonString = new String(reducebutton.toString());
            String reducebuttonhoverString = new String(reducebuttonhover.toString());
            Background reducebuttonimage = new Background(new BackgroundImage(new Image(reducebuttonString), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(35, 35, false, false, true, false)));
            Background reducebuttonhoverimage = new Background(new BackgroundImage(new Image(reducebuttonhoverString), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(35, 35, false, false, true, false)));
            app_reduce_btn.setBackground(reducebuttonimage);
            app_reduce_btn.setOnMouseEntered(e -> app_reduce_btn.setBackground(reducebuttonhoverimage));
            app_reduce_btn.setOnMouseExited(e -> app_reduce_btn.setBackground(reducebuttonimage));
        }
    }

    private Image toString(Object value) {
        return null;
    }

    public void onSettingsBtnClicked() {
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
        ScrollPane settings_container = (ScrollPane) stage.getScene().lookup("#settings_container");
        boolean show = !settings_container.isVisible();
        setSettingsContainerShown(show);

        statutservermc_container.setManaged(true);
        statutservermc_container.setVisible(true);
    }

    public void onHomeBtnClicked() {
//        ScrollPane settings_container = (ScrollPane) stage.getScene().lookup("#settings_container");
//        boolean show = !settings_container.isVisible();
        boolean show = true;
        setHomeShown(show);
    }

    public void onServerMinecraftStatutBtnClicked() {
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
        boolean show = true;
        statutservermc_container.setManaged(show);
        statutservermc_container.setVisible(show);
    }

    public void onNewsMLBtnClicked() {
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
        ScrollPane newsScrollPane = (ScrollPane) stage.getScene().getRoot().lookup("#newsScrollPane");
        VBox news_container = (VBox) stage.getScene().lookup("#news_container");
        boolean show = !news_container.isVisible();
        setNewsContainerShown(show);

        statutservermc_container.setManaged(true);
        statutservermc_container.setVisible(true);

        Object newstitlelabel = dataFields.get("newstitlebar");
        Object newshbox = dataFields.get("newshbox");
        Object newstextarea = dataFields.get("newstextarea");

        if (dataFields.containsKey("newstitlebar")){
            /*Title Label*/
            String titlelabelColorString = new String(newstitlelabel.toString());
            Color titlelabelColor = Color.web(titlelabelColorString);
            titlelabelColor = titlelabelColor.deriveColor(0, 1.0, 1.0, 0.8);
            /*newshbox*/
            String newshboxString = new String(newshbox.toString());
            Color newshboxColor = Color.web(newshboxString);
            newshboxColor = newshboxColor.deriveColor(0, 1.0, 1.0, 0.8);
            /*newstextarea*/
            String newstextareaString = new String(newstextarea.toString());
            Color newstextareaColor = Color.web(newstextareaString);
            newstextareaColor = newstextareaColor.deriveColor(0, 1.0, 1.0, 0.8);

            for(Node node : anchorepane.getScene().getRoot().lookupAll("#title_label") ){
                Label label = (Label) node;
                label.setBackground(new Background(new BackgroundFill(titlelabelColor, CornerRadii.EMPTY, Insets.EMPTY)));
//                node.setStyle("-fx-background-color: " + titlelabelColor + ";");
            }
            for(Node node : anchorepane.getScene().getRoot().lookupAll("#newshbox") ){
                HBox hbox = (HBox) node;
                hbox.setBackground(new Background(new BackgroundFill(newshboxColor, CornerRadii.EMPTY, Insets.EMPTY)));
//                node.setStyle("-fx-background-color: " + titlelabelColor + ";");
            }
            for(Node node : anchorepane.getScene().getRoot().lookupAll("#content_text") ){
                TextArea hbox = (TextArea) node;
                hbox.setBackground(new Background(new BackgroundFill(newstextareaColor, CornerRadii.EMPTY, Insets.EMPTY)));
//                node.setStyle("-fx-background-color: " + titlelabelColor + ";");
            }
        }
    }

    private void setSettingsContainerShown(boolean show) {
        setTabsShown(false);
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
        ScrollPane settings_container = (ScrollPane) stage.getScene().lookup("#settings_container");
        AnchorPane main_container = (AnchorPane) stage.getScene().lookup("#main_container");
        settings_container.setManaged(show);
        settings_container.setVisible(show);
        main_container.setManaged(!show);
        main_container.setVisible(!show);

        statutservermc_container.setManaged(true);
        statutservermc_container.setVisible(true);
    }

    private void setHomeShown(boolean show) {
        setTabsShown(false);
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
        VBox news_container = (VBox) stage.getScene().lookup("#news_container");
        ScrollPane settings_container = (ScrollPane) stage.getScene().lookup("#settings_container");
        AnchorPane main_container = (AnchorPane) stage.getScene().lookup("#main_container");
        main_container.setManaged(show);
        main_container.setVisible(show);
        statutservermc_container.setManaged(true);
        statutservermc_container.setVisible(true);
        news_container.setManaged(!show);
        news_container.setVisible(!show);
        settings_container.setManaged(!show);
        settings_container.setVisible(!show);
    }

    /*private void setServerMinecraftStatutContainerShown(boolean show) {
        setTabsShown(false);
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
        AnchorPane main_container = (AnchorPane) stage.getScene().lookup("#main_container");
        statutservermc_container.setManaged(show);
        statutservermc_container.setVisible(show);
        setManagedAll(statutservermc_container, show);
        setManagedAll(main_container, !show);
    }*/

    private void setNewsContainerShown(boolean show) {
        setTabsShown(false);
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
        VBox news_container = (VBox) stage.getScene().lookup("#news_container");
        ScrollPane newsScrollPane = (ScrollPane) stage.getScene().lookup("#newsScrollPane");
        AnchorPane main_container = (AnchorPane) stage.getScene().lookup("#main_container");
        setManagedAll(news_container, show);
        setManagedAll(newsScrollPane, show);
        statutservermc_container.setManaged(true);
        statutservermc_container.setVisible(true);
        setManagedAll(main_container, !show);
    }

    private void setTabsShown(boolean show) {
        List<Node> tabs = new ArrayList<>();

        VBox news_container = (VBox) stage.getScene().lookup("#news_container");
        ScrollPane newsScrollPane = (ScrollPane) stage.getScene().lookup("#newsScrollPane");
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
        ScrollPane settings_container = (ScrollPane) stage.getScene().lookup("#settings_container");
        AnchorPane main_container = (AnchorPane) stage.getScene().lookup("#main_container");

        tabs.addAll(Arrays.asList(news_container, newsScrollPane, statutservermc_container, settings_container, main_container));

        statutservermc_container.setManaged(true);
        statutservermc_container.setVisible(true);

        for (Node tab : tabs) {
            tab.setManaged(show);
            tab.setVisible(show);
        }
    }

    private void setManagedAll(Node node, boolean show) {
        node.setVisible(show);
        node.setManaged(show);
    }
}