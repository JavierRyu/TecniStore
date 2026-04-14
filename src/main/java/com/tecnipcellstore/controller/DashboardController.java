package com.tecnipcellstore.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.Objects;

public class DashboardController {

    @FXML
    private HBox inventario;

    @FXML
    private HBox ventas;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnListarProductos;

    @FXML
    private VBox centerContent;

    @FXML
    protected void onCategoryInventarioClick() {
        cargarVista("/com/tecnipcellstore/view/inventario.fxml");
    }

    @FXML
    protected void onCategoryVentasClick() {
        cargarVista("/com/tecnipcellstore/view/ventas.fxml");
    }

    @FXML
    protected void onAgregarProducto() {
        System.out.println("Botón 'Agregar Producto' presionado");
        // Aquí abriremos una ventana para agregar producto
    }

    @FXML
    protected void onListarProductos() {
        System.out.println("Botón 'Listar Productos' presionado");
        // Aquí cargaremos y mostraremos los productos
    }

    private void cargarVista(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                    getClass().getResource(rutaFXML),
                    "FXML no encontrado: " + rutaFXML
            ));
            VBox vistaContenido = loader.load();
            centerContent.getChildren().clear();
            centerContent.getChildren().add(vistaContenido);
        } catch (IOException e) {
            System.err.println("Error al cargar la vista: " + rutaFXML);
            e.printStackTrace();
        }
    }
}
