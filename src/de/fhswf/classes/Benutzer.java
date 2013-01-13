/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 *
 * @author Dark
 */
public class Benutzer {
    private String Name;
    private String Vorname;
    private String PasswordHash;
    private String Email;
    private String Telefon;
    private String Adresse;
    private String Ort;
    private String Postleitzahl;
    private boolean IsAdmin;

    /**
     *
     * @param sName
     * @param sVorname
     * @param sPasswordHash
     * @param sEmail
     * @param sTelefon
     * @param sAdresse
     * @param sOrt
     * @param sPostleitzahl
     * @param bIsAdmin
     */
    public Benutzer(String sName, String sVorname, String sPasswordHash, String sEmail, String sTelefon, String sAdresse, String sOrt, String sPostleitzahl, boolean bIsAdmin) { 
        Name = sName;
        Vorname = sVorname;
        PasswordHash = sPasswordHash;
        Email = sEmail;
        Telefon = sTelefon;
        Adresse = sAdresse;
        Ort = sOrt;
        Postleitzahl = sPostleitzahl;
        IsAdmin = bIsAdmin;
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
     * @return the Vorname
     */
    public String getVorname() {
        return Vorname;
    }

    /**
     * @param Vorname the Vorname to set
     */
    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }

    /**
     * @return the PasswordHash
     */
    public String getPasswordHash() {
        return PasswordHash;
    }

    /**
     * @param PasswordHash the PasswordHash to set
     */
    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Telefon
     */
    public String getTelefon() {
        return Telefon;
    }

    /**
     * @param Telefon the Telefon to set
     */
    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
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

    /**
     * @return the IsAdmin
     */
    public boolean getIsAdmin() {
        return IsAdmin;
    }

    /**
     * @param IsAdmin the IsAdmin to set
     */
    public void setIsAdmin(boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }
    
}
