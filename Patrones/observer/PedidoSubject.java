package observer;

import core.interfaces.IPedidoObserver;
import core.models.Pedido;

import java.util.ArrayList;
import java.util.List;


public class PedidoSubject {
    
    private List<IPedidoObserver> observadores;
    
    public PedidoSubject() {
        this.observadores = new ArrayList<>();
    }
    

    public void registrarObservador(IPedidoObserver observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
            System.out.println("Observador registrado: " + observador.getClass().getSimpleName());
        }
    }
    

    public void eliminarObservador(IPedidoObserver observador) {
        if (observadores.remove(observador)) {
            System.out.println("Observador eliminado: " + observador.getClass().getSimpleName());
        }
    }
    

    public void notificarActualizacion(Pedido pedido, String estadoAnterior, String estadoNuevo) {
        System.out.println("\n=== NOTIFICANDO ACTUALIZACIÓN DE PEDIDO #" + pedido.getId() + " ===");
        System.out.println("Estado: " + estadoAnterior + " → " + estadoNuevo);
        
        for (IPedidoObserver observador : observadores) {
            observador.onPedidoActualizado(pedido, estadoAnterior, estadoNuevo);
        }
    }
    

    public void notificarNuevoPedido(Pedido pedido) {
        System.out.println("\n=== NOTIFICANDO NUEVO PEDIDO #" + pedido.getId() + " ===");
        
        for (IPedidoObserver observador : observadores) {
            observador.onNuevoPedido(pedido);
        }
    }

    public void notificarCancelacion(Pedido pedido) {
        System.out.println("\n=== NOTIFICANDO CANCELACIÓN DE PEDIDO #" + pedido.getId() + " ===");
        
        for (IPedidoObserver observador : observadores) {
            observador.onPedidoCancelado(pedido);
        }
    }

    public int contarObservadores() {
        return observadores.size();
    }
}
