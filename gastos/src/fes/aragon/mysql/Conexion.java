/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fes.aragon.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Frank
 */
public class Conexion {
    private String url = "jdbc:mysql://127.0.0.1:3306/gastos?serverTimezone=UTC";
    private String usuario = "iran";
    private String clave = "1234";
    private Connection conexion;

    public Conexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(url, usuario, clave);
    }

    public Connection getConexion() {
        return conexion;
    }
}

