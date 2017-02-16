package tools.altfocusproblem;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class App extends Application implements Initializable {
    @FXML
    private MenuBar menuBar;

    public App() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Alt Focus Problem");
        primaryStage.setScene(scene);


//        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        primaryStage.show();
    }

    @FXML
    private void onInputMethodTextChangedProperty(InputMethodEvent event) {
        System.out.println("onInputMethodTextChangedProperty");
    }
    @FXML
    private void onKeyPressed(KeyEvent event) {
        // Alt単体が押された場合は、そのイベントを無効にする
        System.out.println("onKeyPressed source:"+event.getSource());
//        System.out.println("onKeyPressed event.toString():"+event.toString());
//        System.out.println("onKeyPressed event.getCharacter():"+event.getCharacter());
//        System.out.println("onKeyPressed event.getCode():"+event.getCode());
        if (event.getCode()== KeyCode.ALT &&
                event.isAltDown() &&
                !event.isControlDown() &&
                !event.isMetaDown() &&
                !event.isShiftDown() &&
                !event.isShortcutDown()
                ) {
            event.consume();
        }
    }
    @FXML
    private void onKeyReleased(KeyEvent event) {
//        System.out.println("onKeyReleased source:"+event.getSource());
//        System.out.println("onKeyReleased menuBar.isFocused():"+menuBar.isFocused());
//        if (menuBar.isFocused()) {
//            menuBar.setFocusTraversable(false);
//            menuBar.setFocusTraversable(true);
//        } else {
//            menuBar.requestFocus();
//        }
    }
    @FXML
    private void onKeyTyped(KeyEvent event) {
//        System.out.println("onKeyTyped source:"+event.getSource());
    }
    public static void main( String[] args ) {
        Application.launch(App.class, args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        menuBar.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            System.out.println("KEY_PRESSED");
//        });
    }
}
