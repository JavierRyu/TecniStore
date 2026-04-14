package com.tecnipcellstore.dao;

import com.tecnipcellstore.model.Producto;
import com.tecnipcellstore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductoDAO {

    public void guardar(Producto producto) {
        String sql = "INSERT INTO producto (id,nombre,descripcion,precio,stock) VALUES (?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, producto.getId());
            stmt.setString(2, producto.getNombre());
            stmt.setString(3, producto.getDescripcion());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());

            stmt.executeUpdate();

            System.out.println("Producto Guardado Exitosamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
