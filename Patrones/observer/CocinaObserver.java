package observer;

import core.interfaces.IPedidoObserver;
import core.models.Pedido;


public class CocinaObserver implements IPedidoObserver {
    
    private String nombreCocina;
    
    public CocinaObserver(String nombreCocina) {
        this.nombreCocina = nombreCocina;
    }
    
    @Override
    public void onPedidoActualizado(Pedido pedido, String estadoAnterior, String estadoNuevo) {
        System.out.println("[COCINA - " + nombreCocina + "] Pedido #" + pedido.getId() + 
                         " cambió de estado: " + estadoAnterior + " → " + estadoNuevo);
        
        switch (estadoNuevo.toUpperCase()) {
            case "EN_COLA":
                System.out.println("    Pedido agregado a la cola de preparación");
                break;
            case "EN_PREPARACION":
                System.out.println("    Iniciando preparación del pedido");
                mostrarDetallesPedido(pedido);
                break;
            case "LISTO":
                System.out.println("    Pedido terminado y listo para servir");
                alertarMesero(pedido);
                break;
            case "SERVIDO":
                System.out.println("    Pedido servido, removiendo de cocina");
                break;
        }
    }
    
    @Override
    public void onNuevoPedido(Pedido pedido) {
        System.out.println("[COCINA - " + nombreCocina + "]  NUEVO PEDIDO #" + pedido.getId());
        System.out.println("   Mesa: " + pedido.getMesaId());
        System.out.println("   Productos: " + pedido.getProductos().size() + " items");
        mostrarDetallesPedido(pedido);
    }
    
    @Override
    public void onPedidoCancelado(Pedido pedido) {
        System.out.println("[COCINA - " + nombreCocina + "]  PEDIDO CANCELADO " + pedido.getId());
        System.out.println("   Deteniendo preparación inmediatamente");
    }
    

    private void mostrarDetallesPedido(Pedido pedido) {
        System.out.println("   --- Detalles del pedido ---");
        if (pedido.getProductos() != null) {
            pedido.getProductos().forEach(producto -> 
                System.out.println("      • " + producto.getNombre())
            );
        }
    }
    

    private void alertarMesero(Pedido pedido) {
        System.out.println("   Alertando a mesero: Pedido #" + pedido.getId() + 
                         " de Mesa " + pedido.getMesaId() + " está listo");
    }
    
    public String getNombreCocina() {
        return nombreCocina;
    }
}
