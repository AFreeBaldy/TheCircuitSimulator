package com.capedbaldy.thecircuitsimulator.controllers;

import com.capedbaldy.thecircuitsimulator.Core;
import com.capedbaldy.thecircuitsimulator.SceneList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadProjectController extends Pane implements Initializable, MyControllers {
    public ListView<String> listView;
    public Pane backButton;
    public Pane deleteButton;
    public Pane renameButton;
    public Pane copyButton;
    public Pane loadButton;
    private final Core core = Core.getInstance();

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Text text;
        text = (Text) backButton.lookup("Text");
        text.setText("BACK");
        text = (Text) deleteButton.lookup("Text");
        text.setText("DELETE");
        text = (Text) renameButton.lookup("Text");
        text.setText("RENAME");
        text = (Text) copyButton.lookup("Text");
        text.setText("COPY");
        text = (Text) loadButton.lookup("Text");
        text.setText("LOAD");

        bindMouseEvents();
    }

    private void bindMouseEvents() {
        HBox button;
        button = (HBox) backButton.lookup(".my-btn");
        button.setOnMouseClicked(this::onBackButtonClicked);
        button = (HBox) deleteButton.lookup(".my-btn");
        button.setOnMouseClicked(this::onDeleteButtonClicked);
        button = (HBox) renameButton.lookup(".my-btn");
        button.setOnMouseClicked(this::onRenameButtonClicked);
        button = (HBox) copyButton.lookup(".my-btn");
        button.setOnMouseClicked(this::onCopyButtonClicked);
        button = (HBox) loadButton.lookup(".my-btn");
        button.setOnMouseClicked(this::onLoadButtonClicked);
        listView.setOnMouseClicked(this::onListViewClicked);
    }

    private void renderProjectList() {
        ArrayList<String> projectNames = core.getProjectNames();
        listView.getItems().clear();
        listView.getItems().addAll(projectNames);
    }

    private void onListViewClicked(MouseEvent mouseEvent) {

    }

    private void onLoadButtonClicked(MouseEvent mouseEvent) {

    }

    private void onCopyButtonClicked(MouseEvent mouseEvent) {

    }

    private void onRenameButtonClicked(MouseEvent mouseEvent) {

    }

    private void onDeleteButtonClicked(MouseEvent mouseEvent) {

    }

    private void onBackButtonClicked(MouseEvent mouseEvent) {
        core.switchToScene(SceneList.HOME);
    }
}
