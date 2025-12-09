public class PedidoEnMesa extends Pedido {

    private int numeroMesa;
    private Mesero meseroAsignado;

    public PedidoEnMesa(int numeroMesa, Mesero meseroAsignado) {
        super();
        this.numeroMesa = numeroMesa;
        this.meseroAsignado = meseroAsignado;
    }

    @Override
    public double calcularTotal() {
        return items.stream().mapToDouble(Item::getPrecio).sum();
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("=== PEDIDO EN MESA ===");
        System.out.println("ID: " + id);
        System.out.println("Mesa: " + numeroMesa);
        System.out.println("Mesero: " + meseroAsignado.getNombre());
        items.forEach(i -> System.out.println(i.getNombre() + " - " + i.getPrecio()));
        System.out.println("Total: " + calcularTotal());
    }
}
