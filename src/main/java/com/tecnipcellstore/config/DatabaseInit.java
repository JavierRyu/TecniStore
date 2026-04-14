package com.tecnipcellstore.config;

import com.tecnipcellstore.config.DatabaseInit;
import com.tecnipcellstore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInit {

    public static void init() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS producto (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT NOT NULL," +
                    "descripcion TEXT," +
                    "precio REAL NOT NULL," +
                    "stock INTEGER NOT NULL" +
                    ")";

            stmt.execute(sql);

            System.out.println("Tabla Producto Creada Correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
