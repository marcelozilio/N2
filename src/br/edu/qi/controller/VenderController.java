package br.edu.qi.controller;

import br.edu.qi.bo.AutomovelBo;
import br.edu.qi.bo.ClienteBo;
import br.edu.qi.bo.VendaBo;
import br.edu.qi.model.Automovel;
import br.edu.qi.model.Cliente;
import br.edu.qi.model.Venda;
import br.edu.qi.util.Validacoes;
import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador de Vender.fxml.
 *
 * @author Marcelo Zilio Correa
 * @since 23/11/2017 - 13:11
 */
public class VenderController implements Initializable {

    private Stage stage;
    private Venda venda;
    private VendaBo bo;

    @FXML
    private ComboBox cbxAutomoveis, cbxClientes;

    @FXML
    private TextField tfValor, tfQtdParcelas;

    @FXML
    private CheckBox cbAVista;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.venda = new Venda();
        this.bo = new VendaBo();
        setCombos();

        cbAVista.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            tfQtdParcelas.setDisable(newValue);
        });
    }

    @FXML
    public void save() {
        try {
            this.venda.setCliente((Cliente) cbxClientes.getSelectionModel()
                    .getSelectedItem());
            this.venda.setAutomovel((Automovel) cbxAutomoveis.getSelectionModel().
                    getSelectedItem());
            this.venda.setValor((Double.parseDouble(Validacoes
                    .validaNumero(tfValor.getText(), "Valor", tfValor))));
            this.venda.setDataVenda(new Date());
            if (!cbAVista.isSelected()) {
                this.venda.setQtdParcelas(Integer.parseInt(Validacoes.validaNumero(tfQtdParcelas.getText(), "Qtd. de Parcelas", tfQtdParcelas)));
                this.venda.setaVista(0);
            } else { 
                this.venda.setQtdParcelas(1);
                this.venda.setaVista(1);
            }
            this.bo.save(venda);
            clear();
            new ViewUtils().msg("Venda concluída com sucesso.", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            new ViewUtils().msg(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    /**
     * Preenche os ComboBox da tela.
     */
    private void setCombos() {
        try {
            cbxAutomoveis.setItems(FXCollections.observableArrayList(
                    new AutomovelBo().findAll()));
            cbxAutomoveis.getSelectionModel().select(0);

            cbxClientes.setItems(FXCollections.observableArrayList(
                    new ClienteBo().findAll()));
            cbxClientes.getSelectionModel().select(0);
        } catch (Exception ex) {
            Logger.getLogger(VenderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Limpa os campos da tela.
     */
    private void clear() {
        tfQtdParcelas.setText(null);
        tfValor.setText(null);
        cbAVista.setSelected(false);
        setCombos();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
