
public class Semaforo { 

    static final int MUTEX = 1;
    private int risorseDisponibili;

    // costruttore del Semaforo
    public Semaforo (int risorseDisponibili){

        this.risorseDisponibili = risorseDisponibili;            
    }

    // richiesta risorsa (corrisponde alla WAIT del Semaforo di Dijkstra)
    public synchronized void richiedi() throws InterruptedException{
        
        while (risorseDisponibili == 0)
            wait();
        
        risorseDisponibili--;
    }

    // rilascio risorsa (corrisponde alla SIGNAL del Semaforo di Dijkstra)
    public synchronized void rilascia(){
        risorseDisponibili++;
        notifyAll();
    }

}
