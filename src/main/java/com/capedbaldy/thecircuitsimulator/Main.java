package com.capedbaldy.thecircuitsimulator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Core core;
    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage stage) throws Exception {
        core = Core.getInstance(stage);
        core.run();
    }

    @Override
    public void stop() throws Exception {
        core.save();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
