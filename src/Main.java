public class Main {
    
    public static void main(String[] args) throws Exception {

        final Parcheggio PARCHEGGIO = new Parcheggio(Parcheggio.MUTEX);
        
        final int NUMERO_AUTOMOBILI = 10;
        for (int i=1; i <= NUMERO_AUTOMOBILI; i++)
            new Thread(new Automobile("auto"+i, PARCHEGGIO)).start();
    }
}
