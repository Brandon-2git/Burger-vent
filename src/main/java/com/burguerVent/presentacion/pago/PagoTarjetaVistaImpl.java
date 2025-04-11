package com.burguerVent.presentacion.pago;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

/**
 * Implementación de la vista de pago con tarjeta utilizando JavaFX.
 * Esta clase maneja la interfaz gráfica y la interacción del usuario para el proceso
 * de pago con tarjeta. Implementa la interfaz {@link PagoTarjetaVista} y utiliza
 * FXML para la definición de la interfaz de usuario.
 * 
 * Características principales:
 * - Validación en tiempo real del número de tarjeta
 * - Manejo de eventos de pago y navegación
 * - Mensajes informativos y de error para el usuario
 * - Integración con Spring Framework mediante la anotación @Component
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 * @see PagoTarjetaVista
 * @see Component
 */
@Component
public class PagoTarjetaVistaImpl implements PagoTarjetaVista {
    
    /**
     * Campo de texto para el ingreso del número de tarjeta.
     * Este campo está vinculado al elemento FXML mediante la anotación @FXML
     * y solo permite el ingreso de dígitos numéricos.
     */
    @FXML
    private TextField txtNumeroTarjeta;
    
    /**
     * Campo de texto para el ingreso de la contraseña.
     * Este campo está vinculado al elemento FXML mediante la anotación @FXML
     * y solo permite el ingreso de dígitos numéricos.
     */
    @FXML
    private TextField txtPassword;
    
    /**
     * Botón que inicia el proceso de pago.
     * Al hacer clic en este botón, se ejecutará el callback {@link #onPagar}
     * si está configurado.
     */
    @FXML
    private Button btnPagar;
    
    /**
     * Botón para regresar a la vista anterior.
     * Al hacer clic en este botón, se ejecutará el callback {@link #onRegresar}
     * si está configurado.
     */
    @FXML
    private Button btnRegresar;
    
    /**
     * Callback que se ejecutará cuando el usuario presione el botón de pagar.
     * Este callback debe ser configurado mediante {@link #setOnPagar(Runnable)}.
     */
    private Runnable onPagar;
    
    /**
     * Callback que se ejecutará cuando el usuario presione el botón de regresar.
     * Este callback debe ser configurado mediante {@link #setOnRegresar(Runnable)}.
     */
    private Runnable onRegresar;
    
    /**
     * Ventana principal de la vista.
     * Almacena la referencia a la ventana JavaFX que contiene esta vista.
     */
    private Stage stage;
    
