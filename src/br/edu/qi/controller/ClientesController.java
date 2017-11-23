package br.edu.qi.controller;

import br.edu.qi.bo.ClienteBo;
import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Controlador de Clientes.fxml
 *
 * @author Marcelo Zilio Correa
 * @since 16/11/2017 - 20:08
 */
public class ClientesController implements Initializable {

    private Stage stage;

    @FXML
    private TableView tableClientes;
    
    @FXML
    private TableColumn tcNome, tcEndereco, tcCidade, tcEstado, tcTelefone, tcEmail;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherTabela();
    }

    @FXML
    private void openWindowInseirClientes() {
        try {
            InserirClienteController controller = (InserirClienteController) new ViewUtils()
                    .openWindow("/br/edu/qi/view/InserirCliente.fxml", this.stage, "Inserir Clientes");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }        
    }
    
    private void preencherTabela() {
        try {
            tableClientes.setItems(FXCollections.observableArrayList(new ClienteBo().findAll()));
            
            tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            tcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
            tcCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
            tcEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
            tcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
            tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            
        } catch (Exception ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
