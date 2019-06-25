package Battle;

import javafx.event.EventHandler;
import javafx.scene.Group;
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

public class BattleView {

    Game currentGame;

    private Group battleRoot = new Group();
    private Group TableRoot=new Group();

    private Scene BattleScene = new Scene(battleRoot, Consts.width, Consts.height);

    private Image battleBoardImage = new Image("pics/battlemap2_middleground@2x.jpeg");
    private ImageView battleBoardImageView;


    // cards :

    //private Image hero1Image = new Image(currentGame.getPlayer1().getMainDeck().getHero().getAddress());
    //private Image hero2Image = new Image(currentGame.getPlayer2().getMainDeck().getHero().getAddress());
    private Image[] cardsImage = new Image[20];

    // buttons :

    private int endTurnSizeX = 200;
    private int endTurnSizeY = 100;

    private Image endTurnImage = new Image("pics/button_end_turn_mine.png");
    private Image endTurnImage1 = new Image("pics/button_end_turn_mine_glow.png");

    private ImageView endTurnImageView1 = new ImageView(endTurnImage1);
    private ImageView endTurnImageView = new ImageView(endTurnImage);

    private Button endTurnButton = new Button();

    private Label endTurnLabel= new Label("END TURN");

    // cells :

    private int cellSize = 70;

    private Button[][] cell = new Button[9][5];
    private Rectangle rectangle[][] = new Rectangle[9][5];

    public BattleView() {

        battleBoardImageView = new ImageView(battleBoardImage);
        battleBoardImageView.setFitHeight(Consts.height);
        battleBoardImageView.setFitWidth(Consts.width);
        battleRoot.getChildren().addAll(battleBoardImageView);
        drawRects();
        drawButtons();

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
                rectangle[i][j].setFill(javafx.scene.paint.Color.rgb(35, 250, 10));
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

