public class PedidoDelivery extends Pedido {

    private String direccion;
    private String telefono;

    public PedidoDelivery(String direccion, String telefono) {
        super();
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public double calcularTotal() {
        return items.stream().mapToDouble(Item::getPrecio).sum() + 5.0;
        // ejemplo: delivery agrega 5 bs
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("=== PEDIDO DELIVERY ===");
        System.out.println("ID: " + id);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        items.forEach(i -> System.out.println(i.getNombre() + " - " + i.getPrecio()));
        System.out.println("Total: " + calcularTotal());
    }
}
