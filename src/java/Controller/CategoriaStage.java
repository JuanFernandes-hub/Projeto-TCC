
package Controller;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author juann
 */
public class CategoriaStage extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../View/ViewCategoria.fxml"));
        
        //Image aplicationIcon = new Image(getClass().getResourceAsStream(""));
        //stage.getIcons().add(aplicationIcon);
        stage.setTitle("Colibri");
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CategoriaStage.stage = stage;
    }
    
    
    
}
