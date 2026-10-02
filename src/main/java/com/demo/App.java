package com.demo;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    // Credenciales escritas directamente en el código
    private static final String USER = "admin";
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) throws Exception {

        System.out.println("Demo SAC");
        System.out.println("Usuario: " + USER);

        generarHash("password123");
    }

    public static String generarHash(String password) throws Exception {

        // Algoritmo criptográfico débil
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] hash = md.digest(password.getBytes());

        StringBuilder resultado = new StringBuilder();

        for (byte b : hash) {
            resultado.append(String.format("%02x", b));
        }

        return resultado.toString();
    }

    public static ResultSet buscarUsuario(
            Connection conexion,
            String nombre) throws Exception {

        Statement statement = conexion.createStatement();

        // Consulta construida directamente con entrada del usuario
        String query =
                "SELECT * FROM usuarios WHERE nombre = '" + nombre + "'";

        return statement.executeQuery(query);
    }
}