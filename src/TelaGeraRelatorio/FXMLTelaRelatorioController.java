package TelaGeraRelatorio;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    @FXML JFXHamburger hamburger;
    HamburgerBackArrowBasicTransition burger;
    HamburgerBasicCloseTransition burger2;
    HamburgerSlideCloseTransition burger3;
    @FXML JFXDrawer drawer;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Image lupa = new Image(getClass().getResourceAsStream("/imagens/lupa.png"));
            Image pdf = new Image(getClass().getResourceAsStream("/imagens/pdfB.png"));
            Image cadastro = new Image(getClass().getResourceAsStream("/imagens/cadastro.png"));
            AnchorPane box = FXMLLoader.load(getClass().getResource("/MenuLateral/FXMLMenuLateral.fxml"));
            drawer.setSidePane(box);
            pesquisaAnimal.setGraphic(new ImageView(lupa));
            pesquisaAnimal.setContentDisplay(ContentDisplay.RIGHT);
            pesquisaAnimal.setText("Pesquisar   ");
            geraPDF.setGraphic(new ImageView(pdf));
            geraPDF.setContentDisplay(ContentDisplay.RIGHT);
            geraPDF.setText("Gerar PDF   ");
            burger3 = new HamburgerSlideCloseTransition(hamburger);
            burger3.setRate(-1);
            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, new eventoHamburger());
            JFXNodesList lista = new JFXNodesList();
            JFXNodesList lista2 = new JFXNodesList();
            JFXNodesList lista3 = new JFXNodesList();
            JFXButton t1= new JFXButton("t1");
            t1.setButtonType(JFXButton.ButtonType.RAISED);
            JFXButton t2= new JFXButton("t2");
            t2.setButtonType(JFXButton.ButtonType.RAISED);
            JFXButton t3= new JFXButton("t3");
            t3.setButtonType(JFXButton.ButtonType.RAISED);
            JFXButton t4= new JFXButton("t4");
            t4.setButtonType(JFXButton.ButtonType.RAISED);
            JFXButton t5= new JFXButton("t5");
            t5.setButtonType(JFXButton.ButtonType.RAISED);
            JFXButton t6= new JFXButton("t6");
            t6.setButtonType(JFXButton.ButtonType.RAISED);
            JFXButton t7= new JFXButton("t7");
            t7.setButtonType(JFXButton.ButtonType.RAISED);
            lista.setLayoutX(40);
            lista.setLayoutY(40);
            lista2.addAnimatedNode(t5);
            lista2.addAnimatedNode(t6);
            lista2.addAnimatedNode(t7);
            lista.addAnimatedNode(t1);
            lista.addAnimatedNode(t2);
            lista.addAnimatedNode(t3);
            lista.addAnimatedNode(t4);
            lista.addAnimatedNode(lista2);
            lista2.setRotate(-90);
            lista.animateList();
            //lista.setRotate(-90);
            painelPrincipal.getChildren().add(lista);
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaRelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class Teste implements EventHandler {

        @Override
        public void handle(Event event) {
            System.out.println("clicou no drawer");
        }

    }

    private class eventoHamburger implements EventHandler {

        @Override
        public void handle(Event event) {
            burger3.setRate(burger3.getRate() * -1);
            burger3.play();
            if (drawer.isShown()) {
                drawer.close();
            } else {
                drawer.open();
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
