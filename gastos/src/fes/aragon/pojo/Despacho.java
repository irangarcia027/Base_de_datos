/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.pojo;

/**
 *
 * @author Frank
 */
public class Despacho {
    private int id_despacho;
    private String nombre_despacho;

    public Despacho() {
    }

    public int getId_despacho() {
        return id_despacho;
    }

    public void setId_despacho(int id_despacho) {
        this.id_despacho = id_despacho;
    }

    public String getNombre_despacho() {
        return nombre_despacho;
    }

    public void setNombre_despacho(String nombre_despacho) {
        this.nombre_despacho = nombre_despacho;
    }

    @Override
    public String toString() {
        return  nombre_despacho;
    }
}
