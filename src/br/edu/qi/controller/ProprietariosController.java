package br.edu.qi.controller;

import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * Controlador de Proprietarios.fxml
 *
 * @author Marcelo Zilio Correa
 * @since 16/11/2017 - 20:24
 */
public class ProprietariosController implements Initializable {

    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void openWindowInserirProprietario(ActionEvent event) {
        try {
            InserirProprietarioController controller =  (InserirProprietarioController) new ViewUtils()
                    .openWindow("/br/edu/qi/view/InserirProprietario.fxml", this.stage, "Inserir Proprietário");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
