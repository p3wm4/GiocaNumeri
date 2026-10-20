import java.time.Instant;
import java.util.Random;

public class Giocatore implements Runnable {
    String nome;
    int punteggio;

    public Giocatore(String nome) {
        this.nome = nome;
        this.punteggio = 0;
    }

    @Override
    public void run(){
        Long tempoInizio = System.currentTimeMillis();
        int numero=10;
        String parola = "Buongiorno";
        punteggio=100;
        System.out.println("Giocatore: "+ nome);

        for (int i=0; i <numero; i++){
            try {
                System.out.println("Giocatore: " + nome + " | i: "+ i);
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