public class Main {
    
    public static void main(String[] args) throws Exception {
             

        final Parcheggio PARCHEGGIO = new Parcheggio();
        
        final int NUMERO_VEICOLI = 10;
        for (int i=1; i <= NUMERO_VEICOLI; i++)
            new Thread(new Automobile("auto"+i, PARCHEGGIO)).start();
    }
}
