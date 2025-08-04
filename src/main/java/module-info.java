module com.mycompany.p2p {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.p2p to javafx.fxml;
    exports com.mycompany.p2p;
}
