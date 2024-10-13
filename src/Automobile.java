import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Automobile implements Runnable {

    private String nome;
    private ParcheggioMultiPosto parcheggio;
    
    // costruttore dell'automobile
    public Automobile(String nome, ParcheggioMultiPosto parcheggio) {
        this.nome = nome;
        this.parcheggio = parcheggio;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            TimeUnit.SECONDS.sleep(RANDOM.nextInt(2));

            // richiesta parcheggio
            System.out.println(this.toString() + " sta richiedendo il parcheggio");
            parcheggio.richiedi();

            // utilizzo parcheggio
            System.out.println(this.toString() + " sta sostando nel parcheggio");
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

            // rilascio parcheggio
            System.out.println(this.toString() + " sta liberando il parcheggio");
            parcheggio.rilascia();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Automobile " + nome;
    }

}