    /**
     * Inicializa los componentes de la interfaz de usuario.
     * Este método es llamado automáticamente por JavaFX después de cargar el archivo FXML.
     * Configura:
     * - Los manejadores de eventos para los botones
     * - La validación del campo de número de tarjeta
     * - La validación del campo de contraseña
     * 
     * La validación del número de tarjeta asegura que solo se puedan ingresar dígitos,
     * eliminando automáticamente cualquier otro carácter ingresado.
     */
    @FXML
    public void initialize() {
        System.out.println("Inicializando PagoTarjetaVistaImpl...");
        
        // Validación para el número de tarjeta (solo números, máximo 8 dígitos)
        txtNumeroTarjeta.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtNumeroTarjeta.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() > 8) {
                txtNumeroTarjeta.setText(oldValue);
            }
        });
        
        // Validación para la contraseña (solo números, máximo 4 dígitos)
        txtPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtPassword.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() > 4) {
                txtPassword.setText(oldValue);
            }
        });
        
        // Configurar eventos de los botones
        btnPagar.setOnAction(e -> {
            System.out.println("Botón pagar presionado");
            if (validarDatosTarjeta() && onPagar != null) {
                onPagar.run();
            }
        });
        
        btnRegresar.setOnAction(e -> {
            System.out.println("Botón regresar presionado");
            if (onRegresar != null) {
                onRegresar.run();
            }
        });
    }
    
    private boolean validarDatosTarjeta() {
        String numeroTarjeta = txtNumeroTarjeta.getText();
        String password = txtPassword.getText();
        
        if (numeroTarjeta == null || numeroTarjeta.length() != 8) {
            mostrarError("El número de tarjeta debe tener 8 dígitos");
            return false;
        }
        
        if (password == null || password.length() != 4) {
            mostrarError("La contraseña debe tener 4 dígitos");
            return false;
        }
        
        return true;
    }
    
    /**
     * {@inheritDoc}
     * Establece el callback que se ejecutará cuando el usuario presione el botón de pagar.
     * 
     * @param action El callback a ejecutar, no puede ser null
     */
    @Override
    public void setOnPagar(Runnable action) {
        System.out.println("Configurando acción de pago");
        this.onPagar = action;
    }
    
    /**
     * {@inheritDoc}
     * Establece el callback que se ejecutará cuando el usuario presione el botón de regresar.
     * 
     * @param action El callback a ejecutar, no puede ser null
     */
    @Override
    public void setOnRegresar(Runnable action) {
        System.out.println("Configurando acción de regreso");
        this.onRegresar = action;
    }
    
    /**
     * {@inheritDoc}
     * Obtiene el número de tarjeta ingresado por el usuario.
     * 
     * @return El número de tarjeta ingresado, o una cadena vacía si el campo no está inicializado
     */
    @Override
    public String getNumeroTarjeta() {
        return txtNumeroTarjeta != null ? txtNumeroTarjeta.getText() : "";
    }
    
    /**
     * {@inheritDoc}
     * Muestra la ventana de pago con tarjeta.
     * Este método:
     * 1. Carga el archivo FXML que define la interfaz
     * 2. Crea una nueva ventana si no existe
     * 3. Muestra la ventana y la trae al frente
     * 
     * Si ocurre algún error durante la carga, se mostrará un mensaje de error al usuario.
     */
    @Override
    public void mostrar() {
        try {
            System.out.println("Mostrando vista de pago con tarjeta...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PagoTarjeta.fxml"));
            loader.setController(this);  // Usar esta instancia como controlador
            Parent root = loader.load();
            
            if (stage == null) {
                stage = new Stage();
                stage.setTitle("Pago con Tarjeta");
            }
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.toFront();
            
            // Configurar los eventos después de cargar el FXML
            btnPagar.setOnAction(e -> {
                System.out.println("Botón pagar presionado");
                if (validarDatosTarjeta() && onPagar != null) {
                    onPagar.run();
                }
            });
            
            btnRegresar.setOnAction(e -> {
                System.out.println("Botón regresar presionado");
                if (onRegresar != null) {
                    onRegresar.run();
                }
            });
            
            // Configurar validaciones de campos
            txtNumeroTarjeta.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    txtNumeroTarjeta.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (newValue.length() > 8) {
                    txtNumeroTarjeta.setText(oldValue);
                }
            });
            
            txtPassword.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    txtPassword.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (newValue.length() > 4) {
                    txtPassword.setText(oldValue);
                }
            });
            
        } catch (Exception e) {
            System.err.println("Error al mostrar la vista de pago con tarjeta: " + e.getMessage());
            e.printStackTrace();
            mostrarError("Error al cargar la ventana de pago con tarjeta");
        }
    }
    
    /**
     * {@inheritDoc}
     * Cierra la ventana de pago con tarjeta.
     * Este método verifica que la ventana exista antes de intentar cerrarla.
     */
    @Override
    public void cerrar() {
        try {
            System.out.println("Cerrando ventana de pago con tarjeta...");
            if (stage != null) {
                stage.close();
                stage = null; // Liberamos la referencia
                System.out.println("Ventana cerrada exitosamente");
            } else {
                System.out.println("La ventana ya está cerrada o no existe");
            }
        } catch (Exception e) {
            System.err.println("Error al cerrar la ventana: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Establece la ventana principal para esta vista.
     * Este método permite inyectar una ventana existente en lugar de crear una nueva.
     * 
     * @param stage La ventana a utilizar, no puede ser null
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    /**
     * {@inheritDoc}
     * Muestra un mensaje de error al usuario utilizando un diálogo de alerta.
     * 
     * @param mensaje El mensaje de error a mostrar, no puede ser null
     */
    @Override
    public void mostrarError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    /**
     * {@inheritDoc}
     * Muestra un mensaje informativo al usuario utilizando un diálogo de alerta.
     * 
     * @param titulo El título del mensaje, no puede ser null
     * @param mensaje El contenido del mensaje, no puede ser null
     */
    @Override
    public void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
} 