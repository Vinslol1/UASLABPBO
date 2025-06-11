module com.pos.bukanpedulilindungi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.jdi;
    requires java.desktop;
    requires mysql.connector.java;
    requires javafx.base;

    opens com.pos.bukanpedulilindungi to javafx.fxml;
    exports com.pos.bukanpedulilindungi;
}