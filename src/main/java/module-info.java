module fes.ico.camisasfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens fes.ico.camisasfx to javafx.fxml;
    exports fes.ico.camisasfx;
    exports fes.ico.camisasfx.controller;
    opens fes.ico.camisasfx.controller to javafx.fxml;
}