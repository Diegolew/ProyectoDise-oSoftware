package com.restaurante.restaurantebackend.patrones.factory;

import com.restaurante.restaurantebackend.modelo.Pedido;

public class FabricaDelivery implements PedidoFactory {

    private int id;
    private String cliente;
    private String direccion;

    public FabricaDelivery(int id, String cliente, String direccion) {
        this.id = id;
        this.cliente = cliente;
        this.direccion = direccion;
    }

    @Override
    public Pedido crearPedido() {
        return new PedidoDelivery(id, cliente, direccion);
    }
}