package br.edu.qi.controller;

import br.edu.qi.bo.VendaBo;
import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Controlador de Vendas.fxml
 *
 * @author Marcelo Zilio Correa
 * @since 23/11/2017 - 14:02
 */
public class VendasController implements Initializable {

    private Stage stage;
    
    @FXML
    private TableView tableVendas;
    
    @FXML
    private TableColumn tcCliente, tcAutomovel, tcData, tcValor;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherTabela();
    }
    
    @FXML
    public void openWindowVender(ActionEvent event) {
        try {
            VenderController controller = (VenderController) new ViewUtils().openWindow("/br/edu/qi/view/Vender.fxml", this.stage, "Vender");
            controller.setStage(this.stage);
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
        if(!event.isConsumed()) {
            preencherTabela();
        }
    }
    
    private void preencherTabela() {
        try {
            tableVendas.setItems(FXCollections.observableArrayList(new VendaBo().findAll()));
            tcCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
            tcAutomovel.setCellValueFactory(new PropertyValueFactory<>("automovel"));
            tcData.setCellValueFactory(new PropertyValueFactory<>("dataVenda"));
            tcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        } catch (Exception e) {
            new ViewUtils().msg(e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }   
}
