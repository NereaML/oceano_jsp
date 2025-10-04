package com.cursogetafe.oceano.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Config {

    private static EntityManagerFactory emf;

    private Config() {}

    public static EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("oceano");
        }
        return emf;
    }

    // Conexión JDBC directa (opcional)
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/oceanworld";
        String user = "root";
        String pass = "1234";
        return DriverManager.getConnection(url, user, pass);
    }
}
