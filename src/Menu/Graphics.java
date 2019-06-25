package Menu;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Battle.*;
import Consts.Consts;
import Menu.MainMenuView;
import Menu.Menu;
import java.util.Scanner;

public class Graphics extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        /*BattleView menu = new BattleView();

        primaryStage.setTitle("duelyst");
        primaryStage.setScene(menu.getBattleScene());
        primaryStage.show();*/


        stage = primaryStage;

        Image iconImage = new Image("pics/icon.png");
        ImageView imageView = new ImageView(iconImage);
        imageView.setX(Consts.width / 2 - 100);
        imageView.setY(Consts.height / 2 - 100);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        Group group = new Group();
        group.getChildren().add(imageView);

        primaryStage.setTitle("duelyst");
        primaryStage.setScene(new Scene( group, Consts.width, Consts.height));
        primaryStage.show();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Menu.menu();
            }
        });
        thread.start();
    }

    public static void graphics(String[] args) {

        launch(args);
    }

    public static void changeScene(Scene scene) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                stage.setScene(scene);
            }
        });
        /*
        stage.setScene(scene);*/
    }
}