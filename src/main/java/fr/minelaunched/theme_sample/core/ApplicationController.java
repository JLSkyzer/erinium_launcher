package fr.minelaunched.theme_sample.core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public ApplicationController(Stage stage) {
        this.stage = stage;
        stage.setTitle("Erinium World");
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.centerOnScreen();
        stage.setResizable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnchorPane statutservermc_container = (AnchorPane) stage.getScene().lookup("#statutservermc_container");
//        setManagedAll(btnServerMinecraftStatut, isStatutServerMCEnabled);
        setManagedAll(btnNewsML, isNewsMLEnabled);
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
        VBox news_container = (VBox) stage.getScene().lookup("#news_container");
        boolean show = !news_container.isVisible();
        setNewsContainerShown(show);

        statutservermc_container.setManaged(true);
        statutservermc_container.setVisible(true);
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