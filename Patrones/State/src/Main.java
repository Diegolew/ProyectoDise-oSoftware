public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        pedido.avanzar();      // En Preparación
        pedido.avanzar();      // Listo
        pedido.retroceder();   // En Preparación
        pedido.avanzar();      // Listo
        pedido.avanzar();      // Servido

        // pedido.cancelar(); -> Esto lanzará excepción
    }
}
