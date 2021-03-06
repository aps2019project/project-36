package Menu;


import Collective.Card.Hero;
import Player.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Battle.*;
import Consts.Consts;
import Menu.MainMenuView;
import Menu.Menu;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Graphics extends Application {

    public static ObjectOutputStream objectOutputStream;
    public static Stage stage;
    public static Player player = new Player();
    private Media backgroundMusic = new Media(getClass ().getResource ("/audio/Tower-Defense_Looping.mp3").toExternalForm ());
    MediaPlayer backgroundMusicPlayer = new MediaPlayer (backgroundMusic);
    @Override
    public void start(Stage primaryStage) throws Exception {
        backgroundMusicPlayer.play ();
        stage = primaryStage;
        player.setUsername("yegi");
        Deck deck = new Deck();
        Consts.setBattleDeck(deck);
        player.setMainDeck(deck);

//        BattleView battle = new BattleView();
//        primaryStage.setTitle("duelyst");
//        primaryStage.setScene(battle.getBattleScene());
//        primaryStage.show();


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



    public static void graphics(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8000);

        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        //ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        //System.out.println("here");

        ClientInfo clientInfo = Main.clientInfo;
        clientInfo.setOrder("new");


        objectOutputStream.writeObject(clientInfo);
        objectOutputStream.flush();

        //socket.close();

        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        ClientInfo object = (ClientInfo) objectInputStream.readObject();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();*/

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