public interface PedidoState {
    void avanzar(Pedido pedido);
    void retroceder(Pedido pedido);
    void cancelar(Pedido pedido);
    String getNombreEstado();
}

