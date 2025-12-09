package com.restaurante.restaurantebackend.patrones.state;

import com.restaurante.restaurantebackend.modelo.Pedido;

public class Listo extends BaseEstadoPedido {

    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new Servido());
    }

    @Override
    public void retroceder(Pedido pedido) {
        pedido.setEstado(new EnPreparacion());
    }

    @Override
    public String getNombre() {
        return "Listo para Servir";
    }
}