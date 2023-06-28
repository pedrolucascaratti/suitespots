/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prog.orient.objeto.suitespots.views;

import prog.orient.objeto.suitespots.controller.Router;

/**
 *
 * @author gabri
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        Router.getInstance().setHome(this);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtHome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        cInclusao = new javax.swing.JMenuItem();
        cEdicao = new javax.swing.JMenuItem();
        cExclusao = new javax.swing.JMenuItem();
        cConsulta = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        txtHome.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        txtHome.setText("SuiteSpots");

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu3.setText("Cadastro");

        jMenu4.setText("Cliente");

        cInclusao.setText("Inclusão");
        cInclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cInclusaoActionPerformed(evt);
            }
        });
        jMenu4.add(cInclusao);

        cEdicao.setText("Edição");
        cEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEdicaoActionPerformed(evt);
            }
        });
        jMenu4.add(cEdicao);

        cExclusao.setText("Exclusão");
        cExclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cExclusaoActionPerformed(evt);
            }
        });
        jMenu4.add(cExclusao);

        cConsulta.setText("Consulta");
        cConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cConsultaActionPerformed(evt);
            }
        });
        jMenu4.add(cConsulta);

        jMenu3.add(jMenu4);

        jMenu6.setText("Quarto");

        jMenuItem15.setText("Inclusão");
        jMenu6.add(jMenuItem15);

        jMenuItem16.setText("Edição");
        jMenu6.add(jMenuItem16);

        jMenuItem17.setText("Exclusão");
        jMenu6.add(jMenuItem17);

        jMenuItem18.setText("Consulta");
        jMenu6.add(jMenuItem18);

        jMenu3.add(jMenu6);

        jMenuBar1.add(jMenu3);

        jMenu7.setText("Reserva");

        jMenuItem9.setText("Nova");
        jMenu7.add(jMenuItem9);

        jMenuItem10.setText("Editar");
        jMenu7.add(jMenuItem10);

        jMenuItem11.setText("Excluir");
        jMenu7.add(jMenuItem11);

        jMenuItem12.setText("Relatório");
        jMenu7.add(jMenuItem12);

        jMenuBar1.add(jMenu7);

        jMenu5.setText("Sair");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(262, Short.MAX_VALUE)
                                .addComponent(txtHome)
                                .addContainerGap(243, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(101, Short.MAX_VALUE)
                                .addComponent(txtHome)
                                .addContainerGap(140, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cInclusaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cInclusaoActionPerformed
        Router.getInstance().push(new InclusaoCliente());
    }// GEN-LAST:event_cInclusaoActionPerformed

    private void cEdicaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cEdicaoActionPerformed
        Router.getInstance().push(new AltercaoCliente());
    }// GEN-LAST:event_cEdicaoActionPerformed

    private void cExclusaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cExclusaoActionPerformed
        Router.getInstance().push(new ExclusaoCliente());
    }// GEN-LAST:event_cExclusaoActionPerformed

    private void cConsultaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cConsultaActionPerformed
        Router.getInstance().push(new ColsultaCliente());
    }// GEN-LAST:event_cConsultaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cConsulta;
    private javax.swing.JMenuItem cEdicao;
    private javax.swing.JMenuItem cExclusao;
    private javax.swing.JMenuItem cInclusao;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel txtHome;
    // End of variables declaration//GEN-END:variables
}
