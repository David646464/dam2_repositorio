/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package escenariocomplexo;

import escenariocomplexo.Database.DatabaseManager;
import escenariocomplexo.Objects.Can;
import escenariocomplexo.Objects.Cita;
import escenariocomplexo.Objects.Propietario;
import escenariocomplexo.Utils.ErrorClass;
import escenariocomplexo.Utils.xestorXanelas;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Nitropc
 */
public class IFrmXestionPerruqueria extends javax.swing.JInternalFrame {
    
    
    

    /**
     * Creates new form IFrmXestionPerruqueria
     */
    public IFrmXestionPerruqueria() {
        initComponents();
        this.setResizable(true);
        cargarPropietarios();
        atribuirValoresBotones();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateChooserData.setDateFormat(dateFormat);
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

        botonHoras = new javax.swing.ButtonGroup();
        ComboCan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCHIP = new javax.swing.JLabel();
        comboCan = new javax.swing.JComboBox();
        comboPropietario = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dateChooserData = new datechooser.beans.DateChooserCombo();
        jButton1 = new javax.swing.JButton();
        boton12 = new javax.swing.JRadioButton();
        boton10 = new javax.swing.JRadioButton();
        boton16 = new javax.swing.JRadioButton();
        boton11 = new javax.swing.JRadioButton();
        boton17 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnReservar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        ComboCan.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Propietario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        ComboCan.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Can");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        ComboCan.add(jLabel2, gridBagConstraints);

        txtCHIP.setText("CHIP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        ComboCan.add(txtCHIP, gridBagConstraints);

        comboCan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCanItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        ComboCan.add(comboCan, gridBagConstraints);

        comboPropietario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPropietario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPropietarioItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        ComboCan.add(comboPropietario, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(ComboCan, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cita"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 69;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(dateChooserData, gridBagConstraints);

        jButton1.setText("Nova data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        botonHoras.add(boton12);
        boton12.setText("12.00h");
        boton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(boton12, gridBagConstraints);

        botonHoras.add(boton10);
        boton10.setText("10.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(boton10, gridBagConstraints);

        botonHoras.add(boton16);
        boton16.setText("16.00h");
        boton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton16ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(boton16, gridBagConstraints);

        botonHoras.add(boton11);
        boton11.setText("11.00h");
        boton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton11ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(boton11, gridBagConstraints);

        botonHoras.add(boton17);
        boton17.setText("17.00h");
        boton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton17ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(boton17, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel2.add(btnReservar, gridBagConstraints);

        jButton3.setText("Pechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel2.add(jButton3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCanItemStateChanged
        Can can = (Can) comboCan.getSelectedItem();

        if (can != null) {
            txtCHIP.setText("CHIP " + can.getChip());
        } else {
            txtCHIP.setText("CHIP");
        }

    }//GEN-LAST:event_comboCanItemStateChanged

    private void comboPropietarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPropietarioItemStateChanged
        Propietario propietario = (Propietario) comboPropietario.getSelectedItem();
        comboCan.removeAllItems();
        if (propietario != null) {
            ArrayList<Can> cans = DatabaseManager.recuperarTodolosCansDunPropietario(propietario.getDni());
            for (Can c : cans) {
                comboCan.addItem(c);
            }
        }
    }//GEN-LAST:event_comboPropietarioItemStateChanged

    private void boton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton16ActionPerformed

    private void boton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton17ActionPerformed

    private void boton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton11ActionPerformed

    private void boton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String data = dateChooserData.getText();
        ArrayList<Cita> citas = DatabaseManager.citasPorFecha(data);
        boton10.setForeground(Color.GREEN);
        boton11.setForeground(Color.GREEN);
        boton12.setForeground(Color.GREEN);
        boton16.setForeground(Color.GREEN);
        boton17.setForeground(Color.GREEN);

        boton10.setEnabled(true);
        boton11.setEnabled(true);
        boton12.setEnabled(true);
        boton16.setEnabled(true);
        boton17.setEnabled(true);
        for (Cita c : citas) {

            switch (c.getHora()) {
                case 10 -> {
                    boton10.setForeground(Color.red);
                    boton10.setEnabled(false);
                }
                case 11 -> {
                    boton11.setForeground(Color.red);
                    boton11.setEnabled(false);
                }
                case 12 -> {
                    boton12.setForeground(Color.red);
                    boton12.setEnabled(false);
                }
                case 16 -> {
                    boton16.setForeground(Color.red);
                    boton16.setEnabled(false);
                }
                case 17 -> {
                    boton17.setForeground(Color.red);
                    boton17.setEnabled(false);

                }
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed

        if (todoCorrecto()) {
            DatabaseManager.inserirCitaPerruqueria(new Cita(0, Integer.valueOf(((Can) comboCan.getSelectedItem()).getChip()), dateChooserData.getText(), horaSeleccionada()));
            jButton1ActionPerformed(evt);
        } else {

        }

    }//GEN-LAST:event_btnReservarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        xestorXanelas.cerrarPerruqueria();
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    private void cargarPropietarios() {

        ArrayList<Propietario> listaPropietarios = DatabaseManager.recuperarTodolosPropietarios();
        comboPropietario.removeAllItems();
        for (Propietario p : listaPropietarios) {
            comboPropietario.addItem(p);
        }

    }

    private int horaSeleccionada() {
        int valueInt = 0;
        switch (botonHoras.getSelection().getActionCommand()) {
            case "10" ->
                valueInt = 10;
            case "11" ->
                valueInt = 11;
            case "12" ->
                valueInt = 12;
            case "16" ->
                valueInt = 16;
            case "17" ->
                valueInt = 17;

        }
        return valueInt;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ComboCan;
    private javax.swing.JRadioButton boton10;
    private javax.swing.JRadioButton boton11;
    private javax.swing.JRadioButton boton12;
    private javax.swing.JRadioButton boton16;
    private javax.swing.JRadioButton boton17;
    private javax.swing.ButtonGroup botonHoras;
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox comboCan;
    private javax.swing.JComboBox comboPropietario;
    private datechooser.beans.DateChooserCombo dateChooserData;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtCHIP;
    // End of variables declaration//GEN-END:variables

    private void atribuirValoresBotones() {
        boton10.setActionCommand("10");
        boton11.setActionCommand("11");
        boton12.setActionCommand("12");
        boton16.setActionCommand("16");
        boton17.setActionCommand("17");
    }

    private boolean todoCorrecto() {
        boolean todoOK = true;

        if (botonHoras.getSelection() == null) {
            todoOK = false;
            ErrorClass.mostrarError(20, this.getDesktopPane());
                    
        }else if (comboCan.getSelectedItem() == null){
            todoOK = false;
            ErrorClass.mostrarError(21, this.getDesktopPane());
        }
        
        return todoOK;
    }
}
