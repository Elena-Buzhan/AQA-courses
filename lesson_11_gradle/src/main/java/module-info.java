module com.example.lesson_11_gradle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lesson_11_gradle to javafx.fxml;
    exports com.example.lesson_11_gradle;
}