package com.capedbaldy.thecircuitsimulator;

import com.capedbaldy.thecircuitsimulator.controllers.CreateProjectController;
import com.capedbaldy.thecircuitsimulator.controllers.HomeController;
import com.capedbaldy.thecircuitsimulator.controllers.LoadProjectController;
import com.capedbaldy.thecircuitsimulator.controllers.MyControllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneHandler {
    private final HashMap<SceneList, Scene> scenes;
    private final HashMap<Scene, MyControllers> controllers;

    public SceneHandler() {
        this.scenes = new HashMap<>();
        controllers = new HashMap<>();
    }


    private void loadHomeScene(Stage window) {

        HomeController container = new HomeController();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/capedbaldy/thecircuitsimulator/fxml/home.fxml"));
        fxmlLoader.setRoot(container);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        Scene scene = new Scene(container);

        window.setScene(scene);
        window.setTitle("The Circuit Simulator");
        window.show();
        scenes.put(SceneList.HOME, scene);
    }


    public void switchToScene(SceneList scene, Stage  window) {
        if (!scenes.containsKey(scene)) {
            if (scene == SceneList.HOME)
                loadHomeScene(window);
            if (scene == SceneList.CREATE_PROJECT)
                loadCreateProjectScene(window);
            if (scene == SceneList.LOAD_PROJECT)
                loadLoadProjectScene(window);
            return;
        }
        window.setScene(scenes.get(scene));
    }

    private void loadLoadProjectScene(Stage window) {
        LoadProjectController container = new LoadProjectController();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/capedbaldy/thecircuitsimulator/fxml/load-project.fxml"));
        fxmlLoader.setRoot(container);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        Scene scene = new Scene(container);
        window.setScene(scene);
        window.setTitle("The Circuit Simulator");
        window.show();
        scenes.put(SceneList.LOAD_PROJECT, scene);
    }

    @SuppressWarnings("Duplicates")
    private void loadCreateProjectScene(Stage window) {
        CreateProjectController container = new CreateProjectController();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/capedbaldy/thecircuitsimulator/fxml/create-project.fxml"));
        fxmlLoader.setRoot(container);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        Scene scene = new Scene(container);
        window.setScene(scene);
        window.setTitle("The Circuit Simulator");
        window.show();
        scenes.put(SceneList.CREATE_PROJECT, scene);
    }
}
