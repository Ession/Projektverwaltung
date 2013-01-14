package de.fhswf.database;

import de.fhswf.classes.Ansprechpartner;
import de.fhswf.classes.Benutzer;
import de.fhswf.classes.Organisation;
import de.fhswf.classes.Projekt;
import de.fhswf.classes.Teilnehmerzuordnung;
import de.fhswf.classes.Terminvorschlag;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Datenbankverbindungsklasse für die Projektverwaltung 
 * @author dark
 */
public class DataP
{

    private static final String DataBaseFileName = "projektverwaltung2";
    private static final File DataBaseFile = new File(DataBaseFileName + ".script");
    private DataBase dataBase;
    
    /**
     * Initieren der Datenbank mit erstellen von Tabellen und Testdaten.
     */
    private void initDataBase()
    {
        Boolean exists = DataBaseFile.isFile();
        try
        {
            dataBase = new DataBase(DataBaseFileName);
            if (!exists)
            {
                update(
                        "CREATE TABLE benutzer("
                        + "b_name VARCHAR(30), "
                        + "b_vorname VARCHAR(30), "
                        + "b_passwordhash VARCHAR(30), "
                        + "b_email VARCHAR(50) UNIQUE, "
                        + "b_telefon VARCHAR(30), "
                        + "b_adresse VARCHAR(30), "
                        + "b_ort VARCHAR(30), "
                        + "b_postleitzahl VARCHAR(5), "
                        + "b_isadmin BOOLEAN"
                        + ")");
                
                update(
                        "CREATE TABLE projekt("
                        + "p_titel VARCHAR(30) UNIQUE, "
                        + "p_fach VARCHAR(30), "
                        + "p_kurzbeschreibung VARCHAR(200), "
                        + "p_beschreibung VARCHAR(1500), "
                        + "p_skizze VARCHAR(300), "
                        + "p_ansprechpartner VARCHAR(30), "
                        + "p_teilnehmer1 VARCHAR(30), "
                        + "p_teilnehmer2 VARCHAR(30), "
                        + "p_teilnehmer3 VARCHAR(30), "
                        + "p_vortrag1 VARCHAR(30), "
                        + "p_vortrag2 VARCHAR(30) "
                        + ")");
                
                update(
                        "CREATE TABLE ansprechpartner("
                        + "a_name VARCHAR(30),"
                        + "a_vorname VARCHAR(30), "
                        + "a_email VARCHAR(50) UNIQUE, "
                        + "a_organisation VARCHAR(30) "
                        + ")");

                update(
                        "CREATE TABLE organisation("
                        + "o_name VARCHAR(30) UNIQUE, "
                        + "o_adresse VARCHAR(30), "
                        + "o_ort VARCHAR(30), "
                        + "o_postleitzahl VARCHAR(5) "
                        + ")");

                update(
                        "CREATE TABLE projektteilnehmer("
                        + "pt_email VARCHAR(50), "
                        + "pt_titel VARCHAR(30), "
                        + "pt_index INTEGER "
                        + ")");

                update(
                        "CREATE TABLE terminvorschlag("
                        + "tv_titel VARCHAR(50), "
                        + "tv_termin VARCHAR(30), "
                        + "tv_index INTEGER, "
                        + "tv_status VARCHAR(30) "
                        + ")");

                update("INSERT INTO benutzer(b_name, b_vorname, b_passwordhash, b_email, b_telefon, b_adresse, b_ort, b_postleitzahl, b_isadmin) "
                        + "VALUES('Jost','Mathias','11111','mail@mathiasjost.com', '02373/12729', 'Stiftstraße 19', 'Menden', '58706', TRUE)");
                update("INSERT INTO benutzer(b_name, b_vorname, b_passwordhash, b_email, b_telefon, b_adresse, b_ort, b_postleitzahl, b_isadmin) "
                        + "VALUES('Tester','Fred','22222','fred@tester.com', '02373/12345', 'Teststraße 1', 'Frankfurt', '12345', FALSE)");
                update("INSERT INTO benutzer(b_name, b_vorname, b_passwordhash, b_email, b_telefon, b_adresse, b_ort, b_postleitzahl, b_isadmin) "
                        + "VALUES('Tester','Greg','33333','greg@tester.com', '02373/54321', 'Teststraße 2', 'München', '54321', FALSE)");
                
                update("INSERT INTO projekt(p_titel, p_fach, p_kurzbeschreibung, p_beschreibung, p_skizze, p_ansprechpartner, p_teilnehmer1, p_teilnehmer2, p_teilnehmer3, p_vortrag1, p_vortrag2) "
                        + "VALUES('Testprojekt 1','GUI','Ein Einfaches Gui Programm','Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.', 'Immernoch ein einfaches GUI Programm', 'jeff@tester.com', 'mail@mathiasjost.com', 'greg@tester.com', '', '21.01.2013 10:30Uhr', '')");
                update("INSERT INTO projekt(p_titel, p_fach, p_kurzbeschreibung, p_beschreibung, p_skizze, p_ansprechpartner, p_teilnehmer1, p_teilnehmer2, p_teilnehmer3, p_vortrag1, p_vortrag2) "
                        + "VALUES('Testprojekt 2','Java','Ein Einfaches Java Programm','Blub Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.', 'Immernoch ein einfaches Java Programm', 'chuck@tester.com', 'fred@tester.com', 'greg@tester.com', 'mail@mathiasjost.com', '22.01.2013 10:30Uhr', '28.01.2013 11:30Uhr')");
                
                update("INSERT INTO ansprechpartner(a_name, a_vorname, a_email, a_organisation) "
                        + "VALUES('Tester','Jeff','jeff@tester.com','Fachhochschule Südwestfahlen')");
                update("INSERT INTO ansprechpartner(a_name, a_vorname, a_email, a_organisation) "
                        + "VALUES('Tester','Chuck','chuck@tester.com','Brumberg')");
                update("INSERT INTO ansprechpartner(a_name, a_vorname, a_email, a_organisation) "
                        + "VALUES('Tester','Bill','Bill@tester.com','Brumberg')");
                
                update("INSERT INTO organisation(o_name, o_adresse, o_ort, o_postleitzahl) "
                        + "VALUES('Fachhochschule Südwestfahlen','Frauenstuhlweg 1','Iserlohn','58636')");
                update("INSERT INTO organisation(o_name, o_adresse, o_ort, o_postleitzahl) "
                        + "VALUES('Brumberg','Werweis 5','Menden','58706')");
            }
        }
        catch (Exception e)
        {
        }
    }

