public class EnColaState extends BasePedidoState {

    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EnPreparacionState());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoState());
    }

    @Override
    public String getNombreEstado() {
        return "En Cola";
    }
}

