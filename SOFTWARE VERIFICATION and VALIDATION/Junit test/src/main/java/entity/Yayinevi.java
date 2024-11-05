/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author MP
 */
public class Yayinevi {
    private String yayineviAdi;
    private String adres;
    private String telefon;

    public Yayinevi(String yayineviAdi, String adres, String telefon) {
        this.yayineviAdi = yayineviAdi;
        this.adres = adres;
        this.telefon = telefon;
    }

    // Getters
    public String getYayineviAdi() {
        return yayineviAdi;
    }

    public String getAdres() {
        return adres;
    }

    public String getTelefon() {
        return telefon;
    }

    // Setters
    public void setYayineviAdi(String yayineviAdi) {
        this.yayineviAdi = yayineviAdi;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Yayinevi{" +
                "yayineviAdi='" + yayineviAdi + '\'' +
                ", adres='" + adres + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
