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

import java.io.File;

public class ShopMenuView {
    private Group shopMenuRoot;
    private Scene shopMenuScene;

    private Image buttonImage = new Image("pics/button_secondary@2x.png");
    private Image buttonImage1 = new Image("pics/button_secondary_glow.png");
    private Image shopBackgroundImage = new Image("pics/counterplay-games-the-great-tree-eyos.jpg");

    private Button showCollectionButton = new Button("Show Collection");
    private Button searchButton = new Button("Search");
    private Button searchCollectionButton = new Button("Search Collection");
    private Button buyButton = new Button("Buy");
    private Button sellButton = new Button("Sell");
    private Button helpButton = new Button("Help");
    private Button showButton= new Button("Show");
    private Button mainMenuButton= new Button("Main Menu");

    private Label showCollectionLabel = new Label("Show Collection");
    private Label searchLabel = new Label("Search");
    private Label searchCollectionLabel = new Label("Search Collection");
    private Label buyLabel = new Label("Buy");
    private Label sellLabel = new Label("Sell");
    private Label helpLabel = new Label("Help");
    private Label showLabel= new Label ("Show");
    private Label mainMenuLabel= new Label ("Home");

    private final int buttonSizeWidth = 250;
    private final int buttonSizeHeight = 80;

    private ImageView showButtonImageView = new ImageView(buttonImage);
    private ImageView showButtonImageView1 = new ImageView(buttonImage1);
    private ImageView showCollectionButtonImageView = new ImageView(buttonImage);
    private ImageView showCollectionButtonImageView1 = new ImageView(buttonImage1);
    private ImageView searchButtonImageView = new ImageView(buttonImage);
    private ImageView searchButtonImageView1 = new ImageView(buttonImage1);
    private ImageView searchCollectionButtonImageView = new ImageView(buttonImage);
    private ImageView searchCollectionButtonImageView1 = new ImageView(buttonImage1);
    private ImageView buyButtonImageView = new ImageView(buttonImage);
    private ImageView buyButtonImageView1 = new ImageView(buttonImage1);
    private ImageView sellButtonImageView = new ImageView(buttonImage);
    private ImageView sellButtonImageView1 = new ImageView(buttonImage1);
    private ImageView mainMenuButtonImageView = new ImageView(buttonImage);
    private ImageView mainMenuButtonImageView1 = new ImageView(buttonImage1);
    private ImageView helpButtonImageView = new ImageView(buttonImage);
    private ImageView helpButtonImageView1 = new ImageView(buttonImage1);

    private ImageView backgroundImageView = new ImageView(shopBackgroundImage);


    private Media mouseClicked = new Media(getClass ( ).getClassLoader ().getResource ("audio/Button-SoundBible.com-1420500901.mp3" ).toExternalForm ());
    private Media mouseEntered= new Media (getClass().getClassLoader().getResource ("audio/zapsplat_multimedia_click_003_19369.mp3").toExternalForm ());
    MediaPlayer clickedPlayer= new MediaPlayer (mouseClicked);
    MediaPlayer enteredPlayer= new MediaPlayer (mouseEntered);

