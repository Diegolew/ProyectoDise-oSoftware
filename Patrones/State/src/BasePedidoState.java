public abstract class BasePedidoState implements PedidoState {

    @Override
    public void avanzar(Pedido pedido) {
        throw new TransicionInvalidaException(
                "No se puede avanzar desde el estado: " + getNombreEstado()
        );
    }

    @Override
    public void retroceder(Pedido pedido) {
        throw new TransicionInvalidaException(
                "No se puede retroceder desde el estado: " + getNombreEstado()
        );
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new TransicionInvalidaException(
                "No se puede cancelar desde el estado: " + getNombreEstado()
        );
    }
}

