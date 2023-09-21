/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Aprendices;

/**
 *
 * @author CGAO
 */
public class controladorAprendices {
    public void controlarAprendices(ActionEvent evento, Aprendices unAprendices){
    String aprendices=evento.getActionCommand();
        switch (aprendices) {
            case "Insertar" -> unAprendices.insertar();
            case "Modificar" -> unAprendices.modificar();
            case "Eliminar" -> unAprendices.eliminar();
        }
    }
}
