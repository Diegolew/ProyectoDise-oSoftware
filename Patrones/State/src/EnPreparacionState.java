public class EnPreparacionState extends BasePedidoState {

    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new ListoState());
    }

    @Override
    public void retroceder(Pedido pedido) {
        pedido.setEstado(new EnColaState());
    }

    @Override
    public String getNombreEstado() {
        return "En Preparación";
    }
}
