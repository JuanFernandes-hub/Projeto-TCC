
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
public class Desktop extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../View/ViewDesktop.fxml"));
        
        //Image aplicationIcon = new Image(getClass().getResourceAsStream(""));
        //stage.getIcons().add(aplicationIcon);
        stage.setTitle("Colibri");
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
