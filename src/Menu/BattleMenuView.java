package Menu;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import Consts.Consts;

import javax.sound.midi.Receiver;
import java.awt.*;
import java.io.File;

public class BattleMenuView {
    private Group battleMenuRoot;
    private Scene battleMenuScene;

    private Image buttonImage = new Image("pics/button_secondary@2x.png");
    private Image buttonImage1 = new Image("pics/button_secondary_glow.png");
    private Image battleBackgroundImage = new Image("pics/anton_fadeev_chapter_23_the_rise.jpg");

    private Button singlePlayerButton = new Button("Single Player");
    private Button multiPlayerButton = new Button("Multi Player");
    private Button helpButton = new Button("Help");
    private Button mainMenuButton= new Button("Home");

    private Label singlePlayerLabel = new Label("Single Player");
    private Label multiPlayerLabel = new Label("Multi Player");
    private Label helpLabel = new Label("Help");
    private Label mainMenuLabel= new Label ("Home");

    private final int buttonSizeWidth = 250;
    private final int buttonSizeHeight = 80;

    private ImageView singlePlayerButtonImageView = new ImageView(buttonImage);
    private ImageView singlePlayerButtonImageView1 = new ImageView(buttonImage1);
    private ImageView multiPlayerButtonImageView = new ImageView(buttonImage);
    private ImageView multiPlayerButtonImageView1 = new ImageView(buttonImage1);
    private ImageView mainMenuButtonImageView = new ImageView(buttonImage);
    private ImageView mainMenuButtonImageView1 = new ImageView(buttonImage1);
    private ImageView helpButtonImageView = new ImageView(buttonImage);
    private ImageView helpButtonImageView1 = new ImageView(buttonImage1);

    private ImageView backgroundImageView = new ImageView(battleBackgroundImage);

    private Media mouseClicked = new Media(getClass ( ).getClassLoader ().getResource ("audio/Button-SoundBible.com-1420500901.mp3" ).toExternalForm ());
    private Media mouseEntered= new Media (getClass().getClassLoader().getResource ("audio/zapsplat_multimedia_click_003_19369.mp3").toExternalForm ());
    MediaPlayer clickedPlayer= new MediaPlayer (mouseClicked);
    MediaPlayer enteredPlayer= new MediaPlayer (mouseEntered);

    public BattleMenuView() {

        enteredPlayer.setVolume(0.5);
        battleMenuRoot = new Group();
        backgroundImageView.setFitHeight(Consts.height);
        backgroundImageView.setFitWidth(Consts.width);
        battleMenuScene = new Scene(battleMenuRoot, Consts.width, Consts.height);
        battleMenuRoot.getChildren().add(backgroundImageView);


        //single player
        setImageView( singlePlayerButtonImageView, 1);
        setImageView( singlePlayerButtonImageView1, 1);
        singlePlayerButtonImageView1.setOpacity(0);
        setButton( singlePlayerButton, 1);
        setLabel (singlePlayerLabel, 1);
        battleMenuRoot.getChildren().add( singlePlayerButtonImageView);
        battleMenuRoot.getChildren().add( singlePlayerButtonImageView1);
        battleMenuRoot.getChildren().add( singlePlayerButton);
        battleMenuRoot.getChildren().add( singlePlayerLabel);

        //multi player
        setImageView(multiPlayerButtonImageView, 2);
        setImageView(multiPlayerButtonImageView1, 2);
        multiPlayerButtonImageView1.setOpacity(0);
        setButton(multiPlayerButton, 2);
        setLabel(multiPlayerLabel, 2);
        battleMenuRoot.getChildren().add(multiPlayerButtonImageView);
        battleMenuRoot.getChildren().add(multiPlayerButtonImageView1);
        battleMenuRoot.getChildren().add(multiPlayerLabel);
        battleMenuRoot.getChildren().add(multiPlayerButton);

        //help button
        setImageView(helpButtonImageView, 3);
        setImageView(helpButtonImageView1, 3);
        helpButtonImageView1.setOpacity(0);
        setButton(helpButton, 3);
        setLabel(helpLabel, 3);
        battleMenuRoot.getChildren().add(helpButtonImageView);
        battleMenuRoot.getChildren().add(helpButtonImageView1);
        battleMenuRoot.getChildren().add(helpLabel);
        battleMenuRoot.getChildren().add(helpButton);

        //main menu
        setImageView(mainMenuButtonImageView, 0);
        setImageView(mainMenuButtonImageView1, 0);
        mainMenuButtonImageView1.setOpacity(0);
        setButton(mainMenuButton, 0);
        setLabel(mainMenuLabel, 0);
        battleMenuRoot.getChildren().add(mainMenuButtonImageView);
        battleMenuRoot.getChildren().add(mainMenuButtonImageView1);
        battleMenuRoot.getChildren().add(mainMenuLabel);
        battleMenuRoot.getChildren().add(mainMenuButton);

        checkMovements();

    }

