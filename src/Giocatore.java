import java.time.Instant;
import java.util.Random;

public class Giocatore implements Runnable {
    String nome;
    String parola;
    String chiave;
    int punteggio;

    public Giocatore(String nome, String parola, String chiave) {
        this.nome = nome;
        this.parola = parola;
        this.chiave = chiave;
        this.punteggio = 0;
    }

    @Override
    public void run(){
        Long tempoInizio = System.currentTimeMillis();
        int numero=10;
        punteggio=100;
        Xor cifratura = new Xor(parola, chiave);
        System.out.println("Giocatore: "+ nome);

        for (int i=0; i <numero; i++){
            try {
                System.out.println(" i: "+ i);
                cifratura.cifratura(parola, chiave);
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println("errore nella transizione da RUNNING a SLEEPING " + ex.getMessage());
            }
        }
        //parte potenziata grazie a Gemini
        String parolaCifrata = cifratura.cifratura(parola, chiave);

        // 2. Preparo il nome del file con la data corrente nel formato ggmmyyyy
        String dataCorrente = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        String nomeFile = nome + " - gioco del " + dataCorrente + ".txt";

        // 3. Scrivo numero, punteggio e parola cifrata sul file PRIMA dell'output
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))) {
            writer.println("Numero: " + numero);
            writer.println("Punteggio: " + punteggio);
            writer.println("Parola cifrata: " + parolaCifrata);
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del file: " + e.getMessage());
        }

        // 4. Solo dopo aver scritto il file, stampo i risultati in output

        Long tempoFine = System.currentTimeMillis(); //long serve per rappresentare numeri interi più lunghi.
        System.out.println("Risultato: " +cifratura.cifratura(parola, chiave));
        System.out.println("Giocatore: " + nome + " | Punteggio: "+ punteggio + " | Durata esecuzione: "+ (tempoFine - tempoInizio)/1000);
    }
}