
public class Parcheggio { // realizzato con un Semaforo Mutex (di Dijkstra con valore 1)

    static final int MUTEX = 1;
    private int postiDisponibili;

    // costruttore del Semaforo
    public Parcheggio (int postiDisponibili){

        this.postiDisponibili = postiDisponibili;            
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
