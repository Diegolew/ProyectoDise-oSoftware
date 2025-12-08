public class ListoState extends BasePedidoState {

    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new ServidoState());
    }

    @Override
    public void retroceder(Pedido pedido) {
        pedido.setEstado(new EnPreparacionState());
    }

    @Override
    public String getNombreEstado() {
        return "Listo";
    }
}

