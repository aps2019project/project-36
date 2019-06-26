package Battle;

import Collective.Card.Card;
import Collective.Card.Hero;
import Map.*;
import Menu.Graphics;
import Menu.Main;
import Player.Player;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Consts.Consts;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.cert.TrustAnchor;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class BattleView {

    private int finalHandCard = 6;

    Game currentGame = new Game();

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

    Map currentMap = new Map();

    Player player1 = new Player();

    private Group battleRoot = new Group();
    private Group TableRoot=new Group();

    private Scene BattleScene = new Scene(battleRoot, Consts.width, Consts.height);

    private Image battleBoardImage = new Image("pics/battlemap6_middleground.png");
    private ImageView battleBoardImageView;


    // cards :


    //todo adding the address
    //private Image hero1Image = new Image(currentGame.getPlayer1().getMainDeck().getHero().getAddress());
    //private Image hero2Image = new Image(currentGame.getPlayer2().getMainDeck().getHero().getAddress());

    private Image hero1Image = new Image("pics/heroSample1.png");
    private Image hero2Image = new Image("pics/heroSample2.png");

    private ImageView hero1ImageView = new ImageView(hero1Image);
    private ImageView hero2ImageView = new ImageView(hero2Image);


    private Image[] cardsImage = new Image[21];
    private ImageView[] cardsImageView = new ImageView[21];

    // buttons :

    private int endTurnSizeX = 200;
    private int endTurnSizeY = 100;

    private int rightSizeX = 100;
    private int rightSizeY = 50;


    private int leftSizeX = rightSizeX;
    private int leftSizeY = rightSizeY;

    private int locateY = 590;
    private int locateX = 1050;


    private Image endTurnImage = new Image("pics/button_end_turn_mine.png");
    private Image endTurnImage1 = new Image("pics/button_end_turn_mine_glow.png");

    private ImageView endTurnImageView1 = new ImageView(endTurnImage1);
    private ImageView endTurnImageView = new ImageView(endTurnImage);

    private Button endTurnButton = new Button();

    private Label endTurnLabel= new Label("END TURN");

    private Image DeckImage;// = new Image("/Users/ygnh/Downloads/project-3/src/pics/replace_background@2x.png");

    //private ImageView DeckImageView = new ImageView(DeckImage);

    private Button DeckButton = new Button();

    private Label DeckLabel = new Label("Deck");

    //private Image image;// = new Image("pics/button_primary_left@2x.png");

    private Image leftImage = new Image("pics/button_primary_left@2x.png");
    private Image leftImage1 = new Image("pics/button_primary_left_glow@2x.png");

    private ImageView leftImageView1 = new ImageView(leftImage1);
    private ImageView leftImageView = new ImageView(leftImage);

    private Button leftButton = new Button();

    private Label leftLabel= new Label("END GAME");

    private Image rightImage = new Image("pics/button_primary_right@2x.png");
    private Image rightImage1 = new Image("pics/button_primary_right_glow@2x.png");

    private ImageView rightImageView1 = new ImageView(rightImage1);
    private ImageView rightImageView = new ImageView(rightImage);

    private Button rightButton = new Button();

    private Label rightLabel= new Label("QUIT");

    // hand :
    private int handSize = 100;
    private int handX = 340;
    private int handY = 560;

    private Image handImage;// = new Image("pics/lesson_ring_glow@2x.png");
    //private Image handImage;// = new Image("pics/replace_outer_ring_shine@2x.png");
    private ImageView[] handImageViews = new ImageView[5];
    private Button[] handButtons = new Button[5];

    private ImageView[] cardHandImageViews = new ImageView[5];

    // cells :

    private int cellSize = 70;

    private Button[][] cell = new Button[9][5];
    private Rectangle rectangle[][] = new Rectangle[9][5];

    public BattleView() {

        setPlayer1(Graphics.player);
        System.out.println(player1.getUsername());
        System.out.println(player1.getMainDeck().getHero().getName() + "here");

        try {
            cardsImage[0] = new Image(new FileInputStream("/Users/ygnh/Downloads/project-3/src/HeroGifs/"
                    + player1.getMainDeck().getHero().getName() + ".gif"));
            for (int i = 1; i < 13; i++){
                System.out.println("/Users/ygnh/Downloads/project-3/src/MinionGifs/" + player1.getMainDeck().getCards().get(i).getName() + ".gif");
                cardsImage[i] = new Image(new FileInputStream("/Users/ygnh/Downloads/project-3/src/MinionGifs/"
                        + player1.getMainDeck().getCards().get(i).getName() + ".gif"));
            }
            handImage = new Image(new FileInputStream("/Users/ygnh/Downloads/project-3/src/pics/lesson_ring_glow@2x.png"));
            DeckImage = new Image(new FileInputStream("/Users/ygnh/Downloads/project-3/src/pics/replace_background@2x.png"));
            //battleBoardImage = new Image(new FileInputStream("pics/replace_background@2x.png"));
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }


        ImageView DeckImageView = new ImageView(DeckImage);

        battleBoardImageView = new ImageView(battleBoardImage);
        battleBoardImageView.setFitHeight(Consts.height);
        battleBoardImageView.setFitWidth(Consts.width);
        battleRoot.getChildren().addAll(battleBoardImageView);

        // hero :

        hero1ImageView.setFitWidth(100);
        hero1ImageView.setFitHeight(100);
        hero1ImageView.relocate(200, 30);
        battleRoot.getChildren().add(hero1ImageView);

        hero2ImageView.setFitWidth(100);
        hero2ImageView.setFitHeight(100);
        hero2ImageView.relocate(Consts.width - 200 - 100,30);
        battleRoot.getChildren().add(hero2ImageView);


        //end turn Button

        endTurnImageView.setFitWidth(endTurnSizeX);
        endTurnImageView.setFitHeight(endTurnSizeY);
        endTurnImageView.relocate(950, 500);
        endTurnImageView1.setFitWidth(endTurnSizeX);
        endTurnImageView1.setFitHeight(endTurnSizeY);
        endTurnImageView1.relocate(950, 500);
        endTurnButton.setPrefSize(endTurnSizeX, endTurnSizeY);
        endTurnButton.relocate(950, 500);
        endTurnImageView1.setOpacity(0);
        endTurnButton.setOpacity(0);
        endTurnLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        endTurnLabel.setTextFill(Color.WHITE);
        endTurnLabel.relocate(1000, 540);
        battleRoot.getChildren().add(endTurnImageView);
        battleRoot.getChildren().add(endTurnImageView1);
        battleRoot.getChildren().add(endTurnLabel);
        battleRoot.getChildren().add(endTurnButton);

        // left right button

        leftImageView.setFitWidth(leftSizeX);
        leftImageView.setFitHeight(leftSizeY);
        leftImageView.relocate(locateX - 100, locateY);
        leftImageView1.setFitWidth(leftSizeX);
        leftImageView1.setFitHeight(leftSizeY);
        leftImageView1.relocate(locateX - 100, locateY);
        leftButton.setPrefSize(leftSizeX, leftSizeY);
        leftButton.relocate(locateX - 100, locateY);
        leftImageView1.setOpacity(0);
        leftButton.setOpacity(0);
        leftLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        leftLabel.setTextFill(Color.WHITE);
        leftLabel.relocate(locateX - 100 + 25, locateY + 18);
        battleRoot.getChildren().add(leftImageView);
        battleRoot.getChildren().add(leftImageView1);
        battleRoot.getChildren().add(leftLabel);
        battleRoot.getChildren().add(leftButton);

        rightImageView.setFitWidth(rightSizeX);
        rightImageView.setFitHeight(rightSizeY);
        rightImageView.relocate(locateX, locateY);
        rightImageView1.setFitWidth(rightSizeX);
        rightImageView1.setFitHeight(rightSizeY);
        rightImageView1.relocate(locateX, locateY);
        rightButton.setPrefSize(rightSizeX, rightSizeY);
        rightButton.relocate(locateX, locateY);
        rightImageView1.setOpacity(0);
        rightButton.setOpacity(0);
        rightLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        rightLabel.setTextFill(Color.WHITE);
        rightLabel.relocate(locateX + 25, locateY + 15);
        battleRoot.getChildren().add(rightImageView);
        battleRoot.getChildren().add(rightImageView1);
        battleRoot.getChildren().add(rightLabel);
        battleRoot.getChildren().add(rightButton);

        DeckImageView.setFitWidth(200);
        DeckImageView.setFitHeight(200);
        DeckImageView.relocate(100, 500);
        DeckButton.setPrefSize(200, 200);
        DeckButton.relocate(100, 500);
        DeckButton.setOpacity(0);
        DeckLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        DeckLabel.setTextFill(Color.WHITE);
        DeckLabel.relocate(175, 585);
        battleRoot.getChildren().add(DeckImageView);
        battleRoot.getChildren().add(DeckLabel);
        battleRoot.getChildren().add(DeckButton);

        drawRects();
        drawButtons();

        setHand();
        setCards();
        changeHand();

        /*for (int i = 0; i < 4; i++) {
            battleRoot.getChildren().add(cardsImageView[i]);
        }*/



        for (int i = 0; i < 9; i++) {
            battleRoot.getChildren().addAll(cell[i]);
        }
        checkOnMovements();

    }

    public void drawRects() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                rectangle[i][j] = new Rectangle((Consts.width - (2 * 8) - (cellSize * 9)) / 2 + (cellSize + 2) * i,
                        (Consts.height - (2 * 4) - (cellSize * 5)) / 2 + (cellSize + 2) * j,cellSize , cellSize);
                rectangle[i][j].setFill(javafx.scene.paint.Color.rgb(143, 254, 250));
                rectangle[i][j].setOpacity(0.05);
            }
            battleRoot.getChildren().addAll(rectangle[i]);
        }
    }


    public void drawButtons() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++){
                cell[i][j] = new Button();
                cell[i][j].setPrefSize(cellSize, cellSize);
                cell[i][j].relocate((Consts.width - (2 * 8) - (cellSize * 9)) / 2 + (cellSize + 2) * i,
                        (Consts.height - (2 * 4) - (cellSize * 5)) / 2 + (cellSize + 2) * j);
                cell[i][j].setOpacity(0);
            }
        }
    }

    public void checkOnMovements() {


        endTurnButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (endTurnImageView.getOpacity() == 100)
                    endTurnImageView.setOpacity(0);
                if (endTurnImageView1.getOpacity() == 0)
                    endTurnImageView1.setOpacity(100);

            }
        });

        endTurnButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (endTurnImageView1.getOpacity() == 100)
                    endTurnImageView1.setOpacity(0);
                if (endTurnImageView.getOpacity() == 0)
                    endTurnImageView.setOpacity(100);

            }
        });

        leftButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (leftImageView.getOpacity() == 100)
                    leftImageView.setOpacity(0);
                if (leftImageView1.getOpacity() == 0)
                    leftImageView1.setOpacity(100);

            }
        });

        leftButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (leftImageView1.getOpacity() == 100)
                    leftImageView1.setOpacity(0);
                if (leftImageView.getOpacity() == 0)
                    leftImageView.setOpacity(100);

            }
        });

        rightButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (rightImageView.getOpacity() == 100)
                    rightImageView.setOpacity(0);
                if (rightImageView1.getOpacity() == 0)
                    rightImageView1.setOpacity(100);

            }
        });

        rightButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (rightImageView1.getOpacity() == 100)
                    rightImageView1.setOpacity(0);
                if (rightImageView.getOpacity() == 0)
                    rightImageView.setOpacity(100);

            }
        });

        for (int i = 0; i < 5; i++) {
            final int x = i;
            handButtons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    handImageViews[x].relocate(handImageViews[x].getLayoutX() - handSize / 3.8, handImageViews[x].getLayoutY() - handSize / 3);
                    handImageViews[x].setFitHeight(1.5*handSize);
                    handImageViews[x].setFitWidth(1.5*handSize);


                    cardHandImageViews[x].setFitHeight(150);
                    cardHandImageViews[x].setFitHeight(150);
                    cardHandImageViews[x].relocate(cardHandImageViews[x].getLayoutX(), cardHandImageViews[x].getLayoutY() - 30);

                    for (int i = 0; i < currentMap.getCardsInMap().size(); i++){
                        for (int j = 0; j < 9; j++){
                            for (int k = 0; k < 5; k++){
                                if (abs(currentMap.getCardsInMap().get(i).getCell().getX() - j) + abs(currentMap.getCardsInMap().get(i).getCell().getY() - k) <= 1) {
                                    rectangle[j][k].setOpacity(0.5);
                                }
                                else if (abs(currentMap.getCardsInMap().get(i).getCell().getX() - j) == 1 && abs(currentMap.getCardsInMap().get(i).getCell().getY() - k) == 1){
                                    rectangle[j][k].setOpacity(0.5);
                                }
                            }
                        }
                    }

                    for (int k = 0; k < 9; k++) {
                        for (int t = 0; t < 5; t++){
                            int q = k, w = t;
                            cell[k][t].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    handImageViews[x].relocate(handX + x * (handSize + 10), handY);
                                    handImageViews[x].setFitHeight(handSize);
                                    handImageViews[x].setFitWidth(handSize);

                                    for (int i = 0; i < player1.getMainDeck().getCards().size(); i++) {
                                        if (cardsImageView[i].equals(cardHandImageViews[x])) {
                                            currentMap.addToCardsInMap(player1.getMainDeck().getCards().get(i));
                                            Cell cellA = new Cell();
                                            cellA.setX(q);
                                            cellA.setY(w);
                                            player1.getMainDeck().getCards().get(i).setCell(cellA);
                                            cardsImageView[i].relocate(cell[q][w].getLayoutX() - 23, cell[q][w].getLayoutY() - 65);
                                            for (int h = 0; h < player1.getMainDeck().getCards().size(); h++) {
                                                if (!cardsImageView[h].isVisible()){
                                                    cardHandImageViews[x] = new ImageView();
                                                    cardHandImageViews[x] = cardsImageView[h];
                                                    cardHandImageViews[x].setVisible(true);
                                                    cardHandImageViews[x].relocate(handButtons[x].getLayoutX() - 13, handButtons[x].getLayoutY() - 25);
                                                    //h =
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    /*for (Card b: player1.getMainDeck().getCards()) {
                                        if (b.equals())
                                    }
                                    cardHandImageViews[x].relocate(cell[q][w].getLayoutX() - 23, cell[q][w].getLayoutY() - 65);*/
                                    for (int j = 0; j < 9; j++){
                                        for (int k = 0; k < 5; k++){
                                            //if (abs(currentMap.getCardsInMap().get(i).getCell().getX() - j) + abs(currentMap.getCardsInMap().get(i).getCell().getY() - k) <= 1) {
                                            rectangle[j][k].setOpacity(0.05);
                                        }
                                    }


                                }
                            });
                        }
                    }
                }
            });
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                final int x = i, y = j;
                cell[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        if (rectangle[x][y].getOpacity() != 0.5) {
                            Glow glow = new Glow();
                            glow.setLevel(1000);
                            rectangle[x][y].setEffect(glow);
                            rectangle[x][y].setOpacity(0.3);
                        }

                    }
                });


                cell[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        if (rectangle[x][y].getOpacity() != 0.5) {
                            rectangle[x][y].setEffect(null);
                            rectangle[x][y].setOpacity(0.05);
                        }

                    }
                });
            }
        }
    }


    public void setHand() {



        for (int i = 0 ; i < 5; i++) {

            handButtons[i] = new Button();
            handButtons[i].setPrefSize(handSize, handSize);
            handButtons[i].relocate(handX+ i * (handSize + 10), handY);
            handButtons[i].setOpacity(0);

            handImageViews[i] = new ImageView(handImage);
            handImageViews[i].setFitWidth(handSize);
            handImageViews[i].setFitHeight(handSize);
            handImageViews[i].relocate(handX+ i * (handSize + 10), handY );
        }

        battleRoot.getChildren().addAll(handImageViews);
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Scene getBattleScene() {
        return BattleScene;
    }

    public void setCards() {

        for (int i = 0; i < player1.getMainDeck().getCards().size(); i++){
            cardsImageView[i] = new ImageView(cardsImage[i]);
            cardsImageView[i].setFitWidth(150);
            cardsImageView[i].setFitHeight(150);
            cardsImageView[i].setVisible(false);
            battleRoot.getChildren().add(cardsImageView[i]);
        }

        cardsImageView[0].relocate(rectangle[0][2].getX() - 40, rectangle[0][2].getY() - 65);
        System.out.println(player1.getMainDeck().getCards().get(0).getName());
        currentMap.addToCardsInMap(player1.getMainDeck().getCards().get(0));
        Cell cell = new Cell();
        cell.setX(0);
        cell.setY(2);
        player1.getMainDeck().getCards().get(0).setCell(cell);
        //battleRoot.getChildren().addAll(cardsImageView);
        cardsImageView[0].setVisible(true);
        //battleRoot.getChildren().addAll(cardsImageView);
        /*ImageView im = new ImageView(cardsImage[0]);
        im.setFitWidth(150);
        im.setFitHeight(150);
        im.relocate(rectangle[0][2].getX() - 40, rectangle[0][2].getY() - 65);
        battleRoot.getChildren().add(im);*/
    }

    public void changeHand() {
        for (int i = 1; i < 6; i++) {
            cardHandImageViews[i - 1] = new ImageView();
            cardHandImageViews[i - 1] = cardsImageView[i];


            cardsImageView[i].setFitWidth(100);
            cardsImageView[i].setFitHeight(100);
            cardsImageView[i].setVisible(true);
            cardsImageView[i].relocate(handX+ i * (handSize + 10) - 113, handY - 25);
        }
        battleRoot.getChildren().addAll(handButtons);
    }

    /*public boolean checkOnValidInsert(int x) {
        for (int i = 0; i < player1.getMainDeck().getCards().size()) {
            if (cardsImageView[i].equals(cardHandImageViews[x])) {

            }
        }
        return false;
    }*/
}

