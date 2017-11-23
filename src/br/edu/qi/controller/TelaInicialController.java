package br.edu.qi.controller;

import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * Controlador de TelaIncial.fxml.
 *
 * @author Marcelo Zilio Correa
 * @since 10/11/2017 - 19:42
 */
public class TelaInicialController implements Initializable {

    private Stage stage;

    @FXML
    public void openWindowClientes(ActionEvent event) {
        try {
            ClientesController controller = (ClientesController) new ViewUtils()
                    .openWindow("/br/edu/qi/view/Clientes.fxml", this.stage, "Clientes");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
    }

    @FXML
    public void openWidowProprietarios(ActionEvent event) {
        try {
            ProprietariosController controller = (ProprietariosController) new ViewUtils()
                    .openWindow("/br/edu/qi/view/Proprietarios.fxml", this.stage, "Proprietários");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
    }

    @FXML
    public void openWindowInserirCarro(ActionEvent event) {
        try {
            InserirCarroController controller = (InserirCarroController) new ViewUtils()
                    .openWindow("/br/edu/qi/view/InserirAutomovel.fxml", this.stage, "Inserir Automovel");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
    }

    @FXML
    public void openWindowVendas() {
        try {
            VendasController controller = (VendasController) new ViewUtils().openWindow("/br/edu/qi/view/Vendas.fxml", this.stage, "Vendas Realizadas");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
    }

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
