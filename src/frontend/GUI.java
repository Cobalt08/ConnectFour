package frontend;

import backend.iController;

import backend.Grid;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
//import java.util.ArrayList;

public class GUI extends Application {

	private iController backend;
	private int currentPlayer;
	private Stage stage;
	private int turnCounter;
	private Button quit;
	private Button retry;
	private Label label;
	private Scene scene;
	private Circle[][] grid;

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		this.backend = new Grid();
		this.currentPlayer = 1;
		this.turnCounter = 0;
		this.grid = new Circle[7][6];

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(20.0);
		gridPane.setVgap(20.0);

		Polygon[] triangles = new Polygon[7];
		for (int a = 0; a < triangles.length; a++) {
			triangles[a] = new Polygon();
			triangles[a].getPoints().addAll(new Double[] { 20.0, 0.0, 0.0, 0.0, 10.0, 20.0 });
		}

		int buttonSize = 30;

		Button button1 = new Button();
		button1.setPrefHeight(buttonSize);
		button1.setPrefWidth(buttonSize);
		Button button2 = new Button();
		button2.setPrefHeight(buttonSize);
		button2.setPrefWidth(buttonSize);
		Button button3 = new Button();
		button3.setPrefHeight(buttonSize);
		button3.setPrefWidth(buttonSize);
		Button button4 = new Button();
		button4.setPrefHeight(buttonSize);
		button4.setPrefWidth(buttonSize);
		Button button5 = new Button();
		button5.setPrefHeight(buttonSize);
		button5.setPrefWidth(buttonSize);
		Button button6 = new Button();
		button6.setPrefHeight(buttonSize);
		button6.setPrefWidth(buttonSize);
		Button button7 = new Button();
		button7.setPrefHeight(buttonSize);
		button7.setPrefWidth(buttonSize);

		Button quit = new Button();
		this.quit = quit;
		quit.setText("Quit");
		quit.setPadding(new Insets(5, 10, 5, 10));

		Button retry = new Button();
		retry.setPadding(new Insets(5, 10, 5, 10));
		retry.setText("Try again");
		this.retry = retry;

		Label label = new Label();
		label.setPrefHeight(20);
		label.setPrefHeight(30);
		label.setPadding(new Insets(60, 60, 20, 60));
		this.label = label;

		button1.setOnAction(e -> {
			this.aTurn(0);
		});

		button2.setOnAction(e -> {
			this.aTurn(1);
		});

		button3.setOnAction(e -> {
			this.aTurn(2);
		});

		button4.setOnAction(e -> {
			this.aTurn(3);

		});
		button5.setOnAction(e -> {
			this.aTurn(4);
		});

		button6.setOnAction(e -> {
			this.aTurn(5);
		});

		button7.setOnAction(e -> {
			this.aTurn(6);
		});

		retry.setOnAction(e -> {
			for (int i = 0; i < this.grid.length; i++) {
				for (int o = 0; o < this.grid[i].length; o++) {
					this.grid[i][o].setFill(javafx.scene.paint.Color.WHITE);
				}
			}
			this.backend.clear();
			this.turnCounter = 0;
			this.stage.setScene(this.scene);

		});

		quit.setOnAction(e -> {
			this.stage.close();
		});

		button1.setStyle("-fx-background-radius: 5em; ");
		button2.setStyle("-fx-background-radius: 5em; ");
		button3.setStyle("-fx-background-radius: 5em; ");
		button4.setStyle("-fx-background-radius: 5em; ");
		button5.setStyle("-fx-background-radius: 5em; ");
		button6.setStyle("-fx-background-radius: 5em; ");
		button7.setStyle("-fx-background-radius: 5em; ");

		StackPane stack1 = new StackPane();
		StackPane stack2 = new StackPane();
		StackPane stack3 = new StackPane();
		StackPane stack4 = new StackPane();
		StackPane stack5 = new StackPane();
		StackPane stack6 = new StackPane();
		StackPane stack7 = new StackPane();

		stack1.getChildren().add(button1);
		stack2.getChildren().add(button2);
		stack3.getChildren().add(button3);
		stack4.getChildren().add(button4);
		stack5.getChildren().add(button5);
		stack6.getChildren().add(button6);
		stack7.getChildren().add(button7);

		gridPane.add(stack1, 0, 0);
		gridPane.add(stack2, 1, 0);
		gridPane.add(stack3, 2, 0);
		gridPane.add(stack4, 3, 0);
		gridPane.add(stack5, 4, 0);
		gridPane.add(stack6, 5, 0);
		gridPane.add(stack7, 6, 0);

		StackPane[] stacks = new StackPane[7];

		for (int u = 0; u < 7; u++) {
			stacks[u] = new StackPane();
			stacks[u].getChildren().add(triangles[u]);
			gridPane.add(stacks[u], u, 1);
		}

		for (int i = 0; i < this.grid.length; i++) {
			for (int o = 0; o < this.grid[i].length; o++) {
				this.grid[i][o] = new Circle(20.0);
				this.grid[i][o].setFill(javafx.scene.paint.Color.WHITE);
				gridPane.add(this.grid[i][o], i, o + 2);
			}
		}

		// Group g = new Group();
		// g.getChildren().add(polygon);

		// gridPane.setGridLinesVisible(true);
		Scene scene = new Scene(gridPane);
		this.scene = scene;
		stage.setTitle("Connect Four");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		// GUI gui = new GUI();
		Application.launch(args);
	}

	private void aTurn(int c) {
		int r = this.backend.turn(c, this.currentPlayer);
		if (r != -1) {
			if (this.currentPlayer == 1) {
				this.grid[c][r].setFill(javafx.scene.paint.Color.YELLOW);
			} else {
				this.grid[c][r].setFill(javafx.scene.paint.Color.RED);
			}
			this.turnCounter++;
			this.endGame();
		}
	}

	private void endGame() {
		if (this.turnCounter == 42) {
			this.draw();
		} else {
			int n = backend.hasWon();
			if (n != -1) {
				this.victory(n);
			} else {
				if (this.currentPlayer == 1) {
					this.currentPlayer = 2;
				} else {
					this.currentPlayer = 1;
				}
			}
		}
	}

	private void draw() {
		this.label.setText("Draw");
		this.label.setTranslateY(-30);
		this.quit.setTranslateY(-20);
		this.retry.setTranslateY(-30);
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10, 10, 10, 10));
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(label, retry, this.quit);
		Scene scene = new Scene(vBox);
		stage.setScene(scene);
	}

	private void victory(int n) {
		String winner;
		if (this.currentPlayer == 1) {
			winner = "Yellow";
		} else {
			winner = "Red";
		}
		this.label.setText("Player " + winner + " !");
		this.label.setTranslateY(155);
		this.quit.setTranslateY(190);
		// this.label.setStyle("-fx-font-size: 25");
		this.label.setFont(Font.font("Verdana", FontPosture.ITALIC, 25));
		VBox vBox = new VBox();
		vBox.setSpacing(5.0);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(label, this.quit);
		Image image = new Image("file:./img/Victory2.png");
		ImageView imgView = new ImageView(image);
		StackPane stack = new StackPane();
		stack.getChildren().addAll(imgView, vBox);
		stack.setPadding(new Insets(10, 10, 10, 10));
		Scene scene = new Scene(stack);
		stage.setScene(scene);
	}

}
