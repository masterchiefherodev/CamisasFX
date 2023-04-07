module fes.ico.camisasfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens fes.ico.camisasfx to javafx.fxml;
    exports fes.ico.camisasfx;
    exports fes.ico.camisasfx.controller;
    opens fes.ico.camisasfx.controller to javafx.fxml;
}