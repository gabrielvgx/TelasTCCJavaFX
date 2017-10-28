/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelaGeraRelatorio;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class FXMLTelaRelatorioController implements Initializable {

    @FXML
    JFXToggleButton geraRelatorioFazenda;
    @FXML
    AnchorPane painelPrincipal;
    @FXML
    JFXButton pesquisaAnimal;
    @FXML
    JFXButton geraPDF;
    @FXML
    JFXCheckBox selecionaTodosRelatorios;
    @FXML
    JFXTreeTableView tabelaAnimais;
    HamburgerBackArrowBasicTransition burger;
    JFXDrawer drawer;
    VBox box;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Main.box == null){
            System.out.println("null");
        }
        drawer = new JFXDrawer();
        box = new VBox();
        box.getChildren().add(new JFXButton("oi"));
        drawer.setSidePane(box);
        Image lupa = new Image(getClass().getResourceAsStream("/imagens/lupa.png"));
        Image pdf = new Image(getClass().getResourceAsStream("/imagens/pdfB.png"));
        Image cadastro = new Image(getClass().getResourceAsStream("/imagens/cadastro.png"));
        Image hamburguer = new Image(getClass().getResourceAsStream("/imagens/hamburguer.png"));
        JFXHamburger hamburger = new JFXHamburger();
        pesquisaAnimal.setGraphic(new ImageView(lupa));
        pesquisaAnimal.setContentDisplay(ContentDisplay.RIGHT);
        pesquisaAnimal.setText("Pesquisar   ");
        drawer.setLayoutX(10.0);
        drawer.setLayoutY(20.0);
        drawer.setScaleX(40.0);
        drawer.setScaleY(92.0);
        drawer.setPrefWidth(152.0);
        JFXButton ab = new JFXButton("HEllo");
        ab.setScaleX(5.0);
        ab.setScaleY(5.0);
        ab.setLayoutY(5.0);
        ab.setLayoutX(40.0);
        painelPrincipal.getChildren().add(ab);
        drawer.setOnMouseClicked(new Teste());
        painelPrincipal.getChildren().add(drawer);
        geraPDF.setGraphic(new ImageView(pdf));
        geraPDF.setContentDisplay(ContentDisplay.RIGHT);
        geraPDF.setText("Gerar PDF   ");
        hamburger.setLayoutX(painelPrincipal.getPrefWidth() - 50.0);
        hamburger.setLayoutY(10.0);
        burger = new HamburgerBackArrowBasicTransition(hamburger);
        burger.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, new eventoHamburger());
        painelPrincipal.getChildren().add(hamburger);
    }
    private class Teste implements EventHandler{

        @Override
        public void handle(Event event) {
            System.out.println("clicou no drawer");
        }
        
    }
    private class eventoHamburger implements EventHandler {

        @Override
        public void handle(Event event) {
            burger.setRate(burger.getRate() * -1);
            burger.play();
            if (drawer.isShown()) {
                drawer.open();
            } else {
                drawer.close();
            }
        }

    }

    private class eventoMenu implements EventHandler {

        @Override
        public void handle(Event event) {
            System.out.println("clicou em mim");
        }

    }

    @FXML
    protected void gerarRelatorioFazenda() {
        JFXTextField numeroAnimal = (JFXTextField) painelPrincipal.getChildren().get(2);
        numeroAnimal.setDisable(geraRelatorioFazenda.isSelected());
        pesquisaAnimal.setDisable(geraRelatorioFazenda.isSelected());
    }

    @FXML
    protected void selecionarTodosRelatorios() {
        for (int i = 0; i < painelPrincipal.getChildren().size(); i++) {
            if (painelPrincipal.getChildren().get(i) instanceof JFXCheckBox) {
                if (painelPrincipal.getChildren().get(i).getId().contains("relatorio")) {
                    ((JFXCheckBox) painelPrincipal.getChildren().get(i)).setSelected(selecionaTodosRelatorios.isSelected());
                }
            }
        }

    }

    @FXML
    protected void buscaElemento() {
        try {
            Main.setScene("telaCadastro");
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaRelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