    /**
     * bekommt eine SQL expression die auf der Datenbank ausgefürt werden soll.
     * @param expression SQL expression die update ausführen soll
     */
    public void update(String expression)
    {
        if (dataBase == null)
        {
            throw new IllegalAccessError("Bitte erst initDataBase() ausfuehren");
        }
        try
        {
            this.dataBase.update(expression);
        }
        catch (SQLException e)
        {
            System.out.println("Fehler in folgendem Statement:");
            System.out.println(expression);
        }
    }

    /**
     * Beendet die Verbdindung zur Datenbank
     */
    public void shutdown()
    {
        try
        {
            dataBase.shutdown();
        }
        catch (SQLException e)
        {
            System.out.println("Fehler beim Beenden der Datenbank:");
        }
    }

    /**
     * Constructor (initialisiert die Datenbank)
     */
    public DataP()
    {
        initDataBase();
    }

    /**
     * Speichert einen neuen Benutzer in der Datenbank
     * @param b Benutzer dessen Daten gespeichert werden sollen.
     */
    public void saveNewBenutzer(Benutzer b)
    {
        String query = "INSERT INTO benutzer(b_name, b_vorname, b_passwordhash, b_email, b_telefon, b_adresse, b_ort, b_postleitzahl, b_isadmin) VALUES(";
        query += "'" + b.getName() + "',";
        query += "'" + b.getVorname() + "',";
        query += "'" + b.getPasswordHash() + "',";
        query += "'" + b.getEmail() + "',";
        query += "'" + b.getTelefon() + "',";
        query += "'" + b.getAdresse() + "',";
        query += "'" + b.getOrt() + "',";
        query += "'" + b.getPostleitzahl() + "',";
        query += "'" + b.getIsAdmin() + "'";
        query += ")";
        try
        {
            dataBase.update(query);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * Ändert die Daten eines gespeicherten Benutzers
     * @param sOldEmail Die bisherige Email Adresse des zu ändernden Benutzers.
     * @param b Die neuen Daten des Benutzers.
     * @param NewPW Auf True setzen wenn ein neues Passwort gespeichert werden soll.
     */
    public void updateBenutzer(String sOldEmail, Benutzer b, boolean NewPW)
    {
        String query;
        if (NewPW) {
            query = "UPDATE benutzer "
                + "SET b_name='" + b.getName() + "',"
                + "b_vorname='" + b.getVorname() + "',"
                + "b_passwordhash='" + b.getPasswordHash() + "',"
                + "b_email='" + b.getEmail() + "',"
                + "b_telefon='" + b.getTelefon() + "',"
                + "b_adresse='" + b.getAdresse() + "',"
                + "b_ort='" + b.getOrt() + "',"
                + "b_postleitzahl='" + b.getPostleitzahl() + "'"
                + " WHERE b_email='" + sOldEmail + "'";
        }
        else {
            query = "UPDATE benutzer "
                + "SET b_name='" + b.getName() + "',"
                + "b_vorname='" + b.getVorname() + "',"
                + "b_email='" + b.getEmail() + "',"
                + "b_telefon='" + b.getTelefon() + "',"
                + "b_adresse='" + b.getAdresse() + "',"
                + "b_ort='" + b.getOrt() + "',"
                + "b_postleitzahl='" + b.getPostleitzahl() + "'"
                + " WHERE b_email='" + sOldEmail + "'";
        }
        
        try
        {
            dataBase.update(query);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gibt einen Benutzer aus der Datenbank anhand der Emailadresse zurück.
     * @param email Emailadresse des gesuchten Benutzers.
     * @return Der gefundene Benutzer oder null wenn kein Benutzer gefunden wurde.
     */
    public Benutzer getBenutzer(String email)
    {

        try
        {
            ResultSet rs = dataBase.query("Select * from benutzer where b_email  = '" + email + "'");
            if (rs.next())
            {
                return new Benutzer(rs.getString("b_name"), rs.getString("b_vorname"), rs.getString("b_passwordhash"), rs.getString("b_email"), rs.getString("b_telefon"), rs.getString("b_adresse"), rs.getString("b_ort"), rs.getString("b_postleitzahl"), rs.getBoolean("b_isadmin"));
            }
            else
            {
                return null;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
        
    /**
     * Gibt einen Vektor mit allen Benutzern in der Datenbank zurück.
     * @return Vektor mit allen Benutzern in der Datenbank.
     */
    public Vector<Benutzer> getAllBenutzer()
    {
        Vector<Benutzer> vBenutzer = new Vector<Benutzer>();
        try
        {
            ResultSet rs = dataBase.query("Select * from benutzer order by b_name");

            while (rs.next())
            {
                vBenutzer.add(new Benutzer(rs.getString("b_name"), rs.getString("b_vorname"), rs.getString("b_passwordhash"), rs.getString("b_email"), rs.getString("b_telefon"), rs.getString("b_adresse"), rs.getString("b_ort"), rs.getString("b_postleitzahl"), rs.getBoolean("b_isadmin")));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vBenutzer;
    }
    
    /**
     * Gibt ein Tabellenmodell mit allen Benutzern in der Datenbank zurück.
     * @return Tabellenmoddel mit allen Benutzern in der Datenbank.
     */
    public model getBenutzerModel()
    {
        Vector tabellenVector = new Vector();
        Vector header = new Vector();

        for (Enumeration<Benutzer> ea = this.getAllBenutzer().elements(); ea.hasMoreElements();)
        {
            Vector<String> zeilenVector = new Vector<String>();
            Benutzer b = ea.nextElement();
            zeilenVector.add(b.getName() + ", " + b.getVorname());
            zeilenVector.add(b.getEmail());
            zeilenVector.add(b.getTelefon());
            zeilenVector.add(b.getAdresse());
            zeilenVector.add(b.getOrt());
            zeilenVector.add(b.getPostleitzahl());
            if(b.getIsAdmin()) {
               zeilenVector.add("true"); 
            }
            else {
               zeilenVector.add("false");
            }
            
            tabellenVector.add(zeilenVector);
        }
        header.add("Name");
        header.add("EMail-Adresse");
        header.add("Telefon");
        header.add("Adresse");
        header.add("Ort");
        header.add("Postleitzahl");
        header.add("Admin");
        return new model(tabellenVector, header);
    }

    /**
     * Löscht einen Benutzern anhand seiner Emailadresse.
     * @param sEmail Emailadresse des zu löschenden Benutzers.
     */
    public void deleteBenutzer(String sEmail)
    {
        try
        {
            dataBase.update("DELETE FROM benutzer WHERE b_email='" + sEmail + "'");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Speichert ein neues Projekt in der Datenbank.
     * @param p Daten des zu speichernden Projektes.
     */
    public void saveNewProjekt(Projekt p)
    {
        String query = "INSERT INTO projekt(p_titel, p_fach, p_kurzbeschreibung, p_beschreibung, p_skizze, p_ansprechpartner, p_teilnehmer1, p_teilnehmer2, p_teilnehmer3, p_vortrag1, p_vortrag2) VALUES(";
        query += "'" + p.getTitel() + "',";
        query += "'" + p.getFach() + "',";
        query += "'" + p.getKurzbeschreibung() + "',";
        query += "'" + p.getBeschreibung() + "',";
        query += "'" + p.getSkizze() + "',";
        query += "'" + p.getAnsprechpartner().getEmail() + "',";
        query += "'" + p.getTeilnehmer()[0].getEmail() + "',";
        
        if (p.getTeilnehmer()[1] == null) {
            query += "'',";            
        }
        else {
            query += "'" + p.getTeilnehmer()[1].getEmail() + "',";
        }
        
        if (p.getTeilnehmer()[2] == null) {
            query += "'',";            
        }
        else {
            query += "'" + p.getTeilnehmer()[2].getEmail() + "',";
        }
        
        query += "'" + p.getVortrag1() + "',";
        query += "'" + p.getVortrag2() + "'";
        query += ")";
        try
        {
            dataBase.update(query);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gibt ein Projekt aus der Datenbank anhand des Titels zurück.
     * @param titel Titel des gesuchten Projekts.
     * @return Gefundenes Projekt oder wenn kein Projekt gefunden wurde null.
     */
    public Projekt getProjekt(String titel)
    {
        try
        {
            ResultSet rs = dataBase.query("Select * from projekt where p_titel  = '" + titel + "'");
            if (rs.next())
            {
                Ansprechpartner ansp = getAnsprechpartner(rs.getString("p_ansprechpartner"));
                Benutzer[] benu = new Benutzer[3];
                benu[0] = getBenutzer(rs.getString("p_teilnehmer1"));
                benu[1] = getBenutzer(rs.getString("p_teilnehmer2"));
                benu[2] = getBenutzer(rs.getString("p_teilnehmer3"));
                return new Projekt(rs.getString("p_titel"), rs.getString("p_fach"), rs.getString("p_kurzbeschreibung"), rs.getString("p_beschreibung"), rs.getString("p_skizze"), ansp, benu, rs.getString("p_vortrag1"), rs.getString("p_vortrag2"));
            }
            else
            {
                return null;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
        
    /**
     * Ändert die Daten eines Projektes.
     * @param sOldTitel Aktueller Titel des Projektes.
     * @param p Neue Daten des Projektes.
     */
    public void updateProjekt(String sOldTitel, Projekt p)
    {
        String query = "UPDATE projekt "
                + "SET p_titel='" + p.getTitel() + "',"
                + "p_fach='" + p.getFach() + "',"
                + "p_kurzbeschreibung='" + p.getKurzbeschreibung() + "',"
                + "p_beschreibung='" + p.getBeschreibung() + "',"
                + "p_skizze='" + p.getSkizze() + "',"
                + "p_ansprechpartner='" + p.getAnsprechpartner().getEmail() + "',"
                + "p_teilnehmer1='" + p.getTeilnehmer()[0].getEmail() + "',";
        
                if (p.getTeilnehmer()[1] != null) {
                    query += "p_teilnehmer2='" + p.getTeilnehmer()[1].getEmail() + "',";
                }
                
                if (p.getTeilnehmer()[2] != null) {
                    query += "p_teilnehmer3='" + p.getTeilnehmer()[2].getEmail() + "',";
                }
                
         query += "p_vortrag1='" + p.getVortrag1() + "',"
                + "p_vortrag2='" + p.getVortrag2() + "' "
                + "WHERE p_titel='" + sOldTitel + "'";
        try
        {
            dataBase.update(query);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gibt einen Vektor mit allen bestehenden Projekten zurück.
     * @return Alle bestehenden Projekte.
     */
    public Vector<Projekt> getAllProjekt()
    {
        Vector<Projekt> vProjekt = new Vector<Projekt>();
        try
        {
            ResultSet rs = dataBase.query("Select * from projekt order by p_titel");

            while (rs.next())
            {
                Ansprechpartner Ansprechpartner = getAnsprechpartner(rs.getString("p_ansprechpartner"));
                
                Benutzer[] Teilnehmer = {getBenutzer(rs.getString("p_teilnehmer1")), getBenutzer(rs.getString("p_teilnehmer2")), getBenutzer(rs.getString("p_teilnehmer3"))};
                
                vProjekt.add(new Projekt(rs.getString("p_titel"), 
                        rs.getString("p_fach"), 
                        rs.getString("p_kurzbeschreibung"), 
                        rs.getString("p_beschreibung"), 
                        rs.getString("p_skizze"), 
                        Ansprechpartner, 
                        Teilnehmer, 
                        rs.getString("p_vortrag1"), 
                        rs.getString("p_vortrag2")));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vProjekt;
    }
    
    /**
     * Gibt ein Tabellenmodell mit allen bestehenden Projekten zurück.
     * @return Tabellenmoddel mit allen bestehenden Projekten.
     */
    public model getProjektModel()
    {
        Vector tabellenVector = new Vector();
        Vector header = new Vector();

        for (Enumeration<Projekt> ea = this.getAllProjekt().elements(); ea.hasMoreElements();)
        {
            Vector<String> zeilenVector = new Vector<String>();
            Projekt p = ea.nextElement();
            zeilenVector.add(p.getTitel());
            zeilenVector.add(p.getFach());
            zeilenVector.add(p.getAnsprechpartner().getName());
            zeilenVector.add(p.getVortrag1());
            zeilenVector.add(p.getVortrag2());
            
            tabellenVector.add(zeilenVector);
        }
        header.add("Titel");
        header.add("Fach");
        header.add("Ansprechpartner");
        header.add("Vortrag 1");
        header.add("Vortrag 2");
        return new model(tabellenVector, header);

    } 
    
    /**
     * Löscht ein Projekt anhand des Titels
     * @param sTitel Titel des zu löschenden Projektes.
     */
    public void deleteProjekt(String sTitel)
    {
        try
        {
            dataBase.update("DELETE FROM projekt WHERE p_titel='" + sTitel + "'");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * Speichert einen neuen Ansprechpartner in der Datenbank.
     * @param a Der zu speichernde Ansprechpartner.
     */
    public void saveNewAnsprechpartner(Ansprechpartner a)
    {
        String query = "INSERT INTO ansprechpartner(a_name, a_vorname, a_email, a_organisation) VALUES(";
        query += "'" + a.getName() + "',";
        query += "'" + a.getVorname() + "',";
        query += "'" + a.getEmail() + "',";
        query += "'" + a.getOrganisation().getName() + "'";
        query += ")";
        try
        {
            dataBase.update(query);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * Ändert die Daten eines bestehenden Ansprechpartners.
     * @param sOldEmail Aktuelle Emailadresse des zu ändernden Ansprechpartners.
     * @param a Die Neuen Daten des Ansprechpartners.
     */
    public void updateAnsprechpartner(String sOldEmail, Ansprechpartner a)
    {
        String query = "UPDATE ansprechpartner "
                + "SET a_name='" + a.getName() + "',"
                + "a_vorname='" + a.getVorname() + "',"
                + "a_email='" + a.getEmail() + "',"
                + "a_organisation='" + a.getOrganisation().getName() + "' "
                + "WHERE a_email='" + sOldEmail + "'";
        try
        {
            dataBase.update(query);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * Gibt einen bestehenden Ansprechpartner anhand seiner Email Adresse zurück.
     * @param email Email Adresse des gesuchten Ansprechpartners.
     * @return Gibt den gefundenen Ansprechpartner zurück oder wenn keiner gefunden wurde null.
     */
    public Ansprechpartner getAnsprechpartner(String email)
    {

        try
        {
            ResultSet rs = dataBase.query("Select * from ansprechpartner where a_email  = '" + email + "'");
            if (rs.next())
            {
                Organisation org = getOrganisation(rs.getString("a_organisation"));
                return new Ansprechpartner(rs.getString("a_name"), rs.getString("a_vorname"), rs.getString("a_email"), org);
            }
            else
            {
                return null;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    /**
     * Gibt einen Vektor mit allen in der Datenbank gespeicherten Ansprechpartnern zurück.
     * @return Alle in der Datenbank gespeicherten Ansprechpartner.
     */
    public Vector<Ansprechpartner> getAllAnsprechpartner()
    {
        Vector<Ansprechpartner> vAnsp = new Vector<Ansprechpartner>();
        try
        {
            ResultSet rs = dataBase.query("Select * from ansprechpartner order by a_organisation");

            while (rs.next())
            {
                Organisation org = getOrganisation(rs.getString("a_organisation"));
                vAnsp.add(new Ansprechpartner(rs.getString("a_name"), rs.getString("a_vorname"), rs.getString("a_email"), org));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vAnsp;
    }
    
    /**
     * Gibt ein Tabellenmodell mit allen Ansprechpartnern zurück.
     * @return Tabellenmodell mit allen gespeicherten Ansprechpartnern.
     */
    public model getAnsprechpartnerModel()
    {
        Vector tabellenVector = new Vector();
        Vector header = new Vector();

        for (Enumeration<Ansprechpartner> ea = this.getAllAnsprechpartner().elements(); ea.hasMoreElements();)
        {
            Vector<String> zeilenVector = new Vector<String>();
            Ansprechpartner a = ea.nextElement();
            zeilenVector.add(a.getName() + ", " + a.getVorname());
            zeilenVector.add(a.getEmail());
            zeilenVector.add(a.getOrganisation().getName());
            tabellenVector.add(zeilenVector);
        }
        header.add("Name");
        header.add("EMail-Adresse");
        header.add("Organisation");
        return new model(tabellenVector, header);

    }

    /**
     * Löscht einen Ansprechpartner aus der Datenbank anhand seiner Email Adresse.
     * @param sEmail Email Adresse des zu löschenden Ansprechpartners.
     */
    public void deleteAnsprechpartner(String sEmail)
    {
        try
        {
            dataBase.update("DELETE FROM ansprechpartner WHERE a_email='" + sEmail + "'");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * Speichert eine neue Organisation in der Datenbank.
     * @param o die zu speichernde Organisation.
     */
    public void saveNewOrganisation(Organisation o)
    {
        String query = "INSERT INTO organisation(o_name, o_adresse, o_ort, o_postleitzahl) VALUES(";
        query += "'" + o.getName() + "',";
        query += "'" + o.getAdresse() + "',";
        query += "'" + o.getOrt() + "',";
        query += "'" + o.getPostleitzahl() + "'";
        query += ")";
        try
        {
            dataBase.update(query);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * Ändert eine bestehende Organisation.
     * @param sOldName Der bisherige Name der Organisation.
     * @param o Die neuen Daten der Organisation.
     */
    public void updateOrganisation(String sOldName, Organisation o)
    {
        String query = "UPDATE organisation "
                + "SET o_name='" + o.getName() + "',"
                + "o_adresse='" + o.getAdresse() + "',"
                + "o_ort='" + o.getOrt() + "',"
                + "o_postleitzahl='" + o.getPostleitzahl() + "' "
                + "WHERE o_name='" + sOldName + "'";
        try
        {
            dataBase.update(query);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Gibt eine gesuchte Organisation anhand des Namens zurück.
     * @param name Name der gesuchten Organisation.
     * @return Die Organisation wenn gefunden wurde. Ansonsten null. 
     */
    public Organisation getOrganisation(String name)
    {

        try
        {
            ResultSet rs = dataBase.query("Select * from organisation where o_name  = '" + name + "'");
            if (rs.next())
            {
                return new Organisation(rs.getString("o_name"), rs.getString("o_adresse"), rs.getString("o_ort"), rs.getString("o_postleitzahl"));
            }
            else
            {
                return null;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Gibt einen Vektor mit allen Organisationen zurück.
     * @return Alle gespeicherten Organisationen.
     */
    public Vector<Organisation> getAllOrganisation()
    {
        Vector<Organisation> vOrg = new Vector<Organisation>();
        try
        {
            ResultSet rs = dataBase.query("Select * from organisation order by o_name");

            while (rs.next())
            {
                vOrg.add(new Organisation(rs.getString("o_name"), rs.getString("o_adresse"), rs.getString("o_ort"), rs.getString("o_postleitzahl")));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vOrg;
    }

    /**
     * Gibt ein Tabellenmodell mit allen Organisationen zurück.
     * @return Tabellenmodell mit allen Organisationen.
     */
    public model getOrganisationsModel()
    {
        Vector tabellenVector = new Vector();
        Vector header = new Vector();

        for (Enumeration<Organisation> eo = this.getAllOrganisation().elements(); eo.hasMoreElements();)
        {
            Vector<String> zeilenVector = new Vector<String>();
            Organisation o = eo.nextElement();
            zeilenVector.add(o.getName());
            zeilenVector.add(o.getAdresse());
            zeilenVector.add(o.getOrt());
            zeilenVector.add(o.getPostleitzahl());
            int anzahl = 0;
            try
            {
                ResultSet rs = dataBase.query("select count(*) from ansprechpartner where a_organisation = '" + o.getName() + "'");
                while (rs.next())
                {
                    anzahl = rs.getInt(1);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
            zeilenVector.add(String.valueOf(anzahl));
            tabellenVector.add(zeilenVector);
        }
        header.add("Firmenname");
        header.add("Adresse");
        header.add("Ort");
        header.add("Postleitzahl");
        header.add("Anzahl Ansprechpartner");
        return new model(tabellenVector, header);

    }

    /**
     * Löscht eine Organisation anhand des Namens.
     * @param sName Name der zu löschenden Organisation.
     */
    public void deleteOrganisation(String sName)
    {
        try
        {
            dataBase.update("DELETE FROM organisation WHERE o_name='" + sName + "'");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fügt einem Projekt einen neuen Benutzer zu.
     * @param b Benutzer der hinzugefügt werden soll.
     * @param projekttitel Titel des Projektes dem der Benutzer hinzugefügt werden soll.
     * @param teilnehmerindex Um den wievielten Teilnehmer handelt es sich.
     */
    public void setProjektteilnehmer(Benutzer b, String projekttitel, int teilnehmerindex)
    {
        if (teilnehmerindex <= 3 && b != null && getProjekt(projekttitel) != null) {
            String query = "UPDATE projekt SET p_teilnehmer" + teilnehmerindex + "='" + b.getEmail() + "',WHERE p_titel='" + projekttitel + "'";
        
            try
            {
                dataBase.update(query);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Löscht einen Teilnehmer aus der Zuordnungstabelle
     * @param b Benutzer der gelöscht werdne soll
     * @param projekttitel Titel des Projektes dem der Benutzer zugeordnet war.
     */
    public void deleteTeilnehmerzuordnung(Benutzer b, String projekttitel)
    {
        if (b != null) {
            try
            {
                dataBase.update("DELETE FROM projektteilnehmer WHERE pt_email='" + b.getEmail() + "' AND pt_titel='" + projekttitel + "'");
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
    /**
     * Gibt einen gesuchten Teilnehmer aus der Zuordnungstabelle zurück.
     * @param email Email Adresse des gesuchten Benutzers.
     * @return Gefundenezuordnung oder wenn keine Zuordnung gefunden wurde null.
     */
    public Teilnehmerzuordnung getTeilnehmerzuordnung(String email)
    {
        if (!email.equals("")) {
            try
            {
                ResultSet rs = dataBase.query("Select * from projektteilnehmer where pt_email  = '" + email + "'");
                if (rs.next())
                {
                    return new Teilnehmerzuordnung(rs.getString("pt_email"), rs.getString("pt_titel"), rs.getInt("pt_index"));
                }
                else
                {
                    return null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
    
    /**
     * löscht einen Projektteilnehmer
     * @param iIndex Der Index des Teilnehmers
     * @param sTitel Der Titel des Projektes
     */
    public void deleteProjektteilnehmer(int iIndex, String sTitel)
    {
        int index = iIndex + 1;
        if (index <= 3) {
            String query = "UPDATE projekt SET p_teilnehmer" + index + "='test' WHERE p_titel='" + sTitel + "'";
            
            try
            {
                dataBase.update(query);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Fügt eine Teilnehmerzzordnung zur Zuordnungstabelle hinzu
     * @param tz Hinzuzufügende Teilnehmerzuordnung
     */
    public void saveNewTeilnehmerzuordnung(Teilnehmerzuordnung tz)
    {
        if (tz != null) {
            String query = "INSERT INTO projektteilnehmer(pt_email, pt_titel, pt_index) VALUES(";
            query += "'" + tz.getEmail() + "',";
            query += "'" + tz.getTitel() + "',";
            query += "'" + tz.getTeilnehmerindex() + "'";
            query += ")";
            try
            {
                dataBase.update(query);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
      
    
    /**
     * Gibt einen Terminvorschlag zurück
     * @param sStatus Status des gesuchten Terminvorschlags
     * @return Gefundener Terminvorschlag oder wenn keine Zuordnung gefunden wurde null.
     */
    public Terminvorschlag getTerminvorschlagStatus(String sStatus)
    {
        if (sStatus.equals("pending") || sStatus.equals("angenommen") || sStatus.equals("abgelehnt")) {
            try
            {
                ResultSet rs = dataBase.query("Select * from terminvorschlag WHERE tv_status='" + sStatus + "'");
                if (rs.next())
                {
                    return new Terminvorschlag(rs.getString("tv_titel"), rs.getString("tv_termin"), rs.getInt("tv_index"), rs.getString("tv_status"));
                }
                else
                {
                    return null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    /**
     * Gibt einen Terminvorschlag zurück
     * @param sTitel Titel des Projektes
     * @return Gefundener Terminvorschlag oder wenn keine Zuordnung gefunden wurde null.
     */
    public Terminvorschlag getTerminvorschlagTitel(String sTitel)
    {
        if (sTitel != null) {
            try
            {
                ResultSet rs = dataBase.query("Select * from terminvorschlag WHERE tv_titel='" + sTitel + "'");
                if (rs.next())
                {
                    return new Terminvorschlag(rs.getString("tv_titel"), rs.getString("tv_termin"), rs.getInt("tv_index"), rs.getString("tv_status"));
                }
                else
                {
                    return null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    
    /**
     * Fügt eine Terminvorschlag zur Datenbank hinzu
     * @param tv Hinzuzufügende Terminvorschlag
     */
    public void saveNewTerminvorschlag(Terminvorschlag tv)
    {
        if (tv != null) {
            String query = "INSERT INTO terminvorschlag(tv_titel, tv_termin, tv_index, tv_status) VALUES(";
            query += "'" + tv.getTitel() + "',";
            query += "'" + tv.getTermin() + "',";
            query += "'" + tv.getIndex() + "',";
            query += "'" + tv.getStatus() + "'";
            query += ")";
            try
            {
                dataBase.update(query);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Löscht einen Terminvorschlag aus der Datenbank
     * @param index Index des Vorgeschlagenen Termins.
     * @param projekttitel Titel des Projektes dem der Temrin zugeordnet ist.
     */
    public void deleteTerminvorschlag(int index, String projekttitel)
    {
        if (index <= 2 && projekttitel != null) {
            try
            {
                dataBase.update("DELETE FROM terminvorschlag WHERE tv_titel='" + projekttitel + "' AND tv_index='" + index + "'");
            }
            catch (SQLException ex)
            {
                Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
    
    /**
     * Ändert den Status eines Terminvorschlags
     * @param index Index des Vorgeschlagenen Termins.
     * @param projekttitel Titel des Projektes dem der Termin zugeordnet ist.
     * @param sStaus Neuer Status des Vorschlags.
     */
    public void updateTerminstatus(int index, String projekttitel, String sStaus)
    {
        String query = "UPDATE terminvorschlag "
                + "SET tv_status='" + sStaus + "' "
                + "WHERE tv_titel='" + projekttitel + "' AND tv_index='" + index + "' ";
        try
        {
            dataBase.update(query);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DataP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
