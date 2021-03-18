package application;
	
import model.Game;
import javafx.application.Application;
import javafx.stage.Stage;
import view.PlayerView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Game game = new Game();
		PlayerView pv3 = new PlayerView(3, game);
		PlayerView pv2 = new PlayerView(2, game);
		PlayerView pv1 = new PlayerView(1, game);

		game.register(pv1);
		game.register(pv2);
		game.register(pv3);
		pv1.isAanBeurt(true);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
