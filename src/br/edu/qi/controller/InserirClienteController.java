package br.edu.qi.controller;

import br.edu.qi.bo.ClienteBo;
import br.edu.qi.model.Cliente;
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
 * Controlador de InserirCliente.fxml.
 *
 * @author Marcelo Zilio
 * @since 16/11/2017 - 19:43
 */
public class InserirClienteController implements Initializable {

    private Stage stage;
<<<<<<< HEAD
<<<<<<< HEAD

=======
    
>>>>>>> 0c66cba8669fa8e941dedbff56a0adec8a692f01
=======

>>>>>>> 94aa368... Criação de Bo e implementação de Client.
    private ClienteBo bo;
    private Cliente cliente;

    @FXML
    private TextField tfNome, tfEndereco, tfCidade, tfEstado, tfTelefone, tfEmail;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.bo = new ClienteBo();
        this.cliente = new Cliente();
    }

    @FXML
    private void save() {
        try {
            cliente.setNome(Validacoes.validaTexto(tfNome.getText(), "Nome", tfNome));
            cliente.setEmail(Validacoes.validaTexto(tfEmail.getText(), "E-mail", tfEmail));
            cliente.setTelefone(Validacoes.validaTexto(tfTelefone.getText(), "Telefone", tfTelefone));
            cliente.setEndereco(Validacoes.validaTexto(tfEndereco.getText(), "Endereço", tfEndereco));
            cliente.setCidade(Validacoes.validaTexto(tfCidade.getText(), "Cidade", tfCidade));
            cliente.setEstado(Validacoes.validaTexto(tfEstado.getText(), "Estado", tfEstado));
<<<<<<< HEAD
<<<<<<< HEAD
            this.bo.save(cliente);
            clear();
            new ViewUtils().msg("Cliente salvo com sucesso.", Alert.AlertType.INFORMATION);
=======
            
            this.bo.save(cliente);
            
            new ViewUtils().msg("Cliente salvo com sucesso.", Alert.AlertType.INFORMATION);
            
            
            
>>>>>>> 0c66cba8669fa8e941dedbff56a0adec8a692f01
=======
            this.bo.save(cliente);
            clear();
            new ViewUtils().msg("Cliente salvo com sucesso.", Alert.AlertType.INFORMATION);
>>>>>>> 94aa368... Criação de Bo e implementação de Client.
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
