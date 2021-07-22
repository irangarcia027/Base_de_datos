/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package fes.aragon.dao;
import fes.aragon.mysql.Conexion;
import fes.aragon.pojo.Despacho;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Frank
 */
public class DespachoDAO {
    private Conexion cnn;

    public DespachoDAO() throws ClassNotFoundException, SQLException {
    cnn = new Conexion();
    }
    public void guardar(String nombreDespacho) throws SQLException{
        String query = "call almacenar_des(?)";
        CallableStatement solicitud = cnn.getConexion().prepareCall(query);
        solicitud.setString(1, nombreDespacho);
        
        solicitud.execute();
        solicitud.close();
        cnn.getConexion().close();
    }
    public ArrayList<Despacho> obtenerDespacho () throws SQLException{
        Statement solicitar = cnn.getConexion().createStatement();
        String query = "select * from despachos";
        ArrayList<Despacho> info = new ArrayList<>();
        ResultSet datos = solicitar.executeQuery(query);
        if (!datos.next()) {
            System.out.println("no hay datos");
        } else {
            do {
                Despacho temp = new Despacho();
                temp.setId_despacho(datos.getInt(1));
                temp.setNombre_despacho(datos.getString(2));
                info.add(temp);
            } while (datos.next());
        }
        solicitar.close();
        cnn.getConexion().close();
        datos.close();
        return info;
    }
    
}