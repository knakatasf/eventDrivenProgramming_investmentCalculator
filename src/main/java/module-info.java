module org.example.lab11_javafx_eventdrivenprogramming {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab11_javafx_eventdrivenprogramming to javafx.fxml;
    exports org.example.lab11_javafx_eventdrivenprogramming;
}