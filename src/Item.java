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
    
    //untuk mengambil nama
    public String getNama() {
        return nama;
    }
    
    //untuk setting nama
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    //untuk mengambil harga
    public float getHarga() {
        return harga;
    }
    
    //untuk setting harga
    public void setHarga(float harga) {
        this.harga = harga;
    }

    //untuk mengambil jumlah
    public int getJumlah() {
        return jumlah;
    }

    //untuk setting jumlah
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    

}
