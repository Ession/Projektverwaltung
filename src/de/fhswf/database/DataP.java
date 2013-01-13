package de.fhswf.database;

import de.fhswf.classes.Ansprechpartner;
import de.fhswf.classes.Benutzer;
import de.fhswf.classes.Organisation;
import de.fhswf.classes.Projekt;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dark
 */
public class DataP
{

    private static final String DataBaseFileName = "projektverwaltung3";
    private static final File DataBaseFile = new File(DataBaseFileName + ".script");
    private DataBase dataBase;

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
     *
     * @param expression
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
     *
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
     *
     */
    public DataP()
    {
        initDataBase();
    }

    /**
     *
     * @param b
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
     *
     * @param sOldEmail
     * @param b
     * @param NewPW
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
     *
     * @param email
     * @return
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
     *
     * @return
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
     *
     * @return
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
     *
     * @param sEmail
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
     *
     * @param p
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
     *
     * @param titel
     * @return
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
                benu[2] = getBenutzer(rs.getString("p_teilnehmer2"));
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
     *
     * @param sOldTitel
     * @param p
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
                    query += "p_teilnehmer3='" + p.getTeilnehmer()[1].getEmail() + "',";
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
     *
     * @return
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
     *
     * @return
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
     *
     * @param sTitel
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
     *
     * @param a
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
     *
     * @param sOldEmail
     * @param a
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
     *
     * @param email
     * @return
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
     *
     * @return
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
     *
     * @return
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
     *
     * @param sEmail
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
     *
     * @param o
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
     *
     * @param sOldName
     * @param o
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
     *
     * @param name
     * @return
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
     *
     * @return
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
     *
     * @return
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
     *
     * @param sName
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
    
}
