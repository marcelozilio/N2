package br.edu.qi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * Controlador de InserirCarro.fxml
 *
 * @author Marcelo Zilio Correa
 * @since 16/11/2017 - 20:38
 */
public class InserirCarroController implements Initializable {

    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
