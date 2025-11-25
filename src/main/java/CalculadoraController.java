// Importamos las clases necesarias de JavaFX para manejar eventos,
// cargar elementos con @FXML y usar controles de la interfaz gráfica.
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// Esta clase actuará como CONTROLADOR para la interfaz definida en el archivo FXML.
// El FXML la referencia con: fx:controller="CalculadoraController"
public class CalculadoraController {

    // -------------------------------------------------------------------------
    // 1. Enlace entre FXML y Java mediante fx:id + @FXML
    // -------------------------------------------------------------------------

    // Este atributo se enlaza con el TextField del FXML cuyo fx:id="txtNumero1".
    // Esto permite leer el contenido del cuadro de texto desde Java.
    @FXML
    private TextField txtNumero1;

    // Igual que el anterior, pero vinculando el segundo campo numérico.
    @FXML
    private TextField txtNumero2;

    // Vinculado al Label del FXML con fx:id="lblResultado".
    // Aquí se mostrará el resultado de la operación.
    @FXML
    private Label lblResultado;

    // En el FXML se definió una TextArea con fx:id="lblExplicacion".
    // Antes era un Label, pero como queremos mostrar varias líneas de texto,
    // la TextArea es más adecuada.
    @FXML
    private TextArea lblExplicacion;   // <-- Accesso al TextArea del FXML


    // -------------------------------------------------------------------------
    // 2. Método que responde al clic del botón (evento onAction)
    // -------------------------------------------------------------------------

    /**
     * Este método se ejecuta automáticamente cuando el usuario pulsa el botón "Sumar".
     * Está conectado desde el FXML gracias a:
     *     onAction="#onSumarClick"
     *
     * JavaFX detecta ese nombre y llama a este método cuando ocurre el evento.
     */
    @FXML
    private void onSumarClick(ActionEvent event) {

        try {
            // -----------------------------------------------------------------
            // 2.1. Lectura de valores desde los TextField
            // -----------------------------------------------------------------

            // Extraemos el texto del cuadro de texto y lo convertimos a número.
            // Si el usuario escribe algo que no sea un número, lanzará
            // una excepción NumberFormatException.
            double n1 = Double.parseDouble(txtNumero1.getText());
            double n2 = Double.parseDouble(txtNumero2.getText());

            // Sumamos los valores numéricos obtenidos.
            double suma = n1 + n2;

            // -----------------------------------------------------------------
            // 2.2. Mostrar el resultado en el Label
            // -----------------------------------------------------------------

            lblResultado.setText("Resultado: " + suma);

            // -----------------------------------------------------------------
            // 2.3. Explicación pedagógica en la TextArea
            // -----------------------------------------------------------------

            // Usamos un bloque de texto multilinea (desde Java 15).
            // Esto permite una explicación clara para el alumno.
            lblExplicacion.setText("""
                • En FXML, el atributo fx:id vincula un control con un atributo del controlador.
                • La propiedad onAction del botón ejecuta este método onSumarClick cuando haces clic.
                """);

        } catch (NumberFormatException e) {
            // -----------------------------------------------------------------
            // 2.4. Gestión de errores (input no válido)
            // -----------------------------------------------------------------

            // Este bloque se ejecuta si el usuario introduce texto no numérico.
            // Muy útil para evitar que la aplicación falle por un simple error.
            lblExplicacion.setText("Revisa los campos de texto. "
                    + "onAction se ha ejecutado, pero los datos no son correctos.");
        }
    }
}
