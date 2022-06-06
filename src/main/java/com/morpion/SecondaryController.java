package com.morpion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SecondaryController implements Initializable {
	private Set set;
	@FXML
	private Canvas disp;
	private GraphicsContext gc;

	/**
	 * @param set the set to set
	 */
	public void setSet(Set set) {
		this.set = set;
	}

	@FXML
	private void drawCanvas(ActionEvent event) {
		gc.setFill(Color.BLACK);
		gc.fillRect(140 + 105, 0, 2, 320);
		gc.fillRect(140 + 210, 0, 2, 320);
		gc.fillRect(140 + 0, 105, 320, 2);
		gc.fillRect(140 + 0, 210, 320, 2);

		Set.Symbole[][] matrix = set.getMatrix();



		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				switch (matrix[i][j]) {
					case CROSS:
						gc.strokeLine(140 + (i * 105) + 15, j*105 + 15, 140 + (i * 105) + 75, j*105 + 75);
						gc.strokeLine(140 + (i * 105) + 75, j*105 + 75, 140 + (i * 105) + 15, j*105 + 15);
						break;
					case CIRCLE:
						gc.strokeOval(140 + (i*105) + 15, j*105 + 15, 75, 75);
						break;

					default:
						break;
				}
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = disp.getGraphicsContext2D();
	}
}