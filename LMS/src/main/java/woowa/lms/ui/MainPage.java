package woowa.lms.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import woowa.lms.db.DB;
import woowa.lms.domain.Library;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MainPage {

    private Stage primaryStage;
    private Scene scene;
    private Pane pane;
    private HBox hBox;
    private Label label;
    private Button button;

    public MainPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        button = new Button("click");
//        button.setOnAction(e -> {
//            EntityManager em = DB.getEntityManager();
//            EntityTransaction tx = em.getTransaction();
//            tx.begin();
//            Library library = new Library();
//            library.setName("SUNY");
//            em.persist(library);
//            tx.commit();
//            em.close();
//        });
        label = new Label("Hello world");
        hBox = new HBox();
        hBox.getChildren().addAll(label, button);
        pane = new Pane(hBox);
        scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
    }

    public void show() {
        primaryStage.show();
    }

}
