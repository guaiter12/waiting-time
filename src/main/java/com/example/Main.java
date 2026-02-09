package com.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  PIATTAFORMA DI STREAMING MUSICALE       ║");
        System.out.println("╚════════════════════════════════════════════╝");

        try {
            System.out.println("\n--- FASE 1: LETTURA ---");
            Lettore lettore = new Lettore("canzoni.json");
            lettore.start();
            lettore.join();

            System.out.println("\n--- FASE 2: ELABORAZIONE ---");
            ArrayList<Canzone> catalogo = new ArrayList<Canzone>();

            catalogo.add(new Canzone(1, "Bohemian Rhapsody", "Queen", "Rock", 354));
            catalogo.add(new Canzone(2, "Blinding Lights", "The Weeknd", "Pop", 200));
            catalogo.add(new Canzone(3, "Lose Yourself", "Eminem", "Rap", 326));
            catalogo.add(new Canzone(4, "Smells Like Teen Spirit", "Nirvana", "Grunge", 301));
            catalogo.add(new Canzone(5, "One More Time", "Daft Punk", "Electronic", 320));
            catalogo.add(new Canzone(6, "Hotel California", "Eagles", "Rock", 391));
            catalogo.add(new Canzone(7, "Shape of You", "Ed Sheeran", "Pop", 234));
            catalogo.add(new Canzone(8, "Rolling in the Deep", "Adele", "Soul", 228));
            catalogo.add(new Canzone(9, "Billie Jean", "Michael Jackson", "Pop", 294));
            catalogo.add(new Canzone(10, "Wonderwall", "Oasis", "Rock", 258));

            System.out.println("[ELABORAZIONE] Catalogo creato con " + catalogo.size() + " canzoni");

            System.out.println("\n--- FASE 3: SCRITTURA ---");
            Scrittore scrittore = new Scrittore("output.csv", catalogo);
            Thread threadScrittore = new Thread(scrittore);
            threadScrittore.start();
            threadScrittore.join();

            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║  APPLICAZIONE COMPLETATA                 ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println("\nFile utilizzati:");
            System.out.println("  → canzoni.json  (input)");
            System.out.println("  ✓ output.csv    (output)");
            System.out.println("\nTotale canzoni: " + catalogo.size());

        } catch (InterruptedException ex) {
            System.err.println("Errore: " + ex.getMessage());
        }
    }
}