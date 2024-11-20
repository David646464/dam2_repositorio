/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package escenariocomplexo;

import escenariocomplexo.Database.DatabaseManager;
import escenariocomplexo.Objects.Can;
import escenariocomplexo.Objects.Propietario;
import escenariocomplexo.Objects.Vacina;
import escenariocomplexo.Objects.Vacinacion;
import escenariocomplexo.Utils.ErrorClass;
import escenariocomplexo.Utils.xestorXanelas;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Nitropc
 */
public class IFrmVacinacions extends javax.swing.JInternalFrame {

    private ComboBoxModel<Propietario> propietarios;
    private ComboBoxModel<Vacina> vacinas;
    private ComboBoxModel<Can> cans;

    /**
     * Creates new form IFrmVacinacions
     */
    public IFrmVacinacions() {
        initComponents();
        cargarPropietarios();
        cargarVacinas();
        this.setResizable(true);
        this.setSize(1200, 600);
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

        ComboCan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCHIP = new javax.swing.JLabel();
        comboCan = new javax.swing.JComboBox();
        comboPropietario = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboVacinacion = new javax.swing.JComboBox();
        btnVacinar = new javax.swing.JButton();
        txtObservacions = new javax.swing.JTextField();
        dateChooserData = new datechooser.beans.DateChooserCombo();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listVacinacions = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnPechar = new javax.swing.JButton();

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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        getContentPane().add(ComboCan, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aplicar Vacina"));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Vacina");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Observacions");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel6, gridBagConstraints);

        comboVacinacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(comboVacinacion, gridBagConstraints);

        btnVacinar.setText("Vacinar");
        btnVacinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVacinarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(btnVacinar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(txtObservacions, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(dateChooserData, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Vacinas Aplicadas"));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        listVacinacions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vacina", "Num. total doses", "Dose aplicada", "Data", "Observacions"
            }
        ));
        jScrollPane1.setViewportView(listVacinacions);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jScrollPane1, gridBagConstraints);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnEliminar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        getContentPane().add(jPanel4, gridBagConstraints);

        btnPechar.setText("Pechar");
        btnPechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnPechar)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnPechar)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel5, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void comboCanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCanItemStateChanged
        Can can = (Can) comboCan.getSelectedItem();

        if (can != null) {
            txtCHIP.setText("CHIP " + can.getChip());
            cargarVacinasEnTabla(can.getChip());
        } else {
            txtCHIP.setText("CHIP");
        }


    }//GEN-LAST:event_comboCanItemStateChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Vacinacion v = ((Vacinacion) listVacinacions.getModel().getValueAt(listVacinacions.getSelectedRow(), 4));
        int num;
        if ((num = DatabaseManager.existeVacinacionDeDoseSuperior(v.getCodVacina(), v.getDose(), v.getChip())) == 0) {
            DatabaseManager.eliminarUnhaVacinacionDadoSeuCodigo(v.getCodVacinacion());
            cargarVacinasEnTabla(v.getChip());
            System.out.println(num);
        } else {
            ErrorClass.mostrarError(17, this.getDesktopPane());
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVacinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVacinarActionPerformed
        if (todoCorrecto()) {
            Can c = ((Can) comboCan.getSelectedItem());
            Vacina v = ((Vacina) comboVacinacion.getSelectedItem());
            int numDose = DatabaseManager.recuperarUltimaDoseDunhaVacinaParaOCan(c.getChip(), v.getCodVacina());
            if (numDose < v.getNumTotalDoses()) {
                Vacinacion va  = new Vacinacion(0, c.getChip(), v.getCodVacina(), dateChooserData.getText(), txtObservacions.getText(), numDose + 1);
                DatabaseManager.inserirVacinacion(va);
                cargarVacinasEnTabla(c.getChip());
            } else {
                 ErrorClass.mostrarError(19, this.getDesktopPane());
            }
        } else {
            ErrorClass.mostrarError(18, this.getDesktopPane());
        }
    }//GEN-LAST:event_btnVacinarActionPerformed

    private void btnPecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPecharActionPerformed
        xestorXanelas.cerrarVacinacion();
        dispose();
    }//GEN-LAST:event_btnPecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ComboCan;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPechar;
    private javax.swing.JButton btnVacinar;
    private javax.swing.JComboBox comboCan;
    private javax.swing.JComboBox comboPropietario;
    private javax.swing.JComboBox comboVacinacion;
    private datechooser.beans.DateChooserCombo dateChooserData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listVacinacions;
    private javax.swing.JLabel txtCHIP;
    private javax.swing.JTextField txtObservacions;
    // End of variables declaration//GEN-END:variables

    private void cargarPropietarios() {

        ArrayList<Propietario> listaPropietarios = DatabaseManager.recuperarTodolosPropietarios();
        comboPropietario.removeAllItems();
        for (Propietario p : listaPropietarios) {
            comboPropietario.addItem(p);
        }

    }

    private void cargarVacinasEnTabla(String chip) {
        ArrayList<Vacinacion> vacinacions = DatabaseManager.recuperarTodalasVacinacionsDunCan(chip);
        if (vacinacions != null) {

            DefaultTableModel tableModel = (DefaultTableModel) listVacinacions.getModel();
            tableModel.setRowCount(0);
            for (Vacinacion v : vacinacions) {
                ArrayList<Vacina> vacina = DatabaseManager.recuperarUnhaVacinaDadoSeuCodigo(v.getCodVacina());
                Object[] linea = conseguirLinea(v, vacina.get(0), chip);
                tableModel.addRow(linea);

            }
        }
    }

    private Object[] conseguirLinea(Vacinacion v, Vacina vacina, String chip) {
        String nomVacina = vacina.getNomeVacina();
        String numDosesTotales = String.valueOf(vacina.getNumTotalDoses());
        String numDose = String.valueOf(v.getDose());
        String data = v.getData();

        Object[] linea = {nomVacina, numDosesTotales, numDose, data, v};
        return linea;

    }

    private void cargarVacinas() {
        ArrayList<Vacina> listaVacinas = DatabaseManager.recuperarTodalasVacinas();
        comboVacinacion.removeAllItems();
        for (Vacina p : listaVacinas) {
            comboVacinacion.addItem(p);
        }
    }

    private boolean todoCorrecto() {
        boolean cofirmacion = true;

        if (comboPropietario.getSelectedItem() == null) {
            cofirmacion = false;
        } else if (comboCan.getSelectedItem() == null) {
            cofirmacion = false;
        } else if (comboVacinacion.getSelectedItem() == null) {
            cofirmacion = false;
        } else if (txtObservacions.getText().isEmpty()) {
            cofirmacion = false;
        } else if (dateChooserData.getText().isEmpty()) {
            cofirmacion = false;
        }

        return cofirmacion;
    }
}
