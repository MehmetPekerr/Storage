/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author MP
 */
public class Kitap {
    private String kitapAdi;
    private String yazar;
    private int yayinYili;
    private String yayinevi;
    private int sayfaSayisi;

    public Kitap(String kitapAdi, String yazar, int yayinYili, String yayinevi, int sayfaSayisi) {
        this.kitapAdi = kitapAdi;
        this.yazar = yazar;
        this.yayinYili = yayinYili;
        this.yayinevi = yayinevi;
        this.sayfaSayisi = sayfaSayisi;
    }

    // Getters
    public String getKitapAdi() {
        return kitapAdi;
    }

    public String getYazar() {
        return yazar;
    }

    public int getYayinYili() {
        return yayinYili;
    }

    public String getYayinevi() {
        return yayinevi;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    // Setters
    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public void setYayinYili(int yayinYili) {
        this.yayinYili = yayinYili;
    }

    public void setYayinevi(String yayinevi) {
        this.yayinevi = yayinevi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "kitapAdi='" + kitapAdi + '\'' +
                ", yazar='" + yazar + '\'' +
                ", yayinYili=" + yayinYili +
                ", yayinevi='" + yayinevi + '\'' +
                ", sayfaSayisi=" + sayfaSayisi +
                '}';
    }
}
