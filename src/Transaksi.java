
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
    
    
}
