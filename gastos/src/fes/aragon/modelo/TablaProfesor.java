/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import fes.aragon.pojo.Despacho;
import fes.aragon.pojo.Profesor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Frank
 */
public class TablaProfesor extends AbstractTableModel{
    private ArrayList<Profesor> datos = new ArrayList<Profesor>();
    private String[] nombreColumna = {"Curp","Nombre","Apellido paterno","Despacho"};
    private DefaultComboBoxModel modeloDespacho;

    @Override
    public int getRowCount() {
       return datos.size();
    }

    @Override
    public int getColumnCount() {
       return nombreColumna.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String celda= "";
        if (columnIndex == 0) {
            celda = datos.get(rowIndex).getCurp();
        }
        else if (columnIndex == 1) {
            celda = datos.get(rowIndex).getNombre();
        }
        else if (columnIndex == 2) {
            celda = datos.get(rowIndex).getAp_paterno();
        }
        else  { 
           for (int i = 1; i < modeloDespacho.getSize(); i++) {
                Despacho dep=(Despacho) modeloDespacho.getElementAt(i);
                if(datos.get(rowIndex).getId_despacho()==dep.getId_despacho()){
                    celda = dep.getNombre_despacho();   
                }    
            }
        }
        return celda;
    }

    public ArrayList<Profesor> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Profesor> datos) {
        this.datos = datos;
    }

    public DefaultComboBoxModel getModeloDespacho() {
        return modeloDespacho;
    }

    public void setModeloDespacho(DefaultComboBoxModel modeloDespacho) {
        this.modeloDespacho = modeloDespacho;
    }
    

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int colum) {
        return nombreColumna[colum];
    }
}
