/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.forms;

import de.fhswf.classes.Ansprechpartner;
import de.fhswf.classes.Benutzer;
import de.fhswf.classes.Projekt;
import de.fhswf.classes.Teilnehmerzuordnung;
import de.fhswf.classes.Terminvorschlag;
import de.fhswf.database.DataP;
import java.awt.Color;
import java.util.Enumeration;
import javax.swing.JOptionPane;

/**
 *
 * @author Dark
 */
public class ProjektWindow extends javax.swing.JFrame {
    KommentarWindow KommentarW;
    MainWindow parent;
    TeilnehmerWindow TeilnehmerW;
    Projekt projekt;
    Benutzer[] Teilnehmer;
    boolean editMode;
    
    /**
     * Creates new form ProjektWindow
     * @param _parent Parent Fenster in dem das neue Fenster erstellt wurde.
     * @param _projekt Projekt dessen Daten im neu erstellten Fenster angezeigt werden sollen.
     */
    public ProjektWindow(MainWindow _parent, Projekt _projekt) {
        initComponents();
        setLocationRelativeTo(null);
        parent = _parent;
        projekt = _projekt;
        DataP d = new DataP();
        
        while (d.getTerminvorschlagTitel(projekt.getTitel()) != null && !d.getTerminvorschlagTitel(projekt.getTitel()).getStatus().equals("pending")) {
            JOptionPane.showMessageDialog(this, "Der Termin: " + d.getTerminvorschlagTitel(projekt.getTitel()).getTermin() + " wurde " + d.getTerminvorschlagTitel(projekt.getTitel()).getStatus() +".", "Termin " + d.getTerminvorschlagTitel(projekt.getTitel()).getStatus(), JOptionPane.INFORMATION_MESSAGE);
            d.deleteTerminvorschlag(d.getTerminvorschlagTitel(projekt.getTitel()).getIndex(), d.getTerminvorschlagTitel(projekt.getTitel()).getTitel());
        }
        
        if (projekt.getStatus().equals("abgelehnt")) {
            JOptionPane.showMessageDialog(this, projekt.getKommentar(), "Abgelehnt", JOptionPane.INFORMATION_MESSAGE);
        }
            
        jComboBoxAnsprechpartner.removeAllItems();
        for (Enumeration<Ansprechpartner> eo = d.getAllAnsprechpartner().elements(); eo.hasMoreElements();)
        {
            jComboBoxAnsprechpartner.addItem(eo.nextElement().getEmail());
        }
        
        jTextFieldTitel.setText(projekt.getTitel());
        jTextFieldFach.setText(projekt.getFach());
        jTextAreaKurzbeschreibung.setText(projekt.getKurzbeschreibung());
        jTextAreaBeschreibung.setText(projekt.getBeschreibung());
        jTextAreaSkizze.setText(projekt.getSkizze());
        jComboBoxAnsprechpartner.setSelectedItem(projekt.getAnsprechpartner().getEmail());
        jTextFieldVortrag1.setText(projekt.getVortrag1());
        jTextFieldVortrag2.setText(projekt.getVortrag2());
        SetBenutzer(projekt.getTeilnehmer());
        
        if(!parent.Benutzer.getIsAdmin()) {
            jButtonAblehnen.setEnabled(false);
            jButtonAnnehmen.setEnabled(false);
            jButtonSpeichern.setEnabled(false);
            
            for (int i=0; i<3; i++) {
                if (projekt.getTeilnehmer()[i] != null && parent.Benutzer.getEmail().equals(projekt.getTeilnehmer()[i].getEmail())) {
                    jButtonSpeichern.setEnabled(true);
                }
            }
        }
                
        editMode = true;
    }
    
    /**
     * Creates new form ProjektWindow
     * @param _parent Parent Fenster in dem das neue Fenster erstellt wurde.
     */
    public ProjektWindow(MainWindow _parent) {
        initComponents();
        setLocationRelativeTo(null);
        parent = _parent;
        editMode = false;
        
        jComboBoxAnsprechpartner.removeAllItems();
        DataP d = new DataP();
        for (Enumeration<Ansprechpartner> eo = d.getAllAnsprechpartner().elements(); eo.hasMoreElements();)
        {
            jComboBoxAnsprechpartner.addItem(eo.nextElement().getEmail());
        }
    }
    
