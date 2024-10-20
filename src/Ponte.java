
public class Ponte { // realizzato con un Semaforo Mutex 
    //(caso particolare di semaforo di Dijkstra inizializzato a 1)

    static final int MUTEX = 1;
    private int autoChePossonoAccedere;

    // costruttore del Semaforo
    public Ponte (final int AUTO_CHE_POSSONO_ACCEDERE){

        this.autoChePossonoAccedere = AUTO_CHE_POSSONO_ACCEDERE;            
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