    public ShopMenuView() {

        enteredPlayer.setVolume(0.1);
        shopMenuRoot = new Group();
        backgroundImageView.setFitHeight(Consts.height);
        backgroundImageView.setFitWidth(Consts.width);
        shopMenuScene = new Scene(shopMenuRoot, Consts.width, Consts.height);
        shopMenuRoot.getChildren().add(backgroundImageView);


        //show collection
        setImageView(showCollectionButtonImageView, 2);
        setImageView(showCollectionButtonImageView1, 2);
        showCollectionButtonImageView1.setOpacity(0);
        setButton(showCollectionButton, 2);
        setLabel(showCollectionLabel, 2);
        shopMenuRoot.getChildren().add(showCollectionButtonImageView);
        shopMenuRoot.getChildren().add(showCollectionButtonImageView1);
        shopMenuRoot.getChildren().add(showCollectionButton);
        shopMenuRoot.getChildren().add(showCollectionLabel);

        //search
        setImageView(searchButtonImageView, 5);
        setImageView(searchButtonImageView1, 5);
        searchButtonImageView1.setOpacity(0);
        setButton(searchButton, 5);
        setLabel(searchLabel, 5);
        shopMenuRoot.getChildren().add(searchButtonImageView);
        shopMenuRoot.getChildren().add(searchButtonImageView1);
        shopMenuRoot.getChildren().add(searchLabel);
        shopMenuRoot.getChildren().add(searchButton);

        //search collection
        setImageView(searchCollectionButtonImageView, 1);
        setImageView(searchCollectionButtonImageView1, 1);
        searchCollectionButtonImageView1.setOpacity(0);
        setButton(searchCollectionButton , 1);
        setLabel(searchCollectionLabel, 1);
        shopMenuRoot.getChildren().add((searchCollectionButtonImageView));
        shopMenuRoot.getChildren().add((searchCollectionButtonImageView1));
        shopMenuRoot.getChildren().add(searchCollectionLabel);
        shopMenuRoot.getChildren().add(searchCollectionButton );

        //buy Button
        setImageView(buyButtonImageView, 7);
        setImageView(buyButtonImageView1, 7);
        buyButtonImageView1.setOpacity(0);
        setButton(buyButton, 7);
        buyButton.setOpacity(0);
        setLabel(buyLabel, 7);
        shopMenuRoot.getChildren().add(buyButtonImageView);
        shopMenuRoot.getChildren().add(buyButtonImageView1);
        shopMenuRoot.getChildren().add(buyLabel);
        shopMenuRoot.getChildren().add(buyButton);

        //sell
        setImageView(sellButtonImageView, 3);
        setImageView(sellButtonImageView1, 3);
        sellButtonImageView1.setOpacity(0);
        setButton(sellButton, 3);
        setLabel(sellLabel, 3);
        shopMenuRoot.getChildren().add(sellButtonImageView);
        shopMenuRoot.getChildren().add(sellButtonImageView1);
        shopMenuRoot.getChildren().add(sellLabel);
        shopMenuRoot.getChildren().add(sellButton);

        //help button
        setImageView(helpButtonImageView, 4);
        setImageView(helpButtonImageView1, 4);
        helpButtonImageView1.setOpacity(0);
        setButton(helpButton, 4);
        setLabel(helpLabel, 4);
        shopMenuRoot.getChildren().add(helpButtonImageView);
        shopMenuRoot.getChildren().add(helpButtonImageView1);
        shopMenuRoot.getChildren().add(helpLabel);
        shopMenuRoot.getChildren().add(helpButton);

        //show
        setImageView(showButtonImageView, 6);
        setImageView(showButtonImageView1, 6);
        showButtonImageView1.setOpacity(0);
        setButton(showButton, 6);
        setLabel(showLabel, 6);
        shopMenuRoot.getChildren().add(showButtonImageView);
        shopMenuRoot.getChildren().add(showButtonImageView1);
        shopMenuRoot.getChildren().add(showLabel);
        shopMenuRoot.getChildren().add(showButton);

        //main menu
        setImageView(mainMenuButtonImageView, 0);
        setImageView(mainMenuButtonImageView1, 0);
        mainMenuButtonImageView1.setOpacity(0);
        setButton(mainMenuButton, 0);
        setLabel(mainMenuLabel, 0);
        shopMenuRoot.getChildren().add(mainMenuButtonImageView);
        shopMenuRoot.getChildren().add(mainMenuButtonImageView1);
        shopMenuRoot.getChildren().add(mainMenuLabel);
        shopMenuRoot.getChildren().add(mainMenuButton);

        checkMovements();

    }

    public Scene getShopMenuScene() {
        return shopMenuScene;
    }

    public void checkMovements() {

        showCollectionButton.setOnMouseEntered(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {


                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (showCollectionButtonImageView.getOpacity() == 100)
                    showCollectionButtonImageView.setOpacity(0);
                if (showCollectionButtonImageView1.getOpacity() == 0)
                    showCollectionButtonImageView1.setOpacity(100);
            }
        });


        showCollectionButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( showCollectionButtonImageView1.getOpacity() == 100)
                    showCollectionButtonImageView1.setOpacity(0);
                if ( showCollectionButtonImageView.getOpacity() == 0)
                    showCollectionButtonImageView.setOpacity(100);
            }
        });



        searchButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (searchButtonImageView.getOpacity() == 100)
                    searchButtonImageView.setOpacity(0);
                if (searchButtonImageView1.getOpacity() == 0)
                    searchButtonImageView1.setOpacity(100);
            }
        });


        searchButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (searchButtonImageView1.getOpacity() == 100)
                    searchButtonImageView1.setOpacity(0);
                if (searchButtonImageView.getOpacity() == 0)
                    searchButtonImageView.setOpacity(100);
            }
        });

        searchCollectionButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (searchCollectionButtonImageView.getOpacity() == 100)
                    searchCollectionButtonImageView.setOpacity(0);
                if (searchCollectionButtonImageView1.getOpacity() == 0)
                    searchCollectionButtonImageView1.setOpacity(100);
            }
        });


        searchCollectionButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( searchCollectionButtonImageView1.getOpacity() == 100)
                    searchCollectionButtonImageView1.setOpacity(0);
                if ( searchCollectionButtonImageView.getOpacity() == 0)
                    searchCollectionButtonImageView.setOpacity(100);
            }
        });

        buyButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if ( buyButtonImageView.getOpacity() == 100)
                    buyButtonImageView.setOpacity(0);
                if ( buyButtonImageView1.getOpacity() == 0)
                    buyButtonImageView1.setOpacity(100);
            }
        });


        buyButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( buyButtonImageView1.getOpacity() == 100)
                    buyButtonImageView1.setOpacity(0);
                if ( buyButtonImageView.getOpacity() == 0)
                    buyButtonImageView.setOpacity(100);
            }
        });

        sellButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (sellButtonImageView.getOpacity() == 100)
                    sellButtonImageView.setOpacity(0);
                if (sellButtonImageView1.getOpacity() == 0)
                    sellButtonImageView1.setOpacity(100);
            }
        });


        sellButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (sellButtonImageView1.getOpacity() == 100)
                    sellButtonImageView1.setOpacity(0);
                if (sellButtonImageView.getOpacity() == 0)
                    sellButtonImageView.setOpacity(100);
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


        showButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if ( showButtonImageView.getOpacity() == 100)
                    showButtonImageView.setOpacity(0);
                if ( showButtonImageView1.getOpacity() == 0)
                    showButtonImageView1.setOpacity(100);
            }
        });


        showButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( showButtonImageView1.getOpacity() == 100)
                    showButtonImageView1.setOpacity(0);
                if ( showButtonImageView.getOpacity() == 0)
                    showButtonImageView.setOpacity(100);
            }
        });

        showCollectionButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
            }
        });

        showButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
            }
        });

        sellButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
            }
        });

        buyButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
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

        searchButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
            }
        });

        searchCollectionButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
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
        if (n <= 3) {
            buttonImageView.setX(Consts.width / 2 + 70);
            buttonImageView.setY(Consts.height / 2.7 + n * Consts.distance);
        }
        else {
            buttonImageView.setX(Consts.width / 2 + 300);
            buttonImageView.setY(Consts.height / 100 + (n - 2) * Consts.distance);
        }

    }

    public void setButton(Button button, int n) {
        button.setOpacity(0);
        if (n <= 3) {
            button.relocate(Consts.width / 2 + 70, Consts.height / 2.7 + n * Consts.distance);
        }
        else {
            button.relocate(Consts.width / 2 + 300, Consts.height / 100 + (n - 2) * Consts.distance);
        }
        button.setPrefSize(buttonSizeWidth, buttonSizeHeight);
    }

    public void setLabel(Label label, int n) {
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        if (n <= 3) {
            if(n == 1){
                label.relocate(Consts.width / 2 + 120, Consts.height / 2.7 + n * Consts.distance + 27);
            }
            else if (n == 0){
                label.relocate(Consts.width / 2 + 170, Consts.height / 2.7 + n * Consts.distance + 27);
            }
            else if (n == 2){
                label.relocate(Consts.width / 2 + 120, Consts.height / 2.7 + n * Consts.distance + 27);
            }
            else {
                label.relocate(Consts.width / 2 + 170, Consts.height / 2.7 + n * Consts.distance + 27);
            }
        }
        else {
            label.relocate(Consts.width / 2 + 390, Consts.height / 100 + (n - 2) * Consts.distance + 27);
        }
    }
}