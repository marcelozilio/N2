package br.edu.qi.util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
    public Object openWindow(String pathWindow, Stage stage, String title) throws IOException {
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
    }

}
