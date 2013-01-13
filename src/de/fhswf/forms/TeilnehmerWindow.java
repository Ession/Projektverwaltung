/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.forms;

import de.fhswf.classes.Ansprechpartner;
import de.fhswf.classes.Benutzer;
import de.fhswf.classes.Projekt;
import de.fhswf.database.DataP;
import java.awt.Color;

/**
 *
 * @author Dark
 */
public class TeilnehmerWindow extends javax.swing.JFrame {

    ProjektWindow parent;
    
    /**
     * Creates new form TeilnehmerWindow
     */
    public TeilnehmerWindow() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    /**
     * Creates new form TeilnehmerWindow
     * @param _parent 
     */
    public TeilnehmerWindow(ProjektWindow _parent) {
        initComponents();
        setLocationRelativeTo(null);
        parent = _parent;
    }
    
    /**
     * Creates new form TeilnehmerWindow
     * @param _parent
     * @param _benutzer  
     */
    public TeilnehmerWindow(ProjektWindow _parent, Benutzer[] _benutzer) {
        initComponents();
        setLocationRelativeTo(null);
        parent = _parent;
        //System.out.println(_benutzer[0]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTeilnehmer1 = new javax.swing.JTextField();
        jTextFieldTeilnehmer2 = new javax.swing.JTextField();
        jTextFieldTeilnehmer3 = new javax.swing.JTextField();
        jButtonAbbrechen = new javax.swing.JButton();
        jButtonSpeichern = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Email 1");

        jLabel3.setText("Email 2");

        jLabel4.setText("Email 3");

        jTextFieldTeilnehmer1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTeilnehmer1KeyTyped(evt);
            }
        });

        jButtonAbbrechen.setText("Abbrechen");
        jButtonAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbbrechenActionPerformed(evt);
            }
        });

        jButtonSpeichern.setText("Speichern");
        jButtonSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSpeichernActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTeilnehmer3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 121, Short.MAX_VALUE)
                        .addComponent(jButtonSpeichern)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAbbrechen))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTeilnehmer1)
                            .addComponent(jTextFieldTeilnehmer2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTeilnehmer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTeilnehmer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldTeilnehmer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAbbrechen)
                    .addComponent(jButtonSpeichern))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbbrechenActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAbbrechenActionPerformed

    private void jButtonSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSpeichernActionPerformed
        if (!jTextFieldTeilnehmer1.getText().equals(""))
        {
            DataP d = new DataP();
            Benutzer[] ben = new Benutzer[3];
            
            if (d.getBenutzer(jTextFieldTeilnehmer1.getText()) != null) {
                ben[0] = d.getBenutzer(jTextFieldTeilnehmer1.getText());
            }
            
            if (d.getBenutzer(jTextFieldTeilnehmer2.getText()) != null) {
                ben[1] = d.getBenutzer(jTextFieldTeilnehmer2.getText());
            }
            
            if (d.getBenutzer(jTextFieldTeilnehmer3.getText()) != null) {
                ben[2] = d.getBenutzer(jTextFieldTeilnehmer3.getText());
            }
            
            parent.SetBenutzer(ben);
            
            //parent.update();
            this.dispose();
        }
        else {
            Color lightred = new Color(255,102,102);
            
            if (jTextFieldTeilnehmer1.getText().equals(""))
            {
                jTextFieldTeilnehmer1.setBackground(lightred);
            }
        }
    }//GEN-LAST:event_jButtonSpeichernActionPerformed

    private void jTextFieldTeilnehmer1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTeilnehmer1KeyTyped
        jTextFieldTeilnehmer1.setBackground(Color.white);
    }//GEN-LAST:event_jTextFieldTeilnehmer1KeyTyped

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
            java.util.logging.Logger.getLogger(TeilnehmerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeilnehmerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeilnehmerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeilnehmerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeilnehmerWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbbrechen;
    private javax.swing.JButton jButtonSpeichern;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldTeilnehmer1;
    private javax.swing.JTextField jTextFieldTeilnehmer2;
    private javax.swing.JTextField jTextFieldTeilnehmer3;
    // End of variables declaration//GEN-END:variables
}
