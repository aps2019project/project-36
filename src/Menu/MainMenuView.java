package Menu;

import Consts.Consts;
import Player.Account;
import Player.Player;
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
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


public class MainMenuView {

    private Group mainMenuRoot;
    private Scene mainMenuScene;
    private GaussianBlur blur = new GaussianBlur();

    private Image buttonImage = new Image("pics/button_secondary@2x.png");
    private Image buttonImage1 = new Image("pics/button_secondary_glow.png");
    private Image logoImage = new Image("pics/Duelyst_Logo.png");
    private Image menuBackgroundImage = new Image("pics/background.jpg");


    private Button createAccountButton = new Button("Create New Account");
    private Button loginButton = new Button("login");
    private Button showLeaderBoardButton = new Button("show leaderboard");
    private Button saveButton = new Button("save");
    private Button logoutButton = new Button("logout");
    private Button helpButton = new Button("help");

    private Label createAccountLabel = new Label("Create New Account");
    private Label loginLabel = new Label("login");
    private Label showLeaderBoardLabel = new Label("show leaderboard");
    private Label saveLabel = new Label("save");
    private Label logoutLabel = new Label("logout");
    private Label helpLabel = new Label("help");


    private final int buttonSizeWidth = 250;
    private final int buttonSizeHeight = 80;

    private ImageView createAccountButtonImageView = new ImageView(buttonImage);
    private ImageView createAccountButtonImageView1 = new ImageView(buttonImage1);
    private ImageView loginButtonImageView = new ImageView(buttonImage);
    private ImageView loginButtonImageView1 = new ImageView(buttonImage1);
    private ImageView showLeaderBoardButtonImageView = new ImageView(buttonImage);
    private ImageView showLeaderBoardButtonImageView1 = new ImageView(buttonImage1);
    private ImageView saveButtonImageView = new ImageView(buttonImage);
    private ImageView saveButtonImageView1 = new ImageView(buttonImage1);
    private ImageView logoutButtonImageView = new ImageView(buttonImage);
    private ImageView logoutButtonImageView1 = new ImageView(buttonImage1);
    private ImageView helpButtonImageView = new ImageView(buttonImage);
    private ImageView helpButtonImageView1 = new ImageView(buttonImage1);


    private ImageView logoImageView = new ImageView(logoImage);
    private ImageView backgroundImageView = new ImageView(menuBackgroundImage);

    private Media mouseClicked = new Media(getClass().getResource("/audio/Button-SoundBible.com-1420500901.mp3").toExternalForm());
    private Media mouseEntered = new Media(getClass().getResource("/audio/zapsplat_multimedia_click_003_19369.mp3").toExternalForm());
    MediaPlayer clickedPlayer = new MediaPlayer(mouseClicked);
    MediaPlayer enteredPlayer = new MediaPlayer(mouseEntered);

