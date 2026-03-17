/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import model.CuentaAhorros;
import model.CuentaBancaria;
import model.CuentaCorriente;
import service.CuentaBancariaService;
import service.ICuentaService;
import service.ServicioGUI;

/**
 *
 * @author jaiderclavijo
 */
public class GUICostoMensual extends javax.swing.JFrame implements ICambiable {

    ICuentaService service = CuentaBancariaService.getInstance();

    public GUICostoMensual() {
        initComponents();
        setLocationRelativeTo(this);
        ServicioGUI.getInstance().registrarGUI(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTitular = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTipoCuenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCostoMensual = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtInputNumCuenta = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calcular Costo Mensual");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new java.awt.GridLayout(0, 2, 10, 10));

        jLabel2.setText("Numero Cuenta:");
        jPanel1.add(jLabel2);

        txtNumCuenta.setEditable(false);
        jPanel1.add(txtNumCuenta);

        jLabel3.setText("Titular:");
        jPanel1.add(jLabel3);

        txtTitular.setEditable(false);
        jPanel1.add(txtTitular);

        jLabel4.setText("Saldo:");
        jPanel1.add(jLabel4);

        txtSaldo.setEditable(false);
        jPanel1.add(txtSaldo);

        jLabel5.setText("Tipo Cuenta:");
        jPanel1.add(jLabel5);

        txtTipoCuenta.setEditable(false);
        jPanel1.add(txtTipoCuenta);

        jLabel6.setText("Costo Mensual:");
        jPanel1.add(jLabel6);

        txtCostoMensual.setEditable(false);
        jPanel1.add(txtCostoMensual);

        jLabel1.setText("Ingrese numero de cuenta");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtInputNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtInputNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular)
                    .addComponent(btnBuscar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (txtInputNumCuenta.getText().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor ingrese un número");
                return;
            }
            int numBuscar = Integer.parseInt(txtInputNumCuenta.getText());
            CuentaBancaria cuenta = service.buscarPorNumero(numBuscar);
            if (cuenta != null && cuenta.getEstado().equalsIgnoreCase("Activo")) {
                txtNumCuenta.setText(String.valueOf(cuenta.getNumeroCuenta()));
                txtTitular.setText(cuenta.getTitular());
                txtSaldo.setText(String.valueOf(cuenta.getSaldo()));
                if (cuenta instanceof CuentaAhorros) {
                    txtTipoCuenta.setText("Ahorros");
                } else if (cuenta instanceof CuentaCorriente) {
                    txtTipoCuenta.setText("Corriente");
                }
                txtCostoMensual.setText("");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Cuenta no encontrada o inactiva");
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Ingrese solo números");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cuenta no encontrada");
            limpiarCampos();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (txtNumCuenta.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Primero debe buscar una cuenta");
            return;
        }
        try {
            // Referencia de tipo CuentaBancaria (clase abstracta)
            CuentaBancaria cuenta = service.buscarPorNumero(Integer.parseInt(txtNumCuenta.getText()));

            // POLIMORFISMO: misma llamada, resultado diferente según la clase real en tiempo de ejecución
            double costo = cuenta.calcularCostoMensual();

            txtCostoMensual.setText(String.valueOf(costo));
            javax.swing.JOptionPane.showMessageDialog(this,
                "Polimorfismo aplicado\n" +
                "Referencia: CuentaBancaria\n" +
                "Clase real: " + cuenta.getClass().getSimpleName() + "\n" +
                "Método: calcularCostoMensual()\n" +
                "Resultado: $" + costo);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al calcular: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

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
            java.util.logging.Logger.getLogger(GUICostoMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICostoMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICostoMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICostoMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICostoMensual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCostoMensual;
    private javax.swing.JTextField txtInputNumCuenta;
    private javax.swing.JTextField txtNumCuenta;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTipoCuenta;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables

    private void refrescarCuenta() {
        String numStr = txtNumCuenta.getText();
        if (!numStr.isEmpty()) {
            try {
                CuentaBancaria cuenta = service.buscarPorNumero(Integer.parseInt(numStr));
                if (cuenta != null && cuenta.getEstado().equalsIgnoreCase("Activo")) {
                    txtNumCuenta.setText(String.valueOf(cuenta.getNumeroCuenta()));
                    txtTitular.setText(cuenta.getTitular());
                    txtSaldo.setText(String.valueOf(cuenta.getSaldo()));
                    if (cuenta instanceof CuentaAhorros) {
                        txtTipoCuenta.setText("Ahorros");
                    } else if (cuenta instanceof CuentaCorriente) {
                        txtTipoCuenta.setText("Corriente");
                    }
                    txtCostoMensual.setText("");
                } else {
                    limpiarCampos();
                }
            } catch (Exception ex) {
                limpiarCampos();
            }
        }
    }

    private void limpiarCampos() {
        txtNumCuenta.setText("");
        txtTitular.setText("");
        txtSaldo.setText("");
        txtTipoCuenta.setText("");
        txtCostoMensual.setText("");
    }

    @Override
    public void cambio() {
        refrescarCuenta();
    }
}
