public class Pedido {

    private PedidoState estado;

    public Pedido() {
        this.estado = new EnColaState(); // Estado inicial
    }

    public void setEstado(PedidoState nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Estado actual del pedido: " + estado.getNombreEstado());
    }

    public void avanzar() {
        estado.avanzar(this);
    }

    public void retroceder() {
        estado.retroceder(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public String getEstadoNombre() {
        return estado.getNombreEstado();
    }
}
