
public class ParcheggioMultiPosto { // realizzato con un Semaforo di Dijkstra

    private int postiDisponibili;

    // costruttore del Semaforo
    public ParcheggioMultiPosto (int postiDisponibili){

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
