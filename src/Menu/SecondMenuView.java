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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SecondMenuView {
    private Group secondMenuRoot;
    private Scene secondMenuScene;

    private Image buttonImage = new Image("pics/button_secondary@2x.png");
    private Image buttonImage1 = new Image("pics/button_secondary_glow.png");
    private Image secondMenuBackgroundImage = new Image("pics/secondMenu.jpg");

    private Button collectionButton = new Button("Collection");
    private Button shopButton = new Button("Shop");
    private Button battleButton = new Button("Battle");
    private Button mainMenuButton= new Button("Main Menu");

    private Label collectionLabel = new Label("Collection");
    private Label shopLabel = new Label("Shop");
    private Label battleLabel = new Label("Battle");
    private Label mainMenuLabel= new Label ("Home");

    private final int buttonSizeWidth = 250;
    private final int buttonSizeHeight = 80;

    private ImageView collectionButtonImageView = new ImageView(buttonImage);
    private ImageView collectionButtonImageView1 = new ImageView(buttonImage1);
    private ImageView shopButtonImageView = new ImageView(buttonImage);
    private ImageView shopButtonImageView1 = new ImageView(buttonImage1);
    private ImageView battleButtonImageView = new ImageView(buttonImage);
    private ImageView battleButtonImageView1 = new ImageView(buttonImage1);
    private ImageView mainMenuButtonImageView = new ImageView(buttonImage);
    private ImageView mainMenuButtonImageView1 = new ImageView(buttonImage1);

    private ImageView backgroundImageView = new ImageView(secondMenuBackgroundImage);


    private Media mouseClicked = new Media(getClass ( ).getClassLoader ().getResource ("audio/Button-SoundBible.com-1420500901.mp3" ).toExternalForm ());
    private Media mouseEntered= new Media (getClass().getClassLoader().getResource ("audio/zapsplat_multimedia_click_003_19369.mp3").toExternalForm ());
    MediaPlayer clickedPlayer= new MediaPlayer (mouseClicked);
    MediaPlayer enteredPlayer= new MediaPlayer (mouseEntered);

    public SecondMenuView() {

        enteredPlayer.setVolume(0.1);
        secondMenuRoot = new Group();
        backgroundImageView.setFitHeight(Consts.height);
        backgroundImageView.setFitWidth(Consts.width);
        secondMenuScene = new Scene(secondMenuRoot, Consts.width, Consts.height);
        secondMenuRoot.getChildren().add(backgroundImageView);


        //collection
        setImageView(collectionButtonImageView, 3);
        setImageView(collectionButtonImageView1, 3);
        collectionButtonImageView1.setOpacity(0);
        setButton(collectionButton, 3);
        setLabel(collectionLabel, 3);
        secondMenuRoot.getChildren().add(collectionButtonImageView);
        secondMenuRoot.getChildren().add(collectionButtonImageView1);
        secondMenuRoot.getChildren().add(collectionButton);
        secondMenuRoot.getChildren().add(collectionLabel);

        //shop
        setImageView(shopButtonImageView, 1);
        setImageView(shopButtonImageView1, 1);
        shopButtonImageView1.setOpacity(0);
        setButton(shopButton, 1);
        setLabel(shopLabel, 1);
        secondMenuRoot.getChildren().add(shopButtonImageView);
        secondMenuRoot.getChildren().add(shopButtonImageView1);
        secondMenuRoot.getChildren().add(shopLabel);
        secondMenuRoot.getChildren().add(shopButton);

        //battle
        setImageView(battleButtonImageView, 2);
        setImageView(battleButtonImageView1, 2);
        battleButtonImageView1.setOpacity(0);
        setButton(battleButton , 2);
        setLabel(battleLabel, 2);
        secondMenuRoot.getChildren().add((battleButtonImageView));
        secondMenuRoot.getChildren().add((battleButtonImageView1));
        secondMenuRoot.getChildren().add(battleLabel);
        secondMenuRoot.getChildren().add(battleButton );


        //main menu
        setImageView(mainMenuButtonImageView, 0);
        setImageView(mainMenuButtonImageView1, 0);
        mainMenuButtonImageView1.setOpacity(0);
        setButton(mainMenuButton, 0);
        setLabel(mainMenuLabel, 0);
        secondMenuRoot.getChildren().add(mainMenuButtonImageView);
        secondMenuRoot.getChildren().add(mainMenuButtonImageView1);
        secondMenuRoot.getChildren().add(mainMenuLabel);
        secondMenuRoot.getChildren().add(mainMenuButton);

        checkMovements();

    }

    public Scene getSecondMenuScene() {
        return secondMenuScene;
    }

    public void checkMovements() {

        shopButton.setOnMouseEntered(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {


                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if ( shopButtonImageView.getOpacity() == 100)
                    shopButtonImageView.setOpacity(0);
                if ( shopButtonImageView1.getOpacity() == 0)
                    shopButtonImageView1.setOpacity(100);
            }
        });


        shopButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (  shopButtonImageView1.getOpacity() == 100)
                    shopButtonImageView1.setOpacity(0);
                if (  shopButtonImageView.getOpacity() == 0)
                    shopButtonImageView.setOpacity(100);
            }
        });



        collectionButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if ( collectionButtonImageView.getOpacity() == 100)
                    collectionButtonImageView.setOpacity(0);
                if ( collectionButtonImageView1.getOpacity() == 0)
                    collectionButtonImageView1.setOpacity(100);
            }
        });


        collectionButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( collectionButtonImageView1.getOpacity() == 100)
                    collectionButtonImageView1.setOpacity(0);
                if ( collectionButtonImageView.getOpacity() == 0)
                    collectionButtonImageView.setOpacity(100);
            }
        });

        battleButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (battleButtonImageView.getOpacity() == 100)
                    battleButtonImageView.setOpacity(0);
                if (battleButtonImageView1.getOpacity() == 0)
                    battleButtonImageView1.setOpacity(100);
            }
        });


        battleButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( battleButtonImageView1.getOpacity() == 100)
                    battleButtonImageView1.setOpacity(0);
                if ( battleButtonImageView.getOpacity() == 0)
                    battleButtonImageView.setOpacity(100);
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



        collectionButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                Menu.secondMenuCommand("collection");
            }
        });

        shopButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                Menu.secondMenuCommand("shop");
            }
        });

        battleButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                Menu.secondMenuCommand("battle");
            }
        });


        mainMenuButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                Menu.secondMenuCommand("exit");
            }
        });


        Button exit = new Button("");
        try {
            Image image = new Image(new FileInputStream("/Users/rostaroghani/Desktop/project-3/src/pics/button_close.png"));
            ImageView exitButtonImageView = new ImageView(image);
            exitButtonImageView.setFitWidth(50);
            exitButtonImageView.setFitHeight(50);
            exitButtonImageView.setX(10);
            exitButtonImageView.setY(10);
            secondMenuRoot.getChildren().add(exitButtonImageView);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            Image image1 = new Image(new FileInputStream("/Users/rostaroghani/Desktop/project-3/src/pics/button_close@2x.png"));
            ImageView exitButtonImageView1 = new ImageView(image1);
            exitButtonImageView1.setFitWidth(50);
            exitButtonImageView1.setFitHeight(50);
            exitButtonImageView1.setX(10);
            exitButtonImageView1.setY(10);
            secondMenuRoot.getChildren().add(exitButtonImageView1);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        exit.setPrefSize(40, 40);
        exit.relocate(20, 20);
        exit.setOpacity(0);
        secondMenuRoot.getChildren().add(exit);

        exit.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                Menu.secondMenuCommand("exit");
            }
        });


    }

    public void setImageView(ImageView buttonImageView, int n) {

        buttonImageView.setFitWidth(buttonSizeWidth);
        buttonImageView.setFitHeight(buttonSizeHeight);
        buttonImageView.setX(Consts.width / 2 + 70);
        buttonImageView.setY(Consts.height / 2.7 + n * Consts.distance);

    }

    public void setButton(Button button, int n) {
        button.setOpacity(0);
        button.relocate(Consts.width / 2 + 70, Consts.height / 2.7 + n * Consts.distance);
        button.setPrefSize(buttonSizeWidth, buttonSizeHeight);
    }

    public void setLabel(Label label, int n) {
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        if(n== 3)
            label.relocate(Consts.width / 2 + 150, Consts.height / 2.7 + n * Consts.distance + 27);
        else if (n== 2)
            label.relocate(Consts.width / 2 + 165, Consts.height / 2.7 + n * Consts.distance + 27);
        else
            label.relocate(Consts.width / 2 + 170, Consts.height / 2.7 + n * Consts.distance + 27);
    }
}
