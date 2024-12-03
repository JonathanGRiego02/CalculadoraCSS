package org.dad;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {
  // Model
  Calculadora mi_calculadora = new Calculadora();

  StringProperty pantallaP = new SimpleStringProperty();

  // View

  @FXML
  private Button cButton;

  @FXML
  private Button ceButton;

  @FXML
  private Button divButton;

  @FXML
  private Button mulButton;

  @FXML
  private Button igualButton;

  @FXML
  private Button restaButton;

  @FXML
  private Button ceroButton;


  @FXML
  private Button unoButton;

  @FXML
  private Button dosButton;

  @FXML
  private Button tresButton;

  @FXML
  private Button cuatroButton;

  @FXML
  private Button cincoButton;

  @FXML
  private Button seisButton;

  @FXML
  private Button sieteButton;

  @FXML
  private Button ochoButton;

  @FXML
  private Button nueveButton;

  @FXML
  private TextField pantallaTextField;

  @FXML
  private Button puntoButton;

  @FXML
  private GridPane root;

  @FXML
  private Button sumButton;

  // Getters y Setters


  public Button getcButton() {
    return cButton;
  }

  public void setcButton(Button cButton) {
    this.cButton = cButton;
  }

  public Button getCeButton() {
    return ceButton;
  }

  public void setCeButton(Button ceButton) {
    this.ceButton = ceButton;
  }

  public Button getDivButton() {
    return divButton;
  }

  public void setDivButton(Button divButton) {
    this.divButton = divButton;
  }

  public Button getMulButton() {
    return mulButton;
  }

  public void setMulButton(Button mulButton) {
    this.mulButton = mulButton;
  }

  public Button getIgualButton() {
    return igualButton;
  }

  public void setIgualButton(Button igualButton) {
    this.igualButton = igualButton;
  }

  public Button getRestaButton() {
    return restaButton;
  }

  public void setRestaButton(Button restaButton) {
    this.restaButton = restaButton;
  }

  public Button getCeroButton() {
    return ceroButton;
  }

  public void setCeroButton(Button ceroButton) {
    this.ceroButton = ceroButton;
  }

  public Button getUnoButton() {
    return unoButton;
  }

  public void setUnoButton(Button unoButton) {
    this.unoButton = unoButton;
  }

  public Button getDosButton() {
    return dosButton;
  }

  public void setDosButton(Button dosButton) {
    this.dosButton = dosButton;
  }

  public Button getTresButton() {
    return tresButton;
  }

  public void setTresButton(Button tresButton) {
    this.tresButton = tresButton;
  }

  public Button getCuatroButton() {
    return cuatroButton;
  }

  public void setCuatroButton(Button cuatroButton) {
    this.cuatroButton = cuatroButton;
  }

  public Button getCincoButton() {
    return cincoButton;
  }

  public void setCincoButton(Button cincoButton) {
    this.cincoButton = cincoButton;
  }

  public Button getSeisButton() {
    return seisButton;
  }

  public void setSeisButton(Button seisButton) {
    this.seisButton = seisButton;
  }

  public Button getSieteButton() {
    return sieteButton;
  }

  public void setSieteButton(Button sieteButton) {
    this.sieteButton = sieteButton;
  }

  public Button getOchoButton() {
    return ochoButton;
  }

  public void setOchoButton(Button ochoButton) {
    this.ochoButton = ochoButton;
  }

  public Button getNueveButton() {
    return nueveButton;
  }

  public void setNueveButton(Button nueveButton) {
    this.nueveButton = nueveButton;
  }

  public TextField getPantallaTextField() {
    return pantallaTextField;
  }

  public void setPantallaTextField(TextField pantallaTextField) {
    this.pantallaTextField = pantallaTextField;
  }

  public Button getPuntoButton() {
    return puntoButton;
  }

  public void setPuntoButton(Button puntoButton) {
    this.puntoButton = puntoButton;
  }

  public GridPane getRoot() {
    return root;
  }

  public void setRoot(GridPane root) {
    this.root = root;
  }

  public Button getSumButton() {
    return sumButton;
  }

  public void setSumButton(Button sumButton) {
    this.sumButton = sumButton;
  }

  @FXML
  void onBorrarAction(ActionEvent event) {
    mi_calculadora.borrar();
    pantallaP.set(mi_calculadora.getPantalla());
  }

  @FXML
  void onBorrarTodoAction(ActionEvent event) {
    mi_calculadora.borrarTodo();
    pantallaP.set(mi_calculadora.getPantalla());
  }

  @FXML
  void onComaAction(ActionEvent event) {
    mi_calculadora.insertarComa();
    pantallaP.set(mi_calculadora.getPantalla());
  }

  @FXML
  void onDigitAction(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();
    char digito = clickedButton.getText().charAt(0);
    mi_calculadora.insertar(digito);
    pantallaP.set(mi_calculadora.getPantalla());
  }

  @FXML
  void onOperarAction(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();
    char operador = clickedButton.getText().charAt(0);

    mi_calculadora.operar(operador);  
    pantallaP.set(mi_calculadora.getPantalla());
  }

  @FXML
  void onIgualAction(ActionEvent event) {
    mi_calculadora.operar(Calculadora.IGUAL);  // Realiza la operación acumulada
    pantallaP.set(mi_calculadora.getPantalla());
  }

  public CalculadoraController() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
      loader.setController(this);
      loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Binds
    pantallaTextField.textProperty().bind(pantallaP);

    // Iniciar el valor de pantallaP con el valor inicial de la calculadora
    pantallaP.set(mi_calculadora.getPantalla());

  }
}
