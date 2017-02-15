package tools.altfocusproblem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App2 extends Application {
    public static void main( String[] args ) {
        Application.launch(App2.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        MenuBar menuBar = new MenuBar();
        Menu menuItem = new Menu("aaa");
        menuBar.getMenus().add(menuItem);
        root.getChildren().add(menuBar);
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();

        menuBar.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            System.out.println("KEY_PRESSED");
        });

    }
}
