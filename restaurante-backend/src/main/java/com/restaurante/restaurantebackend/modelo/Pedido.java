package com.restaurante.restaurantebackend.modelo;

import com.restaurante.restaurantebackend.patrones.composite.ItemMenu;
import com.restaurante.restaurantebackend.patrones.state.EnCola;
import com.restaurante.restaurantebackend.patrones.observer.PedidoObserver;
import com.restaurante.restaurantebackend.patrones.state.EstadoPedido;
import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {
    protected int id;
    protected String nombreCliente;
    protected List<ItemMenu> items;
    protected EstadoPedido estado;
    private String nitFactura;
    private String razonSocialFactura;
    private String fechaFactura;

    private List<PedidoObserver> observadores = new ArrayList<>();

    public Pedido(int id, String nombreCliente) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.items = new ArrayList<>();
        this.estado = new EnCola();
    }

    public void agregarObservador(PedidoObserver observer) {
        observadores.add(observer);
    }

    public void eliminarObservador(PedidoObserver observer) {
        observadores.remove(observer);
    }

    private void notificarObservadores() {
        for (PedidoObserver observer : observadores) {
            observer.actualizar(this);
        }
    }

    public void agregarItem(ItemMenu item) {
        items.add(item);
    }

    public void avanzarEstado() {
        estado.avanzar(this);
        notificarObservadores();
    }

    public void retrocederEstado() {
        estado.retroceder(this);
        notificarObservadores();
    }

    public void cancelarPedido() {
        estado.cancelar(this);
        notificarObservadores();
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemMenu item : items) {
            total += item.getPrecio();
        }
        return total;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getEstadoNombre() {
        return estado.getNombre();
    }

    public int getId() { return id; }
    public String getNombreCliente() { return nombreCliente; }
    public List<ItemMenu> getItems() { return items; }
    public String getNitFactura() { return nitFactura; }
    public void setNitFactura(String nitFactura) { this.nitFactura = nitFactura; }

    public String getRazonSocialFactura() { return razonSocialFactura; }
    public void setRazonSocialFactura(String razonSocialFactura) { this.razonSocialFactura = razonSocialFactura; }

    public String getFechaFactura() { return fechaFactura; }
    public void setFechaFactura(String fechaFactura) { this.fechaFactura = fechaFactura; }

    // Detalles de facturación 
    private Double subtotalFactura;
    private Double impuestoFactura;
    private String nombreImpuestoFactura;
    private Double descuentoFactura;
    private String nombreDescuentoFactura;
    private Double totalFinalFactura;

    // Getters y Setters
    public Double getSubtotalFactura() { return subtotalFactura; }
    public void setSubtotalFactura(Double subtotalFactura) { this.subtotalFactura = subtotalFactura; }

    public Double getImpuestoFactura() { return impuestoFactura; }
    public void setImpuestoFactura(Double impuestoFactura) { this.impuestoFactura = impuestoFactura; }

    public String getNombreImpuestoFactura() { return nombreImpuestoFactura; }
    public void setNombreImpuestoFactura(String nombreImpuestoFactura) { this.nombreImpuestoFactura = nombreImpuestoFactura; }

    public Double getDescuentoFactura() { return descuentoFactura; }
    public void setDescuentoFactura(Double descuentoFactura) { this.descuentoFactura = descuentoFactura; }

    public String getNombreDescuentoFactura() { return nombreDescuentoFactura; }
    public void setNombreDescuentoFactura(String nombreDescuentoFactura) { this.nombreDescuentoFactura = nombreDescuentoFactura; }

    public Double getTotalFinalFactura() { return totalFinalFactura; }
    public void setTotalFinalFactura(Double totalFinalFactura) { this.totalFinalFactura = totalFinalFactura; }



}