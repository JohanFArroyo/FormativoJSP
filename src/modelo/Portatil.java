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
public class Portatil {
    private int idPortatil;
    private String marcaP;
    private String codigoP;

    public int getIdPortatil() {
        return idPortatil;
    }

    public void setIdPortatil(int idPortatil) {
        this.idPortatil = idPortatil;
    }

    public String getMarcaP() {
        return marcaP;
    }

    public void setMarcaP(String marcaP) {
        this.marcaP = marcaP;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    @Override
    public String toString() {
        return "Portatil{" + "marcaP=" + marcaP + '}';
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
        final Portatil other = (Portatil) obj;
        return this.idPortatil == other.idPortatil;
    }
    
    public Iterator<Portatil> listar(){
        ArrayList<Portatil> losPortatil = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Portatil unPortatil;
            while (rs.next()){
                unPortatil = new Portatil();
                unPortatil.setIdPortatil(rs.getInt("idPortatil"));
                unPortatil.setMarcaP(rs.getString("MarcaP"));
                unPortatil.setCodigoP(rs.getString("CodigoP"));
                losPortatil.add(unPortatil);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar Celador"+ex.getMessage());
        }
        if (losPortatil.isEmpty()){
            Portatil miPortatil = new Portatil();
            miPortatil.setMarcaP("Sin nombre");
            losPortatil.add(miPortatil);
        }
        return losPortatil.iterator();
    }   
    
    public void insertar(){
    try{
        PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO "+this.getClass().getSimpleName()+" VALUES(NULL,?,?)");
        sql.setString(1, this.getMarcaP());
        sql.setString(2, this.getCodigoP());
        sql.executeUpdate();
        System.out.println(this.getClass().getSimpleName()+" insertado correctamente");
    } catch (SQLException ex) {
        System.err.println("Error al insertar "+this.getClass().getSimpleName()+":"+ex.getMessage());
    }
    }
    
    public void modificar(){
    try{
        PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE "+this.getClass().getSimpleName()+
                " SET marcaP = ?, codigoP = ? WHERE idPortatil = ?");
        sql.setString(1, this.getMarcaP());
        sql.setString(2, this.getCodigoP());
        sql.setInt(3, this.getIdPortatil());
        sql.executeUpdate();
        System.out.println(this.getClass().getSimpleName()+" modificado correctamente");
    } catch (SQLException ex) {
        System.err.println("Error al modificar "+this.getClass().getSimpleName()+": "+ex.getMessage());
    }
    }
    
    public void eliminar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("DELETE FROM "+this.getClass().getSimpleName()+" WHERE idPortatil = ?");
            sql.setInt(1, this.getIdPortatil());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+" eliminado correctamente");
        } catch (SQLException ex){
            System.err.println("Error al eliminar "+this.getClass().getSimpleName()+": "+ex.getMessage());
        }
    }
}
