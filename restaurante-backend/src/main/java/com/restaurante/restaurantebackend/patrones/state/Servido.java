package com.restaurante.restaurantebackend.patrones.state;

import com.restaurante.restaurantebackend.modelo.Pedido;

public class Servido extends BaseEstadoPedido {

    @Override
    public void retroceder(Pedido pedido) {
        pedido.setEstado(new Listo());
    }

    @Override
    public boolean puedeFacturar() {
        return true;
    }

    @Override
    public String getNombre() {
        return "Servido";
    }
}