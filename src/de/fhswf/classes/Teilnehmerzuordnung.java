/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 * Datenklasse in Projekt/Teilnehmer zuordnungen dargetsellt werden.
 * @author dark
 */
public class Teilnehmerzuordnung {
    private String Email;
    private String Titel;
    private int Teilnehmerindex;
    
    /**
     * Legt eine neue Teilnehmerzuordnung an.
     * @param sEmail Emailadresse des Teilnehmers
     * @param sTitel Titel des Projektes
     * @param iTeilnehmerindex Der wievielte Teilnehmer ist es.
     */
    public Teilnehmerzuordnung(String sEmail, String sTitel, int iTeilnehmerindex)
    {
        Email = sEmail;
        Titel = sTitel;
        Teilnehmerindex = iTeilnehmerindex;
    }

    /**
     * @return Emailadresse des Teilnehmers
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @return Titel des Projektes
     */
    public String getTitel() {
        return Titel;
    }

    /**
     * @return Der wievielte Teilnehmer ist es.
     */
    public int getTeilnehmerindex() {
        return Teilnehmerindex;
    }
}
