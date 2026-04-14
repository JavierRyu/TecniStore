package com.tecnipcellstore.app;

import com.tecnipcellstore.config.DatabaseInit;
import com.tecnipcellstore.model.Producto;
import com.tecnipcellstore.dao.ProductoDAO;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TecniStoreApplication extends Application {

    /*@Override
    public void init() {
        inicializarBaseDatos();
    }*/

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = crearScene();
        cargarEstilos(scene);

        stage.setTitle("TecniCell Store");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Crea la escena principal desde el FXML del dashboard
     */
    private Scene crearScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(
                getClass().getResource("/com/tecnipcellstore/view/dashboard.fxml"),
                "FXML no encontrado: /com/tecnipcellstore/view/dashboard.fxml"
        ));
        return new Scene(fxmlLoader.load(), 1280, 640);
    }

    /**
     * Carga los estilos CSS a la escena
     */
    private void cargarEstilos(Scene scene) {
        String css = Objects.requireNonNull(
                getClass().getResource("/com/tecnipcellstore/css/styles.css"),
                "CSS no encontrado: /com/tecnipcellstore/css/styles.css"
        ).toExternalForm();
        scene.getStylesheets().add(css);
    }

    /**
     * Inicializa la base de datos con datos de ejemplo

    private void inicializarBaseDatos() {
        DatabaseInit.init();

        Producto productoEjemplo = new Producto();
        productoEjemplo.setId(1);
        productoEjemplo.setNombre("Mouse Gamer");
        productoEjemplo.setDescripcion("Marvo G53");
        productoEjemplo.setPrecio(50);
        productoEjemplo.setStock(10);

        ProductoDAO dao = new ProductoDAO();
        dao.guardar(productoEjemplo);
    }*/
}
