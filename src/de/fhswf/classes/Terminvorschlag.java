/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 * Datenklasse zur Darstellung von Terminvorschlägen
 * @author dark
 */
public class Terminvorschlag {
    private String titel;
    private String termin;
    private int index;
    private String status;
    
    /**
     * Legt einen neuen Terminvorschlag an.
     * @param sTitel Titel des Projektes
     * @param sTermin vorzuschlagender Termin
     * @param iIndex um welchen Termin handelt es sich.
     * @param sStatus welchen Status hat der Vorschlag (angenommen, abgelehnt, pending).
     */
    public Terminvorschlag(String sTitel, String sTermin, int iIndex, String sStatus)
    {
        titel = sTitel;
        termin = sTermin;
        index = iIndex;
        status = sStatus;
    }

    /**
     * @return Titel des Projektes
     */
    public String getTitel() {
        return titel;
    }

    /**
     * @return vorzuschlagender Termin
     */
    public String getTermin() {
        return termin;
    }

    /**
     * @return um welchen Termin handelt es sich.
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return welchen Status hat der Vorschlag (angenommen, abgelehnt, pending).
     */
    public String getStatus() {
        return status;
    }
}
