/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 *
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
     *
     * @param sTitel
     * @param sFach
     * @param sKurzbeschreibung
     * @param sBeschreibung
     * @param sSkizze
     * @param aAnsprechpartner
     * @param bTeilnehmer
     * @param sVortrag1
     * @param sVortrag2
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
     * @return the Titel
     */
    public String getTitel() {
        return Titel;
    }

    /**
     * @param Titel the Titel to set
     */
    public void setTitel(String Titel) {
        this.Titel = Titel;
    }

    /**
     * @return the Fach
     */
    public String getFach() {
        return Fach;
    }

    /**
     * @param Fach the Fach to set
     */
    public void setFach(String Fach) {
        this.Fach = Fach;
    }

    /**
     * @return the Kurzbeschreibung
     */
    public String getKurzbeschreibung() {
        return Kurzbeschreibung;
    }

    /**
     * @param Kurzbeschreibung the Kurzbeschreibung to set
     */
    public void setKurzbeschreibung(String Kurzbeschreibung) {
        this.Kurzbeschreibung = Kurzbeschreibung;
    }

    /**
     * @return the Beschreibung
     */
    public String getBeschreibung() {
        return Beschreibung;
    }

    /**
     * @param Beschreibung the Beschreibung to set
     */
    public void setBeschreibung(String Beschreibung) {
        this.Beschreibung = Beschreibung;
    }

    /**
     * @return the Skizze
     */
    public String getSkizze() {
        return Skizze;
    }

    /**
     * @param Skizze the Skizze to set
     */
    public void setSkizze(String Skizze) {
        this.Skizze = Skizze;
    }

    /**
     * @return the Ansprechpartner
     */
    public Ansprechpartner getAnsprechpartner() {
        return Ansprechpartner;
    }

    /**
     * @param Ansprechpartner the Ansprechpartner to set
     */
    public void setAnsprechpartner(Ansprechpartner Ansprechpartner) {
        this.Ansprechpartner = Ansprechpartner;
    }

    /**
     * @return the Teilnehmer
     */
    public Benutzer[] getTeilnehmer() {
        return Teilnehmer;
    }

    /**
     * @param Teilnehmer the Teilnehmer to set
     */
    public void setTeilnehmer(Benutzer[] Teilnehmer) {
        this.Teilnehmer = Teilnehmer;
    }

    /**
     * @return the Vortrag1
     */
    public String getVortrag1() {
        return Vortrag1;
    }

    /**
     * @param Vortrag1 the Vortrag1 to set
     */
    public void setVortrag1(String Vortrag1) {
        this.Vortrag1 = Vortrag1;
    }

    /**
     * @return the Vortrag2
     */
    public String getVortrag2() {
        return Vortrag2;
    }

    /**
     * @param Vortrag2 the Vortrag2 to set
     */
    public void setVortrag2(String Vortrag2) {
        this.Vortrag2 = Vortrag2;
    }
    
}