    public MainMenuView(String input) {

        enteredPlayer.setVolume(0.1);
        mainMenuRoot = new Group();
        backgroundImageView.setFitHeight(Consts.height);
        backgroundImageView.setFitWidth(Consts.width);
        mainMenuScene = new Scene(mainMenuRoot, Consts.width, Consts.height);
        logoImageView.setX(Consts.width - 400);
        logoImageView.setY(50);
        logoImageView.setFitHeight(150);
        logoImageView.setFitWidth(350);
        mainMenuRoot.getChildren().add(backgroundImageView);
        mainMenuRoot.getChildren().add(logoImageView);


        //create new account
        setImageView(createAccountButtonImageView, 0);
        setImageView(createAccountButtonImageView1, 0);
        createAccountButtonImageView1.setOpacity(0);
        setButton(createAccountButton, 0);
        setLabel(createAccountLabel, 0);
        mainMenuRoot.getChildren().add(createAccountButtonImageView);
        mainMenuRoot.getChildren().add(createAccountButtonImageView1);
        mainMenuRoot.getChildren().add(createAccountLabel);
        mainMenuRoot.getChildren().add(createAccountButton);

        //login button
        setImageView(loginButtonImageView, 1);
        setImageView(loginButtonImageView1, 1);
        loginButtonImageView1.setOpacity(0);
        setButton(loginButton, 1);
        setLabel(loginLabel, 1);
        mainMenuRoot.getChildren().add(loginButtonImageView);
        mainMenuRoot.getChildren().add(loginButtonImageView1);
        mainMenuRoot.getChildren().add(loginLabel);
        mainMenuRoot.getChildren().add(loginButton);


        //show LeaderBoard Button
        setImageView(showLeaderBoardButtonImageView, 2);
        setImageView(showLeaderBoardButtonImageView1, 2);
        showLeaderBoardButtonImageView1.setOpacity(0);
        setButton(showLeaderBoardButton, 2);
        setLabel(showLeaderBoardLabel, 2);
        mainMenuRoot.getChildren().add(showLeaderBoardButtonImageView);
        mainMenuRoot.getChildren().add(showLeaderBoardButtonImageView1);
        mainMenuRoot.getChildren().add(showLeaderBoardLabel);
        mainMenuRoot.getChildren().add(showLeaderBoardButton);

        //save Button
        setImageView(saveButtonImageView, 3);
        setImageView(saveButtonImageView1, 3);
        saveButtonImageView1.setOpacity(0);
        setButton(saveButton, 3);
        saveButton.setOpacity(0);
        setLabel(saveLabel, 3);
        mainMenuRoot.getChildren().add(saveButtonImageView);
        mainMenuRoot.getChildren().add(saveButtonImageView1);
        mainMenuRoot.getChildren().add(saveLabel);
        mainMenuRoot.getChildren().add(saveButton);

        //logout
        setImageView(logoutButtonImageView, 4);
        setImageView(logoutButtonImageView1, 4);
        logoutButtonImageView1.setOpacity(0);
        setButton(logoutButton, 4);
        setLabel(logoutLabel, 4);
        mainMenuRoot.getChildren().add(logoutButtonImageView);
        mainMenuRoot.getChildren().add(logoutButtonImageView1);
        mainMenuRoot.getChildren().add(logoutLabel);
        mainMenuRoot.getChildren().add(logoutButton);

        //help button
        setImageView(helpButtonImageView, 5);
        setImageView(helpButtonImageView1, 5);
        helpButtonImageView1.setOpacity(0);
        setButton(helpButton, 5);
        setLabel(helpLabel, 5);
        mainMenuRoot.getChildren().add(helpButtonImageView);
        mainMenuRoot.getChildren().add(helpButtonImageView1);
        mainMenuRoot.getChildren().add(helpLabel);
        mainMenuRoot.getChildren().add(helpButton);

        checkMovements(input);

    }

    public Scene getMainMenuScene() {
        return mainMenuScene;
    }

