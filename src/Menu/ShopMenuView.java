package Menu;

import Collective.Buff.*;
import Collective.Card.Card;
import Collective.Card.Hero;
import Collective.Card.Minion.Minion;
import Collective.Card.Spell;
import Collective.Item;
import Map.Map;
import Player.Account;
import Shop.ShopMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.io.FileWriter;
import java.io.IOException;

public class ShopMenuView {
    private Group shopMenuRoot;
    private Scene shopMenuScene;
    private GaussianBlur blur= new GaussianBlur ();

    private Image buttonImage = new Image("pics/button_secondary@2x.png");
    private Image buttonImage1 = new Image("pics/button_secondary_glow.png");
    private Image shopBackgroundImage = new Image("pics/counterplay-games-the-great-tree-eyos.jpg");

    private Button showCollectionButton = new Button("Collection");
    private Button searchButton = new Button("Search");
    private Button searchCollectionButton = new Button("Search Collection");
    private Button buyButton = new Button("Buy");
    private Button customButton = new Button("Custom");
    private Button itemButton=new Button("Items");
    private Button cardButton=new Button("Cards");
    private Button auctionButton = new Button("Auction");

    private Label showCollectionLabel = new Label("Collection");
    private Label searchLabel = new Label("Search");
    private Label searchCollectionLabel = new Label("Search Collection");
    private Label buyLabel = new Label("Buy");
    private Label itemButtonLabel=new Label("Items");
    private Label cardButtonLabel=new Label ("Cards");
    private Label customButtonLabel = new Label ("Custom Card");
    private Label auctionButtonLabel = new Label("Aution");

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
    private ImageView customButtonImageView = new ImageView(buttonImage);
    private ImageView customButtonImageView1 = new ImageView(buttonImage1);
    private ImageView auctionButtonImageView = new ImageView(buttonImage);
    private ImageView auctionButtonImageView1 = new ImageView(buttonImage1);

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
        setLabel(buyLabel, 0);
        shopMenuRoot.getChildren().add(buyButtonImageView);
        shopMenuRoot.getChildren().add(buyButtonImageView1);
        shopMenuRoot.getChildren().add(buyLabel);
        shopMenuRoot.getChildren().add(buyButton);
        
        //custom button
        setImageView(customButtonImageView, 4);
        setImageView(customButtonImageView1, 4);
        customButtonImageView1.setOpacity(0);
        setButton(customButton, 4);
        setLabel(customButtonLabel, 4);
        shopMenuRoot.getChildren().add(customButtonImageView);
        shopMenuRoot.getChildren().add(customButtonImageView1);
        shopMenuRoot.getChildren().add(customButtonLabel);
        shopMenuRoot.getChildren().add(customButton);

        //auction Button
        setImageView(auctionButtonImageView, 5);
        setImageView(auctionButtonImageView1, 5);
        auctionButtonImageView1.setOpacity(0);
        setButton(auctionButton, 5);
        setLabel(auctionButtonLabel, 5);
        shopMenuRoot.getChildren().add(auctionButtonImageView);
        shopMenuRoot.getChildren().add(auctionButtonImageView1);
        shopMenuRoot.getChildren().add(auctionButtonLabel);
        shopMenuRoot.getChildren().add(auctionButton);

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

        customButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if ( customButtonImageView.getOpacity() == 100)
                    customButtonImageView.setOpacity(0);
                if (customButtonImageView1.getOpacity() == 0)
                    customButtonImageView1.setOpacity(100);
            }
        });


        customButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( customButtonImageView1.getOpacity() == 100)
                    customButtonImageView1.setOpacity(0);
                if ( customButtonImageView.getOpacity() == 0)
                    customButtonImageView.setOpacity(100);
            }
        });

        auctionButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if ( auctionButtonImageView.getOpacity() == 100)
                    auctionButtonImageView.setOpacity(0);
                if (auctionButtonImageView1.getOpacity() == 0)
                    auctionButtonImageView1.setOpacity(100);
            }
        });


        auctionButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( auctionButtonImageView1.getOpacity() == 100)
                    auctionButtonImageView1.setOpacity(0);
                if ( auctionButtonImageView.getOpacity() == 0)
                    auctionButtonImageView.setOpacity(100);
            }
        });

        showCollectionButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                buyOrShowCollectionButtonClicked ("show collection");
            }
        });


        buyButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                buyOrShowCollectionButtonClicked ("buy");
            }
        });


        searchButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                searchButtonClicked ("search");
            }
        });

        searchCollectionButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                searchButtonClicked ("search collection");
            }
        });
        
        customButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                customCardClicked ();
            }
        });

        auctionButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                auctionButtonClicked();
            }
        });

        setExitButton ();
    }


    public void setImageView(ImageView buttonImageView, int n) {

        buttonImageView.setFitWidth(buttonSizeWidth);
        buttonImageView.setFitHeight(buttonSizeHeight);
        buttonImageView.setX(Consts.width / 2 + 70);
        buttonImageView.setY(Consts.height / 2.7 + n * Consts.distance - 150);
    }

    public void setButton(Button button, int n) {
        button.setOpacity(0);
        button.relocate(Consts.width / 2 + 70, Consts.height / 2.7 + n * Consts.distance - 150);
        button.setPrefSize(buttonSizeWidth, buttonSizeHeight);
    }

    public void setLabel(Label label, int n) {
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        if(n == 3){
            label.relocate(Consts.width / 2 + 120, Consts.height / 2.7 + n * Consts.distance + 27 - 150);
        }
        else if (n == 0){
            label.relocate(Consts.width / 2 + 175, Consts.height / 2.7 + n * Consts.distance + 27 - 150);
        }
        else {
            label.relocate(Consts.width / 2 + 150, Consts.height / 2.7 + n * Consts.distance + 27 - 150);
        }

    }

    private void auctionButtonClicked(){
        shopMenuRoot.getChildren ().clear ();
        shopMenuRoot.getChildren ().add (backgroundImageView);
        backgroundImageView.setEffect (blur);
        setExitButton ();
        Label chosenCard = new Label("Write down the ID:");
        TextField chosenCardText = new TextField ();
        labelStyle (chosenCard);
        chosenCard.relocate (350,70);
        chosenCardText.relocate (620,70);
        int i = 0 ;
        for(Item item:Menu.loggedInPlayer.getCollection ().getItems ()){
            Text text = setText ();
            text.setFont (Font.font ("verdana",FontWeight.BOLD,15));
            text.setText (item.getName ()+" :" + item.getItemID ());
            text.relocate (50,120 + i*22);
            shopMenuRoot.getChildren ().add (text);
            i++ ;
        }
        Button button = new Button("Auction");
        button.relocate (450,100);
        button.setPrefSize (100,50);
        shopMenuRoot.getChildren ().addAll (chosenCard,chosenCardText,button);

        button.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent mouseEvent) {
                shopMenuRoot.getChildren ().clear ();
                shopMenuRoot.getChildren ().add (backgroundImageView);
                backgroundImageView.setEffect (blur);

            }
        });
        //TODO
    }

    private void customCardClicked() {
        shopMenuRoot.getChildren ().clear ();
        shopMenuRoot.getChildren ().add (backgroundImageView);
        backgroundImageView.setEffect (blur);
        Label cardTypeLabel = new Label ("Type:");
        cardTypeLabel.relocate (430, 200);
        TextField cardTypeTextField = new TextField ( );
        cardTypeTextField.relocate (550, 200);
        cardTypeLabel.setFont (Font.font ("verdana",FontWeight.BOLD,FontPosture.REGULAR,20));
        cardTypeLabel.setLabelFor (cardTypeTextField);
        cardTypeLabel.setTextFill (Color.GOLD);
        shopMenuRoot.getChildren ( ).addAll (cardTypeLabel, cardTypeTextField);
        cardTypeTextField.setPrefSize (200, 50);
        Button button = new Button ("Make One");
        button.relocate (550,300);
        button.setPrefSize (100,40);
        shopMenuRoot.getChildren ().add (button);
        button.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String answer = "";
                answer = cardTypeTextField.getText ();
                shopMenuRoot.getChildren ().clear ();
                shopMenuRoot.getChildren ().add (backgroundImageView);
                backgroundImageView.setEffect (blur);
                getInfoCustomCard (answer);
            }
        });


    }

    private void getInfoCustomCard(String type){

        Button button = new Button ("Finish");

        Label cardName = new Label ("Name:");
        Label spellTarget = new Label ("Target:");
        Label spellBuff = new Label ("Buffs:");
        Label cardAP = new Label ("AP:");
        Label cardHP = new Label ("HP:");
        Label attackType = new Label ("Attack Type:");
        Label cardRange = new Label ("Range:");
        Label cardSpecialPower = new Label ("Special Power:");
        Label powerActiviation = new Label ("Power Activiation:");
        Label powerCoolDown = new Label ("Power Cooldown:");
        Label cardCost = new Label ("Cost:");
        Label buffType = new Label ("Buff Type:");
        Label effectValue = new Label ("Effect Value:");
        Label buffDelay = new Label ("Delay:");
        Label buffLast = new Label ("Last:");
        Label buffTarget = new Label ("Target:");

        TextField cardNameText = new TextField ();
        TextField spellTargetText = new TextField ();
        TextField spellBuffText = new TextField ();
        TextField cardAPText = new TextField ();
        TextField cardHPText = new TextField ();
        TextField attackTypeText = new TextField ();
        TextField cardRangeText = new TextField ();
        TextField cardSpecialPowerText = new TextField ();
        TextField powerActiviationText = new TextField ();
        TextField powerCoolDownText = new TextField ();
        TextField cardCostText = new TextField ();
        TextField buffTypeText = new TextField ();
        TextField effectValueText = new TextField ();
        TextField buffDelayText = new TextField ();
        TextField buffLastText = new TextField ();
        TextField buffTargetText = new TextField ();


        labelStyle (cardName);
        labelStyle (spellBuff);
        labelStyle (spellTarget);
        labelStyle (cardAP);
        labelStyle (cardHP);
        labelStyle (cardSpecialPower);
        labelStyle (effectValue);
        labelStyle (buffDelay);
        labelStyle (buffLast);
        labelStyle (buffTarget);
        labelStyle (buffType);
        labelStyle (attackType);
        labelStyle (cardRange);
        labelStyle (powerActiviation);
        labelStyle (powerCoolDown);
        labelStyle (cardCost);


        cardName.relocate (430, 200);
        cardNameText.relocate (630, 200);

        cardCost.relocate (430,250);
        cardCostText.relocate (630,250);

        button.relocate (500,600);
        button.setPrefSize (100,50);

        if(type.compareToIgnoreCase ("spell")==0){
            shopMenuRoot.getChildren ().addAll (spellBuff,spellBuffText,spellTarget,spellTargetText);
            spellTarget.relocate (430,300);
            spellTargetText.relocate (630,300);
            spellBuff.relocate (430,350);
            spellBuffText.relocate (630,350);
            shopMenuRoot.getChildren ().addAll (cardName,cardNameText,cardCost,cardCostText,button);

        }
        else if(type.compareToIgnoreCase ("minion")== 0 || type.compareToIgnoreCase ("hero")== 0){
            shopMenuRoot.getChildren ().addAll (cardAP,cardAPText,cardHP,cardHPText,attackType,attackTypeText,cardRange,cardRangeText
            ,cardSpecialPower,cardSpecialPowerText);
            shopMenuRoot.getChildren ().addAll (cardName,cardNameText,cardCost,cardCostText,button);

            cardAP.relocate (430,300);
            cardAPText.relocate (630,300);
            cardHP.relocate (430,350);
            cardHPText.relocate (630,350);
            attackType.relocate (430,400);
            attackTypeText.relocate (630,400);
            cardRange.relocate (430,450);
            cardRangeText.relocate (630,450);
            cardSpecialPower.relocate (430,500);
            cardSpecialPowerText.relocate (630,500);

            if(type.compareToIgnoreCase ("minion")== 0){
                shopMenuRoot.getChildren ().addAll (powerActiviation,powerActiviationText);
                powerActiviation.relocate (430,550);
                powerActiviationText.relocate (630,550);
            }
            else{
                shopMenuRoot.getChildren ().addAll (powerCoolDown,powerCoolDownText);
                powerCoolDown.relocate (430,550);
                powerCoolDownText.relocate (630,550);
            }
        }

        else if(type.compareToIgnoreCase ("buff")== 0){
            shopMenuRoot.getChildren ().addAll (cardName,cardNameText);
            shopMenuRoot.getChildren ().addAll (buffDelay,buffDelayText,buffLast,buffLastText,buffTarget,
                    buffTargetText,buffType,buffTypeText,effectValue,effectValueText,button);

            buffDelay.relocate (430,250);
            buffDelayText.relocate (630,250);
            buffLast.relocate (430,300);
            buffLastText.relocate (630,300);
            buffTarget.relocate (430,350);
            buffTargetText.relocate (630,350);
            buffType.relocate (430,400);
            buffTypeText.relocate (630,400);
            effectValue.relocate (430,450);
            effectValueText.relocate (630,450);
        }

        Gson gson= new GsonBuilder ().setPrettyPrinting ().create ();
        button.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    FileWriter fileWriter = null;
                    try {
                        fileWriter = new FileWriter (type+"/"+cardNameText.getText ()+".json");
                    } catch (IOException e) {
                        e.printStackTrace ( );
                    }
                    Menu.loggedInPlayer.changeDaric (Menu.loggedInPlayer.getDaric () - Integer.parseInt (cardCostText.getText ()));
                    if(type.compareToIgnoreCase ("hero")==0){
                        Hero hero = new Hero();
                        hero.setName (cardNameText.getText ());
                        hero.setAP (Integer.parseInt (cardAPText.getText ()));
                        hero.setHP (Integer.parseInt (cardHPText.getText ()));
                        hero.setKindOfAttack (attackTypeText.getText ());
                        hero.setRangeOfAttack (Integer.parseInt (cardRangeText.getText ()));
                        hero.setSpecialPower (cardSpecialPowerText.getText ());
                        hero.setCoolDown (Integer.parseInt (powerCoolDownText.getText ()));
                        hero.setPrice (Integer.parseInt (cardCostText.getText ()));
                        Menu.loggedInPlayer.getCollection ().addToCards (hero);
                        try {
                            fileWriter.write (gson.toJson (hero));
                        } catch (IOException e) {
                            e.printStackTrace ( );
                        }
                    }
                    else if(type.compareToIgnoreCase ("minion")== 0){
                        Minion minion = new Minion ();
                        minion.setName (cardNameText.getText ());
                        minion.setAP (Integer.parseInt (cardAPText.getText ()));
                        minion.setHP (Integer.parseInt (cardHPText.getText ()));
                        minion.setTypeOfImpact (attackTypeText.getText ());
                        minion.setRangeOfAttack (Integer.parseInt (cardRangeText.getText ()));
                        minion.setTypeOfActivation (Integer.parseInt (powerActiviationText.getText ()));
                        minion.setSpecialPower (cardSpecialPowerText.getText ());
                        minion.setPrice (Integer.parseInt (cardCostText.getText ()));
                        Menu.loggedInPlayer.getCollection ().addToCards (minion);
                        try {
                            fileWriter.write (gson.toJson (minion));
                        } catch (IOException e) {
                            e.printStackTrace ( );
                        }
                    }
                    else if(type.compareToIgnoreCase ("spell")==0){
                        Spell spell = new Spell ();
                        spell.setName (cardNameText.getText ());
                        spell.setPrice (Integer.parseInt (cardCostText.getText ()));
                        spell.setTargetAreas (spellTargetText.getText ());
                        spell.setSpellBuffNames (spellBuffText.getText ());
                        Menu.loggedInPlayer.getCollection ().addToCards (spell);
                        try {
                            fileWriter.write (gson.toJson (spell));
                        } catch (IOException e) {
                            e.printStackTrace ( );
                        }
                    }
                    else{
                        String name = cardNameText.getText ();
                        String type = buffTypeText.getText ();
                        int effectValue = Integer.parseInt (effectValueText.getText ());
                        int delay = Integer.parseInt(buffDelayText.getText ());
                        int last = Integer.parseInt(buffLastText.getText ());
                        String target = buffTargetText.getText ();

                        if(type.compareToIgnoreCase ("Holy")== 0){
                            HolyBuff holyBuff = new HolyBuff ();
                            makeCustomBuff (holyBuff,name,type,effectValue,delay,last,target);
                            Map.getBuffs ().add (holyBuff);
                            try {
                                fileWriter.write (gson.toJson (holyBuff));
                            } catch (IOException e) {
                                e.printStackTrace ( );
                            }
                        }
                        else if(type.compareToIgnoreCase ("Disarm")== 0){
                            DisarmBuff disarmBuff = new DisarmBuff ();
                            makeCustomBuff (disarmBuff,name,type,effectValue,delay,last,target);
                            Map.getBuffs ().add (disarmBuff);
                            try {
                                fileWriter.write (gson.toJson (disarmBuff));
                            } catch (IOException e) {
                                e.printStackTrace ( );
                            }
                        }
                        else if(type.compareToIgnoreCase ("kill")== 0){
                            KillBuff killBuff = new KillBuff ();
                            makeCustomBuff (killBuff,name,type,effectValue,delay,last,target);
                            Map.getBuffs ().add (killBuff);
                            try {
                                fileWriter.write (gson.toJson (killBuff));
                            } catch (IOException e) {
                                e.printStackTrace ( );
                            }
                        }
                        else if(type.compareToIgnoreCase ("Poison")== 0){
                            PoisonBuff poisonBuff = new PoisonBuff ();
                            makeCustomBuff (poisonBuff,name,type,effectValue,delay,last,target);
                            Map.getBuffs ().add (poisonBuff);
                            try {
                                fileWriter.write (gson.toJson (poisonBuff));
                            } catch (IOException e) {
                                e.printStackTrace ( );
                            }
                        }
                        else if(type.compareToIgnoreCase ("power")== 0){
                            PowerBuff powerBuff = new PowerBuff ();
                            makeCustomBuff (powerBuff,name,type,effectValue,delay,last,target);
                            Map.getBuffs ().add (powerBuff);
                            try {
                                fileWriter.write (gson.toJson (powerBuff));
                            } catch (IOException e) {
                                e.printStackTrace ( );
                            }
                        }
                        else if(type.compareToIgnoreCase ("stun")== 0){
                            StunBuff stunBuff = new StunBuff ();
                            makeCustomBuff (stunBuff,name,type,effectValue,delay,last,target);
                            Map.getBuffs ().add (stunBuff);
                            try {
                                fileWriter.write (gson.toJson (stunBuff));
                            } catch (IOException e) {
                                e.printStackTrace ( );
                            }
                        }
                        else{
                            WeaknessBuff weaknessBuff = new WeaknessBuff ();
                            makeCustomBuff (weaknessBuff,name,type,effectValue,delay,last,target);
                            Map.getBuffs ().add (weaknessBuff);
                            try {
                                fileWriter.write (gson.toJson (weaknessBuff));
                            } catch (IOException e) {
                                e.printStackTrace ( );
                            }
                        }
                    }
                    showCustomCardMessage ();
                }
            });
    }

    public void makeCustomBuff(Buff buff,String name,String type,int effectValue,int delay,int last,String target){
        buff.setName (name);
        buff.setTypeOfBuff (type);
        buff.setStartTurn (delay);
        buff.setDuration (last);
        buff.setPositiveOrNegative (target);
        buff.setDamagePerTurn (effectValue);
    }

    public void showCustomCardMessage(){
        shopMenuRoot.getChildren ().clear ();
        backgroundImageView.setEffect (blur);
        setExitButton ();
        Text text = new Text ("Your card was made successfully");
        text.setFont (Font.font (20));
        shopMenuRoot.getChildren ().addAll (backgroundImageView,text);
        text.relocate (830,100);
        String address = "/Users/rostaroghani/Desktop/Items/CustomItem.png";
        Image image = null;
        try {
            image = new Image (new FileInputStream (address));
            ImageView imageView = new ImageView (image);
            imageView.setFitHeight (560);
            imageView.setFitWidth (430);
            imageView.relocate (350,20);
            shopMenuRoot.getChildren ().add (imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace ( );
        }
    }

    public void labelStyle(Label label){
        label.setFont (Font.font ("verdana",FontWeight.BOLD,FontPosture.REGULAR,20));
        label.setTextFill (Color.GOLD);

    }

    public void buyOrShowCollectionButtonClicked(String menu) {
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
                if(menu.compareToIgnoreCase ("buy")==0){
                    buyItemButtonClicked ();
                }
                else
                    showCollectionItemButtonClicked(Menu.loggedInPlayer);
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
                if(menu.compareToIgnoreCase ("buy")==0){
                    buyCardButtonClicked();
                }
                else
                    showCollectionCardButtonClicked(Menu.loggedInPlayer);

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
                Button buyItemButton = new Button ( Shop.getItems ().get (i).getName ()+" "+Shop.getItemNumbers ().get(i));
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


    public void searchButtonClicked(String menu){
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
                if(menu.compareToIgnoreCase ("search")==0){
                    search(lookingFor);
                }
                else
                    searchCollection(lookingFor,Menu.loggedInPlayer);

            }
        };
        wanted.setOnAction (event);
        setExitButton ();


    }


    public void searchCollection(String name, Account account) {
        boolean found = false;
        Text wanted=setText ();
        shopMenuRoot.getChildren ().add (wanted);
        for (Card x : account.getCollection().getCards()) {
            if (name.compareToIgnoreCase(x.getName()) == 0) {
                wanted.setText ("Found it!");
                //todo
                found = true;
            }
        }
        if (!found) {
            for (Item x : account.getCollection().getItems()) {
                if (name.compareToIgnoreCase(x.getName()) == 0) {
                    wanted.setText ("Found it!");
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
                }
            }
        }
        if (!found) {
            showMessage (0);
            wanted.setText ("You don't have this item/card!");
        }
    }


    public void buy(String name, Account account) {
        boolean found = false;
        showMessage (0);
        Text wanted=setText ();
        shopMenuRoot.getChildren ().add (wanted);
        for (int i= 0 ; i<Shop.getCards ().size (); i++) {
            if (name.compareToIgnoreCase(Shop.getCards ().get (i).getName()) == 0) {
                found = true;
                if (found) {
                    if (Shop.getCards ().get (i).getPrice() > account.getDaric()) {
                        wanted.setText ("You don't have enough money");
                    }else if(Shop.getCardNumbers ().get (i)== 0) {
                        wanted.setText ("This card is not available");
                    }
                    else if (Shop.getCards ().get (i).getPrice() <= account.getDaric() && Shop.getCardNumbers ().get (i)>0) {
                        wanted.setText ("You bought this card successfully");
                        Card card = Shop.makeNewCardByName(Shop.getCards ().get (i).getName());
                        account.getCollection().addToCards(card);
                        card.setCardID(ShopMenu.makeID(Shop.getCards ().get (i).getName(), account));
                        account.changeDaric(account.getDaric() - Shop.getCards ().get (i).getPrice());
                        int number= Shop.getCardNumbers ().get (i);
                        Shop.getCardNumbers ().remove (i);
                        Shop.getCardNumbers ().add (number - 1);

                    }
                    break;
                }
            }
        }
        if (!found) {
            for (int i=0 ; i<Shop.getItems ().size (); i++) {
                if (name.compareToIgnoreCase(Shop.getItems ().get (i).getName()) == 0 && Shop.getItems ().get (i).getType ().compareToIgnoreCase ("Collectible")!=0) {
                    found = true;
                    if (found) {
                        if (Shop.getItems ().get (i).getPrice() > account.getDaric()) {
                            wanted.setText ("You don't have enough money.");
                        } else if (account.getNumberOfItemsOwned() >= 3) {
                            wanted.setText ("You can't have more than 3 items.");
                        } else if(Shop.getItemNumbers ().get (i)== 0) {
                            wanted.setText ("This Item is not available");
                        }
                        else if (account.getNumberOfItemsOwned() < 3 && Shop.getItems ().get (i).getPrice() <= account.getDaric()
                        && Shop.getItemNumbers ().get (i)>0) {
                            wanted.setText ("You bought this item successfully");
                            account.changeDaric(account.getDaric() - Shop.getItems ().get (i).getPrice());
                            account.changeNumberOfItemsOwned(account.getNumberOfItemsOwned() + 1);
                            Item item = Shop.makeNewItemByName(Shop.getItems ().get (i).getName());
                            account.getCollection().addToItems(item);
                            item.setItemID(ShopMenu.makeID(item.getName (), account));
                            int number= Shop.getItemNumbers ().get (i);
                            Shop.getItemNumbers ().remove (i);
                            Shop.getItemNumbers ().add (number - 1);

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
        Text wanted=setText ();
        shopMenuRoot.getChildren ().add (wanted);
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


    public void showCollectionItemButtonClicked(Account account){
        shopMenuRoot.getChildren ( ).clear ( );
        shopMenuRoot.getChildren ( ).addAll (backgroundImageView);
        backgroundImageView.setEffect (blur);
        setExitButton();
        int j=0;
        for(int i=0;i<account.getCollection ().getItems ().size ();i++){
            String itemName=account.getCollection ().getItems ().get (i).getName ();
            String ID=account.getCollection ().getItems ().get (i).getItemID ();
            String address = "/Users/rostaroghani/Desktop/Items/";
            Image image = null;
            try {
                image = new Image (new FileInputStream (address + account.getCollection ().getItems ().get (i).getName ( ) + ".png"));
                ImageView imageView = new ImageView (image);
                imageView.setFitHeight (240);
                imageView.setFitWidth (200);
                shopMenuRoot.getChildren ( ).add (imageView);
                Button sellItemButton = new Button ( account.getCollection ().getItems ().get (i).getName ());
                sellItemButton.setOpacity (10);
                sellItemButton.setPrefSize (Consts.buyButtonWidth, Consts.buyButtonHeight);
                shopMenuRoot.getChildren ( ).add (sellItemButton);
                sellItemButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
                    @Override
                    public void handle(MouseEvent event) {
                        shopMenuRoot.getChildren ().clear ();
                        shopMenuRoot.getChildren ().add (backgroundImageView);
                        backgroundImageView.setEffect (blur);
                        setExitButton ();
                        sell (ID,Menu.loggedInPlayer);
                    }
                });
                if(j<10){
                    if(j<2){
                        imageView.relocate (20,20+340*j);
                        sellItemButton.relocate (50,255+340*j);
                    }
                    else if(j<4){
                        imageView.relocate (260,20+340*(j-2));
                        sellItemButton.relocate (290,255+340*(j-2));
                    }
                    else if(j<6){
                        imageView.relocate (500,20+340*(j-4));
                        sellItemButton.relocate (530,255+340*(j-4));
                    }
                    else if(j<8){
                        imageView.relocate (740,20+340*(j-6));
                        sellItemButton.relocate (770,255+340*(j-6));
                    }
                    else{
                        imageView.relocate (980,20+340*(j-8));
                        sellItemButton.relocate (1010,255+340*(j-8));
                    }
                }
                j++;
            } catch (FileNotFoundException e) {
                e.printStackTrace ( );
            }

        }


    }


    public void showCollectionCardButtonClicked(Account account){
        //todo
    }


    public void sell(String ID, Account account) {
        boolean found = false;
        showMessage (0);
        Text wanted=setText ();
        shopMenuRoot.getChildren ().add (wanted);
        for (Card x : account.getCollection ().getCards()) {
            if (x.getCardID().compareToIgnoreCase(ID) == 0) {
                wanted.setText ("You sold this card successfully");
                account.changeDaric(account.getDaric() + x.getPrice());
                account.getCollection().removeFromCards(x);
                Card.removeFromCards(x);
                found = true;
                break;
            }
        }
        if (!found) {
            for (Item x : account.getCollection ().getItems()) {
                if (x.getItemID().compareToIgnoreCase(ID) == 0) {
                    wanted.setText ("You sold this item successfully");
                    account.getCollection().removeFromItems(x);
                    account.changeDaric(account.getDaric() + x.getPrice());
                    account.changeNumberOfItemsOwned(account.getNumberOfItemsOwned() - 1);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            wanted.setText ("This Card/Item is not in the shop");
        }

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

        exit.setPrefSize(40, 40);
        exit.relocate(5, 5);
        exit.setOpacity(0);
        shopMenuRoot.getChildren().add(exit);

        exit.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                Menu.secondMenu();
                //todo
            }
        });


    }

    public Text setText(){
        Text wanted=new Text ();
        wanted.setFont (Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        wanted.setFill (Color.BLACK);
        wanted.relocate(400, 320);
        return wanted;
    }

}
