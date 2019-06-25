package Battle;

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

public class BattleView {

    Game currentGame;

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

    private Image[] cardsImage = new Image[20];

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
    // cells :

    private int cellSize = 70;

    private Button[][] cell = new Button[9][5];
    private Rectangle rectangle[][] = new Rectangle[9][5];

    public BattleView() {

        try {
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
        drawRects();
        drawButtons();

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

        DeckImageView.setFitWidth(100);
        DeckImageView.setFitHeight(100);
        DeckImageView.relocate(100, 600);
        DeckButton.setPrefSize(100, 100);
        DeckButton.relocate(950, 500);
        DeckButton.setOpacity(0);
        DeckLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        DeckLabel.setTextFill(Color.WHITE);
        DeckLabel.relocate(100, 600);
        battleRoot.getChildren().add(DeckImageView);
        battleRoot.getChildren().add(DeckLabel);
        battleRoot.getChildren().add(DeckButton);

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
                rectangle[i][j].setOpacity(0.2);
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

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                final int x = i, y = j;
                cell[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        Glow glow = new Glow();
                        glow.setLevel(1000);
                        rectangle[x][y].setEffect(glow);
                        rectangle[x][y].setOpacity(0.3);

                    }
                });


                cell[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        rectangle[x][y].setEffect(null);
                        rectangle[x][y].setOpacity(0.2);

                    }
                });
            }
        }
    }

    public void perspective(){

        PerspectiveTransform perspectiveTransform = new PerspectiveTransform();
        perspectiveTransform.setUlx(250);    // Upper left
        perspectiveTransform.setUly(120);
        perspectiveTransform.setUrx(840);    // Upper right
        perspectiveTransform.setUry(130);
        perspectiveTransform.setLlx(270);      // Lower left
        perspectiveTransform.setLly(580);
        perspectiveTransform.setLrx(1030);    // Lower right
        perspectiveTransform.setLry(560);
        //battleRoot.setEffect(perspectiveTransform);
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public Scene getBattleScene() {
        return BattleScene;
    }
}

