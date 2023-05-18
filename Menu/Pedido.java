import java.util.ArrayList;

public class Pedido {
    private ArrayList<String> itensPedido;

    public Pedido() {
        itensPedido = new ArrayList<>();
    }

    public void adicionarPedidoItem(String item) {
        itensPedido.add(item);
    }

    public void mostrarPedido() {
        for (String item : itensPedido) {
            System.out.println(item);
        }
    }
}
