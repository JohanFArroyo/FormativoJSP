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
public class Celador {
    private int idCelador;
    private String nombreC;
    private String cedula;

    public int getIdCelador() {
        return idCelador;
    }

    public void setIdCelador(int idCelador) {
        this.idCelador = idCelador;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Celador{" + "nombreC=" + nombreC + '}';
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
        final Celador other = (Celador) obj;
        return this.idCelador == other.idCelador;
    }
    public Iterator<Celador> listar(){
        ArrayList<Celador> losCelador = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Celador unCelador;
            while (rs.next()){
                unCelador = new Celador();
                unCelador.setIdCelador(rs.getInt("idCelador"));
                unCelador.setNombreC(rs.getString("NombreC"));
                unCelador.setCedula(rs.getString("Cedula"));
                losCelador.add(unCelador);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar Celador"+ex.getMessage());
        }
        if (losCelador.isEmpty()){
            Celador miCelador = new Celador();
            miCelador.setNombreC("Sin nombre");
            losCelador.add(miCelador);
        }
        return losCelador.iterator();
    }   
    
    public void insertar(){
    try{
        PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO "+this.getClass().getSimpleName()+" VALUES(NULL,?,?)");
        sql.setString(1, this.getNombreC());
        sql.setString(2, this.getCedula());
        sql.executeUpdate();
        System.out.println(this.getClass().getSimpleName()+" insertado correctamente");
    } catch (SQLException ex) {
        System.err.println("Error al insertar "+this.getClass().getSimpleName()+":"+ex.getMessage());
    }
    }
    
    public void modificar(){
    try{
        PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE "+this.getClass().getSimpleName()+
                " SET nombreC = ?, cedula = ? WHERE idCelador = ?");
        sql.setString(1, this.getNombreC());
        sql.setString(2, this.getCedula());
        sql.setInt(3, this.getIdCelador());
        sql.executeUpdate();
        System.out.println(this.getClass().getSimpleName()+" modificado correctamente");
    } catch (SQLException ex) {
        System.err.println("Error al modificar "+this.getClass().getSimpleName()+": "+ex.getMessage());
    }
    }
    
    public void eliminar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("DELETE FROM "+this.getClass().getSimpleName()+" WHERE idCelador = ?");
            sql.setInt(1, this.getIdCelador());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+" eliminado correctamente");
        } catch (SQLException ex){
            System.err.println("Error al eliminar "+this.getClass().getSimpleName()+": "+ex.getMessage());
        }
    }
}
