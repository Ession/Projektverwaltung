/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhswf.classes;

/**
 *
 * @author Dark
 */
public class Ansprechpartner {
    private String Name;
    private String Vorname;
    private String Email;
    private Organisation Organisation;
    
    /**
     *
     * @param sName
     * @param sVorname
     * @param sEmail
     * @param oOrganisation
     */
    public Ansprechpartner(String sName, String sVorname, String sEmail, Organisation oOrganisation)
    {
        Name = sName;
        Vorname = sVorname;
        Email = sEmail;
        Organisation = oOrganisation;
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
     * @return the Organisation
     */
    public Organisation getOrganisation() {
        return Organisation;
    }

    /**
     * @param Organisation the Organisation to set
     */
    public void setOrganisation(Organisation Organisation) {
        this.Organisation = Organisation;
    }
}
