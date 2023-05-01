package com.capedbaldy.thecircuitsimulator.controllers;

import com.capedbaldy.thecircuitsimulator.Core;
import com.capedbaldy.thecircuitsimulator.SceneList;
import javafx.fxml.Initializable;
import javafx.geometry.Dimension2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController extends Pane implements Initializable, MyControllers {

    public TextFlow titleTextFlow;
    public VBox homePageNode;
    public HBox loadProjectButton;
    public HBox createProjectButton;
    public HBox exitButton;
    private final Core core;

    private final Dimension2D PREF_DIMENSION = new Dimension2D(1080, 720);

    public HomeController() {
        minWidth(PREF_DIMENSION.getWidth());
        minHeight(PREF_DIMENSION.getHeight());
        prefWidth(PREF_DIMENSION.getWidth());
        prefHeight(PREF_DIMENSION.getHeight());
        core = Core.getInstance();
    }


    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ((Text) loadProjectButton.lookup("Text")).setText("LOAD PROJECT");
        ((Text) createProjectButton.lookup("Text")).setText("NEW PROJECT");
        ((Text) exitButton.lookup("Text")).setText("EXIT");


        initMouseEvents();
    }

    private void initMouseEvents() {
        loadProjectButton.getChildren().get(0).setOnMouseClicked(this::onMenuButtonClicked);
        createProjectButton.getChildren().get(0).setOnMouseClicked(this::onMenuButtonClicked);
        exitButton.getChildren().get(0).setOnMouseClicked(this::onMenuButtonClicked);
    }

    private void onMenuButtonClicked(MouseEvent mouseEvent) {
        if (((HBox) mouseEvent.getSource()).getParent().equals(loadProjectButton)) {
            core.switchToScene(SceneList.LOAD_PROJECT);
            return;
        }
        if (((HBox) mouseEvent.getSource()).getParent().equals(createProjectButton)) {
            core.switchToScene(SceneList.CREATE_PROJECT);
            return;
        }
        core.exit();
    }
}
