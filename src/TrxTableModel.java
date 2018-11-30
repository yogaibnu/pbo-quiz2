
import javax.swing.table.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YOGA
 */
public class TrxTableModel {
    //atribut untuk meynimpan nama 
    private String[] columns; 
    
    //konstruktor
    public TrxTableModel(String[] columns) {
        this.columns = new String[] {
            "Nama", "Harga", "Jumlah"
        };
    }
    
    //method untuk mendapatkan nama kolom
    public String[] getColumnName() {
        return this.columns;
    }
}
