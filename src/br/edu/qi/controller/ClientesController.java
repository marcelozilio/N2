package br.edu.qi.controller;

import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * Controlador de Clientes.fxml
 *
 * @author Marcelo Zilio Correa
 * @since 16/11/2017 - 20:08
 */
public class ClientesController implements Initializable {

    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void openWindowInseirClientes() {
        try {
            InserirClienteController controller = (InserirClienteController) new ViewUtils()
                    .openWindow("/br/edu/qi/view/InserirCliente.fxml", this.stage, "Inserir Clientes");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro ao tentar abrir tela" + e.getMessage());
        }        
    }
    
    

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
