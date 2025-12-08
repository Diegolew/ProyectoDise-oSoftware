public class ServidoState extends BasePedidoState {

    @Override
    public void retroceder(Pedido pedido) {
        pedido.setEstado(new ListoState());
    }

    @Override
    public String getNombreEstado() {
        return "Servido";
    }
}
