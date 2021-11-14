package TFDpackgae;

import TFDpackgae.FXMLMainFormController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application{
        public static TabulatedFunctionDoc tabFDoc;
        public static void main(String[] args) {
            launch(args);
        }
        @Override
        public void start(Stage stage) throws Exception {
            tabFDoc = new TabulatedFunctionDoc();
            tabFDoc.newFunction(0,10,5);
            tabFDoc.saveFunctionAs("tabFDoc");
            FXMLLoader loader = Init.newFXMLLoader(getClass(), "FXMLMainForm");
            Parent root = loader.load();
            FXMLMainFormController ctrl = loader.getController();
            tabFDoc.registerRedrawFunctionController(ctrl);
            Scene scene = new Scene(root);
            stage.setTitle("Tabulated functions");
            stage.setScene(scene);
            stage.show();
        }
}