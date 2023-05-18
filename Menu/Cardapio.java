import java.util.ArrayList;

public class Cardapio {
    private ArrayList<String> itensCardapio;

    public Cardapio() {
        itensCardapio = new ArrayList<>();
    }

    public void adicionarItem(String item) {
        itensCardapio.add(item);
    }

    public void mostrarCardapio() {
        for (String item : itensCardapio) {
            System.out.println(item);
        }
    }
}