public class Main {
    
    public static void main(String[] args) throws Exception {

        final Ponte PONTE = new Ponte(Ponte.MUTEX);
        
        final int NUMERO_AUTOMOBILI = 8;
        for (int i=1; i <= NUMERO_AUTOMOBILI; i++)
            new Thread(new Automobile("auto"+i, PONTE)).start();
    }
}
