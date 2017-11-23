
package br.edu.qi.controller;

import br.edu.qi.enums.MarcasEnum;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Controlador de InserirCarro.fxml.
 *
 * @author Marcelo Zilio Correa
 * @since 16/11/2017 - 20:38
 */
public class InserirCarroController implements Initializable {

    private Stage stage;
    
    @FXML
    private ComboBox cbxMarcas;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxMarcas.setItems(FXCollections.observableArrayList(Arrays.stream(MarcasEnum.values()).collect(Collectors.toList())));
        cbxMarcas.getSelectionModel().select(0);
    }
    
    @FXML
    private void save() {
        
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
