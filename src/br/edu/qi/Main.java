package br.edu.qi;

import br.edu.qi.controller.TelaInicialController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Classe responsável pela inicialização do projeto.
 *
 * @author Marcelo Zilio
 * @since 10/11/2017 - 19:40
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage.setTitle("Revenda de Carros");
            stage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/qi/view/TelaInicial.fxml"));
            Pane root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            TelaInicialController controle = loader.getController();
            controle.setStage(stage);
        } catch (IOException ex) {
            System.out.println("erro init app->" + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
