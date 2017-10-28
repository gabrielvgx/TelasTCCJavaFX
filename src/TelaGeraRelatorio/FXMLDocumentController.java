/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelaGeraRelatorio;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author GVGX_TECNOLOGIA
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    JFXToggleButton geraRelatorioFazenda;
    @FXML
    AnchorPane painelPrincipal;
    @FXML
    JFXButton pesquisaAnimal;
    @FXML
    JFXCheckBox selecionaTodosRelatorios;
    @FXML
    JFXTreeTableView tabelaAnimais;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    protected void gerarRelatorioFazenda() {
        JFXTextField numeroAnimal = (JFXTextField) painelPrincipal.getChildren().get(2);
        numeroAnimal.setDisable(geraRelatorioFazenda.isSelected());
        pesquisaAnimal.setDisable(geraRelatorioFazenda.isSelected());
    }

    @FXML
    protected void selecionarTodosRelatorios() {
        JFXCheckBox[] a = {(JFXCheckBox) painelPrincipal.getChildren().get(6),
            (JFXCheckBox) painelPrincipal.getChildren().get(7),
            (JFXCheckBox) painelPrincipal.getChildren().get(8),
            (JFXCheckBox) painelPrincipal.getChildren().get(9),
            (JFXCheckBox) painelPrincipal.getChildren().get(10)};
        for (int i = 0; i < a.length; i++) {
            a[i].setSelected(selecionaTodosRelatorios.isSelected());
        }

    }

}
