// Importamos las clases necesarias para una aplicación JavaFX.
// Application  → clase base que toda app JavaFX debe extender.
// FXMLLoader   → permite cargar interfaces gráficas definidas en archivos FXML.
// Scene        → representa el "contenido" que irá dentro de la ventana (Stage).
// Stage        → es la ventana principal de la aplicación.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

// La clase Main es el punto de entrada de la aplicación JavaFX.
// Debe extender 'Application' para integrar los ciclos de vida de JavaFX.
// Este requisito es indispensable para poder usar el método 'start'.
public class Main extends Application {

    // -------------------------------------------------------------------------
    // 1. Método start(Stage stage)
    // -------------------------------------------------------------------------
    //
    // Este método es el "corazón" de cualquier aplicación JavaFX.
    // JavaFX lo invoca automáticamente cuando la aplicación se arranca
    // mediante el método launch() (que está más abajo).
    //
    // El parámetro 'stage' representa la ventana principal.
    // Dentro del Stage colocaremos una Scene,
    // y dentro de la Scene colocaremos la interfaz cargada desde el FXML.
    //
    @Override
    public void start(Stage stage) throws Exception {

        // ---------------------------------------------------------------------
        // 2. Cargar la interfaz desde el archivo FXML
        // ---------------------------------------------------------------------
        //
        // FXMLLoader carga un archivo FXML y construye la interfaz de manera
        // declarativa. Esto permite separar la lógica (Java) del diseño (FXML).
        //
        // Main.class.getResource("vista-calculadora.fxml") busca el archivo
        // dentro del directorio 'resources'. Es importante que esté en la ruta
        // correcta (mismo package o carpeta).
        //
        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("vista-calculadora.fxml")
        );

        // ---------------------------------------------------------------------
        // 3. Crear una Scene
        // ---------------------------------------------------------------------
        //
        // Una Scene es el "contenido" que se mostrará dentro de la ventana.
        // Puede contener layouts, botones, textos, etc.
        // fxmlLoader.load() devuelve el nodo raíz del FXML (en este caso un VBox).
        //
        Scene scene = new Scene(fxmlLoader.load());

        // ---------------------------------------------------------------------
        // 4. Configurar la ventana (Stage)
        // ---------------------------------------------------------------------
        //
        // Título de la ventana que verá el usuario.
        //
        stage.setTitle("Mi primera apli con JavaFX");

        // Asignamos la Scene a la ventana (Stage).
        // Es obligatorio: sin escena, la ventana estaría vacía.
        stage.setScene(scene);

        // Hacemos visible la ventana. Sin esta línea NADA se muestra en pantalla.
        stage.show();
    }

    // -------------------------------------------------------------------------
    // 5. Método main
    // -------------------------------------------------------------------------
    //
    // Este método es necesario para arrancar una aplicación Java normal.
    // Pero en JavaFX, en lugar de iniciar directamente la interfaz,
    // llamamos a launch(), método heredado de Application.
    //
    // launch():
    //   - Inicializa el entorno gráfico de JavaFX.
    //   - Crea internamente un Stage.
    //   - Llama automáticamente al método start(Stage).
    //
    public static void main(String[] args) {
        launch();  // Inicia el ciclo de vida de JavaFX
    }
}
