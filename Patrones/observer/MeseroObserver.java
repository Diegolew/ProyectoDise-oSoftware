package observer;

import core.interfaces.IPedidoObserver;
import core.models.Pedido;


public class MeseroObserver implements IPedidoObserver {
    
    private String nombreMesero;
    private int mesasAsignadas;
    
    public MeseroObserver(String nombreMesero, int mesasAsignadas) {
        this.nombreMesero = nombreMesero;
        this.mesasAsignadas = mesasAsignadas;
    }
    
    @Override
    public void onPedidoActualizado(Pedido pedido, String estadoAnterior, String estadoNuevo) {
        System.out.println("[MESERO - " + nombreMesero + "] Actualización Pedido #" + pedido.getId());
        
        switch (estadoNuevo.toUpperCase()) {
            case "EN_COLA":
                System.out.println("    Pedido registrado y enviado a cocina");
                confirmarConCliente(pedido);
                break;
            case "EN_PREPARACION":
                System.out.println("    Cocina está preparando el pedido");
                break;
            case "LISTO":
                System.out.println("    ¡PEDIDO LISTO! Recoger en cocina");
                prepararServicio(pedido);
                break;
            case "SERVIDO":
                System.out.println("    Pedido servido a Mesa " + pedido.getMesaId());
                verificarSatisfaccion(pedido);
                break;
        }
    }
    
    @Override
    public void onNuevoPedido(Pedido pedido) {
        System.out.println("[MESERO - " + nombreMesero + "]  Nuevo pedido registrado #" + pedido.getId());
        System.out.println("   Mesa: " + pedido.getMesaId());
        System.out.println("   Total items: " + pedido.getProductos().size());
        System.out.println("   Estado: Enviado a cocina");
    }
    
    @Override
    public void onPedidoCancelado(Pedido pedido) {
        System.out.println("[MESERO - " + nombreMesero + "]  PEDIDO CANCELADO #" + pedido.getId());
        System.out.println("   Mesa " + pedido.getMesaId() + " - Informar al cliente");
        informarCancelacion(pedido);
    }
    

    private void confirmarConCliente(Pedido pedido) {
        System.out.println("    Confirmando pedido con Mesa " + pedido.getMesaId());
    }
    

    private void prepararServicio(Pedido pedido) {
        System.out.println("    Preparando bandeja para Mesa " + pedido.getMesaId());
        System.out.println("    Dirigiéndose a cocina...");
    }

    
    private void verificarSatisfaccion(Pedido pedido) {
        System.out.println("    Verificar satisfacción del cliente en Mesa " + pedido.getMesaId());
    }
    

    private void informarCancelacion(Pedido pedido) {
        System.out.println("    Informando cancelación a Mesa " + pedido.getMesaId());
        System.out.println("    Ofrecer alternativas al cliente");
    }
    
    public String getNombreMesero() {
        return nombreMesero;
    }
    
    public int getMesasAsignadas() {
        return mesasAsignadas;
    }
}
