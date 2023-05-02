module com.sunbe85.apcsfinal {
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.controls;
    opens com.sunbe85.apcsfinal to javafx.fxml;
    exports com.sunbe85.apcsfinal;
    exports com.sunbe85.apcsfinal.classes;
    opens com.sunbe85.apcsfinal.classes to javafx.fxml;
}