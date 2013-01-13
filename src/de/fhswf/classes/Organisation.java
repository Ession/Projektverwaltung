/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 *
 * @author Dark
 */
public class Organisation {
    private String Name;
    private String Adresse;
    private String Ort;
    private String Postleitzahl;
    
    /**
     *
     * @param sName
     * @param sAdresse
     * @param sOrt
     * @param sPostleitzahl
     */
    public Organisation(String sName, String sAdresse, String sOrt, String sPostleitzahl)
    {
        Name = sName;
        Adresse = sAdresse;
        Ort = sOrt;
        Postleitzahl = sPostleitzahl;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Adresse
     */
    public String getAdresse() {
        return Adresse;
    }

    /**
     * @param Adresse the Adresse to set
     */
    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    /**
     * @return the Ort
     */
    public String getOrt() {
        return Ort;
    }

    /**
     * @param Ort the Ort to set
     */
    public void setOrt(String Ort) {
        this.Ort = Ort;
    }

    /**
     * @return the Postleitzahl
     */
    public String getPostleitzahl() {
        return Postleitzahl;
    }

    /**
     * @param Postleitzahl the Postleitzahl to set
     */
    public void setPostleitzahl(String Postleitzahl) {
        this.Postleitzahl = Postleitzahl;
    }
}