    public Scene getBattleMenuScene() {
        return battleMenuScene;
    }

    public void checkMovements() {

        singlePlayerButton.setOnMouseEntered(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {


                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (singlePlayerButtonImageView.getOpacity() == 100)
                    singlePlayerButtonImageView.setOpacity(0);
                if (singlePlayerButtonImageView1.getOpacity() == 0)
                    singlePlayerButtonImageView1.setOpacity(100);
            }
        });


        singlePlayerButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( singlePlayerButtonImageView1.getOpacity() == 100)
                    singlePlayerButtonImageView1.setOpacity(0);
                if ( singlePlayerButtonImageView.getOpacity() == 0)
                    singlePlayerButtonImageView.setOpacity(100);
            }
        });



        multiPlayerButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (multiPlayerButtonImageView.getOpacity() == 100)
                    multiPlayerButtonImageView.setOpacity(0);
                if (multiPlayerButtonImageView1.getOpacity() == 0)
                    multiPlayerButtonImageView1.setOpacity(100);
            }
        });


        multiPlayerButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (multiPlayerButtonImageView1.getOpacity() == 100)
                    multiPlayerButtonImageView1.setOpacity(0);
                if (multiPlayerButtonImageView.getOpacity() == 0)
                    multiPlayerButtonImageView.setOpacity(100);
            }
        });


        helpButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (helpButtonImageView.getOpacity() == 100)
                    helpButtonImageView.setOpacity(0);
                if (helpButtonImageView1.getOpacity() == 0)
                    helpButtonImageView1.setOpacity(100);
            }
        });


        helpButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (helpButtonImageView1.getOpacity() == 100)
                    helpButtonImageView1.setOpacity(0);
                if (helpButtonImageView.getOpacity() == 0)
                    helpButtonImageView.setOpacity(100);
            }
        });

        mainMenuButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (mainMenuButtonImageView.getOpacity() == 100)
                    mainMenuButtonImageView.setOpacity(0);
                if (mainMenuButtonImageView1.getOpacity() == 0)
                    mainMenuButtonImageView1.setOpacity(100);
            }
        });


        mainMenuButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (mainMenuButtonImageView1.getOpacity() == 100)
                    mainMenuButtonImageView1.setOpacity(0);
                if (mainMenuButtonImageView.getOpacity() == 0)
                    mainMenuButtonImageView.setOpacity(100);
            }
        });


        singlePlayerButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
            }
        });

        multiPlayerButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
            }
        });

        mainMenuButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
            }
        });

        helpButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
            }
        });

    }

    public void setImageView(ImageView buttonImageView, int n) {

        buttonImageView.setFitWidth(buttonSizeWidth);
        buttonImageView.setFitHeight(buttonSizeHeight);
        buttonImageView.setX(Consts.width / 2 + 20);
        buttonImageView.setY(Consts.height / 2.7 + n * Consts.distance);

    }

    public void setButton(Button button, int n) {
        button.setOpacity(0);
        button.relocate(Consts.width / 2 + 20, Consts.height / 2.7 + n * Consts.distance);
        button.setPrefSize(buttonSizeWidth, buttonSizeHeight);
    }

    public void setLabel(Label label, int n) {
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        if(n==0){
            label.relocate(Consts.width / 2 + 120, Consts.height / 2.7 + n * Consts.distance + 27);
        }
        else if(n==3){
            label.relocate(Consts.width / 2 + 120, Consts.height / 2.7 + n * Consts.distance + 27);
        }
        else
            label.relocate(Consts.width / 2 + 90, Consts.height / 2.7 + n * Consts.distance + 27);

    }
}
