

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CalculadoraController {

    // Estos atributos se conectan con los controles del FXML mediante fx:id
    @FXML
    private TextField txtNumero1;

    @FXML
    private TextField txtNumero2;



    // ANTES: private Label lblExplicacion;
    @FXML
    private TextArea lblExplicacion;   // <-- tiene que ser TextArea

    /**
     * Este método se ejecuta cuando pulsamos el botón "Sumar".
     * Está ligado desde el FXML con onAction="#onSumarClick".
     */
    @FXML
    private void onSumarClick(ActionEvent event) {
        try {
            double n1 = Double.parseDouble(txtNumero1.getText());
            double n2 = Double.parseDouble(txtNumero2.getText());
            double suma = n1 + n2;



            // Explicación educativa para el alumno
            lblExplicacion.setText("""
                • En FXML, el atributo fx:id vincula un control con un atributo del controlador.
                • La propiedad onAction del botón ejecuta este método onSumarClick cuando haces clic.
                """);
        } catch (NumberFormatException e) {

            lblExplicacion.setText("Revisa los campos de texto. onAction se ha ejecutado, pero los datos no son correctos.");
        }
    }
}
