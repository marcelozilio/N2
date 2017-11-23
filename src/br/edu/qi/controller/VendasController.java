package br.edu.qi.controller;

import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * Controlador de Vendas.fxml
 *
 * @author Marcelo Zilio Correa
 * @since 23/11/2017 - 14:02
 */
public class VendasController implements Initializable {

    private Stage stage;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
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

    @FXML
    public void openWindowVender(ActionEvent event) {
        try {
            VenderController controller = (VenderController) new ViewUtils().openWindow("/br/edu/qi/view/Vender.fxml", this.stage, "Vender");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
    }

}
