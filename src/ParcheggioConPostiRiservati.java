import java.util.ArrayList;

public class ParcheggioConPostiRiservati { // realizzato con un Monitor

    final private ArrayList<Posto> POSTI_DISPONIBILI = new ArrayList<Posto>();

    public ParcheggioConPostiRiservati (int numeroPosti){

        for (int numero = 1; numero <= numeroPosti; numero++){
            final Posto POSTO = new Posto(numero);
            POSTI_DISPONIBILI.add(POSTO);
        }            
    }

    public synchronized Posto richiedi() throws InterruptedException{
        
        while (POSTI_DISPONIBILI.size() == 0)
            wait();
        
        return POSTI_DISPONIBILI.removeFirst();
    }

    public synchronized void rilascia(Posto posto){
        POSTI_DISPONIBILI.add(posto);
        notify();
    }

}
