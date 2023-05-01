package com.capedbaldy.thecircuitsimulator.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class ButtonController implements Initializable {
    @FXML
    HBox root;

    @FXML
    Text text;

    private ArrayList<Consumer<MouseEvent>> callStack;
    public void addFunctionToCallStack(Consumer<MouseEvent> call) {
        callStack.add(call);
    }

    public void removeFunctionCallStack(Consumer<MouseEvent> call)
    {
        callStack.remove(call);
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        callStack = new ArrayList<>();
    }

    public void onButtonClicked(MouseEvent mouseEvent) {
        for (Consumer<MouseEvent> call:
        callStack){
            call.accept(mouseEvent);
        }
    }

    public void onMouseEntered(MouseEvent mouseEvent) {

    }

    public void onMouseExited(MouseEvent mouseEvent) {

    }
}
