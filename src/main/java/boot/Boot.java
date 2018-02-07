package boot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Boot extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));

        primaryStage.setTitle("AddressBook v1.2");
        Scene scene = new Scene(root,900,700);

        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(700);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
