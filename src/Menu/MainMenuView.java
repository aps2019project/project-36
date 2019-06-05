package Menu;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import Consts.Consts;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.*;

public class MainMenuView {
        Group mainMenuRoot = new Group();
        private Scene mainMenuScene = new Scene(mainMenuRoot, Consts.height, Consts.width);
        private Button createAccountButton = new Button("Create New Account");
//        public MainMenuView() {
//            mainMenuRoot.getChildren().add(createAccountButton);
//            mainMenuScene.setFill(Color.rgb(255, 242, 253));
//        ‌    createAccountButton.relocate(Consts.height / 4, Consts.width / 4);
//            createAccountButton.setShape();
//        }

        public Scene getMainMenuScene() {
            return mainMenuScene;
        }

}
