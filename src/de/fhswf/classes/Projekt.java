/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 * Datenklasse in der POrojekte gespeichert werden.
 * @author Dark
 */
public class Projekt {
    private String Titel;
    private String Fach;
    private String Kurzbeschreibung;
    private String Beschreibung;
    private String Skizze;
    private Ansprechpartner Ansprechpartner;
    private Benutzer[] Teilnehmer;
    private String Vortrag1;
    private String Vortrag2;
    
    /**
     * Legt ein neues Projekt an.
     * @param sTitel Titel Des Projektes.
     * @param sFach Fach Des Projektes.
     * @param sKurzbeschreibung Kurzbeschreibung zum Projekt.
     * @param sBeschreibung Beschreibung zum Projekt.
     * @param sSkizze Skizze zum Projekt.
     * @param aAnsprechpartner Ansprechpartner des Projektes.
     * @param bTeilnehmer Teilnehmer des Projektes
     * @param sVortrag1 Erster Vortragstermin.
     * @param sVortrag2 Zweiter Vortragstermin.
     */
    public Projekt(String sTitel, 
            String sFach, 
            String sKurzbeschreibung, 
            String sBeschreibung, 
            String sSkizze, 
            Ansprechpartner aAnsprechpartner, 
            Benutzer[] bTeilnehmer, 
            String sVortrag1, 
            String sVortrag2) {
        
        Titel = sTitel;
        Fach = sFach;
        Kurzbeschreibung = sKurzbeschreibung;
        Beschreibung = sBeschreibung;
        Skizze = sSkizze;
        Ansprechpartner = aAnsprechpartner;
        Teilnehmer = bTeilnehmer;
        Vortrag1 = sVortrag1;
        Vortrag2 = sVortrag2;        
    }
    
    /**
     * @return Titel Des Projektes.
     */
    public String getTitel() {
        return Titel;
    }

    /**
     * @return Fach Des Projektes.
     */
    public String getFach() {
        return Fach;
    }

    /**
     * @return Kurzbeschreibung zum Projekt
     */
    public String getKurzbeschreibung() {
        return Kurzbeschreibung;
    }

    /**
     * @return Beschreibung des Projektes
     */
    public String getBeschreibung() {
        return Beschreibung;
    }

    /**
     * @return Skizze des Projektes
     */
    public String getSkizze() {
        return Skizze;
    }

    /**
     * @return Ansprechpartner des Projektes
     */
    public Ansprechpartner getAnsprechpartner() {
        return Ansprechpartner;
    }

    /**
     * @return Teilnehmer des Projektes
     */
    public Benutzer[] getTeilnehmer() {
        return Teilnehmer;
    }

    /**
     * @return Erster Vortragstermin
     */
    public String getVortrag1() {
        return Vortrag1;
    }

    /**
     * @return zweiter Vortragstermin
     */
    public String getVortrag2() {
        return Vortrag2;
    }

    /**
     * @param Vortrag1 Erster Vortragstermin
     */
    public void setVortrag1(String Vortrag1) {
        this.Vortrag1 = Vortrag1;
    }

    /**
     * @param Vortrag2 zweiter Vortragstermin
     */
    public void setVortrag2(String Vortrag2) {
        this.Vortrag2 = Vortrag2;
    }

}
