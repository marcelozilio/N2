/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.bo.ClienteBo;
import br.edu.qi.bo.ParcelaBo;
import br.edu.qi.bo.VendaBo;
import br.edu.qi.model.Cliente;
import br.edu.qi.model.Parcela;
import br.edu.qi.model.ParcelaId;
import br.edu.qi.model.Venda;
import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Controlador de ContasReceber.fxml.
 *
 * @author Marcelo Zilio Correa
 * @since 26/11/2017 - 01:07
 */
public class ContasReceberController implements Initializable {

    private Stage stage;
    private ParcelaBo bo;
    private Venda venda;

    @FXML
    private ComboBox cbxClientes, cbxVendas;

    @FXML
    private DatePicker dpDtPagamento;

    @FXML
    private CheckBox cbMulta;

    @FXML
    private TableView<Parcela> tableParcelas;

    @FXML
    private TableColumn tcNumParcela, tcValorParcela, tcDataPagamento, tcMulta;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.venda = new Venda();
        this.bo = new ParcelaBo();

        setComboClientes();

        cbxClientes.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    setComboVendas();
                }
            }
        });

        cbxVendas.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                venda = (Venda) cbxVendas.getSelectionModel().getSelectedItem();
                preencherTabela(venda);
            }
        });
    }

    private void setComboClientes() {
        try {
            cbxClientes.setItems(FXCollections.observableArrayList(new ClienteBo().findAll()));
        } catch (Exception ex) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setComboVendas() {
        try {
            tableParcelas.getItems().clear();
            Cliente cliente = (Cliente) cbxClientes.getSelectionModel().getSelectedItem();

            List<Venda> vendas = new VendaBo()
                    .findAll()
                    .stream()
                    .filter(v -> Objects.equals(v.getCliente().getIdCliente(), cliente.getIdCliente()))
                    .collect(Collectors.toList());
            cbxVendas.setItems(FXCollections.observableArrayList(vendas));
        } catch (Exception e) {
            Logger.getLogger(ContasReceberController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void preencherTabela(Venda venda) {
        try {
            List<Parcela> parcelas = new ParcelaBo()
                    .findAll()
                    .stream()
                    .filter(p -> Objects.equals(p.getId().getIdVenda(), venda.getIdVenda()))
                    .collect(Collectors.toList());
            tableParcelas.setItems(FXCollections.observableArrayList(parcelas));
            tcNumParcela.setCellValueFactory(new PropertyValueFactory<>("id"));
            tcValorParcela.setCellValueFactory(new PropertyValueFactory<>("valor"));
            tcDataPagamento.setCellValueFactory(new PropertyValueFactory<>("dataPgto"));
            tcMulta.setCellValueFactory(new PropertyValueFactory<>("multa"));
        } catch (Exception e) {
            new ViewUtils().msg(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void save() {

        try {
            Parcela parcela = new Parcela();
            parcela.setId(
                    new ParcelaId(tableParcelas.getSelectionModel().getSelectedItem().getId().getIdVenda(),
                            tableParcelas.getSelectionModel().getSelectedItem().getId().getSqParcela()));
            parcela.setDataPgto(Date.from(dpDtPagamento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            parcela.setDataParcela(tableParcelas.getSelectionModel().getSelectedItem().getDataParcela());
            parcela.setValor(tableParcelas.getSelectionModel().getSelectedItem().getValor());
            this.bo.setMulta(cbMulta.isSelected());
            this.bo.update(parcela);
            new ViewUtils().msg("Pagamento salvo.", Alert.AlertType.INFORMATION);
            preencherTabela(venda);
        } catch (Exception ex) {
            new ViewUtils().msg(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void clear() {
        dpDtPagamento.setValue(null);
        cbMulta.setSelected(false);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
