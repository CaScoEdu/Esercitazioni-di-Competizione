public class Main {
    
    public static void main(String[] args) throws Exception {
             
        // creazione del parcheggio (la risorsa condivisa)
        final int NUMERO_POSTI_DEL_PARCHEGGIO = 4;
        final ParcheggioConPostiRiservati PARCHEGGIO = new ParcheggioConPostiRiservati(NUMERO_POSTI_DEL_PARCHEGGIO);
        
        // creazione delle automobili (in competizione per il parcheggio)
        final int NUMERO_AUTOMOBILI = 10;
        for (int i=1; i <= NUMERO_AUTOMOBILI; i++)
            new Thread(new Automobile("auto"+i, PARCHEGGIO)).start();
    }
}
