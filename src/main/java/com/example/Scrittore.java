package com.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scrittore implements Runnable {
    String nomeFile;
    ArrayList<Canzone> catalogo;

    public Scrittore(String nomeFile, ArrayList<Canzone> catalogo) {
        this.nomeFile = nomeFile;
        this.catalogo = catalogo;
    }

    @Override
    public void run() {
        scrivi();
    }

    public void scrivi() {
        BufferedWriter br = null;

        try {
            System.out.println("\n[SCRITTORE] Scrittura file CSV: " + nomeFile);

            br = new BufferedWriter(new FileWriter(nomeFile));

            br.write("ID,Titolo,Artista,Genere,Durata");
            br.write("\n");

            for (Canzone c : catalogo) {
                String riga = c.getId() + "," + c.getTitolo() + "," +
                        c.getArtista() + "," + c.getGenere() + "," +
                        c.getDurata();
                br.write(riga);
                br.write("\n");
            }

            br.flush();

            System.out.println("[SCRITTORE] File CSV creato con successo!");
            System.out.println("[SCRITTORE] Totale canzoni salvate: " + catalogo.size());

        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}
