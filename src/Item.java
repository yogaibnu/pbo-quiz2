/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YOGA
 */
public class Item {
    //atribut dengan variabel nama, harga, jumlah
    private String nama;
    private float harga;
    private int jumlah;
    
    //konstruktor
    public Item(){
        
    }
    
    public Item(String nama, float harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }
    
}
