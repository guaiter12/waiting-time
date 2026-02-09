package com.example;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lettore extends Thread {
    String nomeFile;
    ArrayList<Canzone> canzoniLette;

    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
        this.canzoniLette = new ArrayList<Canzone>();
    }

    public void leggi() {
        FileReader fr;
        int i;
        try {
            fr = new FileReader(nomeFile);
            System.out.println("\n[LETTORE] Lettura file JSON: " + nomeFile);
            System.out.println("=".repeat(50));

            while ((i = fr.read()) != -1)
                System.out.print((char) i);

            System.out.print("\n");
            System.out.println("=".repeat(50));

            fr.close();
        } catch (IOException ex) {
            System.err.println("[LETTORE] Errore in lettura: " + ex.getMessage());
        }
    }

    public void run() {
        leggi();
    }

    public ArrayList<Canzone> getCanzoniLette() {
        return canzoniLette;
    }
}