/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package presentacion;

import bd.ConsultasSQL;
import bd.ConsultasSQLPerrucaria;
import clases.ListadoPerrucaria;
import clases.Vacina;
import clases.Vacinacion;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilidades.Datas;
import utilidades.JTextFieldHintUI;

/**
 *
 * @author usuario
 */
public class IFrmListarCitas extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla;

    /**
     * Creates new form IFrmListarCitas
     */
    public IFrmListarCitas() {
        initComponents();
        pnlBusquedaFecha.setVisible(false);
        txtDesde.setUI(new JTextFieldHintUI("desde", Color.gray));//asi se pone el hint
        txtDesde.setUI(new JTextFieldHintUI("ata", Color.gray));
        modeloTabla = (DefaultTableModel) tblLista.getModel();
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

        pnlBusqueda = new javax.swing.JPanel();
        cmbFiltro = new javax.swing.JComboBox<>();
        pnlBusquedaFecha = new javax.swing.JPanel();
        txtDesde = new javax.swing.JTextField();
        txtAta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        pnlResultados = new javax.swing.JPanel();
        srllLista = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda de citas"));
        pnlBusqueda.setLayout(new java.awt.GridBagLayout());

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "    ", "Data" }));
        cmbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFiltroItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlBusqueda.add(cmbFiltro, gridBagConstraints);

        pnlBusquedaFecha.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlBusquedaFecha.add(txtDesde, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 115;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlBusquedaFecha.add(txtAta, gridBagConstraints);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlBusquedaFecha.add(btnBuscar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.7;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlBusqueda.add(pnlBusquedaFecha, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlBusqueda, gridBagConstraints);

        pnlResultados.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados da búsqueda"));
        pnlResultados.setLayout(new java.awt.GridBagLayout());

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PROPIETARIO", "CAN", "DATA", "HORA"
            }
        ));
        srllLista.setViewportView(tblLista);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlResultados.add(srllLista, gridBagConstraints);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlResultados.add(btnEliminar, gridBagConstraints);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlResultados.add(btnCerrar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.7;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlResultados, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFiltroItemStateChanged
        // TODO add your handling code here:

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String palabraSeleccionada = (String) cmbFiltro.getSelectedItem();
            if (palabraSeleccionada.equals("Data")) {
                pnlBusquedaFecha.setVisible(true);
            }
        }
    }//GEN-LAST:event_cmbFiltroItemStateChanged

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        boolean fecha1Correcta = Datas.isData_Dia_BARRA_Mes_BARRA_Anho_Valida(txtDesde.getText());
        boolean fecha2Correcta = Datas.isData_Dia_BARRA_Mes_BARRA_Anho_Valida(txtAta.getText());

        if (!fecha1Correcta) {
            JOptionPane.showMessageDialog(this, "La fecha 1 es incorrecta, el fermato debe ser dd/MM/yyyy", "Atención", JOptionPane.WARNING_MESSAGE);
            txtDesde.setText("");
            return;
        }
        if (!fecha2Correcta) {
            JOptionPane.showMessageDialog(this, "La fecha 2 es incorrecta, el fermato debe ser dd/MM/yyyy", "Atención", JOptionPane.WARNING_MESSAGE);
            txtAta.setText("");
            return;
        }

        int comprobarFechas = Datas.compararDatasEnFormatoDia_BARRA_Mes_BARRA_Anho(txtDesde.getText(), txtAta.getText());

        if (comprobarFechas == 3) {
            JOptionPane.showMessageDialog(this, "la primera fecha es despues que la segunda, la primera fecha debe ser de antes que la segunda", "Atención", JOptionPane.WARNING_MESSAGE);
            txtDesde.setText("");
            return;
        }

        cargarCitas();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(tblLista.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this, "Debe indicar a cita que desexa eliminar", "Atención", JOptionPane.WARNING_MESSAGE);
            return;                        
        }else{
            ListadoPerrucaria citaSeleccionada = (ListadoPerrucaria) tblLista.getValueAt(tblLista.getSelectedRow(), 0);
            int eliminar = ConsultasSQLPerrucaria.eliminarUnhaCitaDadoSeuCodigo(citaSeleccionada.getCodCita());
            if(eliminar == 0){
                JOptionPane.showMessageDialog(this, "Cita eliminada correctamente", "Atención", JOptionPane.WARNING_MESSAGE);
                cargarCitas();
            }else{
                JOptionPane.showMessageDialog(this, "No ha sido posible eliminar la cita. intentelo de nuevo", "Atención", JOptionPane.WARNING_MESSAGE);
            }
        } 
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlBusquedaFecha;
    private javax.swing.JPanel pnlResultados;
    private javax.swing.JScrollPane srllLista;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtAta;
    private javax.swing.JTextField txtDesde;
    // End of variables declaration//GEN-END:variables


    public void cargarCitas(){
        String fecha1FormatoBueno = Datas.Data_Dia_BARRA_Mes_BARRA_AnhoAFormatoMySQLYYYY_GUION_MM_GUION_DD(txtDesde.getText());
        String fecha2FormatoBueno = Datas.Data_Dia_BARRA_Mes_BARRA_AnhoAFormatoMySQLYYYY_GUION_MM_GUION_DD(txtAta.getText());

        modeloTabla.setRowCount(0);
        Vector listaCitas = ConsultasSQLPerrucaria.recuperarTodaAsCitasDePerrucariaEntreDuasDatas(fecha1FormatoBueno, fecha2FormatoBueno);
        if (listaCitas == null) {
            JOptionPane.showMessageDialog(this, "Ocurreu un erro de base de datos ao recuperar a lista de citas entre las fechas", "Atención", JOptionPane.WARNING_MESSAGE);
            modeloTabla.setRowCount(0);
            return;
        } else {
            /*for (int i = 0; i < listaCitas.size(); i++) {
                System.out.println("Elemento " + i + ": " + listaCitas.elementAt(i));
            }*/
            for (int i = 0; i < listaCitas.size(); i++) {
                //primero hay que comvertir cada elemento de listacitas a ListadoPerriqueria por que asi ya podemos coger directamente de aqui lo que nos conviene para cada columna
                ListadoPerrucaria cita = (ListadoPerrucaria) listaCitas.elementAt(i);
                int filaActual = modeloTabla.getRowCount();
                modeloTabla.setRowCount(filaActual + 1);
                modeloTabla.setValueAt(cita.getPropietario(), filaActual, 0);
                modeloTabla.setValueAt(cita.getCan(), filaActual, 1);
                modeloTabla.setValueAt(cita.getData(), filaActual, 2);
                modeloTabla.setValueAt(cita.getHora(), filaActual, 3);
            }
        }
    }
}
