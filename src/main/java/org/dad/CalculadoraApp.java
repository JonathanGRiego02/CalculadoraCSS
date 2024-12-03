package org.dad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraApp extends Application {
  private final CalculadoraController controller = new CalculadoraController();

  @Override
  public void start(Stage primaryStage) throws Exception{
    Scene scene = new Scene(controller.getRoot());

    primaryStage.setTitle("Calculadora");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
