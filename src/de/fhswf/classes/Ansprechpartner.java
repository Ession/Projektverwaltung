/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 * Datenklasse in der Ansprechpartner gespeichert werden.
 * @author Dark
 */
public class Ansprechpartner {
    private String Name;
    private String Vorname;
    private String Email;
    private Organisation Organisation;
    
    /**
     * Legt einen neuen Ansprechpartner an.
     * @param sName Der Name des Ansprechpartners.
     * @param sVorname Der Vorname des Ansprechpartners.
     * @param sEmail Die Email Adresse des Ansprechpartners.
     * @param oOrganisation Die Organisation der der Ansprechpartner angehört.
     */
    public Ansprechpartner(String sName, String sVorname, String sEmail, Organisation oOrganisation)
    {
        Name = sName;
        Vorname = sVorname;
        Email = sEmail;
        Organisation = oOrganisation;
    }

    /**
     * @return Name des Ansprechpartners
     */
    public String getName() {
        return Name;
    }

    /**
     * @return Vorname des Ansprechpartners.
     */
    public String getVorname() {
        return Vorname;
    }

    /**
     * @return Email Adresse des Ansprechpartners.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @return Organisation der der Ansprechpartner angehört.
     */
    public Organisation getOrganisation() {
        return Organisation;
    }
}
