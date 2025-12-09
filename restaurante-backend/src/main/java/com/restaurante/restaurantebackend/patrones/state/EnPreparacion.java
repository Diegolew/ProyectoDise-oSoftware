package com.restaurante.restaurantebackend.patrones.state;

import com.restaurante.restaurantebackend.modelo.Pedido;

public class EnPreparacion extends BaseEstadoPedido {

    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new Listo());
    }

    @Override
    public void retroceder(Pedido pedido) {
        pedido.setEstado(new EnCola());
    }

    @Override
    public String getNombre() {
        return "En Preparación";
    }
}