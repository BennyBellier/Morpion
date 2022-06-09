package com.morpion;

import javafx.event.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

import com.morpion.Set.Symbole;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SecondaryController implements Initializable {
	private Set set;
	@FXML
	private Canvas disp;
	private GraphicsContext gc;
	private int playerTurn;

	/**
	 * @param set the set to set
	 */
	public void setSet(Set set) {
		this.set = set;
	}

	Symbole getSymbole() {
		if (playerTurn == 0) {
			return Symbole.CIRCLE;
		} else {
			return Symbole.CROSS;
		}
	}

	void click(int x, int y) {
		x = (int) (x - 140) / 105;
		y = (int) y / 105;
		System.out.println("Click at (" + x + ", " + y + ")");
		if (set.add(x, y, getSymbole())) {
			playerTurn = (playerTurn + 1) % 2;
		}
		drawCanvas();
	}

	@FXML
	private void resetGame(ActionEvent actionEvent) {
		set = new Set();
	}

	private void drawCanvas() {
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		gc.setStroke(Color.BLACK);
		gc.strokeLine(245, 0, 245, 320);
		gc.strokeLine(350, 0, 350, 320);
		gc.strokeLine(140, 105, 460, 105);
		gc.strokeLine(140, 210, 460, 210);

		Set.Symbole[][] matrix = set.getMatrix();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != null) {
					switch (matrix[i][j]) {
						case CROSS:
							gc.setStroke(Color.BLUE);
							gc.strokeLine(140 + (i * 105) + 15, j*105 + 15, 140 + (i * 105) + 90, j*105 + 90);
							gc.strokeLine(140 + (i * 105) + 15, j*105 + 90, 140 + (i * 105) + 90, j*105 + 15);
							break;
						case CIRCLE:
							gc.setStroke(Color.RED);
							gc.strokeOval(140 + (i * 105) + 15, j*105 + 15, 75, 75);
							break;

						default:
							break;
					}
				}
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = disp.getGraphicsContext2D();
		EventHandler<MouseEvent> clickHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				click((int) e.getX(), (int) e.getY());
			}
		};
		disp.addEventFilter(MouseEvent.MOUSE_CLICKED, clickHandler);
		drawCanvas();
	}
}