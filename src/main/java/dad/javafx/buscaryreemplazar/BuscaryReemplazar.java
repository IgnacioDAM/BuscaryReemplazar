package dad.javafx.buscaryreemplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscaryReemplazar extends Application {

	private TextField buscarText;
	private TextField reemplazarText;
	private Button buscarButton;
	private Button reemplazarButton;
	private Button reemplazartodoButton;
	private Button cerrarButton;
	private Button ayudaButton;
	private CheckBox mayusminus;
	private CheckBox expresionreg;
	private CheckBox buscaratras;
	private CheckBox resaltarresultados;
	private Label espacio;

	@Override
	public void start(Stage primaryStage) throws Exception {

		buscarText = new TextField();
		reemplazarText = new TextField();
		
		espacio = new Label("");
		
		mayusminus = new CheckBox("Mayúsculas y minúsculas");
		expresionreg = new CheckBox("Expresion Regular");
		buscaratras = new CheckBox("Buscar hacia átras");
		resaltarresultados = new CheckBox("Resaltar resultados");
		
		buscarButton = new Button("Buscar");
		reemplazarButton = new Button("Reemplazar");
		reemplazartodoButton = new Button("Reemplazar todo");
		cerrarButton = new Button("Cerrar");
		ayudaButton = new Button("Ayuda");

		VBox botones = new VBox(5, buscarButton, reemplazarButton, reemplazartodoButton, cerrarButton, ayudaButton);

		GridPane root = new GridPane();
		root.setPadding(new Insets(3));
		root.setHgap(3);
		root.setVgap(3);
		root.setGridLinesVisible(true);
		root.addRow(0, new Label("Buscar: "), buscarText);
		root.addRow(1, new Label("Reemplazar con: "), reemplazarText);
		root.addRow(2, espacio, new VBox(5, mayusminus, expresionreg, buscaratras, resaltarresultados));
		
		VBox zonaizquierda = new VBox(5, root);
		
		BorderPane dadroot = new BorderPane();
		dadroot.setRight(botones);
		dadroot.setCenter(zonaizquierda);
		
		Scene scene = new Scene(dadroot, 640, 480);

		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
