import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Automobile implements Runnable {

    private String nome;
    private ParcheggioConPostiRiservati parcheggio;
    
    public Automobile(String nome, ParcheggioConPostiRiservati parcheggio) {
        this.nome = nome;
        this.parcheggio = parcheggio;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            TimeUnit.SECONDS.sleep(RANDOM.nextInt(2));

            // richiesta parcheggio
            System.out.println(this.toString() + " sta richiedendo un posto");
            Posto POSTO = parcheggio.richiedi();

            // utilizzo parcheggio
            System.out.println(this.toString() + " sta sostando nel posto " + POSTO.toString());
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

            // rilascio parcheggio
            System.out.println(this.toString() + " sta liberando il posto " + POSTO.toString());
            parcheggio.rilascia(POSTO);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Automobile " + nome;
    }

}
