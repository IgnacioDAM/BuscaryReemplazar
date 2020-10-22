package dad.javafx.buscaryreemplazar;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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
		
		buscarButton.setMinWidth(130);
		reemplazarButton.setMinWidth(130);
		reemplazartodoButton.setMinWidth(130);
		cerrarButton.setMinWidth(130);
		ayudaButton.setMinWidth(130);

		VBox botones = new VBox(5, buscarButton, reemplazarButton, reemplazartodoButton, cerrarButton, ayudaButton);
		
		//gridpane del checkbox
		GridPane checkbox = new GridPane();
		checkbox.setPadding(new Insets(2));
		checkbox.setHgap(2);
		checkbox.setVgap(2);
		checkbox.setGridLinesVisible(false);
		checkbox.addRow(0, mayusminus, buscaratras);
		checkbox.addRow(1, expresionreg, resaltarresultados);
		
		ColumnConstraints[] columnas = { new ColumnConstraints(), new ColumnConstraints(), };
		checkbox.getColumnConstraints().setAll(columnas);

		// restricciones columna 0
		columnas[0].setHalignment(HPos.LEFT);

		// restricciones columna 1
		columnas[1].setHalignment(HPos.LEFT);
		columnas[1].setFillWidth(true);
		
		//Grid pane Principal
		GridPane root = new GridPane();
		root.setPadding(new Insets(2));
		root.setHgap(2);
		root.setVgap(2);
		root.setGridLinesVisible(false);
		root.addRow(0, new Label("Buscar: "), buscarText);
		root.addRow(1, new Label("Reemplazar con: "), reemplazarText);
		root.addRow(2, espacio, checkbox);

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints(), };
		root.getColumnConstraints().setAll(cols);

		// restricciones columna 0
		cols[0].setHalignment(HPos.LEFT);
		cols[0].setFillWidth(true);

		// restricciones columna 1
		cols[1].setHalignment(HPos.CENTER);
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setFillWidth(true);

		BorderPane dadroot = new BorderPane();
		dadroot.setRight(botones);
		dadroot.setCenter(root);

		BorderPane.setAlignment(root, Pos.CENTER);
		BorderPane.setAlignment(botones, Pos.TOP_LEFT);

		Scene scene = new Scene(dadroot, 640, 480);

		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