    /**
     * Creates new form ProjektWindow
     */
    public ProjektWindow() {
        initComponents();
        setLocationRelativeTo(null);
        editMode = false;
        
        jComboBoxAnsprechpartner.removeAllItems();
        DataP d = new DataP();
        for (Enumeration<Ansprechpartner> eo = d.getAllAnsprechpartner().elements(); eo.hasMoreElements();)
        {
            jComboBoxAnsprechpartner.addItem(eo.nextElement().getEmail());
        }
    }
    
    /**
     * Stellt die Namen der Teilnehmer am Projekt in einem Textlabel da. 
     * @param _benutzer Teilnehmer die Am projekt Teilnehmen sollen.
     */
    public void SetBenutzer(Benutzer[] _benutzer) {
        Teilnehmer = _benutzer;
        
        if (Teilnehmer[0] != null) {
            jLabelTeilnehmer.setText(Teilnehmer[0].getName() + ", " + Teilnehmer[0].getVorname());
        }
        
        if (Teilnehmer[1] != null) {
            jLabelTeilnehmer.setText(jLabelTeilnehmer.getText() + "; " + Teilnehmer[1].getName() + ", " + Teilnehmer[1].getVorname());
        }
        
        if (Teilnehmer[2] != null) {
            jLabelTeilnehmer.setText(jLabelTeilnehmer.getText() + "; " + Teilnehmer[2].getName() + ", " + Teilnehmer[2].getVorname());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldTitel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaKurzbeschreibung = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaBeschreibung = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaSkizze = new javax.swing.JTextArea();
        jComboBoxAnsprechpartner = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelTeilnehmer = new javax.swing.JLabel();
        jButtonTeilnehmerHinzufuegen = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldVortrag1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldVortrag2 = new javax.swing.JTextField();
        jButtonAbbrechen = new javax.swing.JButton();
        jButtonSpeichern = new javax.swing.JButton();
        jButtonAblehnen = new javax.swing.JButton();
        jButtonAnnehmen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 450));

        jLabel1.setText("Titel");

