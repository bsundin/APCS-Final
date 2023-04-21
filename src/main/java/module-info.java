module com.sunbe85.apcsfinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.sunbe85.apcsfinal to javafx.fxml;
    exports com.sunbe85.apcsfinal;
}