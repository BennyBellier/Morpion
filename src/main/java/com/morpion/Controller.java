package com.morpion;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Controller implements Initializable {
  public Set set;
  @FXML private Canvas disp;

  private GraphicsContext gc;

  @FXML private void drawCanvas(ActionEvent event) {
    gc.setFill(Color.AQUA);
    gc.fillRect(10, 10, 100, 100);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    gc = disp.getGraphicsContext2D();
    gc.setFill(Color.BLACK);
    System.out.println("Color set to Black");
    gc.fillRect(10, 10, 100, 100);
    System.out.println("draw rectangle");
  }
}
