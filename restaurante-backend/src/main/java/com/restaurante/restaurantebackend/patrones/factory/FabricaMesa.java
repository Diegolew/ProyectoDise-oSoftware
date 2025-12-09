package com.restaurante.restaurantebackend.patrones.factory;

import com.restaurante.restaurantebackend.modelo.Pedido;

public class FabricaMesa implements PedidoFactory {

    private int id;
    private String cliente;
    private int idMesa;

    public FabricaMesa(int id, String cliente, int idMesa) {
        this.id = id;
        this.cliente = cliente;
        this.idMesa = idMesa;
    }

    @Override
    public Pedido crearPedido() {
        return new PedidoMesa(id, cliente, idMesa);
    }
}