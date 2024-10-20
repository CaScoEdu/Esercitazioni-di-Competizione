import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Automobile implements Runnable {

    final private String NOME;
    final private Parcheggio PARCHEGGIO;
    
    // costruttore dell'automobile
    public Automobile(final String NOME, Parcheggio PARCHEGGIO) {
        this.NOME = NOME;
        this.PARCHEGGIO = PARCHEGGIO;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            TimeUnit.SECONDS.sleep(RANDOM.nextInt(2));

            // richiesta parcheggio
            System.out.println(this.toString() + " sta richiedendo il parcheggio");

            // INIZIO SEZIONE CRITICA IN MUTUA ESCLUSIONE
            PARCHEGGIO.richiedi();

            // utilizzo parcheggio
            System.out.println(this.toString() + " sta sostando nel parcheggio");
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

            // rilascio parcheggio
            System.out.println(this.toString() + " sta liberando il parcheggio");
            PARCHEGGIO.rilascia();
            
            // FINE SEZIONE CRITICA IN MUTUA ESCLUSIONE

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Automobile " + NOME;
    }

}
