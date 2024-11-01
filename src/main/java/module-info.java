module org.example.regexjavadoccsc311 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.regexjavadoccsc311 to javafx.fxml;
    exports org.example.regexjavadoccsc311;
}