package Controller;

import DAO.CategoriaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Categoria;

public class ControllerCategoria implements Initializable {

    @FXML
    private Tab tabCategoria;

    //@FXML
    //private Tab tabLugares;

    @FXML
    private TextField inpCatg;

    @FXML
    private Button btnCad;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnDel;

    @FXML
    private TableView<Categoria> tabelaCatg;

    @FXML
    private TableColumn<Categoria, String> colId;

    @FXML
    private TableColumn<Categoria, String> colCatg;

    private static Categoria selecionado;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencheTabela();

        tabelaCatg.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    ControllerCategoria.selecionado = (Categoria) newValue;
                } else {
                    ControllerCategoria.selecionado = null;
                }
            }
        });
    }

    private ObservableList<Categoria> categoria;

    public void preencheTabela() {
        colId.setCellValueFactory(new PropertyValueFactory("idCategoria"));
        colCatg.setCellValueFactory(new PropertyValueFactory("nome"));

        CategoriaDAO dao = new CategoriaDAO();
        categoria = FXCollections.observableList(dao.getCategoria());
        tabelaCatg.setItems(categoria);
    }

    @FXML
    private void ClicouCad(ActionEvent event) {
        if (inpCatg.getText() == null || inpCatg.getText().equals("")) {
            Alert c = new Alert(Alert.AlertType.WARNING);
            c.setTitle("ATENÇÃO!");
            c.setHeaderText("Campos vazios");
            c.setContentText("Por favor, digite o nome da categoria");
            c.showAndWait();
        } else {
            try {
                Categoria categoria = new Categoria();
                categoria.setNome(inpCatg.getText());
                CategoriaDAO.insereCategoria(categoria);

                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Cadastro de categoria");
                a.setHeaderText("Categoria cadastrada.");
                a.showAndWait();
                clearForm();
                preencheTabela();

            } catch (Exception e) {
                System.out.println("Erro ao cadastrar" + e.getMessage());
            }
        }
    }

    @FXML
    private void selecionouCatg(ActionEvent event) {
        if (selecionado != null) {
            if (inpCatg.getText() != null && !inpCatg.getText().equals("")) {
                String novoNome = inpCatg.getText();
                selecionado.setNome(novoNome);
                CategoriaDAO.atualizaCategoria(selecionado);
                clearForm();
                preencheTabela();

                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Categoria atualizada com sucesso");
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Digite o novo nome da categoria");
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Selecione uma categoria");
            a.showAndWait();
        }

    }

    @FXML
    private void deletaCategoria(ActionEvent event) {
        if (ControllerCategoria.selecionado != null) {

            CategoriaDAO dao = new CategoriaDAO();
            dao.deletaCategoria(ControllerCategoria.selecionado);

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Categoria excluída com sucesso!");
            a.showAndWait();
            preencheTabela();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Selecione uma categoria");
            a.showAndWait();
        }
    }

    private void clearForm() {
        inpCatg.setText(null);
    }

}
