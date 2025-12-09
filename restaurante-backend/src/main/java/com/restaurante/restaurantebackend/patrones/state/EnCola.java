package com.restaurante.restaurantebackend.patrones.state;

import com.restaurante.restaurantebackend.modelo.Pedido;

public class EnCola extends BaseEstadoPedido {

    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EnPreparacion());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new Cancelado());
    }

    @Override
    public String getNombre() {
        return "En Cola";
    }
}