public class MesaPedidoFactory implements PedidoFactory {

    private int numeroMesa;
    private Mesero meseroAsignado;

    public MesaPedidoFactory(int numeroMesa, Mesero meseroAsignado) {
        this.numeroMesa = numeroMesa;
        this.meseroAsignado = meseroAsignado;
    }

    @Override
    public Pedido crearPedido() {
        return new PedidoEnMesa(numeroMesa, meseroAsignado);
    }
}
