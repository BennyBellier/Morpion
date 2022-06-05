module com.morpion {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.morpion to javafx.fxml;
    exports com.morpion;
}
