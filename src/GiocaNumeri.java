import java.util.Scanner;

public class GiocaNumeri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci i dati dei giocatori");

        System.out.println("Giocatore 1: \nNome: ");
        String g1Nome = scanner.nextLine();
        System.out.println("Parola: ");
        String g1Parola = scanner.nextLine();
        System.out.println("Chiave: ");
        String g1Chiave = scanner.nextLine();

        System.out.println("Giocatore 2: \nNome: ");
        String g2Nome = scanner.nextLine();
        System.out.println("Parola: ");
        String g2Parola = scanner.nextLine();
        System.out.println("Chiave: ");
        String g2Chiave = scanner.nextLine();

        Thread tg1 = new Thread(new Giocatore(g1Nome, g1Parola, g1Chiave));
        Thread tg2 = new Thread(new Giocatore(g2Nome, g2Parola, g2Chiave));

        Long TempoEsecuzioneInizio = System.currentTimeMillis();
        System.out.println("Inizio");
        tg1.start();

        try {
            tg1.join(); //main viene fermato e tg1 viene mandato fino alla sua terminazione
        } catch (InterruptedException e) {
            System.err.println("Errore della transizione del main thread da RUNNING a SLEEPING " + e.getMessage());
        }
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Errore della transizione del main thread da RUNNING a SLEEPING " + e.getMessage());
        }
        tg2.start();

        try {
            tg2.join();
        } catch (InterruptedException e) {
            System.err.println("Errore della transizione del main thread da RUNNING a SLEEPING " + e.getMessage());
        }
        Long TempoEsecuzioneFine = System.currentTimeMillis();
        System.out.println("Tempo Esecuzione: "+ (TempoEsecuzioneFine - TempoEsecuzioneInizio)/1000);
        System.out.println("Fine");

    }
}