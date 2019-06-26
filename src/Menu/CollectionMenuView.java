package Menu;

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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import Collective.Card.Card;
import Collective.Item;
import Consts.Consts;
import Player.Account;
import Player.Collection;
import Player.Deck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CollectionMenuView {
    private Group collectionMenuRoot;
    private Scene collectionMenuScene;

    private Image buttonImage = new Image("pics/button_secondary@2x.png");
    private Image buttonImage1 = new Image("pics/button_secondary_glow.png");
    private Image collectionBackgroundImage = new Image("pics/Y1.jpg");

    private Button mainMenuButton = new Button("Home");
    private Button searchButton = new Button("Search");
    private Button showAllDecksButton = new Button("Show All Decks");
    private Button createDeckButton = new Button("Create Deck");
    private Button deleteDeckButton = new Button("Delete Deck");
    private Button showButton= new Button("Show");
    private Button addCardButton= new Button("Add Card");
    private Button removeCardButton= new Button("Remove Card");
    private Button validateDeckButton= new Button("Validate Deck");
    private Button showDeckButton= new Button("Show Deck");
    private Button saveButton= new Button("Save");
    private Button selectDeckButton= new Button("Select Deck");

    private Label mainMenuLabel = new Label("Home");
    private Label searchLabel = new Label("Search");
    private Label showAllDecksLabel = new Label("Show All Decks");
    private Label createDeckLabel = new Label("Create Deck");
    private Label deleteDeckLabel = new Label("Delete Deck");
    private Label showLabel= new Label ("Show");
    private Label addCardLabel= new Label ("Add Card");
    private Label removeCardLabel = new Label("Remove Card");
    private Label validateDeckLabel= new Label ("Validate Deck");
    private Label showDeckLabel= new Label ("Show Deck");
    private Label saveLabel = new Label("Save");
    private Label selectDeckLabel= new Label ("Select Deck");

    private final int buttonSizeWidth = 250;
    private final int buttonSizeHeight = 80;

    private ImageView mainMenuButtonImageView = new ImageView(buttonImage);
    private ImageView mainMenuButtonImageView1 = new ImageView(buttonImage1);
    private ImageView showAllDecksButtonImageView = new ImageView(buttonImage);
    private ImageView showAllDecksButtonImageView1 = new ImageView(buttonImage1);
    private ImageView createDeckButtonImageView = new ImageView(buttonImage);
    private ImageView createDeckButtonImageView1 = new ImageView(buttonImage1);
    private ImageView deleteDeckButtonImageView = new ImageView(buttonImage);
    private ImageView deleteDeckButtonImageView1 = new ImageView(buttonImage1);
    private ImageView addCardButtonImageView = new ImageView(buttonImage);
    private ImageView addCardButtonImageView1 = new ImageView(buttonImage1);
    private ImageView removeCardButtonImageView = new ImageView(buttonImage);
    private ImageView removeCardButtonImageView1 = new ImageView(buttonImage1);
    private ImageView validateDeckButtonImageView = new ImageView(buttonImage);
    private ImageView validateDeckButtonImageView1 = new ImageView(buttonImage1);
    private ImageView showDeckButtonImageView = new ImageView(buttonImage);
    private ImageView showDeckButtonImageView1 = new ImageView(buttonImage1);
    private ImageView saveButtonImageView = new ImageView(buttonImage);
    private ImageView saveButtonImageView1 = new ImageView(buttonImage1);
    private ImageView selectDeckButtonImageView = new ImageView(buttonImage);
    private ImageView selectDeckButtonImageView1 = new ImageView(buttonImage1);
    private ImageView showButtonImageView = new ImageView(buttonImage);
    private ImageView showButtonImageView1 = new ImageView(buttonImage1);
    private ImageView searchButtonImageView = new ImageView(buttonImage);
    private ImageView searchButtonImageView1 = new ImageView(buttonImage1);

    private ImageView backgroundImageView = new ImageView(collectionBackgroundImage);


    private Media mouseClicked = new Media(getClass ( ).getClassLoader ().getResource ("audio/Button-SoundBible.com-1420500901.mp3" ).toExternalForm ());
    private Media mouseEntered= new Media (getClass().getClassLoader().getResource ("audio/zapsplat_multimedia_click_003_19369.mp3").toExternalForm ());
    MediaPlayer clickedPlayer= new MediaPlayer (mouseClicked);
    MediaPlayer enteredPlayer= new MediaPlayer (mouseEntered);

    public CollectionMenuView() {

        enteredPlayer.setVolume(0.5);
        collectionMenuRoot = new Group();
        backgroundImageView.setFitHeight(Consts.height);
        backgroundImageView.setFitWidth(Consts.width);
        collectionMenuScene = new Scene(collectionMenuRoot, Consts.width, Consts.height);
        collectionMenuRoot.getChildren().add(backgroundImageView);


        //show all decks
        setImageView(showAllDecksButtonImageView, 12);
        setImageView(showAllDecksButtonImageView1, 12);
        showAllDecksButtonImageView1.setOpacity(0);
        setButton(showAllDecksButton, 12);
        setLabel(showAllDecksLabel, 12);
        collectionMenuRoot.getChildren().add(showAllDecksButtonImageView);
        collectionMenuRoot.getChildren().add(showAllDecksButtonImageView1);
        collectionMenuRoot.getChildren().add(showAllDecksButton);
        collectionMenuRoot.getChildren().add(showAllDecksLabel);

        //search
        setImageView(searchButtonImageView, 2);
        setImageView(searchButtonImageView1, 2);
        searchButtonImageView1.setOpacity(0);
        setButton(searchButton, 2);
        setLabel(searchLabel, 2);
        collectionMenuRoot.getChildren().add(searchButtonImageView);
        collectionMenuRoot.getChildren().add(searchButtonImageView1);
        collectionMenuRoot.getChildren().add(searchLabel);
        collectionMenuRoot.getChildren().add(searchButton);

        //create Deck
        setImageView(createDeckButtonImageView, 8);
        setImageView(createDeckButtonImageView1, 8);
        createDeckButtonImageView1.setOpacity(0);
        setButton(createDeckButton , 8);
        setLabel(createDeckLabel, 8);
        collectionMenuRoot.getChildren().add((createDeckButtonImageView));
        collectionMenuRoot.getChildren().add((createDeckButtonImageView1));
        collectionMenuRoot.getChildren().add(createDeckLabel);
        collectionMenuRoot.getChildren().add(createDeckButton );

        //delete deck
        setImageView(deleteDeckButtonImageView, 9);
        setImageView(deleteDeckButtonImageView1, 9);
        deleteDeckButtonImageView1.setOpacity(0);
        setButton(deleteDeckButton, 9);
        deleteDeckButton.setOpacity(0);
        setLabel(deleteDeckLabel, 9);
        collectionMenuRoot.getChildren().add(deleteDeckButtonImageView);
        collectionMenuRoot.getChildren().add(deleteDeckButtonImageView1);
        collectionMenuRoot.getChildren().add(deleteDeckLabel);
        collectionMenuRoot.getChildren().add(deleteDeckButton);

        //add card
        setImageView(addCardButtonImageView, 4);
        setImageView(addCardButtonImageView1, 4);
        addCardButtonImageView1.setOpacity(0);
        setButton(addCardButton, 4);
        setLabel(addCardLabel, 4);
        collectionMenuRoot.getChildren().add(addCardButtonImageView);
        collectionMenuRoot.getChildren().add(addCardButtonImageView1);
        collectionMenuRoot.getChildren().add(addCardLabel);
        collectionMenuRoot.getChildren().add(addCardButton);


        //show
        setImageView(showButtonImageView, 6);
        setImageView(showButtonImageView1, 6);
        showButtonImageView1.setOpacity(0);
        setButton(showButton, 6);
        setLabel(showLabel, 6);
        collectionMenuRoot.getChildren().add(showButtonImageView);
        collectionMenuRoot.getChildren().add(showButtonImageView1);
        collectionMenuRoot.getChildren().add(showLabel);
        collectionMenuRoot.getChildren().add(showButton);

        //main menu
        setImageView(mainMenuButtonImageView, 0);
        setImageView(mainMenuButtonImageView1, 0);
        mainMenuButtonImageView1.setOpacity(0);
        setButton(mainMenuButton, 0);
        setLabel(mainMenuLabel, 0);
        collectionMenuRoot.getChildren().add(mainMenuButtonImageView);
        collectionMenuRoot.getChildren().add(mainMenuButtonImageView1);
        collectionMenuRoot.getChildren().add(mainMenuLabel);
        collectionMenuRoot.getChildren().add(mainMenuButton);

        //remove card
        setImageView(removeCardButtonImageView, 5);
        setImageView(removeCardButtonImageView1, 5);
        removeCardButtonImageView1.setOpacity(0);
        setButton(removeCardButton, 5);
        setLabel(removeCardLabel, 5);
        collectionMenuRoot.getChildren().add(removeCardButtonImageView);
        collectionMenuRoot.getChildren().add(removeCardButtonImageView1);
        collectionMenuRoot.getChildren().add(removeCardLabel);
        collectionMenuRoot.getChildren().add(removeCardButton);

        //validate deck
        setImageView(validateDeckButtonImageView, 11);
        setImageView(validateDeckButtonImageView1, 11);
        validateDeckButtonImageView1.setOpacity(0);
        setButton(validateDeckButton, 11);
        setLabel(validateDeckLabel, 11);
        collectionMenuRoot.getChildren().add(validateDeckButtonImageView);
        collectionMenuRoot.getChildren().add(validateDeckButtonImageView1);
        collectionMenuRoot.getChildren().add(validateDeckLabel);
        collectionMenuRoot.getChildren().add(validateDeckButton);

        //save
        setImageView(saveButtonImageView, 1);
        setImageView(saveButtonImageView1, 1);
        saveButtonImageView1.setOpacity(0);
        setButton(saveButton, 1);
        setLabel(saveLabel, 1);
        collectionMenuRoot.getChildren().add(saveButtonImageView);
        collectionMenuRoot.getChildren().add(saveButtonImageView1);
        collectionMenuRoot.getChildren().add(saveLabel);
        collectionMenuRoot.getChildren().add(saveButton);

        //show deck
        setImageView(showDeckButtonImageView, 7);
        setImageView(showDeckButtonImageView1, 7);
        showDeckButtonImageView1.setOpacity(0);
        setButton(showDeckButton, 7);
        setLabel(showDeckLabel, 7);
        collectionMenuRoot.getChildren().add(showDeckButtonImageView);
        collectionMenuRoot.getChildren().add(showDeckButtonImageView1);
        collectionMenuRoot.getChildren().add(showDeckLabel);
        collectionMenuRoot.getChildren().add(showDeckButton);

        //select deck
        setImageView(selectDeckButtonImageView, 10);
        setImageView(selectDeckButtonImageView1, 10);
        selectDeckButtonImageView1.setOpacity(0);
        setButton(selectDeckButton, 10);
        setLabel(selectDeckLabel, 10);
        collectionMenuRoot.getChildren().add(selectDeckButtonImageView);
        collectionMenuRoot.getChildren().add(selectDeckButtonImageView1);
        collectionMenuRoot.getChildren().add(selectDeckLabel);
        collectionMenuRoot.getChildren().add(selectDeckButton);

        checkMovements();

    }

    public Scene getCollectionMenuScene() {
        return collectionMenuScene;
    }

    public void checkMovements() {

        showAllDecksButton.setOnMouseEntered(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {


                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (showAllDecksButtonImageView.getOpacity() == 100)
                    showAllDecksButtonImageView.setOpacity(0);
                if (showAllDecksButtonImageView1.getOpacity() == 0)
                    showAllDecksButtonImageView1.setOpacity(100);
            }
        });


        showAllDecksButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( showAllDecksButtonImageView1.getOpacity() == 100)
                    showAllDecksButtonImageView1.setOpacity(0);
                if ( showAllDecksButtonImageView.getOpacity() == 0)
                    showAllDecksButtonImageView.setOpacity(100);
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

        validateDeckButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (validateDeckButtonImageView.getOpacity() == 100)
                    validateDeckButtonImageView.setOpacity(0);
                if (validateDeckButtonImageView1.getOpacity() == 0)
                    validateDeckButtonImageView1.setOpacity(100);
            }
        });


        validateDeckButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (validateDeckButtonImageView1.getOpacity() == 100)
                    validateDeckButtonImageView1.setOpacity(0);
                if (validateDeckButtonImageView.getOpacity() == 0)
                    validateDeckButtonImageView.setOpacity(100);
            }
        });

       showDeckButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (showDeckButtonImageView.getOpacity() == 100)
                    showDeckButtonImageView.setOpacity(0);
                if (showDeckButtonImageView1.getOpacity() == 0)
                    showDeckButtonImageView1.setOpacity(100);
            }
        });


        showDeckButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (showDeckButtonImageView1.getOpacity() == 100)
                    showDeckButtonImageView1.setOpacity(0);
                if (showDeckButtonImageView.getOpacity() == 0)
                    showDeckButtonImageView.setOpacity(100);
            }
        });


        saveButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (saveButtonImageView.getOpacity() == 100)
                    saveButtonImageView.setOpacity(0);
                if (saveButtonImageView1.getOpacity() == 0)
                    saveButtonImageView1.setOpacity(100);
            }
        });


       saveButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (saveButtonImageView1.getOpacity() == 100)
                    saveButtonImageView1.setOpacity(0);
                if (saveButtonImageView.getOpacity() == 0)
                    saveButtonImageView.setOpacity(100);
            }
        });

        selectDeckButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (selectDeckButtonImageView.getOpacity() == 100)
                    selectDeckButtonImageView.setOpacity(0);
                if (selectDeckButtonImageView1.getOpacity() == 0)
                    selectDeckButtonImageView1.setOpacity(100);
            }
        });


        selectDeckButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (selectDeckButtonImageView1.getOpacity() == 100)
                    selectDeckButtonImageView1.setOpacity(0);
                if (selectDeckButtonImageView.getOpacity() == 0)
                    selectDeckButtonImageView.setOpacity(100);
            }
        });


        createDeckButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (createDeckButtonImageView.getOpacity() == 100)
                    createDeckButtonImageView.setOpacity(0);
                if (createDeckButtonImageView1.getOpacity() == 0)
                    createDeckButtonImageView1.setOpacity(100);
            }
        });


        createDeckButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( createDeckButtonImageView1.getOpacity() == 100)
                    createDeckButtonImageView1.setOpacity(0);
                if ( createDeckButtonImageView.getOpacity() == 0)
                    createDeckButtonImageView.setOpacity(100);
            }
        });

        deleteDeckButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if ( deleteDeckButtonImageView.getOpacity() == 100)
                    deleteDeckButtonImageView.setOpacity(0);
                if ( deleteDeckButtonImageView1.getOpacity() == 0)
                    deleteDeckButtonImageView1.setOpacity(100);
            }
        });


        deleteDeckButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if ( deleteDeckButtonImageView1.getOpacity() == 100)
                    deleteDeckButtonImageView1.setOpacity(0);
                if ( deleteDeckButtonImageView.getOpacity() == 0)
                    deleteDeckButtonImageView.setOpacity(100);
            }
        });

        addCardButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (addCardButtonImageView.getOpacity() == 100)
                    addCardButtonImageView.setOpacity(0);
                if (addCardButtonImageView1.getOpacity() == 0)
                    addCardButtonImageView1.setOpacity(100);
            }
        });


        addCardButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (addCardButtonImageView1.getOpacity() == 100)
                    addCardButtonImageView1.setOpacity(0);
                if (addCardButtonImageView.getOpacity() == 0)
                    addCardButtonImageView.setOpacity(100);
            }
        });

        removeCardButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if ( removeCardButtonImageView.getOpacity() == 100)
                    removeCardButtonImageView.setOpacity(0);
                if ( removeCardButtonImageView1.getOpacity() == 0)
                    removeCardButtonImageView1.setOpacity(100);
            }
        });


        removeCardButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (removeCardButtonImageView1.getOpacity() == 100)
                    removeCardButtonImageView1.setOpacity(0);
                if (removeCardButtonImageView.getOpacity() == 0)
                    removeCardButtonImageView.setOpacity(100);
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

        showAllDecksButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                collectionMenuRoot.getChildren ().clear();
                collectionMenuRoot.getChildren().add(backgroundImageView);
                backgroundImageView.setEffect(new GaussianBlur());
                showAllDecksClicked(Menu.loggedInPlayer);
            }
        });

        showButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                //todo
            }
        });

        addCardButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                collectionMenuRoot.getChildren ().clear();
                collectionMenuRoot.getChildren().add(backgroundImageView);
                backgroundImageView.setEffect(new GaussianBlur());
                TextField deckName = new TextField("deck name");
                TextField cardID = new TextField("card/item ID");
                cardID.relocate(0, 100);
                collectionMenuRoot.getChildren().add(deckName);
                deckName.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        collectionMenuRoot.getChildren().add(cardID);
                        cardID.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                addOrRemoveCardClicked("add", deckName.getText(), cardID.getText());
                            }
                        });
                    }
                });
            }
        });

        removeCardButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                collectionMenuRoot.getChildren ().clear();
                collectionMenuRoot.getChildren().add(backgroundImageView);
                backgroundImageView.setEffect(new GaussianBlur());
                TextField deckName = new TextField("deck name");
                TextField cardID = new TextField("card/item ID");
                cardID.relocate(0, 100);
                collectionMenuRoot.getChildren().add(deckName);
                deckName.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        collectionMenuRoot.getChildren().add(cardID);
                        cardID.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                addOrRemoveCardClicked("remove", deckName.getText(), cardID.getText());
                            }
                        });
                    }
                });
            }
        });

        mainMenuButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                Menu.firstMenu();
            }
        });


        searchButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                collectionMenuRoot.getChildren ().clear();
                collectionMenuRoot.getChildren().add(backgroundImageView);
                backgroundImageView.setEffect(new GaussianBlur());
                TextField ID = new TextField();
                ID.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        searchClicked(ID.getText());
                    }
                });
            }
        });

        createDeckButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                collectionMenuRoot.getChildren ().clear();
                collectionMenuRoot.getChildren().add(backgroundImageView);
                backgroundImageView.setEffect(new GaussianBlur());
                TextField textField = new TextField();
                collectionMenuRoot.getChildren().add(textField);
                textField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        collectionMenuRoot.getChildren().remove(textField);
                        createOrRemoveDeck("create", textField.getText());
                    }
                });
            }
        });

        deleteDeckButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                collectionMenuRoot.getChildren ().clear();
                collectionMenuRoot.getChildren().add(backgroundImageView);
                backgroundImageView.setEffect(new GaussianBlur());
                TextField textField = new TextField();
                textField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        createOrRemoveDeck("remove", textField.getText());
                    }
                });
            }
        });

        validateDeckButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                collectionMenuRoot.getChildren ().clear();
                collectionMenuRoot.getChildren().add(backgroundImageView);
                backgroundImageView.setEffect(new GaussianBlur());
                TextField textField = new TextField();
                textField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        for (int i = 0; i < Menu.loggedInPlayer.getCollection().getDecks().size(); i++) {
                            if (Menu.loggedInPlayer.getCollection().getDecks().get(i).getName().compareToIgnoreCase(textField.getText())==0) {
                                if (Menu.loggedInPlayer.getCollection().validateDeck(Menu.loggedInPlayer.getCollection().getDecks().get(i))) {
                                    Text text = new Text("valid");
                                    collectionMenuRoot.getChildren().add(text);
                                    System.out.println("valid");
                                } else {
                                    Text text = new Text("invalid");
                                    collectionMenuRoot.getChildren().add(text);
                                    System.out.println("invalid");
                                }
                                break;
                            }
                        }
                    }
                });
            }
        });

        showDeckButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                collectionMenuRoot.getChildren ().clear();
                collectionMenuRoot.getChildren().add(backgroundImageView);
                backgroundImageView.setEffect(new GaussianBlur());
                TextField textField = new TextField();
                collectionMenuRoot.getChildren().add(textField);
                textField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        for (Deck deck: Menu.loggedInPlayer.getCollection().getDecks()) {
                            if(deck.getName().compareToIgnoreCase(textField.getText()) == 0){
                                showDeck(deck);
                            }
                        }
                    }
                });
            }
        });

        selectDeckButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                collectionMenuRoot.getChildren ().clear();
                collectionMenuRoot.getChildren().add(backgroundImageView);
                backgroundImageView.setEffect(new GaussianBlur());
                TextField textField = new TextField();
                collectionMenuRoot.getChildren().add(textField);
                textField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        selectClicked(textField.getText());
                    }
                });
            }
        });

        saveButton.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                //todo
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
            collectionMenuRoot.getChildren().add(exitButtonImageView);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            Image image1 = new Image(new FileInputStream ("/Users/rostaroghani/Desktop/project-3/src/pics/button_close@2x.png"));
            ImageView exitButtonImageView1 = new ImageView(image1);
            exitButtonImageView1.setFitWidth(50);
            exitButtonImageView1.setFitHeight(50);
            exitButtonImageView1.setX(10);
            exitButtonImageView1.setY(10);
            collectionMenuRoot.getChildren().add(exitButtonImageView1);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        exit.setPrefSize(40, 40);
        exit.relocate(20, 20);
        exit.setOpacity(0);
        collectionMenuRoot.getChildren().add(exit);

        exit.setOnMouseClicked (new EventHandler<MouseEvent> ( ) {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play ();
                clickedPlayer.seek(Duration.ZERO);
                Menu.secondMenuCommand("exit");
            }
        });
        //faqat be safheye qabl bargarde na be main menu
    }

    public void setImageView(ImageView buttonImageView, int n) {

        buttonImageView.setFitWidth(buttonSizeWidth);
        buttonImageView.setFitHeight(buttonSizeHeight);
        if (n <= 3) {
            buttonImageView.setX(Consts.width - 750);
            buttonImageView.setY(Consts.height / 100 + 100 +  n * Consts.distance);
        }
        else if(n<=7){
            buttonImageView.setX(Consts.width / 2 + 100);
            buttonImageView.setY(Consts.height / 100 + (n - 3) * Consts.distance);
        }
        else {
            buttonImageView.setX(Consts.width / 2 + 340 );
            buttonImageView.setY(Consts.height / 100 + (n - 7) * Consts.distance);
        }

    }

    public void setButton(Button button, int n) {
        button.setOpacity(0);
        if (n <= 3) {
            button.relocate(Consts.width -750, Consts.height / 100 + 100 +  n * Consts.distance);
        }
        else if(n<=7){
            button.relocate(Consts.width / 2 + 100, Consts.height / 100 + (n-3) * Consts.distance);
        }
        else {
            button.relocate(Consts.width / 2 + 340, Consts.height / 100 + (n - 7) * Consts.distance);
        }
        button.setPrefSize(buttonSizeWidth, buttonSizeHeight);
    }

    public void setLabel(Label label, int n) {
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        if (n <= 3) {
            if(n==3){
                label.relocate(Consts.width - 660 , Consts.height / 100 + 130 + n * Consts.distance);
            }
            else{
                label.relocate(Consts.width - 650 , Consts.height / 100 + 130 + n * Consts.distance);
            }
        }
        else if(n<=7){
            if(n==4){
                label.relocate(Consts.width / 2 + 180, Consts.height / 100 + (n-3) * Consts.distance + 30);
            }
            else if(n==6){
                label.relocate(Consts.width / 2 + 195, Consts.height / 100 + (n-3) * Consts.distance + 30);
            }
            else{
                label.relocate(Consts.width / 2 + 165, Consts.height / 100 + (n-3) * Consts.distance + 30);
            }
        }
        else {
            label.relocate(Consts.width / 2 + 400, Consts.height / 100 + (n - 7) * Consts.distance + 30);
        }
    }

    public void showAllDecksClicked(Account account) {
        boolean haveMainDeck=false;
        if(account.getMainDeck ()!=null){
            System.out.println (account.getMainDeck ().getName () );
            showDeck (account.getMainDeck ());
            haveMainDeck=true;
        }
        for(Deck x:account.getDecks ()){
            if(!haveMainDeck){
                System.out.println (x.getName () );
                showDeck (x);
            }
            else if(!(x.equals (account.getMainDeck ()))){
                System.out.println (x.getName () );
                showDeck (x);
            }
        }
    }

    public void showDeck(Deck deck){

        Button exit = new Button("back");
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Menu.collectionMenu();
            }
        });
        int changeY = 50;
        Text deckName = new Text("deck name = " + deck.getName());
        collectionMenuRoot.getChildren().add(deckName);
        deckName.relocate(100, changeY);
        changeY+=50;
        System.out.println("deck name = " + deck.getName());

        Text heroes = new Text("Heroes:" );
        collectionMenuRoot.getChildren().add(heroes);
        heroes.relocate(100, changeY);
        changeY += 50;
        System.out.println ("Heroes:" );
        for(int i = 0; i< deck.getCards ().size (); i++){
            if(deck.getCards ().get(i).getType ().compareTo ("Hero")==0){
                Text text = new Text((i+1) +" Name: " + deck.getCards ().get(i).getName () +" - AP: "+deck.getCards ().get(i).getAP ()+
                        " - HP: "+ deck.getCards ().get(i).getHP ()+" - Special Power: "+ deck.getCards ().get(i).getDesc () +
                        " - Buy Cost: " + deck.getCards ().get (i).getPrice ());
                text.relocate(100, changeY);
                collectionMenuRoot.getChildren().add(text);
                changeY += 50;
                System.out.println ((i+1) +" Name: " + deck.getCards ().get(i).getName () +" - AP: "+deck.getCards ().get(i).getAP ()+
                        " - HP: "+ deck.getCards ().get(i).getHP ()+" - Special Power: "+ deck.getCards ().get(i).getDesc () +
                        " - Buy Cost: " + deck.getCards ().get (i).getPrice ());
            }
        }
        Text items = new Text("Items:" );
        collectionMenuRoot.getChildren().add(items);
        items.relocate(100, changeY);
        changeY += 50;
        System.out.println ("Items:" );
        for(int i= 0; i< deck.getItems ().size(); i++){
            Text text = new Text((i+1) + ": Name:" + deck.getItems ().get(i).getName () + "- Desc:" + deck.getItems ().get (i).getDesc () +
                    "Buy Cost:" + deck.getItems ().get(i).getPrice ());
            collectionMenuRoot.getChildren().add(text);
            text.relocate(100, changeY);
            changeY += 50;
            System.out.println ((i+1) + ": Name:" + deck.getItems ().get(i).getName () + "- Desc:" + deck.getItems ().get (i).getDesc () +
                    "Buy Cost:" + deck.getItems ().get(i).getPrice ());
        }
        Text cards = new Text("Cards:" );
        cards.relocate(100, changeY);
        collectionMenuRoot.getChildren().add(cards);
        changeY += 50;
        System.out.println ("Cards:" );
        for(int i = 0; i< deck.getCards ().size (); i++){
            if(deck.getCards ().get(i).getType ().compareTo ("Spell")== 0){
                Text text = new Text((i+1) +"Type "+ deck.getCards ().get (i).getType ()+ " - Name: " +deck.getCards ().get(i).getName () +
                        " - MP: "+deck.getCards ().get(i).getMP ()+" - Class: " +deck.getCards ().getClass () +" - Description: "+
                        deck.getCards ().get(i).getDesc () + " - Buy Cost: " + deck.getCards ().get (i).getPrice ());
                collectionMenuRoot.getChildren().add(text);
                text.relocate(100, changeY);
                changeY += 50;
                System.out.println ((i+1) +"Type "+ deck.getCards ().get (i).getType ()+ " - Name: " +deck.getCards ().get(i).getName () +
                        " - MP: "+deck.getCards ().get(i).getMP ()+" - Class: " +deck.getCards ().getClass () +" - Description: "+
                        deck.getCards ().get(i).getDesc () + " - Buy Cost: " + deck.getCards ().get (i).getPrice ());
            }
            else if(deck.getCards ().get(i).getType ().compareTo ("Minion")== 0){
                Text text = new Text((i+1) +"Type "+ deck.getCards ().get (i).getType ()+ " - Name: " +
                        deck.getCards ().get(i).getName () + " - Class: " +deck.getCards ().getClass () +
                        " - AP: "+deck.getCards ().get(i).getAP ()+" - HP: "+deck.getCards ().get (i).getHP ()+
                        " - MP"+deck.getCards ().get (i).getMP ()+" - SpecialPower: "+
                        deck.getCards ().get(i).getDesc () + " - Buy Cost: " + deck.getCards ().get (i).getPrice ());
                collectionMenuRoot.getChildren().add(text);
                text.relocate(100, changeY);
                changeY += 50;
                System.out.println ((i+1) +"Type "+ deck.getCards ().get (i).getType ()+ " - Name: " +
                        deck.getCards ().get(i).getName () + " - Class: " +deck.getCards ().getClass () +
                        " - AP: "+deck.getCards ().get(i).getAP ()+" - HP: "+deck.getCards ().get (i).getHP ()+
                        " - MP"+deck.getCards ().get (i).getMP ()+" - SpecialPower: "+
                        deck.getCards ().get(i).getDesc () + " - Buy Cost: " + deck.getCards ().get (i).getPrice ());
            }
        }
    }

    public void addOrRemoveCardClicked(String order, String deckName, String cardID) {

        outer:
        for (Deck deck: Menu.loggedInPlayer.getCollection().getDecks()) {
            if(deck.getName().equals(deckName)){
                for (Card card: Menu.loggedInPlayer.getCollection().getCards()) {
                    System.out.println("card.getName() = " + card.getName());
                    if(card.getCardID().equals(cardID)){
                        if (card.getType().equals("Hero")){
                            if(deck.getHero() != null){
                                if(order.equals("add")) {
                                    Text text = new Text("cannot add any hero to deck");
                                    collectionMenuRoot.getChildren().add(text);
                                    System.out.println("cannot add any hero to deck");
                                }
                                else{
                                    deck.setHero(null);
                                }
                                break outer;
                            }
                            else {
                                deck.setHero(card);
                                break outer;
                            }
                        }
                        if(order.compareToIgnoreCase("add")==0) {
                            deck.addToCards(card);
                            if(deck.getCards().size() > 20){
                                Text text = new Text("cannot add any hero to deck");
                                collectionMenuRoot.getChildren().add(text);
                                System.out.println("cannot add any card to deck");
                                deck.removeFromCards(card);
                            }
                        }
                        else
                        if(deck.contains(card)) {
                            deck.removeFromCards(card);
                        }
                        else {
                            Text text = new Text("Deck doesn't contain this item");
                            collectionMenuRoot.getChildren().add(text);
                            System.out.println("Deck doesn't contain this card");
                        }
                        break outer;
                    }
                }
                for (Item item : Menu.loggedInPlayer.getCollection().getItems()){
                    if(item.getItemID().equals(cardID)){
                        if (order.compareToIgnoreCase("add")==0) {
                            deck.addToItems(item);
                            if (!deck.validateDeck()) {
                                Text text = new Text("cannot add any hero to deck");
                                collectionMenuRoot.getChildren().add(text);
                                System.out.println("cannot add any item to deck");
                                deck.removeFromItems(item);
                            }
                        }
                        else {
                            if(deck.contains(item)) {
                                deck.removeFromItems(item);
                            }
                            else {
                                Text text = new Text("Deck doesn't contain this item");
                                collectionMenuRoot.getChildren().add(text);
                                System.out.println("Deck doesn't contain this item");
                            }
                        }
                        break outer;
                    }
                }
                Text text = new Text("selected card/item is not in the collection");
                collectionMenuRoot.getChildren().add(text);
                System.out.println("selected card/item is not in the collection");
            }
        }
    }

    public void searchClicked(String name) {
        String temp = Menu.loggedInPlayer.getCollection().search(name);
        if (temp != "") {
            Text text = new Text(temp);
            collectionMenuRoot.getChildren().add(text);
            System.out.println(temp);
        } else {
            Text text = new Text("entered card/item does not exist in this collection");
            System.out.println("entered card/item does not exist in this collection");
        }
    }

    public void createOrRemoveDeck(String order, String name) {

        if(order.equals("create")) {
            boolean check = false;
            Deck deck = new Deck();
            deck.setName(name);
            for (int i = 0; i < Menu.loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (Menu.loggedInPlayer.getCollection().getDecks().get(i).getName().equals(name)) {
                    Text text = new Text("Deck already exists!");
                    collectionMenuRoot.getChildren().add(text);
                    System.out.println("Deck already exists!");
                    check = true;
                }
            }
            if (!check) {
                Text text = new Text("added!");

                collectionMenuRoot.getChildren().add(text);
                text.relocate(100, 100);
                text.setFont(Font.font(40));
                Menu.loggedInPlayer.getCollection().addToDecks(deck);
            }
            System.out.println("deck.getName() = " + deck.getName());
        }
        else{
            boolean check = false;
            for (int i = 0; i < Menu.loggedInPlayer.getCollection().getDecks().size(); i++) {
                if (Menu.loggedInPlayer.getCollection().getDecks().get(i).getName().equals(name)) {
                    Menu.loggedInPlayer.getCollection().getDecks().remove(i);
                    check = true;
                }
            }
            if (!check) {
                System.out.println("Deck doesn't exist!");
            }
        }
    }

    public void selectClicked(String name) {
        boolean check = false;
        for (int i = 0; i < Menu.loggedInPlayer.getCollection().getDecks().size(); i++) {
            if (Menu.loggedInPlayer.getCollection().getDecks().get(i).getName().compareToIgnoreCase(name)==0) {
                Menu.loggedInPlayer.setMainDeck(Menu.loggedInPlayer.getCollection().getDecks().get(i));
                check = true;
                Text text = new Text("selected");
                collectionMenuRoot.getChildren().add(text);
                text.relocate(100, 100);
                text.setFont(Font.font(40));
            }
        }
        if (!check) {
            Text text = new Text("Deck doesnt exist!");
            collectionMenuRoot.getChildren().add(text);
            System.out.println("Deck doesnt exist!");
        }
    }
}