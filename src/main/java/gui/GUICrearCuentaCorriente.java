/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import javax.swing.JOptionPane;
import service.CuentaBancariaService;
import service.ICuentaService;
import service.ServicioGUI;

/**
 *
 * @author sdlgv
 */
public class GUICrearCuentaCorriente extends javax.swing.JFrame {

    ICuentaService service = CuentaBancariaService.getInstance();

    public GUICrearCuentaCorriente() {
        initComponents();
        setLocationRelativeTo(this);
        setTarjetaFieldsEnabled(false);
    }

    private void setTarjetaFieldsEnabled(boolean enabled) {
        txtNumeroTarjeta.setEnabled(enabled);
        txtCupo.setEnabled(enabled);
        txtCuotaManejo.setEnabled(enabled);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTitular = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLimtSobreGiro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtComision = new javax.swing.JTextField();
        chkAsociarTarjeta = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroTarjeta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCupo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCuotaManejo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Cuenta Corriente");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new java.awt.GridLayout(0, 2, 10, 10));

        jLabel1.setText("Numero Cuenta:");
        jPanel1.add(jLabel1);
        jPanel1.add(txtNumCuenta);

        jLabel2.setText("Titular:");
        jPanel1.add(jLabel2);
        jPanel1.add(txtTitular);

        jLabel3.setText("Saldo:");
        jPanel1.add(jLabel3);
        jPanel1.add(txtSaldo);

        jLabel4.setText("Limite sobre giro:");
        jPanel1.add(jLabel4);
        jPanel1.add(txtLimtSobreGiro);

        jLabel5.setText("Comision:");
        jPanel1.add(jLabel5);
        jPanel1.add(txtComision);

        chkAsociarTarjeta.setText("Asociar Tarjeta de Crédito");
        chkAsociarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAsociarTarjetaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new java.awt.GridLayout(0, 2, 10, 10));

        jLabel6.setText("Numero Tarjeta:");
        jPanel2.add(jLabel6);
        jPanel2.add(txtNumeroTarjeta);

        jLabel7.setText("Cupo:");
        jPanel2.add(jLabel7);
        jPanel2.add(txtCupo);

        jLabel8.setText("Cuota Manejo:");
        jPanel2.add(jLabel8);
        jPanel2.add(txtCuotaManejo);

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkAsociarTarjeta)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkAsociarTarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkAsociarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAsociarTarjetaActionPerformed
        setTarjetaFieldsEnabled(chkAsociarTarjeta.isSelected());
    }//GEN-LAST:event_chkAsociarTarjetaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int num = Integer.parseInt(txtNumCuenta.getText());
            String titu = txtTitular.getText();
            double sal = Double.parseDouble(txtSaldo.getText());
            double sobre = Double.parseDouble(txtLimtSobreGiro.getText());
            double comi = Double.parseDouble(txtComision.getText());

            service.crearCuentaCorriente(num, titu, sal, sobre, comi);
            ServicioGUI.getInstance().cambioEnGUI();

            if (chkAsociarTarjeta.isSelected()) {
                String numTarjeta = txtNumeroTarjeta.getText().trim();
                if (numTarjeta.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "El número de tarjeta no puede estar vacío.");
                    return;
                }
                double cupo = Double.parseDouble(txtCupo.getText());
                double cuota = Double.parseDouble(txtCuotaManejo.getText());
                service.asociarTarjetaCredito(num, numTarjeta, cupo, cuota);
                ServicioGUI.getInstance().cambioEnGUI();
                JOptionPane.showMessageDialog(this, "Cuenta corriente y tarjeta creadas exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Cuenta creada exitosamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Revisa que los campos numéricos sean correctos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUICrearCuentaCorriente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICrearCuentaCorriente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICrearCuentaCorriente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICrearCuentaCorriente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICrearCuentaCorriente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkAsociarTarjeta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtComision;
    private javax.swing.JTextField txtCuotaManejo;
    private javax.swing.JTextField txtCupo;
    private javax.swing.JTextField txtLimtSobreGiro;
    private javax.swing.JTextField txtNumCuenta;
    private javax.swing.JTextField txtNumeroTarjeta;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
