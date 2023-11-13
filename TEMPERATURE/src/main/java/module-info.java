module com.yashpreet.temperature {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.yashpreet.temperature to javafx.fxml;
    exports com.yashpreet.temperature;
}