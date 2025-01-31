/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package presentacion;

import bd.ConsultasSQL;
import bd.ConsultasSQLPerrucaria;
import clases.Can;
import clases.CitaPerrucaria;
import clases.Propietario;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders;
import utilidades.Datas;

/**
 *
 * @author usuario
 */
public class IFrmXestionPerruqueria extends javax.swing.JInternalFrame {

    DefaultComboBoxModel<Propietario> modeloPropietarios;
    DefaultComboBoxModel<Can> modeloCans;
    JRadioButton[] rdButon;
    /**
     * Creates new form IFrmXestionPerruqueria
     */
    public IFrmXestionPerruqueria() {
        initComponents();
        rdButon = new JRadioButton[]{rbDiez,rbOnce,rbDoce,rbCuatro,rbCinco};
        modeloPropietarios = new DefaultComboBoxModel<Propietario>();
        cmbPropietario.setModel(modeloPropietarios);
        modeloCans = new DefaultComboBoxModel<Can>();
        cmbCan.setModel(modeloCans);
        cargarPropietarios();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        conjuntoDeHoras = new javax.swing.ButtonGroup();
        lblPropietario = new javax.swing.JLabel();
        cmbPropietario = new javax.swing.JComboBox();
        lblCan = new javax.swing.JLabel();
        cmbCan = new javax.swing.JComboBox();
        pnlCitas = new javax.swing.JPanel();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        btnNovaData = new javax.swing.JButton();
        rbDiez = new javax.swing.JRadioButton();
        rbCuatro = new javax.swing.JRadioButton();
        rbOnce = new javax.swing.JRadioButton();
        rbCinco = new javax.swing.JRadioButton();
        rbDoce = new javax.swing.JRadioButton();
        btnReservar = new javax.swing.JButton();
        btnPechar = new javax.swing.JButton();

        setResizable(true);
        setMinimumSize(new java.awt.Dimension(500, 200));
        setName(""); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblPropietario.setText("Propietario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(lblPropietario, gridBagConstraints);

        cmbPropietario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPropietario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPropietarioItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(cmbPropietario, gridBagConstraints);

        lblCan.setText("Can");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(lblCan, gridBagConstraints);

        cmbCan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCanItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(cmbCan, gridBagConstraints);

        pnlCitas.setBorder(javax.swing.BorderFactory.createTitledBorder("Cita"));
        pnlCitas.setLayout(new java.awt.GridBagLayout());

        lblData.setText("Data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        pnlCitas.add(lblData, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlCitas.add(txtData, gridBagConstraints);

        btnNovaData.setText("Nova data");
        btnNovaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaDataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlCitas.add(btnNovaData, gridBagConstraints);

        conjuntoDeHoras.add(rbDiez);
        rbDiez.setText("10.00h");
        rbDiez.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlCitas.add(rbDiez, gridBagConstraints);

        conjuntoDeHoras.add(rbCuatro);
        rbCuatro.setText("16.00h");
        rbCuatro.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlCitas.add(rbCuatro, gridBagConstraints);

        conjuntoDeHoras.add(rbOnce);
        rbOnce.setText("11.00h");
        rbOnce.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlCitas.add(rbOnce, gridBagConstraints);

        conjuntoDeHoras.add(rbCinco);
        rbCinco.setText("17.00h");
        rbCinco.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlCitas.add(rbCinco, gridBagConstraints);

        conjuntoDeHoras.add(rbDoce);
        rbDoce.setText("12.00h");
        rbDoce.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlCitas.add(rbDoce, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlCitas, gridBagConstraints);

        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(btnReservar, gridBagConstraints);

        btnPechar.setText("Pechar");
        btnPechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPecharActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(btnPechar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarPropietarios() {
        modeloPropietarios.removeAllElements();
        Vector propietarios = ConsultasSQL.recuperarTodolosPropietarios();
        if (propietarios == null) {
            JOptionPane.showMessageDialog(this, "Ocurreu un erro de base de datos ao recuperar os propietarios. Erro -10. Póñase en contacto co administrador", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            for (int i = 0; i < propietarios.size(); i++) {
                modeloPropietarios.addElement((Propietario) propietarios.elementAt(i));
            }
        }
    }

    private void cargarCans(String dni) {
        modeloCans.removeAllElements();
        Vector cans = ConsultasSQL.recuperarTodolosCansDunPropietario(dni);
        if (cans == null) {
            JOptionPane.showMessageDialog(this, "Ocurreu un erro de base de datos ao recuperar os cans do propietario. Erro -11. Póñase en contacto co administrador", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            for (int i = 0; i < cans.size(); i++) {
                modeloCans.addElement((Can) cans.elementAt(i));
            }
        }
    }

    private void mostrarDisponibilidadHoras(String data) {
        ArrayList<CitaPerrucaria> horasDisponibles = ConsultasSQLPerrucaria.recuperarTodaAsCitasDunhaData(data);
        
        
        for(JRadioButton buton : rdButon){
            buton.setForeground(Color.GREEN);
            buton.setEnabled(true);
            String textoBoton = buton.getText();
            
            for(CitaPerrucaria cita : horasDisponibles){
                String hora = cita.getHora00();
                if(textoBoton.equals(hora)){
                    buton.setForeground(Color.RED);
                    buton.setEnabled(false);
                }
            }
        }
    }

    private void cmbCanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCanItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCanItemStateChanged

    private void cmbPropietarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPropietarioItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String dniPropietario = modeloPropietarios.getElementAt(cmbPropietario.getSelectedIndex()).getDni();
            cargarCans(dniPropietario);
        }
    }//GEN-LAST:event_cmbPropietarioItemStateChanged

    private void btnNovaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaDataActionPerformed
        // TODO add your handling code here:
        
        if(txtData.isEditable()){
            txtData.setEnabled(true);
            btnNovaData.setText("amosar citas");
        }
        
        String data = txtData.getText();
       
        if(!Datas.isData_Dia_BARRA_Mes_BARRA_Anho_Valida(data)){
            JOptionPane.showMessageDialog(this, "A data non he valida", "atencion", JOptionPane.ERROR_MESSAGE);
        }else{
            String dataBD = Datas.Data_Dia_BARRA_Mes_BARRA_AnhoAFormatoMySQLYYYY_GUION_MM_GUION_DD(data);
            mostrarDisponibilidadHoras(dataBD);
        }
       
        
    }//GEN-LAST:event_btnNovaDataActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        // TODO add your handling code here:
        Can can = (Can)cmbCan.getSelectedItem();
        if(can == null){
            JOptionPane.showMessageDialog(this, "Error,debe seleccionar un can", "atencion", JOptionPane.ERROR_MESSAGE);
        }
        
        String codPerro = can.getChip().trim();
        String data = txtData.getText().trim();
        if(data.isEmpty()){
            JOptionPane.showMessageDialog(this, "Error,debe añadir unha data", "atencion", JOptionPane.ERROR_MESSAGE);
        }
        
        String dataBD = Datas.Data_Dia_BARRA_Mes_BARRA_AnhoAFormatoMySQLYYYY_GUION_MM_GUION_DD(data);
        
        String textoSeleccionado = "";
        for(JRadioButton boton : rdButon){
            if(boton.isSelected()){
                textoSeleccionado = boton.getText();
                break;
            }
        }
        
        String hora = textoSeleccionado.substring(0,2);
        
        CitaPerrucaria cita = new CitaPerrucaria(codPerro, dataBD, Integer.parseInt(hora));
        
        if(ConsultasSQLPerrucaria.inserirCitaPerrucaria(cita) == 0){
            JOptionPane.showMessageDialog(this, "Cita grabada", "atencion", JOptionPane.INFORMATION_MESSAGE);
            mostrarDisponibilidadHoras(dataBD);
        }else{
            JOptionPane.showMessageDialog(this, "Error al insertar la cita", "atencion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnPecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnPecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovaData;
    private javax.swing.JButton btnPechar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox cmbCan;
    private javax.swing.JComboBox cmbPropietario;
    private javax.swing.ButtonGroup conjuntoDeHoras;
    private javax.swing.JLabel lblCan;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblPropietario;
    private javax.swing.JPanel pnlCitas;
    private javax.swing.JRadioButton rbCinco;
    private javax.swing.JRadioButton rbCuatro;
    private javax.swing.JRadioButton rbDiez;
    private javax.swing.JRadioButton rbDoce;
    private javax.swing.JRadioButton rbOnce;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
