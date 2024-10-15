import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Automobile implements Runnable {

    private String nome;
    private Ponte ponte;
    
    // costruttore dell'automobile
    public Automobile(String nome, Ponte ponte) {
        this.nome = nome;
        this.ponte = ponte;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            TimeUnit.SECONDS.sleep(RANDOM.nextInt(2));

            // richiesta (accesso al) ponte
            System.out.println(this.toString() + " vuole accedere al ponte");

            // INIZIO SEZIONE CRITICA IN MUTUA ESCLUSIONE
            ponte.richiedi();

            // utilizzo ponte
            System.out.println(this.toString() + " sta transitando sul ponte");
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

            // rilascio ponte (uscita dal ponte)
            System.out.println(this.toString() + " sta uscendo dal ponte");
            ponte.rilascia();
            
            // FINE SEZIONE CRITICA IN MUTUA ESCLUSIONE

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Automobile " + nome;
    }

}
