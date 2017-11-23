package br.edu.qi.controller;

import br.edu.qi.bo.ProprietarioBo;
import br.edu.qi.model.Proprietario;
import br.edu.qi.util.Validacoes;
import br.edu.qi.util.ViewUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador de InserirProduto.fxml
 *
 * @author Marcelo Zilio Correa
 * @since 16/11/2017 - 20:34
 */
public class InserirProprietarioController implements Initializable {

    private Stage stage;
    private ProprietarioBo bo;
    private Proprietario proprietario;

    @FXML
    private TextField tfNome, tfEndereco, tfCidade, tfEstado, tfTelefone, tfEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.proprietario = new Proprietario();
        this.bo = new ProprietarioBo();
    }

    @FXML
    private void save() {
        try {
            proprietario.setNome(Validacoes.validaTexto(tfNome.getText(), "Nome", tfNome));
            proprietario.setEmail(Validacoes.validaTexto(tfEmail.getText(), "E-mail", tfEmail));
            proprietario.setTelefone(Validacoes.validaTexto(tfTelefone.getText(), "Telefone", tfTelefone));
            proprietario.setEndereco(Validacoes.validaTexto(tfEndereco.getText(), "Endereço", tfEndereco));
            proprietario.setCidade(Validacoes.validaTexto(tfCidade.getText(), "Cidade", tfCidade));
            proprietario.setEstado(Validacoes.validaTexto(tfEstado.getText(), "Estado", tfEstado));
            this.bo.save(proprietario);
            clear();
            new ViewUtils().msg("Proprietário salvo com sucesso.", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            new ViewUtils().msg(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void clear() {
        tfNome.setText(null);
        tfEndereco.setText(null);
        tfCidade.setText(null);
        tfEstado.setText(null);
        tfTelefone.setText(null);
        tfEmail.setText(null);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
