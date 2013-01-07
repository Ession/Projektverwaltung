/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.forms;

import de.fhswf.database.DataP;

/**
 *
 * @author Dark
 */
public class MainWindow extends javax.swing.JFrame {

    LoginWindow parent;
    BenutzerWindow BenutzerW;
    ProjektWindow ProjektW;
    AnsprechpartnerWindow AnsprechpartnerW;
    OrganisationWindow OrganisationW;
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow(LoginWindow _parent) {
        initComponents();
        parent = _parent;
        setLocationRelativeTo(null);
    }
    
    public MainWindow() {
        initComponents();
        update();
    }
    
    public final void update()
    {
        DataP d = new DataP();
        jTableAnsprechpartner.setModel(d.getAnsprechpartnerModel());
        jTableOrganisation.setModel(d.getOrganisationsModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProjekte = new javax.swing.JTable();
        jButtonProjektNeu = new javax.swing.JButton();
        jButtonProjektBearbeiten = new javax.swing.JButton();
        jButtonProjektLoeschen = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAnsprechpartner = new javax.swing.JTable();
        jButtonAnsprechpartnerNeu = new javax.swing.JButton();
        jButtonAnsprechpartnerBearbeiten = new javax.swing.JButton();
        jButtonAnsprechpartnerLoeschen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableOrganisation = new javax.swing.JTable();
        jButtonOrganisationNeu = new javax.swing.JButton();
        jButtonOrganisationBearbeiten = new javax.swing.JButton();
        jButtonOrganisationLoeschen = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableBenutzer = new javax.swing.JTable();
        jButtonBenutzerNeu = new javax.swing.JButton();
        jButtonBenutzerBearbeiten = new javax.swing.JButton();
        jButtonBenutzerLoeschen = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableProjekte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableProjekte);

        jButtonProjektNeu.setText("Neu");
        jButtonProjektNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProjektNeuActionPerformed(evt);
            }
        });

        jButtonProjektBearbeiten.setText("Bearbeiten");
        jButtonProjektBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProjektBearbeitenActionPerformed(evt);
            }
        });

        jButtonProjektLoeschen.setText("Löschen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonProjektLoeschen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonProjektBearbeiten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonProjektNeu)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProjektNeu)
                    .addComponent(jButtonProjektBearbeiten)
                    .addComponent(jButtonProjektLoeschen))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Projekte", jPanel1);

        jLabel1.setText("Ansprechpartner");

        jTableAnsprechpartner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableAnsprechpartner);

        jButtonAnsprechpartnerNeu.setText("Neu");
        jButtonAnsprechpartnerNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnsprechpartnerNeuActionPerformed(evt);
            }
        });

        jButtonAnsprechpartnerBearbeiten.setText("Bearbeiten");

        jButtonAnsprechpartnerLoeschen.setText("Löschen");

        jLabel2.setText("Organisation");

        jTableOrganisation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableOrganisation);

        jButtonOrganisationNeu.setText("Neu");
        jButtonOrganisationNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrganisationNeuActionPerformed(evt);
            }
        });

        jButtonOrganisationBearbeiten.setText("Bearbeiten");

        jButtonOrganisationLoeschen.setText("Löschen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonAnsprechpartnerLoeschen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAnsprechpartnerBearbeiten)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAnsprechpartnerNeu))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonOrganisationLoeschen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonOrganisationBearbeiten)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonOrganisationNeu)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnsprechpartnerNeu)
                    .addComponent(jButtonAnsprechpartnerBearbeiten)
                    .addComponent(jButtonAnsprechpartnerLoeschen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOrganisationNeu)
                    .addComponent(jButtonOrganisationBearbeiten)
                    .addComponent(jButtonOrganisationLoeschen))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ansprechpartner", jPanel2);

        jTableBenutzer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTableBenutzer);

        jButtonBenutzerNeu.setText("Neu");
        jButtonBenutzerNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBenutzerNeuActionPerformed(evt);
            }
        });

        jButtonBenutzerBearbeiten.setText("Bearbeiten");

        jButtonBenutzerLoeschen.setText("Löschen");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonBenutzerLoeschen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBenutzerBearbeiten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBenutzerNeu)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBenutzerNeu)
                    .addComponent(jButtonBenutzerBearbeiten)
                    .addComponent(jButtonBenutzerLoeschen))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Benutzer", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBenutzerNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBenutzerNeuActionPerformed
        if (BenutzerW != null)
        {
            BenutzerW.dispose();
        }
        BenutzerW = new BenutzerWindow();
        BenutzerW.setVisible(true);
    }//GEN-LAST:event_jButtonBenutzerNeuActionPerformed

    private void jButtonProjektNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProjektNeuActionPerformed
        if (ProjektW != null)
        {
            ProjektW.dispose();
        }
        ProjektW = new ProjektWindow();
        ProjektW.setVisible(true);
    }//GEN-LAST:event_jButtonProjektNeuActionPerformed

    private void jButtonProjektBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProjektBearbeitenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProjektBearbeitenActionPerformed

    private void jButtonAnsprechpartnerNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnsprechpartnerNeuActionPerformed
        if (AnsprechpartnerW != null)
        {
            AnsprechpartnerW.dispose();
        }
        AnsprechpartnerW = new AnsprechpartnerWindow();
        AnsprechpartnerW.setVisible(true);
    }//GEN-LAST:event_jButtonAnsprechpartnerNeuActionPerformed

    private void jButtonOrganisationNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrganisationNeuActionPerformed
        if (OrganisationW != null)
        {
            OrganisationW.dispose();
        }
        OrganisationW = new OrganisationWindow();
        OrganisationW.setVisible(true);
    }//GEN-LAST:event_jButtonOrganisationNeuActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnsprechpartnerBearbeiten;
    private javax.swing.JButton jButtonAnsprechpartnerLoeschen;
    private javax.swing.JButton jButtonAnsprechpartnerNeu;
    private javax.swing.JButton jButtonBenutzerBearbeiten;
    private javax.swing.JButton jButtonBenutzerLoeschen;
    private javax.swing.JButton jButtonBenutzerNeu;
    private javax.swing.JButton jButtonOrganisationBearbeiten;
    private javax.swing.JButton jButtonOrganisationLoeschen;
    private javax.swing.JButton jButtonOrganisationNeu;
    private javax.swing.JButton jButtonProjektBearbeiten;
    private javax.swing.JButton jButtonProjektLoeschen;
    private javax.swing.JButton jButtonProjektNeu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAnsprechpartner;
    private javax.swing.JTable jTableBenutzer;
    private javax.swing.JTable jTableOrganisation;
    private javax.swing.JTable jTableProjekte;
    // End of variables declaration//GEN-END:variables
}
