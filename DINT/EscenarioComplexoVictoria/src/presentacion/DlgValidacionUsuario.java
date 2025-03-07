/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import bd.Conexion;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author DAM 2
 */
public class DlgValidacionUsuario extends javax.swing.JDialog {

    /**
     * Creates new form DlgValidacionUsuario
     */
    public DlgValidacionUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        //Establecemos o botón por defecto. Algo de usabilidade....
        JRootPane rootPane = SwingUtilities.getRootPane(btnConectar); 
        rootPane.setDefaultButton(btnConectar);//esta linea y la aterior hace que vaya el enter para conectar
        pnlDetalles.setVisible(false);
        //Poñemos o foco na password
        SwingUtilities.invokeLater(new Runnable() {//pone el puntero directamente en la contraseña
        public void run() {
            pwfContrasinal.requestFocus();
          }
        });
        
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

        lblImaxe = new javax.swing.JLabel();
        pnlUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblContrasinal = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        pwfContrasinal = new javax.swing.JPasswordField();
        pnlDetalles = new javax.swing.JPanel();
        lblIPServidor = new javax.swing.JLabel();
        txtIPServidor = new javax.swing.JTextField();
        lblPorto = new javax.swing.JLabel();
        txtPorto = new javax.swing.JTextField();
        pnlBotons = new javax.swing.JPanel();
        btnConectar = new javax.swing.JButton();
        btnPechar = new javax.swing.JButton();
        btnDetalles = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Validación de usuario");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(4, 0));

        lblImaxe.setText("jLabel1");
        getContentPane().add(lblImaxe);

        pnlUsuario.setLayout(new java.awt.GridBagLayout());

        lblUsuario.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        pnlUsuario.add(lblUsuario, gridBagConstraints);

        lblContrasinal.setText("Contrasinal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pnlUsuario.add(lblContrasinal, gridBagConstraints);

        txtUsuario.setText("root");
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        pnlUsuario.add(txtUsuario, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        pnlUsuario.add(pwfContrasinal, gridBagConstraints);

        getContentPane().add(pnlUsuario);

        pnlDetalles.setLayout(new java.awt.GridLayout(2, 2));

        lblIPServidor.setText("IP Servidor");
        pnlDetalles.add(lblIPServidor);

        txtIPServidor.setText("localhost");
        pnlDetalles.add(txtIPServidor);

        lblPorto.setText("Porto");
        pnlDetalles.add(lblPorto);

        txtPorto.setText("3306");
        pnlDetalles.add(txtPorto);

        getContentPane().add(pnlDetalles);

        pnlBotons.setLayout(new javax.swing.BoxLayout(pnlBotons, javax.swing.BoxLayout.X_AXIS));

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });
        pnlBotons.add(btnConectar);

        btnPechar.setText("Pechar");
        btnPechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPecharActionPerformed(evt);
            }
        });
        pnlBotons.add(btnPechar);

        btnDetalles.setText("Detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        pnlBotons.add(btnDetalles);

        getContentPane().add(pnlBotons);

        setSize(new java.awt.Dimension(422, 226));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        // TODO add your handling code here:
        String usuario=txtUsuario.getText().trim();
        if(usuario.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Debe indicar o usuario para conectarse á base de datos", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String contrasinal=new String(pwfContrasinal.getPassword());        
        
        String ipServidor=txtIPServidor.getText().trim();
        if(ipServidor.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Debe indicar a dirección do servidor de base de datos", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }  
        
        String porto=txtPorto.getText().trim();
        if(porto.compareTo("")==0)
        {
            JOptionPane.showMessageDialog(this, "Debe indicar o porto de servidor de base de datos", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }          
        
        int resultado=Conexion.conectar(ipServidor, porto, usuario, "clinica", contrasinal);
//        if(resultado==0)
//        {
//            ((FrmPrincipal)getParent()).activarAplicacion();
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(this, "Ocurreu un erro ao intentar conectar coa base de datos, Erro "+resultado+"\nPóñase en contacto co administrador", "Atención", JOptionPane.WARNING_MESSAGE);
//            System.exit(2);
//        }
        if(resultado!=0)
        {
            JOptionPane.showMessageDialog(this, "Ocurreu un erro ao intentar conectar coa base de datos, Erro "+resultado+"\nPóñase en contacto co administrador", "Atención", JOptionPane.WARNING_MESSAGE);
            System.exit(2);
        }
        conectado=true;
        dispose();
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnPecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPecharActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnPecharActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if(!conectado) System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        pnlDetalles.setVisible(btnDetalles.isSelected() );
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        btnConectar.setEnabled(!txtUsuario.getText().equals(""));
    }//GEN-LAST:event_txtUsuarioKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgValidacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgValidacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgValidacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgValidacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgValidacionUsuario dialog = new DlgValidacionUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JToggleButton btnDetalles;
    private javax.swing.JButton btnPechar;
    private javax.swing.JLabel lblContrasinal;
    private javax.swing.JLabel lblIPServidor;
    private javax.swing.JLabel lblImaxe;
    private javax.swing.JLabel lblPorto;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlBotons;
    private javax.swing.JPanel pnlDetalles;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JPasswordField pwfContrasinal;
    private javax.swing.JTextField txtIPServidor;
    private javax.swing.JTextField txtPorto;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    boolean conectado=false;
}
