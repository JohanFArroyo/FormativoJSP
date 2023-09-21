/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Portatil;

/**
 *
 * @author CGAO
 */
public class controladorPortatil {
     public void controlarPortatil(ActionEvent evento, Portatil unPortatil){
        String portatil=evento.getActionCommand();
        switch (portatil) {
            case "Insertar" -> unPortatil.insertar();
            case "Modificar" -> unPortatil.modificar();
            case "Eliminar" -> unPortatil.eliminar();
        }
    }
}
