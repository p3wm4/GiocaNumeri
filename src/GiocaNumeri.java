public class GiocaNumeri {
    public static void main(String[] args) {
        Long TempoEsecuzioneInizio = System.currentTimeMillis();
        System.out.println("Inizio");
        Giocatore g1= new Giocatore("Francesco"); //un giocatore che si comporta come un Runnable
        Giocatore g2= new Giocatore("Monica");
        Thread tg1 = new Thread(g1);
        Thread tg2 = new Thread(g2);

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