    public void checkMovements(String input) {

        createAccountButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (createAccountButtonImageView.getOpacity() == 100)
                    createAccountButtonImageView.setOpacity(0);
                if (createAccountButtonImageView1.getOpacity() == 0)
                    createAccountButtonImageView1.setOpacity(100);
            }
        });


        createAccountButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (createAccountButtonImageView1.getOpacity() == 100)
                    createAccountButtonImageView1.setOpacity(0);
                if (createAccountButtonImageView.getOpacity() == 0)
                    createAccountButtonImageView.setOpacity(100);
            }
        });


        loginButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (loginButtonImageView.getOpacity() == 100)
                    loginButtonImageView.setOpacity(0);
                if (loginButtonImageView1.getOpacity() == 0)
                    loginButtonImageView1.setOpacity(100);
            }
        });


        loginButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (loginButtonImageView1.getOpacity() == 100)
                    loginButtonImageView1.setOpacity(0);
                if (loginButtonImageView.getOpacity() == 0)
                    loginButtonImageView.setOpacity(100);
            }
        });

        showLeaderBoardButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (showLeaderBoardButtonImageView.getOpacity() == 100)
                    showLeaderBoardButtonImageView.setOpacity(0);
                if (showLeaderBoardButtonImageView1.getOpacity() == 0)
                    showLeaderBoardButtonImageView1.setOpacity(100);
            }
        });


        showLeaderBoardButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (showLeaderBoardButtonImageView1.getOpacity() == 100)
                    showLeaderBoardButtonImageView1.setOpacity(0);
                if (showLeaderBoardButtonImageView.getOpacity() == 0)
                    showLeaderBoardButtonImageView.setOpacity(100);
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

        logoutButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                enteredPlayer.play();
                enteredPlayer.seek(Duration.ZERO);
                if (logoutButtonImageView.getOpacity() == 100)
                    logoutButtonImageView.setOpacity(0);
                if (logoutButtonImageView1.getOpacity() == 0)
                    logoutButtonImageView1.setOpacity(100);
            }
        });


        logoutButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (logoutButtonImageView1.getOpacity() == 100)
                    logoutButtonImageView1.setOpacity(0);
                if (logoutButtonImageView.getOpacity() == 0)
                    logoutButtonImageView.setOpacity(100);
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


        createAccountButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play();
                clickedPlayer.seek(Duration.ZERO);
                createAccountOrLoginClicked("create account");
            }
        });

        loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play();
                clickedPlayer.seek(Duration.ZERO);
                createAccountOrLoginClicked("login");
            }
        });

        showLeaderBoardButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play();
                clickedPlayer.seek(Duration.ZERO);
                showLeaderBoardClicked();
            }
        });

        saveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play();
                clickedPlayer.seek(Duration.ZERO);
                //todo
            }
        });

        logoutButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play();
                clickedPlayer.seek(Duration.ZERO);
                Menu.loggedInPlayer = null;
                Text text = new Text("logged out");
                mainMenuRoot.getChildren().add(text);
                //todo

            }
        });

        helpButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickedPlayer.play();
                clickedPlayer.seek(Duration.ZERO);
            }
        });


    }

    public void setImageView(ImageView buttonImageView, int n) {

        buttonImageView.setFitWidth(buttonSizeWidth);
        buttonImageView.setFitHeight(buttonSizeHeight);
        if (n <= 2) {
            buttonImageView.setX(Consts.width / 10 - 20);
            buttonImageView.setY(Consts.height / 2.7 + n * Consts.distance);
        } else {
            buttonImageView.setX(Consts.width / 3 - 20);
            buttonImageView.setY(Consts.height / 3 + (n - 2) * Consts.distance);
        }

    }

    public void setButton(Button button, int n) {
        button.setOpacity(0);
        if (n <= 2) {
            button.relocate(Consts.width / 10 - 20, Consts.height / 2.7 + n * Consts.distance);
        } else {
            button.relocate(Consts.width / 3 - 20, Consts.height / 3 + (n - 2) * Consts.distance);
        }
        button.setPrefSize(buttonSizeWidth, buttonSizeHeight);
    }

    public void setLabel(Label label, int n) {
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        if (n <= 2) {
            if (n == 1) {
                label.relocate(Consts.width / 10 + 80, Consts.height / 2.7 + n * Consts.distance + 27);
            } else if (n == 0) {
                label.relocate(Consts.width / 10 + 13, Consts.height / 2.7 + n * Consts.distance + 27);
            } else {
                label.relocate(Consts.width / 10 + 20, Consts.height / 2.7 + n * Consts.distance + 27);
            }
        } else {
            label.relocate(Consts.width / 3 + 80, Consts.height / 3 + (n - 2) * Consts.distance + 27);
        }
    }

    public void createAccountOrLoginClicked(String s) {
        mainMenuRoot.getChildren().clear();
        mainMenuRoot.getChildren().add(backgroundImageView);
        backgroundImageView.setEffect(blur);
        Label usernameLabel = new Label("Username:");
        usernameLabel.relocate(430, 200);
        TextField username = new TextField();
        username.relocate(550, 200);
        usernameLabel.setFont(Font.font(20));
        usernameLabel.setLabelFor(username);
        usernameLabel.setTextFill(Color.BLACK);
        mainMenuRoot.getChildren().addAll(username, usernameLabel);
        username.setPrefSize(200, 50);
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            String str;

            public void handle(ActionEvent e) {
                if (s.equals("login")) {
                    str = "login ";
                } else
                    str = "create account ";
                str += username.getText();
                str += " ";
                if (s.equals("login")) {
                    if (Menu.loggedInPlayer != null) {
                        Text taken = new Text("Another account is logged in! Please first logout!");
                        taken.setFont(Font.font(40));
                        taken.relocate(Consts.width / 5, 100);
                        mainMenuRoot.getChildren().add(taken);
                        return;
                    } else if (!Player.takenUsernames(username.getText())) {
                        Text taken = new Text("This username does not exist!");
                        taken.setFont(Font.font(40));
                        taken.relocate(Consts.width / 5, 100);
                        mainMenuRoot.getChildren().add(taken);
                        return;
                    }
                } else {
                    if (Player.takenUsernames(username.getText())) {
                        Text taken = new Text("username is taken");
                        taken.setFont(Font.font(40));
                        taken.relocate(Consts.width / 5, 100);
                        mainMenuRoot.getChildren().add(taken);
                        return;
                    }
                }
                TextField pass = new TextField();
                Label passwordLabel = new Label("Password:");
                passwordLabel.relocate(440, 300);
                passwordLabel.setTextFill(Color.BLACK);
                pass.relocate(550, 300);
                mainMenuRoot.getChildren().addAll(pass, passwordLabel);
                pass.setPrefSize(200, 50);
                passwordLabel.setFont(Font.font(20));
                passwordLabel.setLabelFor(pass);
                EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        str += pass.getText();
                        pass.setVisible(false);
                        username.setVisible(false);
                        mainMenuRoot.getChildren().removeAll(username, usernameLabel, pass, passwordLabel);
                        Button exit = new Button("");
                        try {
                            Image image = new Image(new FileInputStream("/Users/rostaroghani/Desktop/project-3/src/pics/button_close.png"));
                            ImageView exitButtonImageView = new ImageView(image);
                            exitButtonImageView.setFitWidth(50);
                            exitButtonImageView.setFitHeight(50);
                            exitButtonImageView.setX(10);
                            exitButtonImageView.setY(10);
                            mainMenuRoot.getChildren().add(exitButtonImageView);
                            exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {

                                    enteredPlayer.play();
                                    enteredPlayer.seek(Duration.ZERO);
                                    if (exitButtonImageView.getOpacity() == 100)
                                        exitButtonImageView.setOpacity(0);
                                }
                            });
                            exit.setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    if (exitButtonImageView.getOpacity() == 0)
                                        exitButtonImageView.setOpacity(100);
                                }
                            });
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
                            mainMenuRoot.getChildren().add(exitButtonImageView1);
                            exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {

                                    enteredPlayer.play();
                                    enteredPlayer.seek(Duration.ZERO);
                                    if (exitButtonImageView1.getOpacity() == 0)
                                        exitButtonImageView1.setOpacity(100);
                                }
                            });
                            exit.setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {

                                    if (exitButtonImageView1.getOpacity() == 100)
                                        exitButtonImageView1.setOpacity(0);
                                }
                            });
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }


                        exit.setPrefSize(40, 40);
                        exit.relocate(20, 20);
                        exit.setOpacity(0);
                        mainMenuRoot.getChildren().add(exit);
                        Text text = new Text("Your account was created successfully!");
                        if (s.equals("login")) {
                            text.setText("you're logged in");
                        }
                        text.setFont(Font.font(33));
                        text.relocate(Consts.width / 5, 270);

                        mainMenuRoot.getChildren().add(text);
                        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Menu.firstMenuCommand(str);
                            }
                        });
                    }
                };
                pass.setOnAction(event2);
            }
        };
        username.setOnAction(event1);
    }

    public void showLeaderBoardClicked() {
        mainMenuRoot.getChildren().clear();
        mainMenuRoot.getChildren().add(backgroundImageView);
        backgroundImageView.setEffect(blur);
        ArrayList<Pair> ans = new ArrayList<Pair>();
        for (int i = 0; i < Account.getAccounts().size(); i++) {
            Account account;
            account = Account.getAccounts().get(i);
            int cnt = 0;
            for (int j = 0; j < account.getMatchHistory().size(); j++) {
                if (account.getMatchHistory().get(j).getWinner().getUsername().equals(account.getUsername())) {
                    cnt++;
                }
            }
            Pair pair = new Pair();
            pair.wins = cnt;
            pair.username = account.getUsername();
            ans.add(pair);
        }
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.size(); j++) {
                if (ans.get(i).wins > ans.get(j).wins) {
                    Collections.swap(ans, i, j);
                }
            }
        }
        int changeY = 50;
        for (int i = 0; i < ans.size(); i++) {
            Text text = new Text(i + 1 + "- UserName : " + ans.get(i).username + "- Wins : " + ans.get(i).wins);
            text.relocate(100, changeY);
            changeY += 50;
            mainMenuRoot.getChildren().add(text);
            System.out.println(i + 1 + "- UserName : " + ans.get(i).username + "- Wins : " + ans.get(i).wins);
        }
    }
}

class Pair {
    int wins;
    String username;
}