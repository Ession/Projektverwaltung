package de.fhswf.database;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class model extends DefaultTableModel
{

    public model(Vector data, Vector columnNames)
    {
        super(data, columnNames);
    }

    // die Methode verhindert das Editieren von Zellen
    @Override
    public boolean isCellEditable(int row,int coloumn)
    {
        return false;
    }
}
