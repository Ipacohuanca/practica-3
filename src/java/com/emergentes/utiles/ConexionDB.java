package com.emergentes.utiles;

import java.sql.*;

public class ConexionDB {

    static String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static String usuario = "root";
    static String password = "";

    protected Connection conn = null;

    public ConexionDB() {
        try {
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("ERROR AL CONECTARSE..! " + conn);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DE SQL...! " + ex.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        System.out.println("CERRANDO LA BASE DE DATOS..." + conn);
        try {
            conn.close();
        } catch (SQLException ex) {
System.out.println("ERROR DEL SQL...!" + ex.getMessage());
        }
    }
}
