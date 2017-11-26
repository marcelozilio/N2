package br.edu.qi.controller;

import br.edu.qi.bo.AutomovelBo;
import br.edu.qi.bo.ProprietarioBo;
import br.edu.qi.enums.CoresEnum;
import br.edu.qi.enums.MarcasEnum;
import br.edu.qi.model.Automovel;
import br.edu.qi.model.Proprietario;
import br.edu.qi.util.Validacoes;
import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * Controlador de InserirAutomovel.fxml.
 *
 * @author Marcelo Zilio Correa
 * @since 16/11/2017 - 20:38
 */
public class InserirAutomovelController implements Initializable {

    private Stage stage;
    private Automovel automovel;
    private AutomovelBo bo;

    @FXML
    private ComboBox cbxMarcas, cbxProprietarios, cbxCores;

    @FXML
    private ToggleGroup tgTipo, tgEstado;

    @FXML
    private CheckBox cbArCondicionado, cbTocaFita, cbRodaLiga, cbTapete, cbAlarme;

    @FXML
    private TextField tfAno, tfModelo;

    @FXML
    private TextArea taDescricao;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.automovel = new Automovel();
        this.bo = new AutomovelBo();

        setCombos();

        tgTipo.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            RadioButton aux = (RadioButton) newValue;
            automovel.setTipo(aux.getText());
        });

        tgEstado.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            RadioButton aux = (RadioButton) newValue;
            automovel.setEstado(aux.getText());
        });
    }

    @FXML
    private void save() {
        try {
            this.automovel.setProprietario((Proprietario) cbxProprietarios.getSelectionModel().getSelectedItem());
            this.automovel.setMarca(cbxMarcas.getSelectionModel().getSelectedItem().toString());
            this.automovel.setModelo(tfModelo.getText());
            this.automovel.setAno(Validacoes.validaTexto(tfAno.getText(), "Ano", tfAno));
            this.automovel.setCor(cbxCores.getSelectionModel().getSelectedItem().toString());
            this.automovel.setVendido(0);
            this.automovel.setDescricao(taDescricao.getText());
            this.automovel.setVendas(new HashSet<>());
            if (this.automovel.getTipo() == null) {
                this.automovel.setTipo("Off Road");
            }
            if (this.automovel.getEstado() == null) {
                this.automovel.setEstado("Novo");
            }
            if (cbArCondicionado.isSelected()) {
                this.automovel.setAcessorios("Ar Condicionado");
            }
            if (cbTocaFita.isSelected()) {
                this.automovel.setAcessorios(this.automovel.getAcessorios() + " Toca Fita");
            }
            if (cbRodaLiga.isSelected()) {
                this.automovel.setAcessorios(this.automovel.getAcessorios() + " Roda Liga");
            }
            if (cbTapete.isSelected()) {
                this.automovel.setAcessorios(this.automovel.getAcessorios() + " Tapete");
            }
            if (cbAlarme.isSelected()) {
                this.automovel.setAcessorios(this.automovel.getAcessorios() + " Alarme");
            }
            this.bo.save(automovel);
            new ViewUtils().msg("Automovel salvo com sucesso.", Alert.AlertType.INFORMATION);
            clear();
        } catch (Exception e) {
            new ViewUtils().msg(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    /**
     * Preenche os ComboBox da tela.
     */
    private void setCombos() {
        try {
            cbxMarcas.setItems(FXCollections.observableArrayList(
                    Arrays.stream(MarcasEnum.values()).collect(Collectors.toList())));
            cbxMarcas.getSelectionModel().select(0);

            cbxProprietarios.setItems(FXCollections.observableArrayList(
                    new ProprietarioBo().findAll()));
            cbxProprietarios.getSelectionModel().select(0);

            cbxCores.setItems(FXCollections.observableArrayList(
                    Arrays.stream(CoresEnum.values()).collect(Collectors.toList())));
            cbxCores.getSelectionModel().select(0);
        } catch (Exception ex) {
            Logger.getLogger(InserirAutomovelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que limpa os objetos e os campos.
     */
    private void clear() {
        this.automovel = new Automovel();
        this.bo = new AutomovelBo();
        tfAno.setText(null);
        tfModelo.setText(null);
        taDescricao.setText(null);
        setCombos();        
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
