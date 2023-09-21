/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.controladorPortatil;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import modelo.Portatil;

/**
 *
 * @author CGAO
 */
public class FRMPortatil extends javax.swing.JInternalFrame {

    controladorPortatil portatilController = new controladorPortatil();
    
    public FRMPortatil() {
        initComponents();
        idPortatil.setValue(0);
        idPortatil.setVisible(false);
        limpiarFormulario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idPortatil = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tMarca = new javax.swing.JTextField();
        tCodigo = new javax.swing.JTextField();
        bInsertar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taPortatil = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Formulario Portatil");

        idPortatil.setText("0");

        jLabel1.setText("Marca:");

        jLabel2.setText("Codigo:");

        tMarca.setText("Marca");

        tCodigo.setText("Codigo");

        bInsertar.setText("Insertar");
        bInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsertarActionPerformed(evt);
            }
        });

        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        taPortatil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idPortatil", "Marca", "Codigo"
            }
        ));
        taPortatil.setEnabled(false);
        taPortatil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taPortatilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taPortatil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(idPortatil, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bInsertar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bModificar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(7, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(idPortatil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(bInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(bModificar)
                        .addGap(18, 18, 18)
                        .addComponent(bEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void taPortatilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taPortatilMouseClicked
        if (evt.getClickCount()==2) {
            int fila = taPortatil.rowAtPoint(evt.getPoint());
            if (fila>-1) {
                idPortatil.setValue((Integer)taPortatil.getValueAt(fila, 0));
                tMarca.setText((String)taPortatil.getValueAt(fila, 1));
                tCodigo.setText((String)taPortatil.getValueAt(fila, 2));
                bModificar.setEnabled(true);
                bEliminar.setEnabled(true);
            }
        }

    }//GEN-LAST:event_taPortatilMouseClicked

    private void bInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsertarActionPerformed
        portatilController.controlarPortatil(evt, obtenerPortatil());
        limpiarFormulario();
    }//GEN-LAST:event_bInsertarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        portatilController.controlarPortatil(evt, obtenerPortatil());
        limpiarFormulario();
    }//GEN-LAST:event_bModificarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        portatilController.controlarPortatil(evt, obtenerPortatil());
        limpiarFormulario();
    }//GEN-LAST:event_bEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bInsertar;
    private javax.swing.JButton bModificar;
    private javax.swing.JFormattedTextField idPortatil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCodigo;
    private javax.swing.JTextField tMarca;
    private javax.swing.JTable taPortatil;
    // End of variables declaration//GEN-END:variables
    private void limpiarFormulario(){
        idPortatil.setValue(0);
        tMarca.setText("Ingrese M");
        tCodigo.setText("Ingrese C");
        bModificar.setEnabled(false);
        bEliminar.setEnabled(false);
        llenarTabla();
    }
    
    public void llenarTabla(){
        Portatil unPortatil = new Portatil();
        DefaultTableModel tabla = (DefaultTableModel)taPortatil.getModel();
        Iterator<Portatil> itPortatil = unPortatil.listar();
        Object[] filaPortatil = new Object[taPortatil.getColumnCount()];
        tabla.setRowCount(0);
        while (itPortatil.hasNext()) {
            unPortatil = itPortatil.next();
            filaPortatil[0] = unPortatil.getIdPortatil();
            filaPortatil[1] = unPortatil.getMarcaP();
            filaPortatil[2] = unPortatil.getCodigoP();
            tabla.addRow(filaPortatil);
        }
    }
    private Portatil obtenerPortatil(){
        Portatil elPortatil = new Portatil();
        elPortatil.setIdPortatil((Integer) idPortatil.getValue());
        elPortatil.setMarcaP(tMarca.getText());
        elPortatil.setCodigoP(tCodigo.getText());
        return elPortatil;
    }
}
