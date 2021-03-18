package view;

import model.Game;
import model.Observer;
import model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerView implements Observer {
    private Stage stage = new Stage();
    private Scene playerScene;
    private Label totalScore;
    private Button playButton;
    private Label messageLabel;

    private int spelerNummer;
    private Game game;
    private Player player;
    private String text = "";

    public PlayerView(int spelerNummer, Game game) {
        this.spelerNummer = spelerNummer;
        player = new Player(spelerNummer);
        game.addPlayer(player);
        this.game = game;
        totalScore = new Label("Total score:");
        playButton = new Button("Werp dobbelstenen");
        playButton.setOnAction(new ThrowDicesHandler());
        playButton.setDisable(true);
        messageLabel = new Label("Spel nog niet gestart");
        layoutComponents();
        stage.setScene(playerScene);
        stage.setTitle("Speler " + spelerNummer);
        stage.setResizable(false);
        stage.setX(100 + (spelerNummer - 1) * 350);
        stage.setY(200);
        stage.show();
    }

    private void layoutComponents() {
        VBox root = new VBox(10);
        playerScene = new Scene(root, 250, 100);
        root.getChildren().add(playButton);
        root.getChildren().add(totalScore);
        root.getChildren().add(messageLabel);
    }

    public void isAanBeurt(boolean aanBeurt) {
        playButton.setDisable(!aanBeurt);
    }

    class ThrowDicesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            game.throwDice();
            isAanBeurt(false);
        }
    }

    // Getter
    public int getSpelerNummer() {
        return spelerNummer;
    }


    // Observer Methode
    @Override
    public void update(String text) {
        this.text = text;
        messageLabel.setText(text);
        totalScore.setText("Total score: " + player.getPlayerScore());
        if(game.currentPlayer().getPlayerNr() == spelerNummer && game.currentPlayer().getTurn() < 4){
        	isAanBeurt(true);
		}
    }
}
