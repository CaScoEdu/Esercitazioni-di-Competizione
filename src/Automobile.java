import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Automobile implements Runnable {

    final private String NOME;
    final private Ponte PONTE;
    
    // costruttore dell'automobile
    public Automobile(final String NOME, final Ponte PONTE) {
        this.NOME = NOME;
        this.PONTE = PONTE;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            TimeUnit.SECONDS.sleep(RANDOM.nextInt(2));

            // richiesta (accesso al) ponte
            System.out.println(this.toString() + " vuole accedere al ponte");

            // INIZIO SEZIONE CRITICA IN MUTUA ESCLUSIONE
            PONTE.richiedi();

            // utilizzo ponte
            System.out.println(this.toString() + " sta transitando sul ponte");
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

            // rilascio ponte (uscita dal ponte)
            System.out.println(this.toString() + " sta uscendo dal ponte");
            PONTE.rilascia();
            
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
