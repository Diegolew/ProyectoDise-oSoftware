package com.restaurante.restaurantebackend.patrones.state;

import com.restaurante.restaurantebackend.modelo.Pedido;

public abstract class BaseEstadoPedido implements EstadoPedido {

    @Override
    public void avanzar(Pedido pedido) {
        throw new TransicionInvalidaException("No se puede AVANZAR desde el estado: " + getNombre());
    }

    @Override
    public void retroceder(Pedido pedido) {
        throw new TransicionInvalidaException("No se puede RETROCEDER desde el estado: " + getNombre());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new TransicionInvalidaException("No se puede CANCELAR desde el estado: " + getNombre());
    }

    @Override
    public boolean puedeFacturar() {
        return false;
    }
}