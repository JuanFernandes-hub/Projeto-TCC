/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LoginDAO;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Login;
import org.apache.commons.codec.digest.DigestUtils;

public class ControllerLogin implements Initializable {

    @FXML
    private PasswordField inpSenha;

    @FXML
    private TextField inpUsuario;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnSair;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnEntrar.setOnMouseClicked((MouseEvent e) -> {
            validaLogin();
        });
        
        btnEntrar.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                validaLogin();
            }
        });

        btnSair.setOnMouseClicked((MouseEvent e) -> {
            LoginStage.getStage().close();
        });

        btnSair.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                LoginStage.getStage().close();
            }
        });
    }

    private void validaLogin() {
        String usuario = inpUsuario.getText();
        String email = inpUsuario.getText();
        String senha = inpSenha.getText();
        senha = DigestUtils.sha1Hex(senha);
        Login login = LoginDAO.getLogin(usuario, senha, email);
        if (login != null) {
            if (login.getClasse().getNome().equals("administrador")) {
                CategoriaStage categoriaStage = new CategoriaStage();
                LoginStage.getStage().close();
                try {
                    categoriaStage.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Você não é um usuário administrador.");
                a.setHeaderText("Somente o usuário administrador pode entrar aqui.");
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Usuário inválido.");
            a.setHeaderText("Usuário ou senha incorretos. Tente novamente.");
            a.showAndWait();
        }
    }
}
