
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YOGA
 */
public class TrxComboModel {
    private HashMap<String, Float> items = new HashMap<>();
    
    //konstruktor
    public TrxComboModel() {
        this.items.put("Gula", new Float(30000));
        this.items.put("Kopi", new Float(10000));
    }
    
    public ArrayList<String> getNama() {
        ArrayList<String> str = new ArrayList<>();
        for(String item : this.items.keySet()) {
            str.add(item);
        }
        return str;
    }
    
    public ArrayList<Float> getHarga() {
        ArrayList<Float> flt = new ArrayList<>();
        for(float item : this.items.values()) {
            flt.add(item);
        }
        return flt;
    }
    
    public void addItem(String nama, float harga) {
        this.items.put(nama, harga);
    }
}
