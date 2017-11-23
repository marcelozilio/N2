package br.edu.qi.controller;

import br.edu.qi.bo.ProprietarioBo;
import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Controlador de Proprietarios.fxml
 *
 * @author Marcelo Zilio Correa
 * @since 16/11/2017 - 20:24
 */
public class ProprietariosController implements Initializable {

    private Stage stage;

    @FXML
    private TableView tableProprietarios;

    @FXML
    private TableColumn tcNome, tcEndereco, tcCidade, tcEstado, tcTelefone, tcEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherTabela();
    }

    @FXML
    public void openWindowInserirProprietario(ActionEvent event) {
        try {
            InserirProprietarioController controller = (InserirProprietarioController) new ViewUtils()
                    .openWindow("/br/edu/qi/view/InserirProprietario.fxml", this.stage, "Inserir Proprietário");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
        if (!event.isConsumed()) {
            preencherTabela();
        }
    }

    private void preencherTabela() {
        try {
            tableProprietarios.setItems(FXCollections.observableArrayList(new ProprietarioBo().findAll()));

            tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            tcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
            tcCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
            tcEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
            tcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
            tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        } catch (Exception ex) {
            Logger.getLogger(ProprietariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
