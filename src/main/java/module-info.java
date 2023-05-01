module com.capedbaldy.thecircuitsimulator {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    opens com.capedbaldy.thecircuitsimulator;
    opens com.capedbaldy.thecircuitsimulator.controllers;
    exports com.capedbaldy.thecircuitsimulator to javafx.graphics, javafx.fxml, javafx.controls;
}