import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {

    protected int id;
    protected List<Item> items = new ArrayList<>();
    protected State estado;

    public Pedido() {
        this.id = (int) (Math.random() * 10000);
    }

    public abstract double calcularTotal();
    public abstract void mostrarDetalle();

    public int getId() { return id; }

    public void agregarItem(Item item) {
        items.add(item);
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }
}
