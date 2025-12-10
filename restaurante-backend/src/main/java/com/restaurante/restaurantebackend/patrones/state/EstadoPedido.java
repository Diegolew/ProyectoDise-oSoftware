package com.restaurante.restaurantebackend.patrones.state;

import com.restaurante.restaurantebackend.modelo.Pedido;

public interface EstadoPedido {
    void avanzar(Pedido pedido);
    void retroceder(Pedido pedido);
    void cancelar(Pedido pedido);
    
    boolean puedeFacturar(); 
    
    String getNombre();
}