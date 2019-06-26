package Menu;

import Shop.ShopMenu;
import com.google.gson.Gson;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import java.io.*;
import Shop.Shop;
import Consts.Consts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ShopMenuView {
    private Group shopMenuRoot;
    private Scene shopMenuScene;
    private GaussianBlur blur= new GaussianBlur ();
    private ShopMenu shopMenu=new ShopMenu();

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
    private Button itemButton=new Button("Items");
    private Button cardButton=new Button("Cards");

    private Label showCollectionLabel = new Label("Show Collection");
    private Label searchLabel = new Label("Search");
    private Label searchCollectionLabel = new Label("Search Collection");
    private Label buyLabel = new Label("Buy");
    private Label sellLabel = new Label("Sell");
    private Label helpLabel = new Label("Help");
    private Label showLabel= new Label ("Show");
    private Label mainMenuLabel= new Label ("Home");
    private Label itemButtonLabel=new Label("Items");
    private Label cardButtonLabel=new Label ("Cards");

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
    private ImageView itemButtonImageView = new ImageView(buttonImage);
    private ImageView itemButtonImageView1 = new ImageView(buttonImage1);
    private ImageView cardButtonImageView = new ImageView(buttonImage);
    private ImageView cardButtonImageView1 = new ImageView(buttonImage1);

    private ImageView backgroundImageView = new ImageView(shopBackgroundImage);


    private Media mouseClicked = new Media(getClass ( ).getClassLoader ().getResource ("audio/Button-SoundBible.com-1420500901.mp3" ).toExternalForm ());
    private Media mouseEntered= new Media (getClass().getClassLoader().getResource ("audio/zapsplat_multimedia_click_003_19369.mp3").toExternalForm ());
    MediaPlayer clickedPlayer= new MediaPlayer (mouseClicked);
    MediaPlayer enteredPlayer= new MediaPlayer (mouseEntered);


    public void buyItemButtonClicked(){
        Boolean rightPage=true;
        Boolean leftPage=false;
        shopMenuRoot.getChildren ( ).clear ( );
        shopMenuRoot.getChildren ( ).addAll (backgroundImageView);
        backgroundImageView.setEffect (blur);
//        Polygon rightArrow=new Polygon ();
//        rightArrow.getPoints ().addAll (1110.0,310.0,1110.0,350.0,1150.0,330.0);
//        Polygon leftArrow=new Polygon ();
//        leftArrow.getPoints ().addAll (90.0,310.0,90.0,350.0,50.0,330.0);
//        shopMenuRoot.getChildren ().addAll(rightArrow,leftArrow);
        int j=0;
        try {
            for (int i = 0; i < Shop.getItems ( ).size ( ); i++) {
                if(Shop.getItems ().get (i).getType ().compareToIgnoreCase ("Usable")==0 && j<10){
                    String itemName=Shop.getItems ().get (i).getName ();
                    String address = "/Users/rostaroghani/Desktop/Items/";
                    Image image = new Image (new FileInputStream (address + Shop.getItems ( ).get (i).getName ( ) + ".png"));
                    ImageView imageView = new ImageView (image);
                    imageView.setFitHeight (240);
                    imageView.setFitWidth (200);
                    shopMenuRoot.getChildren ( ).add (imageView);
                    Button buyItemButton = new Button ( Shop.getItems ().get (i).getName ());
                    buyItemButton.setOpacity (10);
                    buyItemButton.setPrefSize (Consts.buyButtonWidth, Consts.buyButtonHeight);
                    buyItemButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
                        @Override
                        public void handle(MouseEvent event) {
                            buyItemButton.setStyle ("-fx-border-color: #34BAF0; -fx-border-width: 2px;");
                            shopMenu.buy (itemName,Menu.loggedInPlayer);

                        }
                    });
                    shopMenuRoot.getChildren ( ).add (buyItemButton);
                    if(j<2){
                        imageView.relocate (20,20+340*j);
                        buyItemButton.relocate (50,255+340*j);
                    }
                    else if(j<4){
                        imageView.relocate (260,20+340*(j-2));
                        buyItemButton.relocate (290,255+340*(j-2));
                    }
                    else if(j<6){
                        imageView.relocate (500,20+340*(j-4));
                        buyItemButton.relocate (530,255+340*(j-4));
                    }
                    else if(j<8){
                        imageView.relocate (740,20+340*(j-6));
                        buyItemButton.relocate (770,255+340*(j-6));
                    }
                    else if(j<10){
                        imageView.relocate (980,20+340*(j-8));
                        buyItemButton.relocate (1010,255+340*(j-8));
                    }
                    j++;
                }
//                else if(Shop.getItems ().get (i).getType ().compareToIgnoreCase ("Usable")==0 && j>=10){
//                    leftPage=true;
//                    rightPage=false;
//                }
//                if(rightPage){
//                    rightArrow.setFill (Color.rgb (1,154,215));
//                }
//                else if(!rightPage){
//                    shopMenuRoot.getChildren ().remove (rightArrow);
//                    //rightArrow.setFill (Color.rgb (111,111,111));
//                }
//                if(leftPage){
//                    leftArrow.setFill (Color.rgb (1,154,215));
//                }
//                else if(!leftPage){
//                    shopMenuRoot.getChildren ().remove (leftArrow);
////                    leftArrow.setFill (Color.rgb (111,111,111));
//                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace ( );
        }


    }

    public void buyButtonClicked() {
        shopMenuRoot.getChildren ( ).clear ( );
        shopMenuRoot.getChildren ( ).add(backgroundImageView);
        backgroundImageView.setEffect (blur);

        //item Button
        itemButtonImageView.setFitWidth(buttonSizeWidth);
        itemButtonImageView.setFitHeight(buttonSizeHeight);
        itemButtonImageView1.setFitWidth(buttonSizeWidth);
        itemButtonImageView1.setFitHeight(buttonSizeHeight);
        itemButtonImageView.setX(400);
        itemButtonImageView.setY(250);
        itemButtonImageView1.setX(400);
        itemButtonImageView1.setY(250);
        itemButton.setPrefSize(buttonSizeWidth, buttonSizeHeight);
        itemButtonImageView1.setOpacity(0);
        itemButton.relocate(400, 250 );
        itemButton.setOpacity(0);
        itemButtonLabel.relocate(490, 275);
        itemButtonLabel.setFont(Font.font("Verdana", FontWeight.NORMAL,FontPosture.ITALIC, 20));
        itemButtonLabel.setTextFill (Color.GHOSTWHITE);

        //card Button
        cardButtonImageView.setFitWidth(buttonSizeWidth);
        cardButtonImageView.setFitHeight(buttonSizeHeight);
        cardButtonImageView1.setFitWidth(buttonSizeWidth);
        cardButtonImageView1.setFitHeight(buttonSizeHeight);
        cardButtonImageView.setX(650);
        cardButtonImageView.setY(250);
        cardButtonImageView1.setX(650);
        cardButtonImageView1.setY(250);
        cardButton.setPrefSize(buttonSizeWidth, buttonSizeHeight);
        cardButtonImageView1.setOpacity(0);
        cardButton.relocate(650, 250 );
        cardButton.setOpacity(0);
        cardButtonLabel.relocate(740, 275);
        cardButtonLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.ITALIC,20));
        cardButtonLabel.setTextFill (Color.GHOSTWHITE);


        //item
        shopMenuRoot.getChildren().add(itemButtonImageView);
        shopMenuRoot.getChildren().add(itemButtonImageView1);
        shopMenuRoot.getChildren().add(itemButtonLabel);
        shopMenuRoot.getChildren().add(itemButton);



        //card
        shopMenuRoot.getChildren().add(cardButtonImageView);
        shopMenuRoot.getChildren().add(cardButtonImageView1);
        shopMenuRoot.getChildren().add(cardButtonLabel);
        shopMenuRoot.getChildren().add(cardButton);



        itemButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (itemButtonImageView.getOpacity() == 100)
                    itemButtonImageView.setOpacity(0);
                if (itemButtonImageView1.getOpacity() == 0)
                   itemButtonImageView1.setOpacity(100);
            }
        });


        itemButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (itemButtonImageView1.getOpacity() == 100)
                    itemButtonImageView1.setOpacity(0);
                if (itemButtonImageView.getOpacity() == 0)
                    itemButtonImageView.setOpacity(100);
            }
        });

        itemButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                buyItemButtonClicked ();
            }
        });

        cardButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (cardButtonImageView.getOpacity() == 100)
                    cardButtonImageView.setOpacity(0);
                if (cardButtonImageView1.getOpacity() == 0)
                  cardButtonImageView1.setOpacity(100);
            }
        });


        cardButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( cardButtonImageView1.getOpacity() == 100)
                   cardButtonImageView1.setOpacity(0);
                if ( cardButtonImageView.getOpacity() == 0)
                    cardButtonImageView.setOpacity(100);
            }
        });


    }


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
                buyButtonClicked();
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

        Button exit = new Button("");
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\asus\\IdeaProjects\\project-36\\project-36\\project-36\\src\\pics\\button_close.png"));
            ImageView exitButtonImageView = new ImageView(image);
            exitButtonImageView.setFitWidth(50);
            exitButtonImageView.setFitHeight(50);
            exitButtonImageView.setX(10);
            exitButtonImageView.setY(10);
            shopMenuRoot.getChildren().add(exitButtonImageView);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            Image image1 = new Image(new FileInputStream("C:\\Users\\asus\\IdeaProjects\\project-36\\project-36\\project-36\\src\\pics\\button_close@2x.png"));
            ImageView exitButtonImageView1 = new ImageView(image1);
            exitButtonImageView1.setFitWidth(50);
            exitButtonImageView1.setFitHeight(50);
            exitButtonImageView1.setX(10);
            exitButtonImageView1.setY(10);
            shopMenuRoot.getChildren().add(exitButtonImageView1);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        exit.setPrefSize(40, 40);
        exit.relocate(20, 20);
        exit.setOpacity(0);
        shopMenuRoot.getChildren().add(exit);

        exit.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                Menu.secondMenuCommand("exit");
                //todo
                //faqat be safheye qabl bargarde na be main menu
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
