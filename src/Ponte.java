
public class Ponte { // realizzato con un Semaforo Mutex 
    //(caso particolare di semaforo di Dijkstra inizializzato a 1)

    static final int MUTEX = 1;
    private int autoChePossonoAccedere;

    // costruttore del Semaforo
    public Ponte (int autoChePossonoAccedere){

        this.autoChePossonoAccedere = autoChePossonoAccedere;            
    }

    // richiesta risorsa (WAIT del Semaforo)
    public synchronized void richiedi() throws InterruptedException{
        
        while (autoChePossonoAccedere == 0)
            wait();
        
        autoChePossonoAccedere--;
    }

    // rilascio risorsa (SIGNAL del Semaforo)
    public synchronized void rilascia(){
        autoChePossonoAccedere++;
        notify();
    }

}
