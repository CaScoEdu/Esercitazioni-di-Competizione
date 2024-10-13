public class Posto {

    private int numero;

    public Posto(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Posto n." + numero;
    }

}
