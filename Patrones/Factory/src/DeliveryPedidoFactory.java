public class DeliveryPedidoFactory implements PedidoFactory {

    private String direccion;
    private String telefono;

    public DeliveryPedidoFactory(String direccion, String telefono) {
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public Pedido crearPedido() {
        return new PedidoDelivery(direccion, telefono);
    }
}
