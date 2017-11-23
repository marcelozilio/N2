package br.edu.qi.util;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Classe de utilidades para as telas.
 *
 * @author Marcelo Zilio Correa
 * @since 22/11/2017 - 00:21
 */
public class ViewUtils {

    /**
     * Abre uma nova janela.
     *
     * @param pathWindow caminho do fxml da tela.
     * @param stage Stage pai.
     * @param title título da tela.
     * @return Retorna um controller.
     * @throws IOException
     */
    public Object openWindow(String pathWindow, Stage stage, String title)  {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(pathWindow));
            Pane root = loader.load();
            Stage st = new Stage();
            st.setTitle(title);
            st.setResizable(false);
            st.setScene(new Scene(root));
            st.initModality(Modality.WINDOW_MODAL);
            st.initOwner(stage);
            st.showAndWait();
            return loader.getController();
        } catch (IOException ex) {
            Logger.getLogger(ViewUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Criar menssagens para exibição de informações na tela.
     *
     * @param msg Menssagem que será informado
     * @param tipo Tipo da menssagem {@link Alert#alertType}.
     */
    public void msg(String msg, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Informação");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }       
}
