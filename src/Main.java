import Menu.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        MainMenuView mainMenu = new MainMenuView();

        primaryStage.setTitle("duelyst");
        primaryStage.setScene(mainMenu.getMainMenuScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        Menu.menu();

        launch(args);
    }
}