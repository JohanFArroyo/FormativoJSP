/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Celador;

/**
 *
 * @author CGAO
 */
public class controladorCelador {
     public void controlarCelador(ActionEvent evento, Celador unCelador){
        String celador=evento.getActionCommand();
        switch (celador) {
            case "Insertar" -> unCelador.insertar();
            case "Modificar" -> unCelador.modificar();
            case "Eliminar" -> unCelador.eliminar();
        }
    }
}
