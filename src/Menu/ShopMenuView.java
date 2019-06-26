package Menu;

import Collective.Card.Card;
import Collective.Item;
import Player.Account;
import Shop.ShopMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import javafx.scene.text.Text;
import javafx.util.Duration;
import Consts.Consts;
import Shop.Shop;
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

    private Button showCollectionButton = new Button("Collection");
    private Button searchButton = new Button("Search");
    private Button searchCollectionButton = new Button("Search Collection");
    private Button buyButton = new Button("Buy");
    private Button itemButton=new Button("Items");
    private Button cardButton=new Button("Cards");

    private Label showCollectionLabel = new Label("Collection");
    private Label searchLabel = new Label("Search");
    private Label searchCollectionLabel = new Label("Search Collection");
    private Label buyLabel = new Label("Buy");
    private Label itemButtonLabel=new Label("Items");
    private Label cardButtonLabel=new Label ("Cards");

    private final int buttonSizeWidth = 250;
    private final int buttonSizeHeight = 80;

    private ImageView showCollectionButtonImageView = new ImageView(buttonImage);
    private ImageView showCollectionButtonImageView1 = new ImageView(buttonImage1);
    private ImageView searchButtonImageView = new ImageView(buttonImage);
    private ImageView searchButtonImageView1 = new ImageView(buttonImage1);
    private ImageView searchCollectionButtonImageView = new ImageView(buttonImage);
    private ImageView searchCollectionButtonImageView1 = new ImageView(buttonImage1);
    private ImageView buyButtonImageView = new ImageView(buttonImage);
    private ImageView buyButtonImageView1 = new ImageView(buttonImage1);
    private ImageView itemButtonImageView = new ImageView(buttonImage);
    private ImageView itemButtonImageView1 = new ImageView(buttonImage1);
    private ImageView cardButtonImageView = new ImageView(buttonImage);
    private ImageView cardButtonImageView1 = new ImageView(buttonImage1);


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
        setImageView(searchButtonImageView, 1);
        setImageView(searchButtonImageView1, 1);
        searchButtonImageView1.setOpacity(0);
        setButton(searchButton, 1);
        setLabel(searchLabel, 1);
        shopMenuRoot.getChildren().add(searchButtonImageView);
        shopMenuRoot.getChildren().add(searchButtonImageView1);
        shopMenuRoot.getChildren().add(searchLabel);
        shopMenuRoot.getChildren().add(searchButton);

        //search collection
        setImageView(searchCollectionButtonImageView, 3);
        setImageView(searchCollectionButtonImageView1, 3);
        searchCollectionButtonImageView1.setOpacity(0);
        setButton(searchCollectionButton , 3);
        setLabel(searchCollectionLabel, 3);
        shopMenuRoot.getChildren().add((searchCollectionButtonImageView));
        shopMenuRoot.getChildren().add((searchCollectionButtonImageView1));
        shopMenuRoot.getChildren().add(searchCollectionLabel);
        shopMenuRoot.getChildren().add(searchCollectionButton );

        //buy Button
        setImageView(buyButtonImageView, 0);
        setImageView(buyButtonImageView1, 0);
        buyButtonImageView1.setOpacity(0);
        setButton(buyButton, 0);
        buyButton.setOpacity(0);
        setLabel(buyLabel, 0);
        shopMenuRoot.getChildren().add(buyButtonImageView);
        shopMenuRoot.getChildren().add(buyButtonImageView1);
        shopMenuRoot.getChildren().add(buyLabel);
        shopMenuRoot.getChildren().add(buyButton);




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


        showCollectionButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
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
                buyButtonClicked ();
            }
        });


        searchButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                searchButtonClicked ();
            }
        });

        searchCollectionButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
            }
        });

        setExitButton ();
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
        if(n == 3){
            label.relocate(Consts.width / 2 + 120, Consts.height / 2.7 + n * Consts.distance + 27);
        }
        else if (n == 0){
            label.relocate(Consts.width / 2 + 175, Consts.height / 2.7 + n * Consts.distance + 27);
        }
        else {
            label.relocate(Consts.width / 2 + 150, Consts.height / 2.7 + n * Consts.distance + 27);
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


        cardButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                buyCardButtonClicked();
            }
        });

    }

    public void buyItemButtonClicked(){
        final Boolean[] rightPage = {true};
        final Boolean[] leftPage = {false};
        shopMenuRoot.getChildren ( ).clear ( );
        shopMenuRoot.getChildren ( ).addAll (backgroundImageView);
        backgroundImageView.setEffect (blur);
        setExitButton();
        itemPage (0);
        Button rightArrowButton=new Button ("Next Page");
        Button leftArrowButton=new Button("Last Page");
        rightArrowButton.relocate (1070,320);
        leftArrowButton.relocate (40,320);
        rightArrowButton.setPrefSize (100,50);
        leftArrowButton.setPrefSize (100,50);
        shopMenuRoot.getChildren ().addAll (rightArrowButton);
        rightArrowButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(rightPage[0]){
                    shopMenuRoot.getChildren ().clear ();
                    rightPage[0] =false;
                    leftPage[0] =true;
                    if(rightPage[0]){
                        shopMenuRoot.getChildren ( ).add(rightArrowButton);
                    }
                    shopMenuRoot.getChildren ().addAll (backgroundImageView,leftArrowButton);
                    backgroundImageView.setEffect (blur);
                    setExitButton();
                    itemPage (1);

                }
            }
        });

        leftArrowButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(leftPage[0]){
                    shopMenuRoot.getChildren ().clear ();
                    rightPage[0]=true;
                    leftPage[0]=false;
                    if(leftPage[0]){
                        shopMenuRoot.getChildren ().add (leftArrowButton);

                    }
                    shopMenuRoot.getChildren ( ).addAll (backgroundImageView,rightArrowButton);
                    backgroundImageView.setEffect (blur);
                    setExitButton();
                    itemPage (0);
                }
            }
        });

    }

    public void itemPage(int page){
        int j=0;
        try {
            for (int i = 9 +page*10; i < Math.min(19+page*10,Shop.getItems ().size()); i++) {
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
                shopMenuRoot.getChildren ( ).add (buyItemButton);
                buyItemButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
                    @Override
                    public void handle(MouseEvent event) {
                        buyItemButton.setStyle ("-fx-border-color: #34BAF0; -fx-border-width: 2px;");
                        shopMenuRoot.getChildren ().clear ();
                        shopMenuRoot.getChildren ().add (backgroundImageView);
                        backgroundImageView.setEffect (blur);
                        setExitButton ();
                        buy (itemName,Menu.loggedInPlayer);
                    }
                });
                if(j<10){
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
                    else{
                        imageView.relocate (980,20+340*(j-8));
                        buyItemButton.relocate (1010,255+340*(j-8));
                    }
                }
                else
                    j=j-10;
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace ( );
        }

    }

    public void buyCardButtonClicked(){
        //todo
    }

    public void searchButtonClicked(){
        shopMenuRoot.getChildren ().clear ();
        shopMenuRoot.getChildren ().add (backgroundImageView);
        backgroundImageView.setEffect (blur);
        TextField wanted=new TextField ();
        Label label=new Label("What are you looking for?" );
        label.setTextFill (Color.BLACK);
        label.setFont (Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        label.relocate (320,300);
        wanted.setPrefSize (200, 50);
        label.setLabelFor (wanted);
        wanted.relocate (620,300);
        shopMenuRoot.getChildren ().addAll (wanted,label);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String lookingFor=wanted.getText();
                wanted.setVisible(false);
                shopMenuRoot.getChildren ().removeAll (label,wanted);
                backgroundImageView.setEffect (blur);
                search(lookingFor);

            }
        };
        wanted.setOnAction (event);
        setExitButton ();


    }

    public void buy(String name, Account account) {
        boolean found = false;
        showMessage (0);
        Text wanted=new Text ();
        wanted.setFont (Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        wanted.setFill (Color.BLACK);
        wanted.relocate(400, 320);
        shopMenuRoot.getChildren ().add (wanted);
        for (Card card1 : Shop.getCards()) {
            if (name.compareToIgnoreCase(card1.getName()) == 0) {
                found = true;
                if (found) {
                    if (card1.getPrice() > account.getDaric()) {
                        wanted.setText ("You don't have enough money");
                    } else if (card1.getPrice() <= account.getDaric()) {
                        wanted.setText ("You bought this card successfully");
                        Card card = Shop.makeNewCardByName(card1.getName());
                        card.setCardID(shopMenu.makeID(card1.getName(), account));
                        account.getCollection().addToCards(card);
                        account.changeDaric(account.getDaric() - card1.getPrice());

                    }
                    break;
                }
            }
        }
        if (!found) {
            for (Item x : Shop.getItems()) {
                if (name.compareToIgnoreCase(x.getName()) == 0 && x.getType ().compareToIgnoreCase ("Collectible")!=0) {
                    found = true;
                    if (found) {
                        if (x.getPrice() > account.getDaric()) {
                            wanted.setText ("You don't have enough money.");
                        } else if (account.getNumberOfItemsOwned() >= 3) {
                            wanted.setText ("You can't have more than 3 items.");
                        } else if (account.getNumberOfItemsOwned() < 3 && x.getPrice() <= account.getDaric()) {
                            wanted.setText ("You bought this item successfully");
                            account.changeDaric(account.getDaric() - x.getPrice());
                            account.changeNumberOfItemsOwned(account.getNumberOfItemsOwned() + 1);
                            Item item = Shop.makeNewItemByName(x.getName());
                            item.setItemID(shopMenu.makeID(x.getName(), account));
                            account.getCollection().addToItems(item);
                        }
                        break;
                    }
                }
            }
        }
        if (!found) {
            wanted.setText ("This Card/Item is not in the shop");
        }

    }

    public void search(String name) {
        boolean found = false;
        Text wanted=new Text ();
        wanted.setFont (Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        wanted.setFill (Color.BLACK);
        wanted.relocate(400, 320);
        for (Card x : Shop.getCards()) {
            if (name.compareToIgnoreCase(x.getName()) == 0) {
                wanted.setText ("Found it!");
                wanted.relocate (830,100);
                String cardName=x.getName ();
                //todo
                found = true;
                break;
            }
        }
        if (!found) {
            for (Item x : Shop.getItems()) {
                if (name.compareToIgnoreCase(x.getName()) == 0) {
                    wanted.setText("Found it!");
                    wanted.relocate (830,100);
                    String itemPic=x.getName ();
                    String address = "/Users/rostaroghani/Desktop/Items/";
                    Image image = null;
                    try {
                        image = new Image (new FileInputStream (address + x.getName ( ) + ".png"));
                        ImageView imageView = new ImageView (image);
                        imageView.setFitHeight (560);
                        imageView.setFitWidth (430);
                        imageView.relocate (350,20);
                        shopMenuRoot.getChildren ().add (imageView);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace ( );
                    }
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
           wanted.setText("This Card/Item is not in the shop");
           showMessage (0);
        }
        shopMenuRoot.getChildren ().add (wanted);


    }

    public void showMessage(int position){
        try {
            Image warning = new Image (new FileInputStream ("/Users/rostaroghani/Desktop/project-3/src/pics/notification_your_turn@2x.png"));
            ImageView warningImageView= new ImageView (warning);
            if(position==0){
                warningImageView.relocate (250,270);
            }
            else if(position==-1){
                warningImageView.relocate (250,350);
            }
            warningImageView.setFitHeight (160);
            warningImageView.setFitWidth (700);
            shopMenuRoot.getChildren ().add(warningImageView);
        } catch (FileNotFoundException ec) {
            ec.printStackTrace();
        }
    }


    public void setExitButton(){
        Button exit = new Button(null);
        try {
            Image image = new Image(new FileInputStream("/Users/rostaroghani/Desktop/project-3/src/pics/button_close.png"));
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
            Image image1 = new Image(new FileInputStream("/Users/rostaroghani/Desktop/project-3/src/pics/button_close@2x.png"));
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
        exit.relocate(5, 5);
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
}
