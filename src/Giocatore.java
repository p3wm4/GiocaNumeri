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
            System.out.println("Giocatore: " + nome );
            try {
                System.out.println(" i: "+ i);
                cifratura.cifratura(parola, chiave);
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println("errore nella transizione da RUNNING a SLEEPING " + ex.getMessage());
            }
        }
        System.out.println("Giocatore: " + nome + " | Punteggio: "+ punteggio);
        Long tempoFine = System.currentTimeMillis(); //long serve per rappresentare numeri interi più lunghi.
        System.out.println("Giocatore: " + nome + " | Tempo: "+ (tempoFine - tempoInizio)/1000);
    }
}