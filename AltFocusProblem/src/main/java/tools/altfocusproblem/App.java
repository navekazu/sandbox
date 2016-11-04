package tools.altfocusproblem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public App() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("DBComparator2");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main( String[] args ) {
        Application.launch(App.class, args);
    }
}
