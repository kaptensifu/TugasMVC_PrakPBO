/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Acer
 */
public class data_movie {
    private String judul;
    private Double alur;
    private Double penokohan;
    private Double akting;
    private Double nilai;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Double getAlur() {
        return alur;
    }

    public void setAlur(Double alur) {
        this.alur = alur;
    }

    public Double getPenokohan() {
        return penokohan;
    }

    public void setPenokohan(Double penokohan) {
        this.penokohan = penokohan;
    }

    public Double getAkting() {
        return akting;
    }

    public void setAkting(Double akting) {
        this.akting = akting;
    }

    public Double getNilai() {
        return nilai;
    }

    public void setNilai(Double nilai) {
        this.nilai = nilai;
    }
    
    public double menghitungNilai(){
        nilai= (akting+penokohan+alur)/3.0;
        return nilai;
    }
}
