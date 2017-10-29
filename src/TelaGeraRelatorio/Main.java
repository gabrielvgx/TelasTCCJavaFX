/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelaGeraRelatorio;

import TelaCadastro.FXMLTelaCadastroController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author GVGX_TECNOLOGIA
 */
public class Main extends Application {
    public static Stage stagePrincipal;
    public static Scene telaCadastro;
    public static Scene telaRelatorio;
    @Override
    public void start(Stage stage) throws Exception {
        stagePrincipal = stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLTelaRelatorio.fxml"));
        Parent root2 = FXMLLoader.load(FXMLTelaCadastroController.class.getResource("FXMLTelaCadastro.fxml"));
//        box = FXMLLoader.load(getClass().getResource("FXMLMenuLateral.fxml"));
        telaRelatorio = new Scene(root,1256,655);
        telaCadastro = new Scene(root2,1256,655);
        stage.setScene(telaRelatorio);
        stage.show();
    }
    
    public static void setScene(String nome) throws IOException{
        switch(nome){
            case "telaCadastro":
                stagePrincipal.setScene(telaCadastro);

                break;
            case "telaRelatorio":
                stagePrincipal.setScene(telaRelatorio);
                break;
            default:
                System.out.println("err");
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
