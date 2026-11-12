    public class Xor {
    String parola;
    String chiave;
        public Xor(String parola, String chiave) {
            this.parola = parola;
            this.chiave = chiave;
        }
    public String cifratura (String parola, String chiave){
        StringBuilder risultato = new StringBuilder();

        for (int i = 0; i < parola.length(); i++) {
            char charTesto = parola.charAt(i);

            char charChiave = chiave.charAt(i % chiave.length());

            char charCifrato = (char) (charTesto ^ charChiave);

            risultato.append(charCifrato);
        }
        return risultato.toString();
    }
}
