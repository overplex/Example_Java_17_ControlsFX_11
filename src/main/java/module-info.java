module hellofx {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    
    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}
