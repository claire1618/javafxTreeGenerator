import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MyApplication extends Application {
    public void start(Stage stage1){
        Pane root = createPane();



        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setTitle("Buttons and shit");
        stage1.show();
    }

    public Pane createPane(){
        Button but1 = new Button("small");
        Button but2 = new Button("large");
        HBox top = new HBox(300, but1, but2);
        top.setPadding(new Insets(20));

        Label lab1 = new Label("BOO!");
        lab1.relocate(200, 200);
        double size = 40;
        lab1.setFont(Font.font("Arial", size));

        but1.setOnAction( e -> {
            lab1.setFont(Font.font("Arial", lab1.getFont().getSize() - 10));
        });
        but2.setOnAction( e -> {
            lab1.setFont(Font.font("Arial", lab1.getFont().getSize() + 10));
        });

        Pane root = new Pane(top);
        root.getChildren().addAll(lab1);
        root.setMinSize(400, 400);
        return root;
    }
}
