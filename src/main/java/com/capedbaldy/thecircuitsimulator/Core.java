package com.capedbaldy.thecircuitsimulator;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class Core {

    private static Core instance;

    private final Stage window;
    private boolean isRunning;
    private final SceneHandler sceneHandler;
    private final ProjectManager projectManager;
    private Core(Stage stage) {
        // private constructor to prevent instantiation
        window = stage;
        isRunning = false;
        sceneHandler = new SceneHandler();
        stage.setResizable(false);
        projectManager = new ProjectManager();
    }

    public static Core getInstance(Stage stage) {
        if (instance == null) {
            instance = new Core(stage);
        }
        return instance;
    }


    public static Core getInstance() {
        return Objects.requireNonNull(instance);
    }
    public void run() {
        if (isRunning)
            throw new RuntimeException();
        isRunning = true;
        sceneHandler.switchToScene(SceneList.HOME, window);
    }

    public void exit() {
        isRunning = false;
        window.close();
    }

    public void save() {

    }

    public void switchToScene(SceneList scene) {
        sceneHandler.switchToScene(scene, window);
    }

    public boolean isValidProject(String text) {
        return projectManager.doesProjectExist(text);
    }

    public void createProject(String text) {
        projectManager.createProject(text);
    }

    public ArrayList<String> getProjectNames() {
        return projectManager.getProjectNames();
    }
}
