/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Entrada;

/**
 *
 * @author gutie
 */
public class controladorEntrada {
    public void controlarEntrada(ActionEvent evento, Entrada unEntrada){
        String entrada=evento.getActionCommand();
        switch (entrada) {
            case "Insertar" -> unEntrada.insertar();
            case "Modificar" -> unEntrada.modificar();
            case "Eliminar" -> unEntrada.eliminar();
        }
    }
}
