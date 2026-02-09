package com.example;
public class Canzone {
    private int id;
    private String titolo;
    private String artista;
    private String genere;
    private int durata;

    public Canzone(int id, String titolo, String artista, String genere, int durata) {
        this.id = id;
        this.titolo = titolo;
        this.artista = artista;
        this.genere = genere;
        this.durata = durata;
    }

    public Canzone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String toString() {
        return "ID: " + id + " - " + titolo + " di " + artista +
                " [" + genere + "] - " + durata + " sec";
    }
}
