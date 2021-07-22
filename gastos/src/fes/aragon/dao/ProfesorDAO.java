/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.dao;

import fes.aragon.mysql.Conexion;
import fes.aragon.pojo.Despacho;
import fes.aragon.pojo.Profesor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Frank
 */
public class ProfesorDAO {
    private Conexion cnn;
    

    public ProfesorDAO() throws ClassNotFoundException, SQLException {
        cnn = new Conexion();
    }
    
    public void insertar(Profesor tempProfesor) throws SQLException{ 
        String query = "call almacene_profesor(?,?,?,?,?)";
        CallableStatement solicitud = cnn.getConexion().prepareCall(query);
        solicitud.setString(1, tempProfesor.getCurp());
        solicitud.setString(2, tempProfesor.getNombre());
        solicitud.setString(3, tempProfesor.getAp_materno());
        solicitud.setString(4, tempProfesor.getAp_paterno());
        solicitud.setInt(5, tempProfesor.getId_despacho());

        
        solicitud.execute();
        solicitud.close();
        cnn.getConexion().close();
    }
    public ArrayList<Profesor> BuscarProfesor() throws SQLException{
        String query = "select * from profesor";
        Statement solicitar = cnn.getConexion().createStatement();
        ArrayList<Profesor> info = new ArrayList<>();
        ResultSet datos = solicitar.executeQuery(query);
        if (!datos.next()) {
            System.out.println("no hay datos");
        } else {
            do {
                Profesor prof = new Profesor();
                prof.setId_profesor(datos.getInt(1));
                prof.setCurp(datos.getString(2));
                prof.setNombre(datos.getString(3));
                prof.setAp_materno(datos.getString(4));
                prof.setAp_paterno(datos.getString(5));
                prof.setId_despacho(datos.getInt(6));
                info.add(prof);
            } while (datos.next());
        }
        solicitar.close();
        cnn.getConexion().close();
        datos.close();
        return info;
}
    public void modificar(Profesor tempProfesor) throws SQLException{ 
        String query = "call mod_profesor(?,?,?,?,?,?)";
        CallableStatement solicitud = cnn.getConexion().prepareCall(query);
        solicitud.setInt(1, tempProfesor.getId_profesor());
        solicitud.setString(2, tempProfesor.getCurp());
        solicitud.setString(3, tempProfesor.getNombre());
        solicitud.setString(4, tempProfesor.getAp_materno());
        solicitud.setString(5, tempProfesor.getAp_paterno());
        solicitud.setInt(6, tempProfesor.getId_despacho());
        solicitud.execute();
        solicitud.close();
        cnn.getConexion().close();
    }
    
    
}
