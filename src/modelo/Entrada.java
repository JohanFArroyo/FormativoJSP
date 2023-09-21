/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gutie
 */
public class Entrada {
    private int idEntrada;
    private int idCelador;
    private int idAprendices;
    private int idPortatil;
    private String fechaEntrada;

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdCelador() {
        return idCelador;
    }

    public void setIdCelador(int idCelador) {
        this.idCelador = idCelador;
    }

    public int getIdAprendices() {
        return idAprendices;
    }

    public void setIdAprendices(int idAprendices) {
        this.idAprendices = idAprendices;
    }

    public int getIdPortatil() {
        return idPortatil;
    }

    public void setIdPortatil(int idPortatil) {
        this.idPortatil = idPortatil;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entrada other = (Entrada) obj;
        return this.idEntrada == other.idEntrada;
    }
    
    public Iterator<Entrada> listar(){
        ArrayList<Entrada> losEntrada = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Entrada unEntrada;
            while (rs.next()){
                unEntrada = new Entrada();
                unEntrada.setIdEntrada(rs.getInt("idEntrada"));
                unEntrada.setIdCelador(rs.getInt("idCelador"));
                unEntrada.setIdAprendices(rs.getInt("idAprendices"));
                unEntrada.setIdPortatil(rs.getInt("idPortatil"));
                unEntrada.setFechaEntrada(rs.getString("fechaEntrada"));
                losEntrada.add(unEntrada);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar Entrada"+ex.getMessage());
        }
        if (losEntrada.isEmpty()){
            Entrada miEntrada = new Entrada();
            miEntrada.setFechaEntrada("Sin entrada");
            losEntrada.add(miEntrada);
        }
        return losEntrada.iterator();
    }
    
    public boolean ingresar(String fe) {
        PreparedStatement sql;
        try {
            sql = ConexionBD.conexion.prepareStatement("SELECT * FROM " + this.getClass().getSimpleName() + " WHERE fechaEntrada = ?");
            sql.setString(5, fe);
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                System.out.println("algo");
                return true;
                        
            } else {
                
                System.out.println("nada");
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void insertar(){
    try{
        PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO "+this.getClass().getSimpleName()+" VALUES(NULL,?,?,?,?)");
        sql.setInt(1, this.getIdCelador());
        sql.setInt(2, this.getIdAprendices());
        sql.setInt(3, this.getIdPortatil());
        sql.setString(4, this.getFechaEntrada());
        sql.executeUpdate();
        System.out.println(this.getClass().getSimpleName()+" insertado correctamente");
    } catch (SQLException ex) {
        System.err.println("Error al insertar "+this.getClass().getSimpleName()+":"+ex.getMessage());
    }
    }
    
    public void modificar(){
    try{
        PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE "+this.getClass().getSimpleName()+
                " SET idCelador = ?, idAprendices = ?, idPortatil = ?, fechaEntrada = ? WHERE idEntrada = ?");
        sql.setInt(1, this.getIdCelador());
        sql.setInt(2, this.getIdAprendices());
        sql.setInt(3, this.getIdPortatil());
        sql.setString(4, this.getFechaEntrada());
        sql.setInt(5, this.getIdEntrada());
        sql.executeUpdate();
        System.out.println(this.getClass().getSimpleName()+" modificado correctamente");
    } catch (SQLException ex) {
        System.err.println("Error al modificar "+this.getClass().getSimpleName()+": "+ex.getMessage());
    }
    }
    
    public void eliminar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("DELETE FROM "+this.getClass().getSimpleName()+" WHERE idEntrada = ?");
            sql.setInt(1, this.getIdEntrada());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+" eliminado correctamente");
        } catch (SQLException ex){
            System.err.println("Error al eliminar "+this.getClass().getSimpleName()+": "+ex.getMessage());
        }
    }
    
    public Iterator<Entrada> buscar(String busqueda){
         ArrayList<Entrada> losEntrada = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName()+" where idEntrada LIKE ? ");
            sql.setString(1, "%" +busqueda+ "%");
            ResultSet rs = sql.executeQuery();
            Entrada unEntrada;
            while (rs.next()) {
                unEntrada = new Entrada();
                unEntrada.setIdEntrada(rs.getInt("idEntrada"));
                unEntrada.setIdCelador(rs.getInt("idCelador"));
                unEntrada.setIdAprendices(rs.getInt("idAprendices"));
                unEntrada.setIdPortatil(rs.getInt("idPortatil"));
                unEntrada.setFechaEntrada(rs.getString("fechaEntrada"));
                losEntrada.add(unEntrada);
            }
        } catch (SQLException ex){
            System.err.println("Error al listar celadores:"+ex.getMessage());
        }
        if (losEntrada.isEmpty()){
            Entrada miEntrada = new Entrada();
            miEntrada.setFechaEntrada("No hay fecha");
            losEntrada.add(miEntrada);
        }
        return losEntrada.iterator();
    }
    
    public Entrada bucarPorId(int elId){
        Entrada unEntrada = new Entrada();
        unEntrada.setFechaEntrada("No existe");
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+
                    this.getClass().getSimpleName()+" WHERE idEntrada = ?");
            sql.setInt(1,elId);
            ResultSet rs = sql.executeQuery();
            while (rs.next()){
                unEntrada.setIdEntrada(rs.getInt(idEntrada));
                unEntrada.setIdCelador(rs.getInt(idCelador));
                unEntrada.setIdAprendices(rs.getInt(idAprendices));
                unEntrada.setIdPortatil(rs.getInt(idPortatil));
                unEntrada.setFechaEntrada(rs.getString(fechaEntrada));
            }
        } catch (SQLException ex){
            System.err.print("Error al bucar por Id "+ex.getMessage());
        }
        return unEntrada;
    }
}
