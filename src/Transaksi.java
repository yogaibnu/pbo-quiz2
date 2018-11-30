
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YOGA
 */
public class Transaksi {
    //atribut dengan variabel code, items, total
    private final String code;
    private ArrayList<Item> items = new ArrayList<>();
    private float total;
    
    //konstruktor
    public Transaksi(String code, ArrayList<Item> items) {
        this.code = code;
        this.items = items;
    }
    
    //method untuk setting total
    public void setTotal() {
        float total = 0;
        for(Item item : this.items) {
            total += item.getTotal();
        }
        this.total = total;
    }
    
    //method untuk menampilkan keluaran transaksi
    public String prtDetail() {
        setTotal();
        String str = "";
        str += "Kode\t\t: " + this.code + "\n";
        str += "Daftar Belanja : \n";
        for(Item item : this.items) {
            str += "\t" + item.getNama() + "(x" + item.getJumlah()+ ") : "
                    + item.getTotal() + "\n";
            str += "Total\t\t: " + this.total;
            return str;
        }
    }
}
