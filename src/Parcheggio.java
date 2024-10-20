
public class Parcheggio { // realizzato con un Semaforo di Dijkstra

    static final int MUTEX = 1;
    private int postiDisponibili;

    // costruttore del Semaforo
    public Parcheggio (final int POSTI_DISPONIBILI){

        this.postiDisponibili = POSTI_DISPONIBILI;            
    }

    // richiesta risorsa (WAIT del Semaforo)
    public synchronized void richiedi() throws InterruptedException{
        
        while (postiDisponibili == 0)
            wait();
        
        postiDisponibili--;
    }

    // rilascio risorsa (SIGNAL del Semaforo)
    public synchronized void rilascia(){
        postiDisponibili++;
        notify();
    }

}
