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

/**
 *
 * @author CGAO
 */
public class Aprendices {
    private int idAprendices;
    private String nombreA;
    private String fichaA;
    private String ident;

    public int getIdAprendices() {
        return idAprendices;
    }

    public void setIdAprendices(int idAprendices) {
        this.idAprendices = idAprendices;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getFichaA() {
        return fichaA;
    }

    public void setFichaA(String fichaA) {
        this.fichaA = fichaA;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return "Aprendices{" + "nombreA=" + nombreA + '}';
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
        final Aprendices other = (Aprendices) obj;
        return this.idAprendices == other.idAprendices;
    }
    
    public Iterator<Aprendices> listar(){
        ArrayList<Aprendices> losAprendices = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Aprendices unAprendices;
            while (rs.next()){
                unAprendices = new Aprendices();
                unAprendices.setIdAprendices(rs.getInt("idAprendices"));
                unAprendices.setNombreA(rs.getString("NombreA"));
                unAprendices.setFichaA(rs.getString("FichaA"));
                unAprendices.setIdent(rs.getString("Ident"));
                losAprendices.add(unAprendices);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar Celador"+ex.getMessage());
        }
        if (losAprendices.isEmpty()){
            Aprendices miAprendices = new Aprendices();
            miAprendices.setNombreA("Sin nombre");
            losAprendices.add(miAprendices);
        }
        return losAprendices.iterator();
    }   
    
    public void insertar(){
    try{
        PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO "+this.getClass().getSimpleName()+" VALUES(NULL,?,?,?)");
        sql.setString(1, this.getNombreA());
        sql.setString(2, this.getFichaA());
        sql.setString(3, this.getIdent());
        sql.executeUpdate();
        System.out.println(this.getClass().getSimpleName()+" insertado correctamente");
    } catch (SQLException ex) {
        System.err.println("Error al insertar "+this.getClass().getSimpleName()+":"+ex.getMessage());
    }
    }
    
    public void modificar(){
    try{
        PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE "+this.getClass().getSimpleName()+
                " SET nombreA = ?, fichaA = ?, ident = ? WHERE idAprendices = ?");
        sql.setString(1, this.getNombreA());
        sql.setString(2, this.getFichaA());
        sql.setString(3, this.getIdent());
        sql.setInt(4, this.getIdAprendices());
        sql.executeUpdate();
        System.out.println(this.getClass().getSimpleName()+" modificado correctamente");
    } catch (SQLException ex) {
        System.err.println("Error al modificar "+this.getClass().getSimpleName()+": "+ex.getMessage());
    }
    }
    
    public void eliminar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("DELETE FROM "+this.getClass().getSimpleName()+" WHERE idAprendices = ?");
            sql.setInt(1, this.getIdAprendices());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+" eliminado correctamente");
        } catch (SQLException ex){
            System.err.println("Error al eliminar "+this.getClass().getSimpleName()+": "+ex.getMessage());
        }
    }
}
