package com.restaurante.restaurantebackend.patrones.state;

import com.restaurante.restaurantebackend.modelo.Pedido;

public class Cancelado extends BaseEstadoPedido {
    @Override
    public String getNombre() {
        return "Cancelado";
    }
}