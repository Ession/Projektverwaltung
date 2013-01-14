/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 * Datenklasse in der Benutzer gespeichert werden.
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
     * Legt einen neuen Benutzer an.
     * @param sName Name des Benutzers.
     * @param sVorname Vorname des Benutzers.
     * @param sPasswordHash Passworthash des Benutzers.
     * @param sEmail Email Adresse des Benutzers.
     * @param sTelefon Telefonnummer des Benutzers.
     * @param sAdresse Adresse des Benutzers.
     * @param sOrt Wohnort des Benutzers.
     * @param sPostleitzahl Postleitzahl des Benutzers.
     * @param bIsAdmin Handelt es sich beim benutzer um einen Admin?
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
     * @return Name des Benutzers.
     */
    public String getName() {
        return Name;
    }

    /**
     * @return Vorname des Benutzers.
     */
    public String getVorname() {
        return Vorname;
    }

    /**
     * @return Passworthash des Benutzers.
     */
    public String getPasswordHash() {
        return PasswordHash;
    }

    /**
     * @return Email Adresse des Benutzers.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @return Telefonnummer des Benutzers.
     */
    public String getTelefon() {
        return Telefon;
    }

    /**
     * @return Adresse des Benutzers.
     */
    public String getAdresse() {
        return Adresse;
    }

    /**
     * @return Wohnort des Benutzers.
     */
    public String getOrt() {
        return Ort;
    }

    /**
     * @return Postleitzahl des Benutzers.
     */
    public String getPostleitzahl() {
        return Postleitzahl;
    }

    /**
     * @return Wenn es suich um einen Admin handelt true, sonst false.
     */
    public boolean getIsAdmin() {
        return IsAdmin;
    }
    
}
