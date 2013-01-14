/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 * Datenklasse in der Organisationen gespeichert werden.
 * @author Dark
 */
public class Organisation {
    private String Name;
    private String Adresse;
    private String Ort;
    private String Postleitzahl;
    
    /**
     * Legt eine neue Organisation an.
     * @param sName Name der Organisation.
     * @param sAdresse Adresse der Organisation.
     * @param sOrt Wohnort der Organisation.
     * @param sPostleitzahl Postleitzahl der Organisation.
     */
    public Organisation(String sName, String sAdresse, String sOrt, String sPostleitzahl)
    {
        Name = sName;
        Adresse = sAdresse;
        Ort = sOrt;
        Postleitzahl = sPostleitzahl;
    }

    /**
     * @return Name der Organisation.
     */
    public String getName() {
        return Name;
    }

    /**
     * @return Adresse der Organisation.
     */
    public String getAdresse() {
        return Adresse;
    }

    /**
     * @return Wohnort der Organisation.
     */
    public String getOrt() {
        return Ort;
    }

    /**
     * @return Postleitzahl der Organisation.
     */
    public String getPostleitzahl() {
        return Postleitzahl;
    }
}
