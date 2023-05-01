package com.capedbaldy.thecircuitsimulator.controllers;

import com.capedbaldy.thecircuitsimulator.Core;
import com.capedbaldy.thecircuitsimulator.SceneList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateProjectController extends Pane implements Initializable, MyControllers {

    public TextField textBox;
    public VBox backButton;
    public VBox createButton;
    public Text errorText;

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
        text = (Text) createButton.lookup("Text");
        text.setText("CREATE");
        handleTextBoxError();

        bindEvents();
    }

    private void bindEvents() {
        textBox.setOnAction((ActionEvent) -> submit());
        textBox.setOnKeyTyped(this::keyPressedInTextBox);
        HBox button;
        button = (HBox) backButton.lookup(".my-btn");
        button.setOnMouseClicked(this::onBackButtonClicked);

        button = (HBox) createButton.lookup(".my-btn");
        button.setOnMouseClicked((MouseEvent) -> submit());
    }

    private void onBackButtonClicked(MouseEvent mouseEvent) {
        core.switchToScene(SceneList.HOME);
    }

    private void submit() {
        if (textBox.getText().isBlank() || core.isValidProject(textBox.getText()))
            return;
        core.createProject(textBox.getText());
        core.switchToScene(SceneList.PROJECT);
    }
    private void keyPressedInTextBox(KeyEvent actionEvent) {
        handleTextBoxError();
    }

    private void handleTextBoxError() {
        if (textBox.getText().isBlank()) {
            String emptyProjectNameError = "Please enter a name for this project";
            errorText.setText(emptyProjectNameError);
            errorText.setVisible(true);
            createButton.lookup(".my-btn").setDisable(true);
        }
        else if (core.isValidProject(textBox.getText()))
        {
            String existingProjectNameError = "Project already exists";
            errorText.setText(existingProjectNameError);
            errorText.setVisible(true);
            createButton.lookup(".my-btn").setDisable(true);
        } else {
            errorText.setVisible(false);
            createButton.lookup(".my-btn").setDisable(false);
        }
    }

    public void onSceneHidden() {

    }
}
