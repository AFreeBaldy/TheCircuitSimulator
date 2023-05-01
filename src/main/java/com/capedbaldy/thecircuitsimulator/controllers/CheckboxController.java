package com.capedbaldy.thecircuitsimulator.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class CheckboxController implements Initializable {
    @FXML
    public HBox checkbox;
    @FXML
    public SVGPath checkmark;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        update();
    }

    private boolean isSelected;
    private ArrayList<Consumer<Boolean>> functionCallStack;

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        functionCallStack = new ArrayList<>();
    }


    private void update() {
        if (isSelected) {
            checkbox.getStyleClass().add("selected");
        } else {
            checkbox.getStyleClass().remove("selected");
        }
        for (Consumer<Boolean> consumer :
                functionCallStack) {
            consumer.accept(isSelected);
        }
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
        isSelected = !isSelected;
        update();
    }

    public void onMouseEntered(MouseEvent mouseEvent) {

    }

    public void onMouseExited(MouseEvent mouseEvent) {

    }

    public void addFunctionToCallStack(Consumer<Boolean> mockConsumer) {
        functionCallStack.add(mockConsumer);
    }
}