        jTextFieldTitel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTitelKeyTyped(evt);
            }
        });

        jLabel2.setText("Fach");

        jTextFieldFach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFachKeyTyped(evt);
            }
        });

        jLabel3.setText("Kurzbeschreibung");

        jTextAreaKurzbeschreibung.setColumns(20);
        jTextAreaKurzbeschreibung.setRows(3);
        jTextAreaKurzbeschreibung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaKurzbeschreibungKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaKurzbeschreibung);

        jLabel4.setText("Beschreibung");

        jTextAreaBeschreibung.setColumns(20);
        jTextAreaBeschreibung.setRows(5);
        jTextAreaBeschreibung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaBeschreibungKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaBeschreibung);

        jLabel5.setText("Skizze");

        jTextAreaSkizze.setColumns(20);
        jTextAreaSkizze.setRows(3);
        jTextAreaSkizze.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaSkizzeKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jTextAreaSkizze);

        jComboBoxAnsprechpartner.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Ansprechpartner");

        jLabel7.setText("Teilnehmer");

        jButtonTeilnehmerHinzufuegen.setText("Hinzufügen");
        jButtonTeilnehmerHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTeilnehmerHinzufuegenActionPerformed(evt);
            }
        });

        jLabel9.setText("Vortrag 1");

        jLabel10.setText("Vortrag 2");

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

        jButtonAblehnen.setText("Ablehnen");
        jButtonAblehnen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAblehnenActionPerformed(evt);
            }
        });

        jButtonAnnehmen.setText("Annehmen");
        jButtonAnnehmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnehmenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAblehnen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAnnehmen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(jButtonSpeichern)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAbbrechen))
                    .addComponent(jTextFieldTitel)
                    .addComponent(jTextFieldFach)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addComponent(jComboBoxAnsprechpartner, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTeilnehmer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTeilnehmerHinzufuegen))
                    .addComponent(jTextFieldVortrag1)
                    .addComponent(jTextFieldVortrag2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldFach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAnsprechpartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelTeilnehmer)
                    .addComponent(jButtonTeilnehmerHinzufuegen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldVortrag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldVortrag2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAbbrechen)
                    .addComponent(jButtonSpeichern)
                    .addComponent(jButtonAblehnen)
                    .addComponent(jButtonAnnehmen))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbbrechenActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAbbrechenActionPerformed

    private void jButtonSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSpeichernActionPerformed
        if (!jTextFieldTitel.getText().equals("") 
                && !jTextFieldFach.getText().equals("")  
                && !jTextAreaKurzbeschreibung.getText().equals("")
                && !jTextAreaBeschreibung.getText().equals("")
                && !jTextAreaSkizze.getText().equals(""))
        {
            if (Teilnehmer == null) {
                JOptionPane.showMessageDialog(this, "Es muss mindestens ein Teilnehmer hinzugefügt werden.", "Teilnehmer", JOptionPane.ERROR_MESSAGE);
            }
            else {
                DataP d = new DataP();
                Teilnehmerzuordnung tz;
                Terminvorschlag tv;
                
                for (int i=0; i<3; i++) {
                    if (Teilnehmer[i] != null) {
                        if (!Teilnehmer[i].getEmail().equals(parent.Benutzer.getEmail())) {
                            if (editMode) {
                                if (d.getProjekt(jTextFieldTitel.getText()).getTeilnehmer()[i] != null) {
                                    if (!Teilnehmer[i].getEmail().equals(d.getProjekt(jTextFieldTitel.getText()).getTeilnehmer()[i].getEmail())) {
                                        tz = new Teilnehmerzuordnung(Teilnehmer[i].getEmail(), jTextFieldTitel.getText(), i);
                                        d.saveNewTeilnehmerzuordnung(tz);
                                    } 
                                }
                                
                            }
                            else {
                                tz = new Teilnehmerzuordnung(Teilnehmer[i].getEmail(), jTextFieldTitel.getText(), i);
                                d.saveNewTeilnehmerzuordnung(tz);
                            }
                        }
                    }
                }
                
                if (!jTextFieldVortrag1.getText().equals("")) {
                    if (!jTextFieldVortrag1.getText().equals(d.getProjekt(jTextFieldTitel.getText()).getVortrag1())) {
                        tv = new Terminvorschlag(d.getProjekt(jTextFieldTitel.getText()).getTitel(), jTextFieldVortrag1.getText(), 1, "pending");
                        d.saveNewTerminvorschlag(tv);
                    }
                }  
                
                if (!jTextFieldVortrag2.getText().equals("")) {
                    if (!jTextFieldVortrag2.getText().equals(d.getProjekt(jTextFieldTitel.getText()).getVortrag2())) {
                        tv = new Terminvorschlag(d.getProjekt(jTextFieldTitel.getText()).getTitel(), jTextFieldVortrag2.getText(), 2, "pending");
                        d.saveNewTerminvorschlag(tv);
                    }
                }    
                
                Ansprechpartner ansp = d.getAnsprechpartner(jComboBoxAnsprechpartner.getSelectedItem().toString());
                Projekt proj = new Projekt(jTextFieldTitel.getText(), jTextFieldFach.getText(), jTextAreaKurzbeschreibung.getText(), jTextAreaBeschreibung.getText(), jTextAreaSkizze.getText(), ansp, Teilnehmer, jTextFieldVortrag1.getText(), jTextFieldVortrag2.getText(), "pending", "pending");
                
                if (editMode) {
                    d.updateProjekt(projekt.getTitel(), proj);
                }
                else {
                    d.saveNewProjekt(proj);
                }
                
                parent.update();
                this.dispose();
            }
        }
        else
        {
            
            Color lightred = new Color(255,102,102);
            
            if (jTextFieldTitel.getText().equals(""))
            {
                jTextFieldTitel.setBackground(lightred);
            }
            
            if (jTextFieldFach.getText().equals(""))
            {
                jTextFieldFach.setBackground(lightred);
            }
            
            if (jTextAreaKurzbeschreibung.getText().equals(""))
            {
                jTextAreaKurzbeschreibung.setBackground(lightred);
            }
            
            if (jTextAreaBeschreibung.getText().equals(""))
            {
                jTextAreaBeschreibung.setBackground(lightred);
            }
            
            if (jTextAreaSkizze.getText().equals(""))
            {
                jTextAreaSkizze.setBackground(lightred);
            }
        }
    }//GEN-LAST:event_jButtonSpeichernActionPerformed

    private void jTextFieldTitelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTitelKeyTyped
        jTextFieldTitel.setBackground(Color.white);
    }//GEN-LAST:event_jTextFieldTitelKeyTyped

    private void jTextFieldFachKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFachKeyTyped
        jTextFieldFach.setBackground(Color.white);
    }//GEN-LAST:event_jTextFieldFachKeyTyped

    private void jTextAreaKurzbeschreibungKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaKurzbeschreibungKeyTyped
        jTextAreaKurzbeschreibung.setBackground(Color.white);
    }//GEN-LAST:event_jTextAreaKurzbeschreibungKeyTyped

    private void jTextAreaBeschreibungKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaBeschreibungKeyTyped
        jTextAreaBeschreibung.setBackground(Color.white);
    }//GEN-LAST:event_jTextAreaBeschreibungKeyTyped

    private void jTextAreaSkizzeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaSkizzeKeyTyped
        jTextAreaSkizze.setBackground(Color.white);
    }//GEN-LAST:event_jTextAreaSkizzeKeyTyped

    private void jButtonTeilnehmerHinzufuegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTeilnehmerHinzufuegenActionPerformed
        if (TeilnehmerW != null) {
            TeilnehmerW.dispose();
        }
        if (Teilnehmer == null) {
            TeilnehmerW = new TeilnehmerWindow(this);
        }
        else {
            TeilnehmerW = new TeilnehmerWindow(this, Teilnehmer);
        }
        TeilnehmerW.setVisible(true);
    }//GEN-LAST:event_jButtonTeilnehmerHinzufuegenActionPerformed

    private void jButtonAnnehmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnehmenActionPerformed
        DataP d = new DataP();
        d.updateProjektStatus(projekt.getTitel(), "angenommen");
                
        parent.update();
        this.dispose();
    }//GEN-LAST:event_jButtonAnnehmenActionPerformed

    private void jButtonAblehnenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAblehnenActionPerformed
        DataP d = new DataP();
        
        if (KommentarW != null)
        {
            KommentarW.dispose();
        }
        KommentarW = new KommentarWindow(this, projekt);
        KommentarW.setVisible(true);
    }//GEN-LAST:event_jButtonAblehnenActionPerformed

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
            java.util.logging.Logger.getLogger(ProjektWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjektWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjektWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjektWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjektWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbbrechen;
    private javax.swing.JButton jButtonAblehnen;
    private javax.swing.JButton jButtonAnnehmen;
    private javax.swing.JButton jButtonSpeichern;
    private javax.swing.JButton jButtonTeilnehmerHinzufuegen;
    private javax.swing.JComboBox jComboBoxAnsprechpartner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTeilnehmer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaBeschreibung;
    private javax.swing.JTextArea jTextAreaKurzbeschreibung;
    private javax.swing.JTextArea jTextAreaSkizze;
    private javax.swing.JTextField jTextFieldFach;
    private javax.swing.JTextField jTextFieldTitel;
    private javax.swing.JTextField jTextFieldVortrag1;
    private javax.swing.JTextField jTextFieldVortrag2;
    // End of variables declaration//GEN-END:variables
}
